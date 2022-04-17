import java.util.ArrayList;
import java.util.List;


public class Prim {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(false); //Prim es con lista

        for (int i = 0; i < 9; i++) {
            grafo.anhadirNodo();
        }
        grafo.anhadirVertice(0, 1, 4);
        grafo.anhadirVertice(0, 7, 8);
        grafo.anhadirVertice(1, 2, 8);
        grafo.anhadirVertice(1, 7, 11);
        grafo.anhadirVertice(2, 3, 7);
        grafo.anhadirVertice(2, 8, 2);
        grafo.anhadirVertice(2, 5, 4);
        grafo.anhadirVertice(3, 4, 9);
        grafo.anhadirVertice(3, 5, 14);
        grafo.anhadirVertice(4, 5, 10);
        grafo.anhadirVertice(5, 6, 2);
        grafo.anhadirVertice(6, 7, 1);
        grafo.anhadirVertice(6, 8, 6);
        grafo.anhadirVertice(7, 8, 7);

        algoritmoDePrim(grafo);

    }

    public static void algoritmoDePrim(Grafo g){
        ArrayList<Integer> visitados = new ArrayList();
        int nodoInicio = g.darPrimerNodo(); //Escogeremos el primer nodo pq sí
        visitados.add(nodoInicio);
        List<Grafo.Tupla<Integer, Integer>> vertices = g.darAdyacenciasDeNodo(nodoInicio);
        //While no hayamos visitado todos los nodos
        while(visitados.size() != g.nodos().size()){
            int menorpeso = Integer.MAX_VALUE; //MAX_VALUE para que esto sea true con cualquier peso
            int nodomenorpeso = -1; //El nodo -1 no existe, no hay problema B)
            for (int i = 0; i < vertices.size(); i++) {

                //System.out.println("Considerando vértice hacia: " + vertices.get(i).objeto1 + ", con peso de: " + vertices.get(i).objeto2);

                //Si este camino nos lleva a un nodo ya visitado, lo sacamos de la lista
                if(visitados.contains(vertices.get(i).objeto1)){
                    vertices.remove(i);
                    i--;
                    //System.out.println("Ya habíamos visitado este vértice, skip");
                    //System.out.println("----------------------------------------");
                    continue;
                }
                //Vamos por el camino con menor peso
                if(vertices.get(i).objeto2 < menorpeso){
                    menorpeso = vertices.get(i).objeto2;
                    nodomenorpeso = vertices.get(i).objeto1;
                    //System.out.println("Este vértice es el nuevo menor. Su peso es de " + menorpeso);
                    //System.out.println("-----------------------------------------------------------");
                    continue;
                }
                //System.out.println("Nada importante.");
                //System.out.println("------------------");
            }
            visitados.add(nodomenorpeso); //Marcamos el nodo del camino con menor peso como visitado
            System.out.println("Nodo marcado como visitado: " + nodomenorpeso);

            vertices.addAll(g.darAdyacenciasDeNodo(nodomenorpeso)); //Y ahora tmb consideraremos visitar los vértices del nuevo nodo
        }

    }

}
