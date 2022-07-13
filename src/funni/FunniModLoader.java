package funni;

import mindustry.mod.*;
import funni.content.*;

public class FunniModLoader extends Mod{

	public FunniModLoader(){
	}

	@Override
	public void loadContent(){
		new FunniBlocks().load();
	}

}
