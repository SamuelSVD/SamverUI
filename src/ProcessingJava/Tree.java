package ProcessingJava;
import processing.core.*;

import processing.core.PVector;
public class Tree extends VisualComponent{
	float curr_length, max_length, growth_speed, decay, angle_range;
	int num_branches;
	boolean done_growing;
	Tree [] branches;
	public Tree(PVector position, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches) {
		super(position, colour);
		this.curr_length = 0;
		this.max_length = max_length;
		this.growth_speed = growth_speed;
		this.angle_range = angle_range;
		this.decay = decay;
		this.num_branches = num_branches;
		branches = new Tree[num_branches];
		done_growing = false;
	}
	public void update(float d) {
		if (done_growing) return;
		curr_length =+ growth_speed * d;
		if (curr_length > max_length) {
			done_growing = true;
			curr_length = max_length;
			if (branches[0] == null) {
				for (int i = 0; i < num_branches; i++) {
					float angle = this.position.z - angle_range/2 + angle_range/(float)(num_branches-1)*i;
					float x = position.x + curr_length * cos(position.z);
					float y = position.y + curr_length * sin(position.z);
					PVector pos = new PVector(x,y,angle);
					branches[i] = new Tree(pos, colour, max_length*decay, growth_speed * decay, angle_range, decay, num_branches);
				}
			}
		}
	}
	public void draw() {
//		pushMatrix();
//		translate(position.x, position.y);
//		rotate(position.z);
		float x = position.x + curr_length * cos(position.z);
		float y = position.y + curr_length * sin(position.z);
		line(position.x,position.y,x,y);
//		popMatrix();
	}
}
