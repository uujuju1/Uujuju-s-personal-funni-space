package funni.graph;

import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.world.*;

public class GraphBlock extends Block {
	public GraphBlock(String name) {
		super(name);
		update = true;
	}

	public class GraphBlockBuild extends Building {
		public int id;
		public static int groupId;
		FloatModule module = new FloatModule();

		@Override
		public void updateTile() {
			if (module.graph.builds.get(id) != this) module.graph.addBuild(this);
			module.graph.update();
			for (int i = 0; i < proximity.size; i++) {
				if (proximity.get(i) instanceof GraphBlockBuild) {
					GraphBlockBuild next = (GraphBlockBuild) proximity.get(i);
					if (next.module.graph != module.graph) module.graph.mergeGraph(next.module.graph);
				}
			}
		}

		@Override
		public void draw() {
			Lines.stroke(3);
			Lines.lineAngle(x, y, 0, module.value);
		}
	}
}