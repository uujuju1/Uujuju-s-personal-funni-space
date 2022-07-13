package funni.graph;

import arc.util.io.*;
import mindustry.world.modules.*;

public class FloatModule extends BlockModule {

	public float value = 0;

	public FloatGraph graph = new FloatGraph();

	@Override
	public void write(Writes write){
		write.f(value);
	}

	@Override
	public void read(Reads read){
		value = read.f();
	}
}