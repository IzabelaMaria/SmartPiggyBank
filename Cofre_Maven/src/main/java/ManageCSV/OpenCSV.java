/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageCSV;

import cofrinho.Cofrinho;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OpenCSV {

    public static List<Cofrinho> LerCsv(Path csv_via){

        List<Cofrinho> cofrinhos = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csv_via);
            CsvToBean<Cofrinho> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Cofrinho.class)
                    .withIgnoreEmptyLine(true)
                    .build();

            cofrinhos = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cofrinhos;
    }


}
