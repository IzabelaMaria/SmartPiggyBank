package cofrinho;

public class Moeda implements Comparable<Moeda> {
    private float valor;
    
   public Moeda(float v){
    
    valor=v;
    
    }

    public float getValor() {
        return valor;
    }

     @Override
    public int compareTo(Moeda o) {
         
        if (valor < o.valor) {
            return -1;
            
        }
        else if (valor > o.valor) {
            return 1;
            
        }
        else  {
            return 0;
            
        }
    }
   
   
}
