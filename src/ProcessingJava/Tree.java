package ProcessingJava;
import processing.core.*;
public class Tree extends VisualComponent{
	float curr_length, max_length, growth_speed, decay, angle_range;
	int num_branches;
	int branch_count;
	int branch_limit = -1;
	boolean done_growing;
	Tree [] branches;

	private Tree(PVector position, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit, int branch_count) {
    super(position, colour);
    this.curr_length = 0;
    this.max_length = max_length;
    this.growth_speed = growth_speed;
    this.angle_range = angle_range;
    this.decay = decay;
    this.num_branches = num_branches;
    branches = new Tree[num_branches];
    done_growing = false;
    this.branch_limit = branch_limit;
    this.branch_count = branch_count;
    if (branch_count >= branch_limit) done_growing = true;
  }
  
	public Tree(PVector position, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit) {
    this(position, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit, 0);
  }
    
	public Tree(PVector position, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches) {
    this(position, colour, max_length, growth_speed, angle_range, decay, num_branches, -1, 0);
		if (branch_limit == -1 && max_length <= 5) {
		  System.out.println("TU SHORT");
		  done_growing = true;
		}
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
//		System.out.println(curr_length + " " + growth_speed + " " + d);
		curr_length += growth_speed * d;
		
		if (curr_length > max_length) {
		  System.out.println("DONE");
			done_growing = true;
			curr_length = max_length;
			if (branches[0] == null) {
				for (int i = 0; i < num_branches; i++) {
					float angle = this.position.z - angle_range/2 + angle_range/(float)(num_branches-1)*i;
					float x = position.x + curr_length * cos(position.z);
					float y = position.y + curr_length * sin(position.z);
					PVector pos = new PVector(x,y,angle);
					if (branch_limit == -1) {
					  branches[i] = new Tree(pos, colour, max_length*decay, growth_speed * decay, angle_range, decay, num_branches);
					} else {
					  branches[i] = new Tree(pos, colour, max_length*decay, growth_speed * decay, angle_range, decay, num_branches, branch_limit, branch_count+1);
          }
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
		float x = position.x + curr_length * cos(position.z);
    float y = position.y + curr_length * sin(position.z);
    sketch.line(position.x, position.y, x, y);
		if (branches[0] != null) {
      for (int i = 0; i < num_branches; i++) {
        branches[i].draw();
      }
    }
		
	}
}
