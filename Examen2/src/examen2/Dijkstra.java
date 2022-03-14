package examen2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra<E> {

	Graph<E> grafo;

	public Dijkstra(Graph<E> g) {
		grafo = g;
	}

	public void setGrafo(Graph<E> g) {
		grafo = g;
	}

	static int[] distancias = null;

	
	public int[] dijkstra(Node<E> nodoInicial) {
		distancias = new int[grafo.size()];
		
		ArrayList<Node<E>> caminos = new ArrayList<Node<E>>();
		for (int i = 0; i < grafo.size(); i++) {
			caminos.add(null
					);
		}
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}

		distancias[grafo.indexOf(nodoInicial)] = 0;

		LinkedList<Node<E>> queue = new LinkedList<Node<E>>();
		queue.add(nodoInicial);
 		
		
		while (!queue.isEmpty()) {
			Node<E> nodoActual = queue.poll();
			for (Node<E> vecino : nodoActual.vecinos) {

				int weight = nodoActual.getDistanciaHacia(vecino);

				int distanceFromU = distancias[grafo.indexOf(nodoActual)] + weight;
				if (distanceFromU < distancias[grafo.indexOf(vecino)]) {

					queue.remove(vecino);
					distancias[grafo.indexOf(vecino)] = distanceFromU;
					
					//actualizar camino anterior
					caminos.set(grafo.indexOf(vecino), nodoActual);
					
					int i = 0;
					for (; i < queue.size(); i++) {
						if (distancias[grafo.indexOf(vecino)] < distancias[i]) {
							break;
						}
					}
					queue.add(i, vecino);
//					System.out.println(queue);
				}
			}
		}
		
		System.out.println("Nodos existentes");
		for (Node<E> node : grafo.listNodes) {
			System.out.print(node.value);
		}
		System.out.println();
		System.out.println("Caminos Minimos:");
		int cont=0;
		System.out.println("Hacia" +"\tDesde"+"\tDistancia");
		for (Node<E> node : caminos) {
			if(node!=null) {
				System.out.println(grafo.listNodes.get(cont+1)+" : \t"+node.value+"\t"+distancias[cont+1]);
				cont++;
			}
		else {
			System.out.println(grafo.listNodes.get(0)+" : \tnull"+"\t"+distancias[cont]);
		}
		}
		System.out.println();
			
		return distancias;
	}

	class RespuestaDijstra{
		int[] distanciasMinimas;
		ArrayList<Node<E>> caminos ;
	}
}

