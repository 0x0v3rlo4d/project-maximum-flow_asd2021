

public class Graph {
private int numVertex;
private int money;
private int[][] adjacencyMatrix;
private double waktu;
private double kecepatan;
char [] parent;
        public Graph(int numVertex){
                this.numVertex = numVertex;
                this.adjacencyMatrix = new int[numVertex][numVertex];
                this.parent = new char[numVertex];
                this.money=0;
                this.waktu=0;
}

public void addEdge(int from, int to,int len)
{
    from -= 'A';
    to -= 'A';
    adjacencyMatrix[from][to]=len*10;
    adjacencyMatrix[to][from]=len*10;
    
}



        public void displayGraph(){
                for(int i=0; i < numVertex; i++){
                for(int j = 0; j < numVertex; j++){
               // System.out.print(adjacencyMatrix[i][j] + " ");
}
        //System.out.println();
}
}
            public int dijkstra(int Src, int dst){
                    int[] distance = new int[numVertex];
                    boolean[] fixed = new boolean[numVertex];
                     
                     Src -= 'A';
                     dst -= 'A';
                    for(int i = 0; i < numVertex; i++){
                     distance[i] = Integer.MAX_VALUE;
                    fixed[i] = false;
}
            distance[Src] = 0;
            parent[Src] = '_';
                    while(true){
                        int marked = minIndex(distance, fixed);
                        if(marked < 0) break;
                        if(distance[marked] == Integer.MAX_VALUE) break;
                        fixed[marked] = true;
                        for(int j = 0; j < numVertex; j++){
                                        if(adjacencyMatrix[marked][j] > 0 && !fixed[j]){
                                        int newDistance = distance[marked] + adjacencyMatrix[marked][j];
                                        if(newDistance < distance[j]){
                                            distance[j] = newDistance;
                                            parent[j] = (char)(marked+'A');
}
}
}
}
                    if(distance[dst] == Integer.MAX_VALUE) System.out.println("No route found");
                            else{
                            System.out.println("Jarak dari " + (char)(Src+'A') + " ke  " + (char)(dst+'A') + " adalah " + (distance[dst]/10)+" KM");
                            //System.out.print("Rute: " + " -> ");
                            route((char)dst);
                           // System.out.print("Jaraknya : ");
                           // System.out.print(distance[dst]);
                          
                                }
            this.money=distance[dst]*10000/19; //Harga bensin per KM = 10000, 1 liter bs mengantarkan sejauh 19 Km
            //System.out.println(distance[dst]);
            this.waktu=distance[dst]/15.0; 
            System.out.println("Waktu yang diperlukan untuk sampai adalah : "+ this.waktu*60 + " Menit");
            return distance[dst];
                   
}
public double getMoney(){
    System.out.println("menghabiskan biaya bensin : ");
    return this.money;
}
public double getKecepatan(){
    System.out.println("Waktu yang diperlukan : ");
    return this.kecepatan*60;
}
public void route (char dst) {
    StringBuilder route= new StringBuilder("");
    int count=0;
        while(parent[dst]!='_')
        {
            //System.out.println(parent[dst]);
            route.insert(0, "-"+(char)(dst+'A'));
            dst= (char) (parent[dst]-'A');
            count++;
        }

        route.insert(0,(char)(dst+'A'));
        System.out.println("Traveler Melewati "+ (count+1) + " Tempat" + " Dengan Rute ");
        System.out.println(route);

    }
    
    public void otherRoute(int a, int b, int src, int dst){
        System.out.println("Oops! Jalan tidak dapat dilalui karena situasi tak terduga. Mencari rute lain.");
        a -= 'A';
        b -= 'A';
        adjacencyMatrix[a][b]=10000;
        adjacencyMatrix[b][a]=10000;
        dijkstra(src, dst);
    }
    private int minIndex(int[] distance, boolean[] fixed){
            int idx = 0;
            for(; idx < numVertex; idx++){
if(!fixed[idx]) break;
}
                    if(idx == fixed.length) return -1;
                        for(int i = idx + 1; i < fixed.length; i++){
               if(!fixed[i] && distance[i] < distance[idx]){
        idx = i;
}
}
                        return idx;
                }
                }
