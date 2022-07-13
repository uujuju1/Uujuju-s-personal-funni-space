package funni.graph;

import mindustry.entities.comp.*;

public class FloatUpdater extends EntityComp {
	public transient FloatGraph graph;

	@Override
	public void update() {
		graph.update();
	}
}