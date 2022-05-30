public class Main
{
    public static void main(String[] args) throws Exception 
    {
        int numVertex = 9;
        
        Graph map = new Graph(numVertex);
        map.addEdge('A','B',10);
        map.addEdge('A','C',5);
        map.addEdge('A','D',1);
        map.addEdge('B','E',10);
        map.addEdge('B','G',3);
        map.addEdge('B','C',4);
        map.addEdge('C','E',10);
        map.addEdge('C','F',17);
        map.addEdge('C','D',5);
        map.addEdge('D','F',16);
        map.addEdge('D','H',21);
        map.addEdge('E','G',2);
        map.addEdge('E','F',2);
        map.addEdge('E','I',18);
        map.addEdge('F','I',15);
        map.addEdge('F','H',6);
        map.addEdge('H','I',10);

        map.displayGraph();

        map.dijkstra('A','I');
        System.out.println();
        System.out.println(map.getMoney());
        System.out.println(map.getKeuntungan());
    }
}
