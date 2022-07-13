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
		FloatModule graph = new FloatModule();

		@Override
		public void updateTile() {
			graph.graph.update();
			for (int i = 0; i < proximity.size; i++) {
				if (proximity.get(i) instanceof GraphBlockBuild) {
					GraphBlockBuild next = (GraphBlockBuild) proximity.get(i);
					if (next.graph.graph != graph.graph) graph.graph.mergeGraph(next.graph.graph);
				}
			}
		}

		@Override
		public void draw() {
			Lines.stroke(3);
			Lines.lineAngle(x, y, 0, graph.value);
		}
	}
}