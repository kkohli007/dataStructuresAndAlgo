package src.dataStructures.graphs;

import java.util.*;

public class Graph {

    private boolean isDirected;

    private Map<Vertex, List<Vertex>> adjacencyList;

    public Graph(boolean isDirected){
        adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addVertex(String label)
    {
        Vertex vertex = new Vertex(label);
        adjacencyList.put(vertex, null);
    }

    public void removeVertex(String label)
    {
        adjacencyList.remove(new Vertex(label));
    }

    public void addEdge(String sourceVertexLabel, String destinationVertexLabel)
    {
        Vertex sourceVertex = new Vertex(sourceVertexLabel);
        Vertex destinationVertex = new Vertex(destinationVertexLabel);
        if(!adjacencyList.containsKey(sourceVertex))
        {
            System.out.println("Source Vertex not present:" + sourceVertex);
            return;
        }
        if(!adjacencyList.containsKey(destinationVertex))
        {
            System.out.println("Destination Vertex not present:" + destinationVertex);
            return;
        }

        if(adjacencyList.get(sourceVertex) != null)
        {
            adjacencyList.get(sourceVertex).add(destinationVertex);
        }
        else
        {
            List<Vertex> vertexList = new ArrayList<>();
            vertexList.add(destinationVertex);
            adjacencyList.put(sourceVertex, vertexList);
        }

        if(!isDirected)
        {
            if(adjacencyList.get(destinationVertex) != null)
            {
                adjacencyList.get(destinationVertex).add(sourceVertex);
            }
            else
            {
                List<Vertex> vertexList = new ArrayList<>();
                vertexList.add(sourceVertex);
                adjacencyList.put(destinationVertex, vertexList);
            }
        }
    }

    public void removeEdges(String sourceVertexLabel, String destinationVertexLabel)
    {
        Vertex sourceVertex = new Vertex(sourceVertexLabel);
        Vertex destinationVertex = new Vertex(destinationVertexLabel);
        if(!adjacencyList.containsKey(sourceVertex))
        {
            System.out.println("Source Vertex not present:" + sourceVertex);
            return;
        }
        if(!adjacencyList.containsKey(destinationVertex))
        {
            System.out.println("Destination Vertex not present:" + destinationVertex);
            return;
        }

        boolean edgeDeleted = deleteEdge(sourceVertex, destinationVertex);

        if(!isDirected)
        {
            deleteEdge(destinationVertex, sourceVertex);
        }
    }

    private boolean deleteEdge(Vertex sourceVertex, Vertex destinationVertex)
    {
        List<Vertex> vertexList = adjacencyList.get(sourceVertex);
        boolean isEdgeFound = false;
        if(vertexList!=null)
        {
            Iterator listIterator = vertexList.iterator();

            while(listIterator.hasNext())
            {
                if(listIterator.next().equals(destinationVertex))
                {
                    isEdgeFound = true;
                    vertexList.remove(destinationVertex);
                    break;
                }
            }
        }
        if(!isEdgeFound) {
            System.out.println("Edge not found Source vertex:" + sourceVertex + ",Destination Vertex:" + destinationVertex);
        }
        return isEdgeFound;
    }

    public void printGraphList()
    {
        for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyList.entrySet())
        {
            System.out.print(entry.getKey() + " ::");

            if(entry.getValue() != null)
            {
                for (Vertex vertex : entry.getValue()) {
                    System.out.print(" -> " + vertex);
                }
                System.out.println();
            }
            else
            {
                System.out.println(" -> null");
            }
        }
    }
}
