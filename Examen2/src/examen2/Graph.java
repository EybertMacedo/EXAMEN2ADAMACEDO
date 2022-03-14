package examen2;


import java.util.ArrayList;

public class Graph<E> {
	public ArrayList<Node<E>> listNodes = new ArrayList<Node<E>>();

	public Graph() {
	}

	public Node<E> addVertex(E e) {
		Node<E> node = new Node<E>(e);
		listNodes.add(node);
		return node;
	}

	public void addUndirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		node2.addVecino(node1, distancia);
	}

	public void addDirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
	}

	public int size() {
		return listNodes.size();
	}

	public Node<E> getNode(int i) {
		return listNodes.get(i);
	}

	public int indexOf(Node<E> node) {
		return listNodes.indexOf(node);
	}
}
