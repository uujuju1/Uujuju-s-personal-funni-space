package funni.content;

import mindustry.world.*;
import mindustry.world.meta.*;
import funni.graph.*;

public class FunniBlocks {
	public static Block test;
	public void load() {
		test = new GraphBlock("test") {{
			buildVisibility = BuildVisibility.shown;
			size = 1;
			destructible = true;
			sync = true;
		}};
	}
}