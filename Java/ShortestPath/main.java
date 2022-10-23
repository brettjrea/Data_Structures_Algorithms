package ShortestPath;

import java.util.List;

public class main {
	
	 public static void main(String[] args)

	    {

	        graph g = new graph(15);//graph with 15 vertices

	        //setting all city names 

	        g.setVertex(0,"Mohave");

	        g.setVertex(1,"Coconino");

	        g.setVertex(2,"Navajo");

	        g.setVertex(3,"Apache");

	        g.setVertex(4,"Greenlee");

	        g.setVertex(5,"Cochise");

	        g.setVertex(6,"Santa Cruz");

	        g.setVertex(7,"Pima");

	        g.setVertex(8,"Pinal");

	        g.setVertex(9,"Graham");

	        g.setVertex(10,"Gila");

	        g.setVertex(11,"Yavapai");

	        g.setVertex(12,"La Paz");

	        g.setVertex(13,"Yuma");

	        g.setVertex(14,"Maricopa");

	        //adding edges between cities

	        g.addEdge("Mohave","Coconino",14);

	        g.addEdge("Mohave","Yavapai",14);

	        g.addEdge("Mohave","La Paz",9);

	        g.addEdge("Coconino","Navajo",9);

	        g.addEdge("Coconino","Gila",17);

	        g.addEdge("Coconino","Yavapai",9);

	        g.addEdge("Navajo","Gila",13);

	        g.addEdge("Navajo","Graham",20);

	        g.addEdge("Navajo","Apache",5);

	        g.addEdge("Apache","Greenlee",17);

	        g.addEdge("Apache","Graham",19);

	        g.addEdge("Greenlee","Cochise",16);

	        g.addEdge("Greenlee","Graham",4);

	        g.addEdge("Cochise","Graham",12);

	        g.addEdge("Cochise","Pima",9);

	        g.addEdge("Cochise","Santa Cruz",8);

	        g.addEdge("Santa Cruz","Pima",6);

	        g.addEdge("Pima","Graham",12);

	        g.addEdge("Pima","Pinal",7);

	        g.addEdge("Pima","Maricopa",10);

	        g.addEdge("Pima","Yuma",23);

	        g.addEdge("Pinal","Graham",13);

	        g.addEdge("Pinal","Gila",5);

	        g.addEdge("Pinal","Maricopa",6);

	        g.addEdge("Graham","Gila",7);

	       

	        g.addEdge("Gila","Yavapai",18);

	        g.addEdge("Gila","Maricopa",8);

	       

	        g.addEdge("Yavapai","La Paz",9);

	        g.addEdge("Yavapai","Maricopa",16);

	        g.addEdge("La Paz","Maricopa",15);

	        g.addEdge("La Paz","Yuma",11);

	        g.addEdge("Maricopa","Yuma",18);

	        //list of neighbors for Maricopa

	        List<String> myList = g.getNeighbors("Greenlee");

	        System.out.print("Neighbor cities of Greenlee : ");

	        System.out.println(myList);//display list

	        System.out.print("Distance between Maricopa and Yuma : " + g.getDistance("Maricopa","Yuma")+"\n");//distance between two cities

	        System.out.print("Adjacency Matrix: \n");
	        g.print();//adjacency matrix

	    }

	}
