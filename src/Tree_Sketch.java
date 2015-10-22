import ProcessingJava.*;
import processing.core.*;

public class Tree_Sketch extends Sketch{

	public Tree_Sketch(PVector size) {
		super(size);
	}

	public void setup() {
		setSpeed(0.0333f);
		PVector pos = new PVector(250,250,PI/2);
		PVector colour = new PVector(0,0,0);
		Tree t = new Tree(pos, colour, 100.0f, 50.0f, PI/2, 0.5f, 2);
		addVisualComponent(t);
	}

}
