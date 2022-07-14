package funni.graph;

import arc.util.io.*;
import mindustry.world.modules.*;
import funni.graph.GraphBlock.*;

public class GraphModule extends BlockModule {
	public static int blockId;

	public float value = 0;
	public GraphBlockBuild starter;
	public Seq<GraphBlockBuild> builds = new Seq<>(16);

	public FloatModule(GraphBlockBuild starter) {
		this.starter = starter;
		graph = new FloatGraph(starter);
		addBlock(starter);
	}

	public void addBlock(GraphBlockBuild new) {
		new.module = this;
		new.id = blockId++;
		builds.add(new);
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