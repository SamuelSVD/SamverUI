package ProcessingJava;
import processing.core.*;
public class FadingTree extends VisualComponent{
	float curr_length, max_length, growth_speed, decay, angle_range;
	int num_branches;
	int branch_count;
	int branch_limit = -1;
	boolean done_growing;
	FadingTree [] branches;
	PVector colour2, curr_colour;
	protected FadingTree(PVector position, PVector colour, PVector colour2, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit, int branch_count) {
	    super(position, colour);
	    this.rotation_after_translate = position.z;
	    this.colour2 = colour2;
	    PVector colour_diff = new PVector(colour2.x-colour.x,colour2.y-colour.y,colour2.z-colour.z);
	    if (branch_limit >1) {
	      this.curr_colour = new PVector(colour.x + colour_diff.x/(branch_limit-1)*branch_count, colour.y + colour_diff.y/(branch_limit-1)*branch_count, colour.z + colour_diff.z/(branch_limit-1)*branch_count);
	    } else {
	      this.curr_colour = colour;
	    }
	    this.curr_length = 0;
	    this.max_length = max_length;
	    this.growth_speed = growth_speed;
	    this.angle_range = angle_range;
	    this.decay = decay;
	    this.num_branches = num_branches;
	    branches = new FadingTree[num_branches];
	    done_growing = false;
	    this.branch_limit = branch_limit;
	    this.branch_count = branch_count;
	    if (branch_count >= branch_limit) done_growing = true;
	}
  
	public FadingTree(PVector position, PVector colour, PVector colour2, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit) {
		this(position, colour, colour2, max_length, growth_speed, angle_range, decay, num_branches, branch_limit, 0);
	}
	
	public void update(float d) {
		if (branches[0] != null) {
			for (int i = 0; i < num_branches; i++) {
				branches[i].update(d);
			}
		}
		if (done_growing) {
		  return;
		}
		curr_length += growth_speed * d;
		
		if (curr_length > max_length) {
			done_growing = true;
			curr_length = max_length;
			if (branches[0] == null) {
				for (int i = 0; i < num_branches; i++) {
					float angle = angle_range/(float)(num_branches-1)*i - angle_range/2;
					float x = curr_length;
					float y = 0;
					
					PVector pos = new PVector(x,y,angle);
					branches[i] = new FadingTree(pos, colour, colour2, max_length*decay, growth_speed * decay, angle_range, decay, num_branches, branch_limit, branch_count+1);
					branches[i].setSketch(sketch);
				}
			}
			
		}
	}
	public void draw() {
		/*sketch.pushMatrix();
		sketch.translate(position.x, position.y);
		sketch.rotate(position.z);
		sketch.line(0, 0, curr_length, 0);
		sketch.popMatrix();*/
		sketch.stroke(curr_colour.x, curr_colour.y, curr_colour.z);
		
		sketch.strokeWeight(2*(1-branch_count/branch_limit));
//		float x = position.x + curr_length * cos(position.z);
//		float y = position.y + curr_length * sin(position.z);
//		sketch.line(position.x, position.y, x, y);
		sketch.line(0, 0, curr_length, 0);
		if (branches[0] != null) {
			for (int i = 0; i < num_branches; i++) {
				branches[i].doDraw();
			}
		}
	}
}
