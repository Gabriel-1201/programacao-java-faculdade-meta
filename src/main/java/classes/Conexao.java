package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    public static String servidor = "127.0.0.1:3306";
    public static String usuario = "root";
    public static String senha = "BatataBatata12!!";
    public static String nome_banco = "crud";
    
    public static Connection conexao() throws ClassNotFoundException{
        Connection conexao = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(
            "jdbc:mysql://"+servidor+"/"+nome_banco+"",usuario,senha
            );
        }catch(SQLException e){
            System.out.println("Erro de conexão: " + e.toString());
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
}
