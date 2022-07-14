package funni.graph;

import arc.util.io.*;
import mindustry.world.modules.*;
import funni.graph.GraphBlock.*;

public class GraphModule extends BlockModule {
	public static int blockId;

	public float value = 0;
	public GraphBlockBuild starter;
	public Seq<GraphBlockBuild> builds = new Seq<>(16);

	public GraphModule(GraphBlockBuild starter) {
		this.starter = starter;
		graph = new FloatGraph(starter);
		addBlock(starter);
	}

	public void addBlock(GraphBlockBuild newer) {
		newer.module = this;
		newer.id = blockId++;
		builds.add(newer);
	}

	@Override
	public void write(Writes write){
		write.f(value);
	}

	@Override
	public void read(Reads read){
		value = read.f();
	}
}