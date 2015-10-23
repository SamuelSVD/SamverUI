import ProcessingJava.*;
import processing.core.*;

public class Tree_Sketch extends Sketch{

	public Tree_Sketch(PVector size) {
		super(size);
	}

	public void setup() {
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
		setSpeed(0.0333f);
		int MODE = 2;
    addVisualComponent(new Square(new PVector(255,255,255), new PVector(500,500)));
    Tree t;
    PVector pos, colour;
    switch (MODE) {
      case 0:
        pos = new PVector(250,400,3*PI/2);
        colour = new PVector(0,0,0);
        t = new Tree(pos, colour, 200.0f, 50.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
        addVisualComponent(t);
        break;
      case 1:
        pos = new PVector(250,350,3*PI/2);
        colour = new PVector(0,0,0);
        t = new Tree(pos, colour, 100.0f, 50.0f, 2*PI, 0.75f, 6, 5); // star thing
        addVisualComponent(t);
        break;
      case 2:
        for (int j = 0; j < 5; j++) {
          for (int i = 0; i < 10; i++) {
            pos = new PVector(250,250,2*PI/10*i);
            colour = new PVector(0,0,0);
            t = new Tree(pos, colour, 20.0f*j, 50.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
            addVisualComponent(t);
          }
        }
        break;
      default:
        pos = new PVector(250,350,3*PI/2);
        colour = new PVector(0,0,0);
        t = new Tree(pos, colour, 100.0f, 50.0f, PI, 0.5f, 6, 4);
        addVisualComponent(t);
        break;
    }
    
	}
	public void draw() {
	  super.draw();
    saveFrame("Images/frame-####.tif");
  }
}
