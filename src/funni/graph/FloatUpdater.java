package funni.graph;

import mindustry.gen.*;

public class FloatUpdater extends EntityComp {
	public transient FloatGraph graph;

	@Override
	public void update() {
		graph.update();
	}
}