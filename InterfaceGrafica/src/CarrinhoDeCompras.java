import java.util.ArrayList;
import java.util.Objects;

public class CarrinhoDeCompras {
    private ArrayList<Produto> listaProdutos;
    private double precoTotal;

    private ArrayList<Integer> quantidadeComprada;

    private int qtdItens;

    public CarrinhoDeCompras(){
        this.listaProdutos = new ArrayList<>();
        this.quantidadeComprada = new ArrayList<>();
    }
    public int adicionaProduto(Produto produto, int qtdComprada){
        if (produto.verificaEstoque(qtdComprada) == 0){
            System.out.println("[ERRO] Não foi possível inserir o item " + produto.getNomeProduto() + " pois restam apenas " + produto.getQuantidadeEstoque() + " unidades!");
            return 0;
        }else{
            this.quantidadeComprada.add(qtdComprada);
            this.listaProdutos.add(produto);
            qtdItens += qtdComprada;
            return 1;
        }

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

    public int getQtdItens() {
        return qtdItens;
    }

    public ArrayList<Integer> getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setQuantidadeComprada(ArrayList<Integer> quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public void listarProdutos(){
        int i;
        for (i = 0 ; i < quantidadeComprada.size() ; i++){
            System.out.println("Nome: " + this.listaProdutos.get(i).getNomeProduto());
            System.out.println("Preco: " + this.listaProdutos.get(i).getPreco());
            System.out.println("Quantidade comprada: " + this.quantidadeComprada.get(i));
            System.out.println(" ");
        }
    }
    public void gerarPrecoTotal(){
        double precoTotal = 0;
        int i;

        for (i = 0 ; i < this.listaProdutos.size() ; i++){

            precoTotal += quantidadeComprada.get(i) * listaProdutos.get(i).getPreco();

        }
        this.precoTotal = precoTotal;
    }


}
