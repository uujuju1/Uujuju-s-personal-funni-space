package funni.graph;

import arc.util.*;
import arc.struct.*;
import arc.util.io.*;
import mindustry.world.modules.*;
import funni.graph.GraphBlock.*;

public class GraphModule extends BlockModule {
	public int blockId;

	public float 
	value = 0,
	rotationDelta;	
	public GraphBlockBuild starter;
	public Seq<GraphBlockBuild> builds = new Seq<>(16);

	public GraphModule(GraphBlockBuild starter) {
		this.starter = starter;
		rotationDelta = 0;
		addBlock(starter);
	}

	public void addBlock(GraphBlockBuild newer) {
		newer.module = this;
		newer.id = blockId++;
		builds.add(newer);
	}

	public void update() {
		builds.each(build -> {if (build != builds.get(0)) build.setValue(starter.getGraph().value);});
		rotationDelta += value * Time.delta;
	}
	public void updateId() {
		builds.each(build -> {
			for (int i = 0; i < builds.size; i++) {
				if (builds.get(i) == build) {
					build.id = i;
				}
			}
		});
		blockId = builds.size;
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