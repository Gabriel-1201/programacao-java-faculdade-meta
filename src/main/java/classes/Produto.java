package classes;

import interfaces.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto implements crud{
    int id;
    int categoria_id;
    String nome;
    double preco;
    int quantidade;
    
    public Produto(int id) throws ClassNotFoundException{
        if(id > 0){
            
            String sql = "SELECT * FROM produtos WHERE id = ?";
            
            try{
                Connection con = Conexao.conexao();
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,id);
                ResultSet registro = stmt.executeQuery();
                
                while(registro.next()){
                    this.setId(registro.getInt("id"));
                    this.setNome(registro.getString("nome"));
                    this.setPreco(registro.getDouble("preco"));
                    this.setQuantidade(registro.getInt("quantidade"));
                    
                }
            }catch(SQLException e){
                System.out.println("Erro "+e.toString());
            }
        }
    }
    public int getId() {
        return id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void adicionar() {
        String sql = "INSERT INTO produtos (categoria_id, nome, preco, quantidade) VALUES (?,?,?,?)";
        
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
