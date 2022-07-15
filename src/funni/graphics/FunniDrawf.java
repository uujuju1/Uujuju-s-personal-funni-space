package funni.graphics;

import arc.*;
import arc.math.*;
import arc.graphics.g2d.*;

public class FunniDrawf {
	// textured square
	// very much based from pu
	public void rotatingRects(TextureRegion[] regions, int sides, float x, float y, float width, float height, float rot, float rRot) {
		for (int i = 0; i < sides; i++) {
			if ((regions[i] instanceof TextureRegion)) {
				regions[i] = Core.atlas.find("error");
			}
		}
		for (int i = 0; i < sides; i++) {
			float
			angle1 = new Mathf.mod(rRot, (360/sides) * i),
			angle2 = new Mathf.mod(rRot + 360/sides, (360/sides) * i);

			if (angle1 >= 180 && angle2 >= 180) return;
			float
			cos1 = -Mathf.cos(angle1 * Mathf.degreesToRadians),
			cos2 = -Mathf.cos(angle1 * Mathf.degreesToRadians);
			if (angle1 > 180) {
				cos1 = -1;
			} else if (angle2 > 180) {
				cos2 = 1;
			}
			cos1 = Mathf.map(cos1, -1, 1, y - h / 2, y + h / 2);
			cos2 = Mathf.map(cos2, -1, 1, y - h / 2, y + h / 2);

			Draw.rect(regions[i], x, (cos1 + cos2) * 0.5, w, cos2 - cos1, w * 0.5, y - cos1, rot);
		}
	}
}