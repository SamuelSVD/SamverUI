package ProcessingComponents;

import ProcessingJava.*;
import processing.core.PVector;

public class Nozzle_3D extends VisualContainer {
  int scale = 100;
  PVector primaryColour;
  PVector secondaryColour;
  PVector metalColour;
  Shape handle_0;
  Shape handle_1;
  Shape handle_2;
	public Nozzle_3D() {
    this(new PVector(), new PVector());
	}

	public Nozzle_3D(PVector position, PVector colour) {
		this(position, colour, colour, colour);
	}
	
	public Nozzle_3D(PVector position, PVector primaryColour, PVector secondaryColour, PVector metalColour) {
		super(position, primaryColour);
		this.primaryColour = primaryColour;
		this.secondaryColour = secondaryColour;
		this.metalColour = metalColour;
		this.handle_0 = new Shape(new PVector(0,0,-25), primaryColour, new PVector(100,100));
		try {
		  this.handle_0.init("Data/Shapes/Items/nozzle_0.pts");
		} catch (Exception e) {}
		this.addVisualComponent(handle_0);
		this.handle_1 = new Shape(new PVector(0,0,25), secondaryColour, new PVector(100,100));
		try {
		  this.handle_1.init("Data/Shapes/Items/nozzle_1.pts");
		} catch (Exception e) {}
		this.addVisualComponent(handle_1);
		this.handle_2 = new Shape(new PVector(0,0,25), metalColour, new PVector(100,100));
		try {
		  this.handle_2.init("Data/Shapes/Items/nozzle_2.pts");
		} catch (Exception e) {}
		this.addVisualComponent(handle_2);
	}
	
	public void draw() {
		super.draw();
//		joinShape(primaryShape, 0, 0, -0.25, 0, 0, 0.25);
	}
	
	private void vertex(double x, double y, double z)
	{
		this.vertex((float)x, (float)y, (float)z);
	}
	private void vertex(double x, double y, double z, double scale)
	{
		this.vertex((float)x, (float)y, (float)z, (float)scale);
	}
	public void vertex(float x, float y, float z)
	{
		vertex(x, y, z, scale);
	}
	
	public void vertex(float x, float y, float z, float scale)
	{
//		System.out.print(String.format("%f %f %f\r\n", x, y, z));
		sketch.vertex(x * scale, y * scale, z * scale);
	}
	
	public void drawPrimaryFace(double x, double y, double z, double scale)
	{
		sketch.fill(primaryColour);
		sketch.translate((float)scale*(float)x, (float)scale*(float)y, (float)scale*(float)z );
//		drawShape(primaryShape, scale);
//		System.out.println(primaryShape[0].length);
    sketch.translate((float)scale*(float)-x, (float)scale*(float)-y, (float)scale*(float)-z );		
	}
	public void drawPrimaryFace(double x, double y, double z)
	{
		drawPrimaryFace(x, y, z, scale);
	}
	public void drawShape(double[][] shape, double scale) {
		sketch.beginShape();
		if (shape.length == 2) {
			for (int i = 0; i < shape[0].length; i++) {
	//			System.out.print(String.format("%d: ", i));
				vertex(shape[0][i], shape[1][i], 0, scale);
			}
		} else if (shape.length == 3) {
			for (int i = 0; i < shape[0].length; i++) {
			//			System.out.print(String.format("%d: ", i));
			  vertex(shape[0][i], shape[1][i], shape[2][i], scale);
			}
		}
		sketch.endShape();
	}
	
	public void joinShape(double[][] shape, double x, double y, double z, double x2, double y2, double z2) 
	{
		for (int i = 0; i < shape[0].length - 1; i++) {
			double[][] temp_shape = {{shape[0][i]+x, shape[0][i+1]+x, shape[0][i+1]+x2, shape[0][i]+x2, shape[0][i]+x},
					                     {shape[1][i]+y, shape[1][i+1]+y, shape[1][i+1]+y2, shape[1][i]+y2, shape[1][i]+y},
					                     {            z,               z,               z2,             z2,             z}};
			drawShape(temp_shape, scale);
		}
	}
	
}
