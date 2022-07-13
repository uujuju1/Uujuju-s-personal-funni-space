package funni.graph;

import arc.struct.*;
import funni.graph.GraphBlock.*;

public class FloatGraph {
	public float id;
	public static float groupId;

	public Seq<GraphBlockBuild> builds = new Seq<>();

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
		set(builds.get(0).graph.value);
	}

	public void addBuild(GraphBlockBuild build) {
		if (build == null || build.graph == null) return;
		build.graph.graph = this;
		builds.add(build); 
	}

	public void clear() {
		builds.clear();
	}

	public void set(float amount) {for (GraphBlockBuild build : builds) build.graph.value = amount;}

}