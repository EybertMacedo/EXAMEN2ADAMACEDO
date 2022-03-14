package examen2;


import java.util.Random;


public class Ejecucion {
	public static void main(String[] args) {

		
		Graph<String> g = new Graph<String>();

		Node<String> A = g.addVertex("A");	
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");

		g.addUndirectedEdge("A", 13, "B");
		g.addUndirectedEdge("A", 11, "C");			
		g.addUndirectedEdge("B", 20, "C");
		g.addUndirectedEdge("B", 50, "E");
		g.addUndirectedEdge("B", 32, "E");
		g.addUndirectedEdge("C", 2, "D");
		g.addUndirectedEdge("D", 23, "B");
		g.addUndirectedEdge("D", 1, "C");
	

		Dijkstra<String> d = new Dijkstra<String>(g);
		
		d.dijkstra(A);


	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	static void print(String[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}
	static void print(int[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + "  ");
		}
		System.out.println();
	}
	static void print(double[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + "  ");
		}
		System.out.println();
	}

	static Graph<Integer> generatorGraph(int n) {
		Random rand = new Random();
		Graph<Integer> g = new Graph<Integer>();
		for (int i = 0; i < n; i++) {
			g.addVertex(i);
		}
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (i < j) {
					int value = rand.nextInt(50);
					if (value < 30) {
						g.addUndirectedEdge(i, value, j);
					}
				}
			}
		}
		return g;
	}

}