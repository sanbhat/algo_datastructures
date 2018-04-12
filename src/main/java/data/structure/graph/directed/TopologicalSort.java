package data.structure.graph.directed;

public class TopologicalSort<T> {

	private Iterable<T> order;
	
	public TopologicalSort(Digraph<T> graph) {
		DirectedCycleDetection<T> cycleDetection = new DirectedCycleDetection<>(graph);
		if(!cycleDetection.hasCycle()) {
			order = new DepthFirstOrder<T>(graph).reversePost();
		}
	}

	public boolean isDAG() {
		return order != null;
	}
	
	public Iterable<T> order() {
		return order;
	}
}
