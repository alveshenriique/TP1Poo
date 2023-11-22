import java.util.ArrayList;
import java.util.Objects;

public class CarrinhoDeCompras {
    private ArrayList<Produto> listaProdutos;
    private double precoTotal;

    public CarrinhoDeCompras(){
        this.listaProdutos = new ArrayList<>();
    }
    public void adicionaProduto(Produto produto){
        this.listaProdutos.add(produto);
    }
    public void removeProduto(String nomeProdutoRemover){
        listaProdutos.removeIf(Produto -> Objects.equals(Produto.getNomeProduto(), nomeProdutoRemover));
    }
    public void listarProdutos(){
        for (Produto produtos : listaProdutos){
            System.out.println("Nome" + produtos.getNomeProduto());
            System.out.println("Preco" + produtos.getPreco());
        }
    }
}
