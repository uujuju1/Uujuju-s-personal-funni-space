package funni.graphics;

import arc.*;
import arc.math.*;
import arc.graphics.g2d.*;

public class FunniDrawf {
	// textured square
	// very much based from pu
	public static void rotatingRects(TextureRegion[] regions, int sides, float x, float y, float width, float height, float rot, float rRot) {
		for (int i = 0; i < sides; i++) {
			float
			angle1 = Mathf.mod(rRot + (360f/sides * i), 360),
			angle2 = Mathf.mod(rRot + (360f/sides) + (360f/sides * i), 360);

			if (!(angle1 >= 180f && angle2 >= 180f)) return;
			float
			cos1 = -Mathf.cos(angle1 * Mathf.degreesToRadians),
			cos2 = -Mathf.cos(angle1 * Mathf.degreesToRadians);
			if (angle1 > 180f) {
				cos1 = -1;
			} else if (angle2 > 180f) {
				cos2 = 1;
			}
			cos1 = Mathf.map(cos1, -1f, 1f, y - height / 2f, y + height / 2f);
			cos2 = Mathf.map(cos2, -1f, 1f, y - height / 2f, y + height / 2f);

			Draw.rect(regions[i], x, (cos1 + cos2) * 0.5f, width, cos2 - cos1, width * 0.5f, y - cos1, rot);
		}
	}
}