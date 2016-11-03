package ProcessingSketches;

import java.util.ArrayList;

import ProcessingJava.*;
import processing.core.PVector;
import Math.*;
import ProcessingComponents.*;


public class Halloween2016 extends Sketch {

	public Halloween2016() {
		this(new PVector(100, 100));
	}

	public Halloween2016(PVector size) {
		this(new PVector(), size);
	}

	public Halloween2016(PVector position, PVector size) {
		super(position, size);
	}

	@Override
	public void setup() {
		record = true;
		this.frame_limit = 1000;
		float offset, speed , starting_angle, angular_speed, a, b;

		
		this.addVisualComponent(new Background(new PVector(255,127,0)));
		
    EllipseParticle e = new EllipseParticle(new PVector(255,255,0), -5/*offset*/, 0.005f /*speed_multiplier*/, 12*PI/8 /*theta*/, 0.1f /*alpha*/, 400 /*ellipse_width*/, 400 /*ellipse_height*/, new PVector(250, 400) /*position*/);
    e.addVisualComponent(new Circle(new PVector(0,0),new PVector(230,230,10),150));
    this.addVisualComponent(e);
		
		PVector position = new PVector(150,200);
		PVector size     = new PVector(200,150);
		PVector colour   = new PVector();
		this.addVisualComponent(new Rectangle(position, size, colour));
		
		position = new PVector(250,550);
		this.addVisualComponent(new Circle(position, colour, 500));
		
		ArrayList<Double> points = new ArrayList<Double>();
		points.add(-150.0);	points.add(100.0);
		points.add(0.0);	points.add(0.0);
		points.add(150.0);	points.add(100.0);
		position = new PVector(250,100);
		Shape shape = new Shape(position, colour);
		shape.init(points);
		this.addVisualComponent(shape);
		
	  position = new PVector(100,350);
	  double rotation = -PI/2-PI/8;
	  float max_length = 50;
	  float growth_speed = 1000;
	  float angle_range = PI/2;
	  float decay = 0.7f;
	  int num_branches = 3;
	  int branch_limit = 4;
	  Tree tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);
	  
	  position = new PVector(80,370);
	  rotation = -PI/2-PI/6;
	  max_length = 45;
	  tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);

	  position = new PVector(60,400);
	  rotation = -PI/2-PI/5;
	  max_length = 60;
	  tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);

	  position = new PVector(400,350);
	  rotation = -PI/2+PI/8;
	  max_length = 50;
	  tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);

	  position = new PVector(420,370);
	  rotation = -PI/2+PI/6;
	  max_length = 45;
	  tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);

	  position = new PVector(440,400);
	  rotation = -PI/2+PI/5;
	  max_length = 60;
	  tree = new Tree(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit);
	  tree.setRotationAfterTranslateFun(new Sin(Math.random()*10,rotation,2*PI/10.0,PI/100));
	  this.addVisualComponent(tree);
	  
	  //door
	  position = new PVector(235,250);
	  size = new PVector(30,50);
	  colour = new PVector(230,230,10);
		this.addVisualComponent(new Rectangle(position, size, colour));
		
		//window
	  position = new PVector(175,200);
	  size = new PVector(20,30);
	  colour = new PVector(230,230,10);
		this.addVisualComponent(new Rectangle(position, size, colour));
		
	  position = new PVector(195,200);
	  size = new PVector(20,30);
	  colour = new PVector(230,230,10);
		this.addVisualComponent(new Rectangle(position, size, colour));

	  position = new PVector(175,230);
	  size = new PVector(20,30);
	  colour = new PVector(230,230,10);
		this.addVisualComponent(new Rectangle(position, size, colour));
		
	  position = new PVector(195,230);
	  size = new PVector(20,30);
	  colour = new PVector(230,230,10);
		this.addVisualComponent(new Rectangle(position, size, colour));

		starting_angle = -PI;
		for (int i = 0; i < 5; i++) {
	    RussianDoll doll = new RussianDoll();
	    doll.setSize(    new PVector(50-5*i, 50-5*i));
	    doll.setPosition(new PVector(-doll.getSize().x/2, -doll.getSize().y*1.25f));
	    doll.setBackgroundColor(Utils.randomPVector());
	    doll.setSkinColor(      Utils.randomPVector());
	    doll.setHairColor(      Utils.randomPVector());
	    doll.setDecorationColor(Utils.randomPVector());
	    Sum sum = new Sum();
	    sum.appendFunction(new Constant(-doll.getSize().y*1.25f));
	    sum.appendFunction(new Abs(new Sin(Math.random() * 2 * PI, 0, 1.1, doll.getSize().y/2)));
	    doll.setPositionFun(1, sum);
	    
	    offset = 0;
	    speed = 0;
	    starting_angle -= (PI/10 - PI/50 * i * 0.8);
	    angular_speed = .05f;
	    a = 250;
	    b = 250;
		  position = new PVector(250,550);
		  e = new EllipseParticle(colour, offset, speed, (float)starting_angle, angular_speed, a, b, position);
			e.addVisualComponent(doll);
			e.setRotationAfterTranslateFun(new Line(0,starting_angle+PI/2,1,angular_speed));
	    this.addVisualComponent(e);
		}
    
	} 
}
