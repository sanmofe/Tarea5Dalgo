import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {


    static int a;
    static int b;



    public static void main(String[] args) {

        int V = 9;
        Grafo grafo = new Grafo(true); //Kruskal es con matriz
        for (int i = 0; i < 9; i++) {
            grafo.anhadirNodo();
        }
        grafo.anhadirVertice(0, 1, 2);
        grafo.anhadirVertice(0, 3, 7);
        grafo.anhadirVertice(0, 5, 2);
        grafo.anhadirVertice(1, 2, 1);
        grafo.anhadirVertice(1, 3, 4);
        grafo.anhadirVertice(1, 4, 3);
        grafo.anhadirVertice(1, 5, 5);
        grafo.anhadirVertice(2, 4, 4);
        grafo.anhadirVertice(2, 5, 4);
        grafo.anhadirVertice(3, 4, 1);
        grafo.anhadirVertice(3, 6, 5);
        grafo.anhadirVertice(4, 6, 7);

        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringTuple);
        namePriorityQueue.add("0,1,2");
        namePriorityQueue.add("0,3,7");
        namePriorityQueue.add("0,5,2");
        namePriorityQueue.add("1,2,1");
        namePriorityQueue.add("1,3,4");
        namePriorityQueue.add("1,4,3");
        namePriorityQueue.add("1,5,5");
        namePriorityQueue.add("2,4,4");
        namePriorityQueue.add("2,5,4");
        namePriorityQueue.add("3,4,1");
        namePriorityQueue.add("3,6,5");
        namePriorityQueue.add("4,6,7");


       ArrayList<String> kruskal = algoritmoKruskal(grafo, namePriorityQueue);

        for (String aristas : kruskal) {

            System.out.println(""+aristas.split(",")[0]+" - " + aristas.split(",")[1] + " Costo = "+ aristas.split(",")[2]);

        }

    }

    public static ArrayList<String> algoritmoKruskal(Grafo g, PriorityQueue<String> namePriorityQueue) {


        int aristasVis = 0;

        int[] parent = new int[g.nodos().size()];
        int[] rank = new int[g.nodos().size()];

        ArrayList<String> aristasVisitadas = new ArrayList();
        make_set(parent);


        while (aristasVis < 12) {

            String arista = namePriorityQueue.remove();


                if(find(parent,Integer.parseInt(arista.split(",")[1])) != find(parent,Integer.parseInt(arista.split(",")[0]))) {
                    aristasVisitadas.add(arista);
                    union_set(parent, rank, Integer.parseInt(arista.split(",")[0]), Integer.parseInt(arista.split(",")[1]));
                }

                    aristasVis++;



        }
        return aristasVisitadas;
    }



    public static int find(int[] parent, int x)
    {
        if(x != parent[x])
            parent[x] = find(parent, parent[x]);
            System.out.println(parent[x]);
        return parent[x];
    }

    public static void union_set(int[] parent, int[] rank, int x, int y)
    {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY)
            return;
        if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else
        {
            parent[rootX] = rootY;
            if (rank[rootX] == rank[rootY])
                rank[rootY]++;
        }
    }

    public static void make_set(int[] parent)
    {
        for (int i=0; i < parent.length; i++)
            parent[i] = i;
    }



    static Comparator<String> stringTuple = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return Integer.parseInt(s1.split(",")[2]) - Integer.parseInt(s2.split(",")[2]);
        }
    };

}
