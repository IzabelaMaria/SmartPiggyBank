package cofrinho;

import ManageCSV.WriteCSV;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    public boolean InserirMoeda(Cofrinho cofre, int moeda) {

        boolean sucesso = false;
        switch (moeda) {
            case 5:
                cofre.Cinco_centavos += 1;
                sucesso = true;
                break;
            case 10:
                cofre.Dez_centavos += 1;
                sucesso = true;
                break;
            case 25:
                cofre.VinteCinco_centavos += 1;
                sucesso = true;
                break;
            case 50:
                cofre.Cinquenta_centavos += 1;
                sucesso = true;
                break;
            case 1:
                cofre.Um_real += 1;
                sucesso = true;
                break;
            default:
                break;
        }
        return sucesso;
    }

    public boolean RetirarMoeda(Cofrinho cofre, int moeda) {

       
        boolean sucesso = false;
        switch (moeda) {
            case 5:
                cofre.Cinco_centavos -= 1;
                sucesso = true;
                break;
            case 10:
                cofre.Dez_centavos -= 1;
                sucesso = true;
                break;
            case 25:
                cofre.VinteCinco_centavos -= 1;
                sucesso = true;
                break;
            case 50:
                cofre.Cinquenta_centavos -= 1;
                sucesso = true;
                break;
            case 1:
                cofre.Um_real -= 1;
                sucesso = true;
                break;
            default:
                break;
        }
        return sucesso;
    }

    public String MaiorMoeda(Cofrinho cofre) {

        String maior = null;
        if (cofre.Cinco_centavos != 0 && cofre.Dez_centavos == 0 && cofre.VinteCinco_centavos == 0 
                && cofre.Cinquenta_centavos == 0 && cofre.Um_real == 0) {

            maior = "5 centavos";

        } else if (cofre.Dez_centavos != 0 && cofre.VinteCinco_centavos == 0 && cofre.Cinquenta_centavos == 0 
                && cofre.Um_real == 0) {

            maior = "10 centavos";

        } else if (cofre.VinteCinco_centavos != 0 && cofre.Cinquenta_centavos == 0 && cofre.Um_real == 0) {

            maior = "25 centavos";

        } else if (cofre.Cinquenta_centavos != 0 && cofre.Um_real == 0) {

            maior = "50 centavos";

        } else if (cofre.Um_real != 0) {

            maior = "1 real";

        }
        return maior;
    }

    public String MenorMoeda(Cofrinho cofre) {

        
        String menor = null;
        if (cofre.Cinco_centavos != 0) {

            menor = "5 centavos";

        } else if (cofre.Dez_centavos != 0 && cofre.Cinco_centavos == 0) {

            menor = "10 centavos";

        } else if (cofre.VinteCinco_centavos != 0 && cofre.Dez_centavos == 0 && cofre.Cinco_centavos == 0) {

            menor = "25 centavos";

        } else if (cofre.Cinquenta_centavos != 0 && cofre.Dez_centavos == 0 && cofre.Cinco_centavos == 0 && 
                cofre.VinteCinco_centavos == 0) {

            menor = "50 centavos";

        } else if (cofre.Um_real != 0 && cofre.Cinquenta_centavos == 0 && cofre.Dez_centavos == 0 
                && cofre.Cinco_centavos == 0 && cofre.VinteCinco_centavos == 0) {

            menor = "1 real";

        }
        return menor;
    }

    public float ValorTotal(Cofrinho cofre) {

        float ValorTotal = 0;

        ValorTotal += (float) (cofre.Cinco_centavos * 0.05);
        ValorTotal += (float) (cofre.Dez_centavos * 0.10);
        ValorTotal += (float) (cofre.VinteCinco_centavos * 0.25);
        ValorTotal += (float) (cofre.Cinquenta_centavos * 0.50);
        ValorTotal += (float) (cofre.Um_real * 1);

        return ValorTotal;
    }

    public List<String> MoedasNoCofre(Cofrinho cofre) {

        List<String> moedas = new ArrayList<>();

        if (cofre.Cinco_centavos != 0) {

            moedas.add("5 centavos");

        }
        if (cofre.Dez_centavos!= 0) {

            moedas.add("10 centavos");

        }
        if (cofre.VinteCinco_centavos != 0) {

            moedas.add("25 centavos");

        }
        if (cofre.Cinquenta_centavos != 0) {

            moedas.add("50 centavos");

        }
        if (cofre.Um_real != 0) {

            moedas.add("1 real");

        }

        return moedas;

    }

    public String ObtemNome(Cofrinho cofre) {

        String nome = null;
        nome = cofre.nome;

        return nome;

    }

    public List<String> Cambio(float valor) {

        
        List<String> cambio = new ArrayList<>();

        float dolar_dia = (float) 5.48;
        float euro_dia = (float) 6.36;
        float EmDolar;
        float EmEuros;

        EmDolar = (float) (valor / dolar_dia);
        EmEuros = (float) (valor / euro_dia);

        cambio.add(Float.toString(EmDolar));
        cambio.add(Float.toString(EmEuros));
        

        return cambio;
    }
    

    public boolean FinanceController(float valor_antes, float valor_atual) {

        float temp_calc;
        boolean alert = false;
        
        System.out.println("vantes"+valor_antes);
        System.out.println("vdepois"+valor_atual);

        temp_calc = (float) ((valor_atual / valor_antes) * 100);

        if (temp_calc < 50.0) {

            alert = true;

        }

        return alert;
    }
    
    public void Operatecsv(){
        WriteCSV w = new WriteCSV();
        List<Cofrinho> initcsv = new ArrayList<>();
        w.WritingCSV(initcsv);
    
    }

}


