package funni.graph;

import mindustry.gen.*;

public class FloatUpdater implements Entityc {
	public transient FloatGraph graph;

	@Override
	public void update() {
		graph.update();
	}
}