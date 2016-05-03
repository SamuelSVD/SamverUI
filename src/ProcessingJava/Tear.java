package ProcessingJava;
import java.util.ArrayList;
import processing.core.*;
public class Tear extends VisualComponent{
	ArrayList<PVector> tear;
	PVector size;
	public Tear(PVector position, PVector size, float angle, PVector colour) {
	  super(position, colour);
	  this.size = size;
	  this.rotation_after_translate = angle;
	
	  tear = new ArrayList<PVector>();
	  float d = 0.02f;
	  //small semi-circle
	  for(float x = 0; x < 2; x += d) {
	    float y = - sqrt(1-pow(1-x,2));
	    tear.add(new PVector(x,y));
	  }
	  //middle semi-circle
	  for(float x = 2; x < 5; x += d) {
	    float y = sqrt(pow(1.5f,2)-pow(3.5f-x,2));
	    tear.add(new PVector(x,y));
	  } 
	  //large semi-circle
	  for(float x = 5; x >= 0; x -= d) {
	    float y = - sqrt(pow(2.5f,2)-pow(x-2.5f,2));
	    tear.add(new PVector(x,y));
	  }     
	    
	}
	public void draw() {
	  sketch.fill(colour.x, colour.y, colour.z);
	  sketch.beginShape();
	  for (int i = 0; i < tear.size(); i++) {
	    sketch.vertex(tear.get(i).x*size.x/5.0f, tear.get(i).y*size.y/5.0f);
	  }
	  sketch.endShape();
	}
}
