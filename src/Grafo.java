import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

    private ArrayList<Integer> nodos;

    private int[][] matrizAdj; //En la matriz, un número diferente a 0 representa que hay una adyacencia, y ese número
    // es el peso del vértice

    private HashMap<Integer, List<Tupla<Integer, Integer>>> listaAdj; //En la lista, cada nodo tiene una lista de tuplas,
    // el objeto1 de la tupla representa el nodo hacia el cual va el vértice y el objeto2 representa el peso del vértice

    boolean usaMatriz;


    public Grafo(boolean esMatriz){
        nodos = new ArrayList();
        if(!esMatriz){
            listaAdj = new HashMap();
        }else{
            matrizAdj = new int[0][0];
        }
        usaMatriz = esMatriz;
    }

    public ArrayList nodos(){ return nodos; }

    public void anhadirNodo(){
        nodos.add(nodos.size());
        if(usaMatriz){
            redimensionarMatriz();
        }
        else{
            listaAdj.put(nodos.size()-1, new LinkedList<>());
            //System.out.println("Nodo añadido: " + nodos.size());
        }
    }

    private void redimensionarMatriz() {
        int[][] nuevaMatriz = new int[nodos.size()][nodos.size()];
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j != matrizAdj.length; j++) {
                //TODO vamos a duplicar la matriz entera o solo la mitad que vamos a usar? Haría mucha diferencia en complejidad?
            }
            System.arraycopy(matrizAdj[i],0, nuevaMatriz[i],0,matrizAdj[i].length); //No tengo la menor idea de si esto funcione, si sí, este método es O(n)
        }
    }

    public void anhadirVertice(int desde, int hacia, int peso){
        //System.out.println("Añadiendo vértice, de " + desde + " a " + hacia + " con peso de " + peso);
        if(usaMatriz){
            matrizAdj[desde][hacia] = peso;
            matrizAdj[hacia][desde] = peso;
        }
        else{
            listaAdj.get(desde).add(new Tupla<>(hacia, peso));
            listaAdj.get(hacia).add(new Tupla<>(desde, peso));
        }
    }

    public int darPrimerNodo(){
        return nodos.get(0);
    }

    public List<Tupla<Integer, Integer>> darAdyacenciasDeNodo(int nodo){
        List<Tupla<Integer, Integer>> devuelveme = new LinkedList();

        if(usaMatriz){
            for (int i = 0; i < nodos.size(); i++) {
                if(i<=nodo){
                    if(matrizAdj[nodo][i] != 0){
                        devuelveme.add(new Tupla<>(i,matrizAdj[nodo][i]));
                    }
                }else{
                    if(matrizAdj[i][nodo] != 0){
                        devuelveme.add(new Tupla<>(i,matrizAdj[i][nodo]));
                    }
                }
            }
        }
        else{
            devuelveme = listaAdj.get(nodo);
        }
        return devuelveme;
    }

    public class Tupla<K, V>{

        //Acceder o sobreescribir cualquiera de estos datos es O(1)

        public K objeto1;

        public V objeto2;

        public Tupla(K objeto1, V objeto2) {
            this.objeto1 = objeto1;
            this.objeto2 = objeto2;
        }
    }

}
