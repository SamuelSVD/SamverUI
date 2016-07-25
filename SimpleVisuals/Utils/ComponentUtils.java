package Utils;

import component.*;
import java.util.ArrayList;

public class ComponentUtils {

	public ComponentUtils() {
	}

	public static boolean VolumeCollide(SVArea area1, SVArea area2) {
		float x1 = area1.position.getX().getValue();
		float y1 = area1.position.getY().getValue();
		float z1 = area1.position.getZ().getValue();
		float w1 = area1.size.getWidth().getValue();
		float h1 = area1.size.getHeight().getValue();
		float d1 = area1.size.getDepth().getValue();
		float x2 = area2.position.getX().getValue();
		float y2 = area2.position.getY().getValue();
		float z2 = area2.position.getZ().getValue();
		float w2 = area2.size.getWidth().getValue();
		float h2 = area2.size.getHeight().getValue();
		float d2 = area2.size.getDepth().getValue();
		
		return false;
	}
	public static boolean volumeCollide(float x1, float y1, float z1, float w1, float h1, float d1, float x2, float y2, float z2, float w2, float h2, float d2) {
		return false;
	}
	public static boolean rectCollide3D(float x1, float y1, float z1, float w1, float h1, float d1, float x2, float y2, float z2, float w2, float h2, float d2) {
		if ()
	}
	public static boolean rectCollide(float x1, float y1, float l1, float w1, float x2, float y2, float l2, float w2) {
		if (l1 < 0) {
			x1 = x1 - l1;
			l1 = -l1;
		}
		if (w1 < 0) {
			y1 = y1 - w1;
			w1 = -w1;
		}
		if (l2 < 0) {
			x2 = x2 - l2;
			l2 = -l2;
		}
		if (w2 < 0) {
			y2 = y2 - w2;
			w2 = -w2;
		}
		float[][] rect1 = {{x1,y1},{x1+l1,y1},{x1,y1+w1}, {x1+l1,y1+w1}};
		float[][] rect2 = {{x2,y2},{x2+l2,y2},{x2,y2+w2}, {x2+l2,y2+w2}};
		for (int i = 0; i < 4; i++) {
			float temp_x = rect1[i][0];
			float temp_y = rect1[i][1];
			if (temp_x >= rect2[0][0] && temp_x <= rect2[1][0]) {
				if (temp_y >= rect2[0][1] && temp_y <= rect2[2][1]) {
					return true;
				}
			}
		}
		return false;
	}
}
