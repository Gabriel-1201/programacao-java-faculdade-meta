package classes;

import interfaces.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Categoria implements crud{
    int id;
    String nome;
    
    public Categoria(int id) throws ClassNotFoundException{
        if(id > 0){
            
            String sql = "SELECT * FROM categorias WHERE id = ?";
            
            try{
                Connection con = Conexao.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,id);
                ResultSet registro = stmt.executeQuery();
                
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                    
                }
            }catch(SQLException e){
                System.out.println("Erro"+e.toString());
            }
        }
    }
    public int getId(){
        return this.id;
    }
    public void setId(int in){
        this.id = in;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String in){
        this.nome = in;
    }

    @Override
    public void adicionar() {
        String sql = "INSERT INTO categorias (nome) VALUES(?)";
        Connection con;
        try {
            con = Conexao.conexao();
            PreparedStatement stmt = con.prepareStatement(sql);
        
            stmt.setString(1,this.getNome());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
