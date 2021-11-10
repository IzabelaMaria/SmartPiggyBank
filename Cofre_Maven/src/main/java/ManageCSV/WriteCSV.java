
package ManageCSV;

import cofrinho.Cofrinho;
import cofrinho.Operations;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {

    public boolean iscreate = false;
    public boolean isfilled = false;

    public void WritingCSV(List<Cofrinho> result){

        List<String[]> linhas = new ArrayList<>();
        Operations utils = new Operations();
        String[] cabecalho = {"id","nome","Cinco_centavos", "Dez_centavos", "VinteCinco_centavos", 
            "Cinquenta_centavos", "Um_real", "Valor_Total"};

        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("src/main/resources/Cofrinhos.csv"));
            iscreate = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVWriter csvWriter = new CSVWriter(writer);

        for(int i = 0; i< result.size();i++){ 
            
            
            linhas.add(new String[]{ Integer.toString(result.get(i).id), 
                result.get(i).nome, 
                Integer.toString(result.get(i).Cinco_centavos),
                Integer.toString(result.get(i).Dez_centavos),
                Integer.toString(result.get(i).VinteCinco_centavos), 
                Integer.toString(result.get(i).Cinquenta_centavos), 
                Integer.toString(result.get(i).Um_real), 
                Float.toString(result.get(i).Valor_Total)});
        }
        csvWriter.writeNext(cabecalho);
        csvWriter.writeAll(linhas);

        try {
            csvWriter.flush();
            writer.close();
            isfilled = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
