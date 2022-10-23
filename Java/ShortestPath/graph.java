package ShortestPath;

import java.util.ArrayList;
import java.util.List;

public class graph {

	private int numOfVertices;// number of vertices in graph

	private String[] vertices;// vertices array

	private int[][] edges;// weights of edges matrix

	public graph(int num) // constructor to allocate space for matrix and vertices array

	{

		numOfVertices = num;

		vertices = new String[numOfVertices];

		edges = new int[numOfVertices][numOfVertices];

		for (int i = 0; i < numOfVertices; i++)

		{

			for (int j = 0; j < numOfVertices; j++)

			{

				edges[i][j] = 0;// initially all are 0 meaning no edge exists

				// or we can allocate Integer.MAX_VALUE to each cell to represent no edge

			}

		}

	}

	public void setVertex(int index, String vertex)

	{

		vertices[index] = vertex;// sets vertices/cities names

	}

	public int getVertexNo(String vertex)// gets the position of city in matrix

	{

		for (int i = 0; i < numOfVertices; i++)

		{

			if (vertices[i].equals(vertex))

				return i;

		}

		return -1;// returns -1 if city wasn't allocated

	}

	public void addEdge(String v1, String v2, int weightOfEdge)// adds and edge between two cities

	{

		int i = getVertexNo(v1);// retrieve the index of city/vertex

		int j = getVertexNo(v2);// retrieve the index of city/vertex

		if (i != -1 && j != -1)// if city exists

		{

			edges[i][j] = weightOfEdge;// sets edge for both cities indices

			edges[j][i] = weightOfEdge;// both are reachable through a single edge

		}

	}

	public int getDistance(String v1, String v2)

	{

		int i = getVertexNo(v1);// retrieve the index of city/vertex

		int j = getVertexNo(v2);// retrieve the index of city/vertex

		if (i != -1 && j != -1)// if cities exists

			if (edges[i][j] != 0)// if edge exists

				return edges[i][j];// returns the edge value

		return Integer.MAX_VALUE;// else maximum integer value is returned

	}

	public List<String> getNeighbors(String v1)

	{

		int i = getVertexNo(v1);// retrieve the index of city/vertex

		List<String> neighbors = new ArrayList<>();// list to hold neighbors

		if (i != -1)// if city exists

			for (int j = 0; j < numOfVertices; j++)// checks in edge matrix for all vertices

			{

				if (edges[i][j] != 0)// if edge exists

					neighbors.add(vertices[j]);// add the neighbor to list

			}

		return neighbors;// return the list

	}

	public void print()

	{

		for (int j = 0; j < numOfVertices; j++)

		{

			System.out.println(vertices[j] + "(" + (char) (65 + j) + ") ");

			//representing city names with A to O (15 cities)

		}

		System.out.println(" ");

		System.out.print("   ");// adjusting spaces

		for (int j = 0; j < numOfVertices; j++)

		{

			System.out.print((char) (65 + j) + "\t");

		} // first row of matrix with column names as A to O

		System.out.println("");

		for (int i = 0; i < numOfVertices; i++)

		{

			System.out.print((char) (65 + i) + "  ");// row numbers from A to O

			for (int j = 0; j < numOfVertices; j++)

			{

				System.out.print(edges[i][j] + "\t");// edge weight between cities/vertices

			}

			System.out.println("");

		}

	}

}