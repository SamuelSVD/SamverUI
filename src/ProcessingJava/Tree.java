/* NOTE: Rotation is stored in position.z */
package ProcessingJava;
import processing.core.*;
public class Tree extends VisualComponent{
	float curr_length, max_length, growth_speed, decay, angle_range;
	int num_branches;
	int branch_count;
	int branch_limit = -1;
	boolean done_growing;
	Tree [] branches;
	protected Tree(PVector position, double rotation, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit, int branch_count) {
    super(position, colour);
    rotation_after_translate = rotation;
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
    isActive = true;
  }
  
  public Tree(PVector position, double rotation, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches, int branch_limit) {
    this(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, branch_limit, 0);
  }
    
	public Tree(PVector position, double rotation, PVector colour, float max_length, float growth_speed, float angle_range, float decay, int num_branches) {
    this(position, rotation, colour, max_length, growth_speed, angle_range, decay, num_branches, -1, 0);
		if (branch_limit == -1 && max_length <= 5) {
		  //System.out.println("TU SHORT");
		  done_growing = true;
		}
	}
	public void update(float d) {
		super.update(d);
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
		  //System.out.println("DONE");
			done_growing = true;
			curr_length = max_length;
			if (branches[0] == null) {
				for (int i = 0; i < num_branches; i++) {
				  float angle = angle_range/(float)(num_branches-1)*i - angle_range/2;
          float x = curr_length;
          float y = 0;
          PVector pos = new PVector(x,y);
					if (branch_limit == -1) {
					  branches[i] = new Tree(pos, angle, colour, max_length*decay, growth_speed * decay, angle_range, decay, num_branches);
					} else {
					  branches[i] = new Tree(pos, angle, colour, max_length*decay, growth_speed * decay, angle_range, decay, num_branches, branch_limit, branch_count+1);
          }
					branches[i].setSketch(sketch);
				}
			}
		}
	}
	public void draw() {
	  sketch.stroke(0);
	  sketch.strokeWeight(5);
	  sketch.line(0,0,curr_length,0);
		if (branches[0] != null) {
      for (int i = 0; i < num_branches; i++) {
        branches[i].doDraw();
      }
    }
	}
}
