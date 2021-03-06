package sketches;
import ProcessingJava.*;
import processing.core.*;

public class Tree_Sketch extends Sketch{

	public Tree_Sketch(PVector size) {
		super(size);
	}

	public void setup() {
    setSpeed(0.0333f);
    int MODE = 7;
	  Tree t;
    PVector pos, colour, new_colour;
    float angle;
    addVisualComponent(new Square(new PVector(255,255,255), new PVector(500,500)));
    switch (MODE) {
      case 0: //dandelion
        pos = new PVector(250,400);
        angle = 3*PI/2;
        colour = new PVector(0,0,0);
        t = new Tree(pos, angle, colour, 200.0f, 50.0f, 3*PI/2, 0.3f, 10, 3); // dandelion
        addVisualComponent(t);
        break;
      case 1: // star thing
        pos = new PVector(250,350);
        angle = 3*PI/2;
        colour = new PVector(0,0,0);
        t = new Tree(pos, angle, colour, 100.0f, 50.0f, 2*PI, 0.75f, 6, 5);
        addVisualComponent(t);
        break;
      case 2:// many dandelions
          for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
              pos = new PVector(250,250);
              angle = 2*PI/10*i;
              colour = new PVector(0,0,0);
              t = new Tree(pos, angle, colour, 20.0f*j, 50.0f, 3*PI/2, 0.3f, 10, 3);
              addVisualComponent(t);
            }
          }
          break;
      case 3: // forest
    	  for (int i = 0; i < 10; i++) {
              pos = new PVector(50+100*i, 300);
              angle = 3*PI/2;
              colour = new PVector(0,0,0);
              t = new Tree(pos, angle, colour, 100, 50.0f, PI/2, 0.5f, 10, 3);
              addVisualComponent(t);
          }
          break;
      case 4:// Coloured tree
        addVisualComponent(new Square(new PVector(0,255,0), new PVector(500,500)));
        addVisualComponent(new Square(new PVector(134,133,23), new PVector(500,355)));
        addVisualComponent(new Square(new PVector(155,155,255), new PVector(500,350)));
//        addVisualComponent(new Circle(new PVector(15,0), new PVector(255,255,0), 150));
        EllipseParticle e = new EllipseParticle(new PVector(255,255,0), 0/*offset*/, 0.005f /*speed_multiplier*/, 12*PI/8 /*theta*/, 0.1f /*alpha*/, 400 /*ellipse_width*/, 400 /*ellipse_height*/, new PVector(250, 400) /*position*/);
        e.addVisualComponent(new Circle(new PVector(0,0),new PVector(255,255,0),150));
        addVisualComponent(e);
    	  pos = new PVector(250,350);
    	  angle = 3*PI/2;
    	  colour = new PVector(139,69,19);
//    	  colour = new PVector(218,180,140);
    	  new_colour = new PVector(0,255,0);
    	  FadingTree t2 = new FadingTree(pos, angle, colour, new_colour, 100, 50.0f, PI/2, 0.5f, 4, 5); // forest
        addVisualComponent(t2);
        
        pos = new PVector(85,350);
        t2 = new FadingTree(pos, angle, colour, new_colour, 100, 50.0f, PI/2, 0.5f, 4, 5); // forest
        addVisualComponent(t2);
        
        pos = new PVector(415,350);
        t2 = new FadingTree(pos, angle, colour, new_colour, 100, 50.0f, PI/2, 0.5f, 4, 5); // forest
        addVisualComponent(t2);
        break;
      case 5:
    	  int N = 6;
    	  colour = new PVector(150,150,255);
    	  new_colour = new PVector(255,255,255);
    	  int length = 100;
    	  int growth = 50;
    	  angle = PI/2;
    	  float decay = 0.5f;
    	  int num_branches = 3;
    	  int limit_branches = 3;
    	  for (int i = 0; i < N; i++) {
        	pos = new PVector(250,250);
        	angle = 2*PI/N*i;
    		  FadingTree tt = new FadingTree(pos, angle, colour, new_colour, length, growth, (float)angle, decay, num_branches, limit_branches);
    		  addVisualComponent(tt);
    	  }
    	  
    	  length = 50;
    	  growth = 50;
    	  angle = PI/2;
    	  decay = 0.5f;
    	  num_branches = 3;
    	  limit_branches = 3;
    	  for (int i = 0; i < N; i++) {
      	  pos = new PVector(250,250);
      	  angle = 2*PI/N*i;
    		  FadingTree tt = new FadingTree(pos,angle, colour, new_colour, length, growth, (float)angle, decay, num_branches, limit_branches);
    		  addVisualComponent(tt);
    	  }
    	  break;
      case 6:
    	  addVisualComponent(new Square(new PVector(), new PVector(500,500)));
    	  int n = 6;
    	  for (int j = 0; j < 5; j++) {
          for (int i = 0; i < n; i++) {
            pos = new PVector(250,250);
            angle = 2*PI/n*i;
            colour = new PVector(0,0,0);
            new_colour = new PVector(255,0,0);
            FadingTree tt = new FadingTree(pos, angle, colour, new_colour, 5+20*j, 2.5f+10*j, PI, 0.5f, (j+5), 3);
            addVisualComponent(tt);
      	  }
    	  }
    	  break;
      case 7:
        addVisualComponent(new Square(new PVector(0,155,0), new PVector(500,500)));
        addVisualComponent(new Square(new PVector(134,133,23), new PVector(500,355)));
        addVisualComponent(new Square(new PVector(155,155,255), new PVector(500,350)));
        for (int j = 15; j > 0; j--) {
          pos = new PVector(random(500),350);
          colour = new PVector(139,69,19);
          angle = 3*PI/2;
          new_colour = new PVector(49,100 + random(100),49);
          N = 10;
          for (int i = N; i > 1; i--) {
            float h = 10;
            t2 = new FadingTree(pos, angle, colour, new_colour, h*i+3*j, (h/2.0f)*i+3*j/2.0f, PI/2, 0.8f - 0.5f*i/N, 4, 5); // pine tree
            addVisualComponent(t2);
          }
        }
        break;
      default:
        pos = new PVector(250,350);
        angle = 3*PI/2;
        colour = new PVector(0,0,0);
        t = new Tree(pos, angle, colour, 100.0f, 50.0f, PI, 0.5f, 6, 4);
        addVisualComponent(t);
        break;
    }
    
	}
}
