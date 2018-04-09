package data.structure.graph.directed;

/**
 * A directed edge clearly defines a direction from a vertex <code>v</code>
 * to another vertex <code>w</code>. The directed edge will also have a weight
 * associated with the directed connection.
 * 
 * @author santhosh
 *
 * @param <T> type of vertex
 */
public class DirectedEdge<T> {

	private final T v;
	
	private final T w;
	
	private final int weight;
	
	public DirectedEdge(T from, T to, int weight) {
		this.v = from;
		this.w = to;
		this.weight = weight;
	}
	
	public T from() {
		return v;
	}
	
	public T to() {
		return w;
	}
	
	public int weight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return v + " --- ("+weight+") ---> " + w;
	}
}
