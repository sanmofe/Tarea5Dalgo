import java.util.ArrayList;
import java.util.List;


public class Prim {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(false); //Prim es con lista
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
                //Si este camino nos lleva a un nodo ya visitado, lo sacamos de la lista
                if(visitados.contains(vertices.get(i).objeto1)){
                    vertices.remove(i);
                    continue;
                }
                //Vamos por el camino con menor peso
                if(vertices.get(i).objeto2 < menorpeso){
                    menorpeso = vertices.get(i).objeto2;
                    nodomenorpeso = vertices.get(i).objeto1;
                }
            }
            visitados.add(nodomenorpeso); //Marcamos el nodo del camino con menor peso como visitado
            vertices.addAll(g.darAdyacenciasDeNodo(nodomenorpeso)); //Y ahora tmb consideraremos visitar los vértices del nuevo nodo
        }

    }

}
