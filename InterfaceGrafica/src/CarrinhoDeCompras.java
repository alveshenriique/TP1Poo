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

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void listarProdutos(){
        for (Produto produtos : listaProdutos){
            System.out.println("Nome: " + produtos.getNomeProduto());
            System.out.println("Preco: " + produtos.getPreco());
            System.out.println("---------------------------------------------------------");
        }
    }
    public void gerarPrecoTotal(){
        double precoTotal = 0;
        int i;

        for (i = 0 ; i < this.listaProdutos.size() ; i++){

            precoTotal += listaProdutos.get(i).getPreco();

        }
        this.precoTotal = precoTotal;
    }
}
