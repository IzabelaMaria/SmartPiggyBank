package cofrinho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CofrinhoDAO {

    // objeto responsável pela conexão com o servidor do banco de dados
    Connection con;
    // objeto responsável por preparar as consultas DINAMICAS
    PreparedStatement pst;
    // objeto responsável por executar as consultas STATICAS
    Statement st;
    // objeto responsável por referencia a tabela resultante da busca
    ResultSet rs;

    String banco = "Cofrinho";
    // TimeZone apartir do MySql 8.0
    String url = "jdbc:mysql://localhost:3306/" + banco + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String usuario = "root";
    String senha = "root";

    boolean sucesso = false;

    public boolean conectarnoBanco() {
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            sucesso = true;

          // JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }

    public boolean NovoCofrinho(String nome, int i) {

        conectarnoBanco();

        String sql = "INSERT INTO Cofrinho (nomeDono,idCofrinho) values (?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, nome);
            pst.setInt(2, i);

            pst.execute();

            sucesso = true;
            JOptionPane.showMessageDialog(null, "Cofrinho criado, ID= " + i);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cofrinho = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return sucesso;
    }

    public Float buscarMaiorMoeda(int id) {

        float maior = 0;
        conectarnoBanco();

        String sql = "Select Max(valorMoeda) FROM Moeda WHERE Cofrinho_idCofrinho=(?)";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                maior = rs.getFloat("Max(valorMoeda)");
                JOptionPane.showMessageDialog(null, "Moeda de maior valor: " + maior);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar moeda = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return maior;
    }

    public boolean RetirarMoeda(float valor, int id) {

        conectarnoBanco();

        String sql = "DELETE FROM Moeda WHERE valorMoeda LIKE ? AND Cofrinho_idCofrinho=? ";

        try {
            pst = con.prepareStatement(sql);

            pst.setFloat(1, valor);
            pst.setInt(2, id);

            pst.executeUpdate();

            sucesso = true;
            JOptionPane.showMessageDialog(null, "Moeda retirada! ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retirar moeda = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return sucesso;
    }

    public float valorTotal(int id) {

        float vtotal = 0;
        conectarnoBanco();

        String sql = "SELECT sum(valorMoeda) FROM moeda WHERE Cofrinho_idCofrinho=?";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                vtotal = rs.getFloat("sum(valorMoeda)");
                JOptionPane.showMessageDialog(null, "Valor total: " + vtotal);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return vtotal;
    }

    public int numeroDeMoedas(int id) {

        int num = 0;
        conectarnoBanco();

        String sql = "SELECT count(valorMoeda) FROM moeda WHERE Cofrinho_idCofrinho=?";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                num = rs.getInt("count(valorMoeda)");
                JOptionPane.showMessageDialog(null, "Número de moedas: " + num);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return num;
    }

    public boolean inserirMoeda(Moeda moeda, int id) {

        conectarnoBanco();

        String sql = "INSERT INTO Moeda (valorMoeda,Cofrinho_idCofrinho) values (?,?)";

        try {
            pst = con.prepareStatement(sql);

            pst.setFloat(1, moeda.getValor());
            pst.setInt(2, id);
            pst.execute();

            sucesso = true;
            JOptionPane.showMessageDialog(null, "Moeda inserida");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return sucesso;
    }

    public boolean pegaNome(int id) {

        String nome;
        conectarnoBanco();

        String sql = "SELECT nomeDono FROM Cofrinho WHERE idCofrinho=?";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {
                nome = rs.getString("nomeDono");
                JOptionPane.showMessageDialog(null, " Olá " + nome);
                
            }
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }
        return sucesso;
    }
   public float MoedasNoCofrinho(int id) {

        float num1 = 0;
        conectarnoBanco();

        String sql = "SELECT valorMoeda FROM Moeda WHERE Cofrinho_idCofrinho=?";

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            
            while (rs.next()) {
                num1 = rs.getFloat("valorMoeda");
                JOptionPane.showMessageDialog(null, num1, "Moedas No Cofrinho",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro! = " + ex.getMessage());

            sucesso = false;
        } finally {
            try {

                if (con != null && pst != null) {
                    con.close();
                    pst.close();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o bd = " + ex.getMessage());

            }

        }

        return num1;
    }  
    

    
}
