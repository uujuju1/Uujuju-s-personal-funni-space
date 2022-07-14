package funni.graph;

public interface GraphBlockBuilding {
	default GraphModule getGraph() {return null;}

	default void setValue(float amount) {
		getGraph().value = amount;
	} 

	default float getValue() {return getGraph().value}
}