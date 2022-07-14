package funni.graph;

import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.world.*;

public class GraphBlock extends Block {
	public GraphBlock(String name) {
		super(name);
		update = true;
	}

	public class GraphBlockBuild extends Building implements GraphBlockBuilding {
		public int id;
		public GraphModule module = new GraphModule(this);

		public GraphModule getGraph() {return module;}

		@Override
		public void updateTile() {
			if (module.starter == this) module.update(); 
			for (int i = 0; i < proximity.size; i++) {
				if (proximity.get(i) instanceof GraphBlockBuild) {
					GraphBlockBuild next = (GraphBlockBuild) proximity.get(i);
					if (next.module != module) module.addBlock(next);
				}
			}
		}

		@Override
		public void onRemoved() {
			module.builds.remove(id);
			module.updateId();
		}

		@Override
		public void draw() {
			Lines.stroke(3);
			Lines.lineAngle(x, y, getValue() * 5, 3);
		}
	}
}