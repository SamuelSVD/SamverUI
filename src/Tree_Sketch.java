import ProcessingJava.*;
import processing.core.*;

public class Tree_Sketch extends Sketch{

	public Tree_Sketch(PVector size) {
		super(size);
	}

	public void setup() {
    size((int)size.x, (int)size.y); //Always needed. Looking for a fix.
	setSpeed(0.0333f);
	int MODE = 6;
    addVisualComponent(new Square(new PVector(255,255,255), new PVector(500,500)));
    Tree t;
    PVector pos, colour, new_colour;
    switch (MODE) {
      case 0: //dandelion
        pos = new PVector(250,400,3*PI/2);
        colour = new PVector(0,0,0);
        t = new Tree(pos, colour, 200.0f, 50.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
        addVisualComponent(t);
        break;
      case 1: // star thing
        pos = new PVector(250,350,3*PI/2);
        colour = new PVector(0,0,0);
        t = new Tree(pos, colour, 100.0f, 50.0f, 2*PI, 0.75f, 6, 5);
        addVisualComponent(t);
        break;
      case 2:// many dandelions
          for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
              pos = new PVector(250,250,2*PI/10*i);
              colour = new PVector(0,0,0);
              t = new Tree(pos, colour, 20.0f*j, 50.0f, 3*PI/2, 0.3f, 10, 3);
              addVisualComponent(t);
            }
          }
          break;
      case 3: // forest
    	  for (int i = 0; i < 10; i++) {
              pos = new PVector(50+100*i, 300, 3*PI/2);
              colour = new PVector(0,0,0);
              t = new Tree(pos, colour, 100, 50.0f, PI/2, 0.5f, 10, 3);
              addVisualComponent(t);
          }
          break;
      case 4:// Coloured tree
    	  pos = new PVector(250,350, 3*PI/2);
    	  colour = new PVector(139,69,19);
//    	  colour = new PVector(218,180,140);
    	  new_colour = new PVector(0,255,0);
    	  FadingTree t2 = new FadingTree(pos, colour, new_colour, 100, 50.0f, PI/2, 0.5f, 4, 5); // forest
          addVisualComponent(t2);
          break;
      case 5:
    	  int N = 6;
    	  colour = new PVector(150,150,255);
    	  new_colour = new PVector(255,255,255);
    	  int length = 100;
    	  int growth = 50;
    	  float angle = PI/2;
    	  float decay = 0.5f;
    	  int num_branches = 3;
    	  int limit_branches = 3;
    	  for (int i = 0; i < N; i++) {
        	  pos = new PVector(250,250,2*PI/N*i);
    		  FadingTree tt = new FadingTree(pos, colour, new_colour, length, growth, angle, decay, num_branches, limit_branches);
    		  addVisualComponent(tt);
    	  }
    	  
    	  length = 50;
    	  growth = 50;
    	  angle = PI/2;
    	  decay = 0.5f;
    	  num_branches = 3;
    	  limit_branches = 3;
    	  for (int i = 0; i < N; i++) {
        	  pos = new PVector(250,250,2*PI/N*i);
    		  FadingTree tt = new FadingTree(pos, colour, new_colour, length, growth, angle, decay, num_branches, limit_branches);
    		  addVisualComponent(tt);
    	  }
    	  break;
      case 6:
    	  addVisualComponent(new Square(new PVector(), new PVector(500,500)));
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
//    saveFrame("Images/frame-####.tif");
  }
}
