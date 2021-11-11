package cofrinho;

import lombok.Data;
@Data

public class Cofrinho {

    public int id;
    public String nome;
    public int Cinco_centavos = 0;
    public int Dez_centavos = 0;
    public int VinteCinco_centavos = 0;
    public int Cinquenta_centavos = 0;
    public int Um_real = 0;
    public float Valor_Total = 0;
    public String name;
    
    public Cofrinho(int user_id,String name){
        this.id = user_id;
        this.nome = name;
    }

}
