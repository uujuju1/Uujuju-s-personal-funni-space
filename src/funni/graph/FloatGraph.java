package funni.graph;

import arc.struct.*;

public class FloatGraph {
	public float id;
	public static float groupId;

	public FloatUpdater entity;

	public Seq<GraphBlockBuild> builds = new Seq<>(false, 16, Building.class);

	public FloatGraph() {
		entity = FloatUpdater::new;
		entity.graph = this;
		id = groupId++;
	}

	public float getId() {return id;}

	public void mergeGraph(FloatGraph with) {
		if (with == this) return;

		with.entity.remove();
		
		for (GraphBlockBuild build : with.builds) {
			addBuild(build);
		}
	}

	public void update() {
		set(builds.get(0).graph.value);
	}

	public void addBuild(GraphBlockBuild build) {
		if (build == null || build.graph == null) return;
		builds.add(build); 
	}

	public void clear() {
		builds.clear();
		entity.remove();
	}

	public void set(float amount) {for (GraphBlockBuild build : with.builds) build.graph.amount = amount;}

}