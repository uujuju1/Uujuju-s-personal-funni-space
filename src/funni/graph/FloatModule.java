package funni.graph;

import arc.util.io.*;
import mindustry.world.modules.*;
import funni.graph.GraphBlock.*;

public class FloatModule extends BlockModule {
	public float value = 0;
	public GraphBlockBuild starter;
	public FloatGraph graph;

	public FloatModule(GraphBlockBuild starter) {
		this.starter = starter;
		graph = new FloatGraph(starter);
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