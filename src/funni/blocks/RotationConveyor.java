package funni.blocks;

import arc.*;
import arc.graphics.g2d.*;
import funni.graph.*;
import funni.graphics.*;

public class RotationConveyor extends GraphBlock {
	public TextureRegion[] rotatorRegions;
	public int rotatorSides = 3;
	public TextureRegion baseRegion, topRegion, rotatorShadowRegion;

	public RotationConveyor(String name) {
		super(name);
		rotate = true;
		solid = true;
	}

	@Override
	public void load() {
		super.load();
		rotatorRegions = new TextureRegion[rotatorSides]
		baseRegion = Core.atlas.find(name + "-base");
		topRegion = Core.atlas.find(name + "-top");
		for (int i = 0; i < rotatorSides; i++) {
			rotatorRegions[i] = Core.atlas.find(name + "-rotator" + i);
		}
		rotatorShadowRegion = Core.atlas.find(name + "-rotator-shadow");
	}

	public class RotationConveyorBuild extends GraphBlockBuild {
		@Override
		public void addBuilds() {
			GraphBlockBuild next;
			if (front() instanceof GraphBlockBuild) {
				next = (GraphBlockBuild) front();
				if (next.module != module) module.addBlock(next);
			}
			if (front() instanceof GraphBlockBuild) {
				next = (GraphBlockBuild) front();
				if (next.module != module) module.addBlock(next);
			}
		}

		@Override
		public void draw() {
			Draw.rect(baseRegion, x, y, rotdeg());
			FunniDrawf.rotatingRects(rotatorRegions, rotatorSides, x, y, 8, 2, getFixedRot(), module.rotationDelta);
			Draw.rect(rotatorShadowRegion, x, y, rotdeg());
			Draw.rect(topRegion, x, y, rotdeg());
		}
	}
}