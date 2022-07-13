package funni.graph;

import arc.util.*;
import arc.struct.*;
import funni.graph.GraphBlock.*;

public class FloatGraph {
	public static int blockId;

	public GraphBlockBuild starter;
	public @Nullable Seq<GraphBlockBuild> builds = new Seq<>();

	public FloatGraph(GraphBlockBuild starter) {
		this.starter = starter;
		addBuild(starter);
	}

	public void mergeGraph(FloatGraph with) {
		if (with == this) return;
		
		for (GraphBlockBuild build : with.builds) {
			addBuild(build);
		}
	}

	public void update() {
		if (builds == null) return; 
		set(starter.module.value);
	}

	public void addBuild(GraphBlockBuild build) {
		if (build == null || build.module == null) return;
		build.module.graph = this;
		build.id = blockId++;
		builds.add(build); 
	}

	public void reset(GraphBlockBuild starter) {
		blockId = 0;
		builds.clear();
		addBuild(starter);
		this.starter = starter;
	}

	public void set(float amount) {for (GraphBlockBuild build : builds) build.module.value = amount;}

}