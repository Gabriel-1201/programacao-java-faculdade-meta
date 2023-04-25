
import classes.*;

public class Crud {

    public static void main(String[] args) throws ClassNotFoundException {
        Produto produto = new Produto(2);
        System.out.println(produto.getNome());
        
        Categoria categoria = new Categoria(2);
        System.out.println(categoria.getNome());
        
        
        
    }
}
