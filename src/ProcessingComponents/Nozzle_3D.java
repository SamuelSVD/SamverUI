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
		  this.handle_0.init("Data/Shapes/Items/Pump_Handle.pts");
		} catch (Exception e) {}
		this.addVisualComponent(handle_0);
		this.handle_1 = new Shape(new PVector(0,0,25), primaryColour, new PVector(100,100));
		try {
		  this.handle_1.init("Data/Shapes/Items/Pump_Handle.pts");
		} catch (Exception e) {}
		this.addVisualComponent(handle_1);
	}
	
	public void draw() {
		super.draw();
		joinShape(primaryShape, 0, 0, -0.25, 0, 0, 0.25);
		sketch.fill(secondaryColour);
		sketch.beginShape();
		vertex(0,0,1);
		vertex(1,0,1);
		vertex(1,1,1);
		vertex(0,1,1);
		vertex(0,0,1);
		sketch.endShape();
		
		sketch.fill(metalColour);
		sketch.beginShape();
		vertex(0,0,2);
		vertex(1,0,2);
		vertex(1,1,2);
		vertex(0,1,2);
		vertex(0,0,2);
		sketch.endShape();  // */
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
		drawShape(primaryShape, scale);
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
