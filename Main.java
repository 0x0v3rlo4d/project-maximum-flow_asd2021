import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        int numVertex = 9;
        
        Graph map = new Graph(numVertex);
        map.addEdge('A','B',2);
        map.addEdge('A','C',5);
        map.addEdge('A','D',2);
        map.addEdge('A','E',4);
        map.addEdge('B','C',1);
        map.addEdge('C','G',1);
        map.addEdge('C','H',5);
        map.addEdge('D','G',2);
        map.addEdge('D','E',5);
        map.addEdge('D','F',2);
        map.addEdge('E','F',1);
        map.addEdge('F','G',3);
        map.addEdge('F','H',1);
        map.addEdge('G','H',3);

       
        map.displayGraph();
        Scanner satu = new Scanner(System.in);
        System.out.println("Dari daerah mana : ");
        char daerah_awal=satu.next().charAt(0);
        System.out.println("Menuju daerah mana : ");
        char daerah_tujuan = satu.next().charAt(0);


        map.dijkstra(daerah_awal,daerah_tujuan);
        System.out.println();
        System.out.println(map.getMoney());
        //System.out.println(map.getKecepatan()+" Menit ");
        System.out.print("Adakah kendala pada perjalanan? (Ya/Tidak) ");
        Scanner in = new Scanner(System.in);
        
            String check = in.nextLine().toLowerCase();
            if(check.equals("ya")){
                System.out.println("Traveller sudah sampai mana : ");
                char dari = in.next().charAt(0);
                System.out.println("Kendala pada jalan apa? ");
                System.out.print("Dari: ");
                char from = in.next().charAt(0);
                System.out.print("Menuju: ");
                char to = in.next().charAt(0);
                
                map.otherRoute(from, to,dari, daerah_tujuan);
                System.out.println(map.getMoney());
                
                
            }
            else {
                System.out.println(map.getMoney());
                System.out.println("Selamat menikmati perjalanan");
            }
            
            
    }
}
