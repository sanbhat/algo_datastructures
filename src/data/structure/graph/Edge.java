package data.structure.graph;

/**
 * An edge represents the connection between two vertices and a weighted edge,
 * carries an extra placeholder called as <b>weight</b>. The structure <code>Edge</code>
 * contains three fields, first vertex, second vertex (which are connected to each other)
 * and the weight of the connection.
 * 
 * @author santhosh
 *
 * @param <T> type of vertex
 */
public final class Edge<T> implements Comparable<Edge<T>>{

	private final T v;
	
	private final T w;
	
	private final int weight;
	
	public Edge(T v, T w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public T either() {
		return v;
	}
	
	public T other(T vs) {
		if(vs == v) {
			return w;
		} else {
			return v;
		}
	}

	@Override
	public int compareTo(Edge<T> o) {
		return Integer.compare(this.weight, o.weight);
	}

	@Override
	public String toString() {
		return v + "---("+this.weight+")---" + w;
	}
	
	
}
