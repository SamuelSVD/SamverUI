package sketches;

import ProcessingJava.Background;
import ProcessingJava.Camera;
import ProcessingJava.Sketch;
import ProcessingJava.camera_mode;
import processing.core.PVector;
import ProcessingComponents.*;
public class ASI_Fueling extends Sketch {

	public ASI_Fueling() {
		// TODO Auto-generated constructor stub
		is_3D = true;
	}

	public ASI_Fueling(PVector size) {
		super(size);
		is_3D = true;
		// TODO Auto-generated constructor stub
	}

	public ASI_Fueling(PVector position, PVector size) {
		super(position, size);
		is_3D = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup() {
    record = false;
    frame_limit = 25*15;
    setSpeed(0.04f);
    camera = new Camera(camera_mode.third_person);
    this.setCamera(camera);
    camera.setTarget(0, 0, 0);
    float l = 1000;
    camera.setLocation(l,l,l);
    camera.angle_accuracy = PI/8;
    camera.position_accuracy = 10;
    camera.DEBUG = false;
    camera.activateControl();
    System.out.println(camera);
    addVisualComponent(new Background(new PVector(255,255,255)));
    addVisualComponent(new Nozzle_3D(new PVector(0,0,0), new PVector(255,0,0), new PVector(0,0,0), new PVector(100,100,100)));
	}

}
