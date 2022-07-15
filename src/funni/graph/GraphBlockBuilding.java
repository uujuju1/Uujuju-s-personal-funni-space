package funni.graph;
// quality of life building
public interface GraphBlockBuilding {
	default GraphModule getGraph() {return null;}

	default void setValue(float amount) {
		getGraph().value = amount;
	} 

	default float getValue() {return getGraph().value;}

	default float getFixedRot() {return 0f;}
}