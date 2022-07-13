package funni.graph;

import arc.struct.*;
import funni.graph.GraphBlock.*;

public class FloatGraph {
	public float id;
	public static float groupId;

	public Seq<GraphBlockBuild> builds = new Seq<>(16);

	public FloatGraph() {
		id = groupId++;
	}

	public float getId() {return id;}

	public void mergeGraph(FloatGraph with) {
		if (with == this) return;
		
		for (GraphBlockBuild build : with.builds) {
			addBuild(build);
		}
	}

	public void update() {
		if (builds.size == 0) return;
		set(builds.get(0).module.value);
	}

	public void addBuild(GraphBlockBuild build) {
		if (build == null || build.module == null) return;
		build.module.graph = this;
		build.id = build.groupId++;
		builds.add(build); 
	}

	public void clear() {
		builds.clear();
	}

	public void set(float amount) {for (GraphBlockBuild build : builds) build.module.value = amount;}

}