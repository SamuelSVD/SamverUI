import java.util.ArrayList;

import Math.*;
import processing.core.*;
import ProcessingJava.*;
import ProcessingComponents.*;

public class RussianDolls extends Sketch{
  float t;
  float mX;
  float mY;
  float x;
  float y;
  PVector bg;
  PVector skin;
  PVector hair;
  PVector dec;
  LinearTransition pos_tx;
  LinearTransition pos_ty;
  LinearTransition size_t;
  RussianDoll r1, r2;
  
  ArrayList<ArrayList<PVector>> colours;
  
  
  public RussianDolls(PVector size) {
    this(new PVector(), size);
  }
  public RussianDolls(PVector position, PVector size) {
    super(position, size);
    
    colours = new ArrayList<ArrayList<PVector>>();
    for (int i = 0; i < 1000; i++) {
      ArrayList<PVector> list = new ArrayList<PVector>();
      for (int j = 0; j < 4; j++) {
        list.add(new PVector(random(255), random(255), random(255)));
      }
      colours.add(list);
    }
    ArrayList<Double> r = new ArrayList<Double>();
    r.add(175.0);
    r.add(100.0);
    pos_tx = new LinearTransition(r, 1.25);
    r.clear();
    r.add(150.0);
    r.add(50.0);
    pos_ty = new LinearTransition(r, 1.25);
    r.clear();
    r.add(150.0);
    r.add(300.0);
    size_t = new LinearTransition(r, 1.25);
  }
  public void setup() {
    record = true;
    frame_limit = 408;
    setSpeed(0.033f);
    
    Background b = new Background(new PVector(255,250,142));
    addVisualComponent(b);
    
    Paisley p = new Paisley(10, 100);
    for (int i = 0; i < 4; i++) {
      p.addVisualComponent(new Tear(new PVector(50,50), new PVector(45,45), i*PI/2, new PVector(255, 168,111)));
    }
    addVisualComponent(p);
    r1 = new RussianDoll();
    r2 = new RussianDoll();
    
    bg = new PVector(255,255,0);
    skin = new PVector(255,255,0);
    hair = new PVector(255,255,0);
    dec = new PVector(255,255,0);
    
    bg = new PVector(random(255),random(255),random(255));
    skin  = new PVector(random(255),random(255),random(255));
    hair = new PVector(random(255),random(255),random(255));
    dec  = new PVector(random(255),random(255),random(255));
    
    if (true) {
      ArrayList<PVector> list = new ArrayList<PVector>();
      list.add(new PVector(240,20,15));
      list.add(new PVector(235, 221, 156));
      list.add(new PVector(65, 0, 0));
      list.add(new PVector(210, 210, 30));
      colours.add(list);
      
      list = new ArrayList<PVector>();
      list.add(new PVector(193,147,49));
      list.add(new PVector(185, 122, 87));
      list.add(new PVector(0, 0, 0));
      list.add(new PVector(0, 162, 200));
      colours.add(list);

      list = new ArrayList<PVector>();
      list.add(new PVector(34,177,76));
      list.add(new PVector(226, 175, 133));
      list.add(new PVector(230, 28, 36));
      list.add(new PVector(0, 200, 200));
      colours.add(list);
    }
    r1.setSize(new PVector(0,0));
    r1.setPosition(new PVector(100,50));
    r2.setBackgroundColor(colours.get(0).get(0));
    r2.setSkinColor(colours.get(0).get(1));
    r2.setHairColor(colours.get(0).get(2));
    r2.setDecorationColor(colours.get(0).get(3));
    addVisualComponent(r2);
    addVisualComponent(r1);
    
  }
  
  public void draw() {
    super.draw();
    if (pos_tx != null) {
      pos_tx.update(0.05);
      pos_ty.update(0.05);
      size_t.update(0.05);
      r2.setPosition(new PVector((float)pos_tx.getValue(), (float)pos_ty.getValue()));
      r2.setSize(new PVector((float)size_t.getValue(),(float)size_t.getValue()));
      if (pos_tx.cumulative > 1.25) {
        System.out.println("SWAP");
        swap();
        r1.init = true;
      }
    }
  }
  public void mousePressed() {
    mX = mouseX;
    mY = mouseY;
    x = 0;
    y = 0;
  }
  public void mouseDragged() {
    x = abs(mX - mouseX);
    y = abs(mY - mouseY);
  }
  public void mouseReleased() {
    System.out.printf("%f %f %f %f\n", mX, mY, x, y);
    System.out.printf("%f %f %f\n", bg.x, bg.y, bg.z);
    System.out.printf("%f %f %f\n", skin.x, skin.y, skin.z);
    System.out.printf("%f %f %f\n", hair.x, hair.y, hair.z);
    System.out.printf("%f %f %f\n", dec.x, dec.y, dec.z);
  }
  public void swap() {
    System.out.println(r1);
    r1.reset();
    System.out.println(r1);
    r1.setSize(new PVector(300,300));
    r1.setBackgroundColor(colours.get(0).get(0));
    r1.setSkinColor(colours.get(0).get(1));
    r1.setHairColor(colours.get(0).get(2));
    r1.setDecorationColor(colours.get(0).get(3));
    colours.add(colours.get(0));
    colours.remove(0);
    
    r2.reset();
    r2.setBackgroundColor(colours.get(0).get(0));
    r2.setSkinColor(colours.get(0).get(1));
    r2.setHairColor(colours.get(0).get(2));
    r2.setDecorationColor(colours.get(0).get(3));
    pos_tx.cumulative = -5.5;
    pos_ty.cumulative = -5.5;
    size_t.cumulative = -5.5;
  }
}
