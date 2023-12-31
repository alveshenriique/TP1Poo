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

    public int adicionaProdutoPeloNome(String nomeProduto, int qtdComprada, Catalogo produtos) {
        for (Produto produto : produtos.produtossDisponiveis) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                if (produto.verificaEstoque(qtdComprada) == 0) {
                    System.out.println("[ERRO] Não foi possível inserir o item " + produto.getNomeProduto() + " pois restam apenas " + produto.getQuantidadeEstoque() + " unidades!");
                    return 0;
                } else {
                    quantidadeComprada.add(qtdComprada);
                    this.listaProdutos.add(produto);
                    qtdItens += qtdComprada;
                    return 1;
                }
            }
        }
        System.out.println("[ERRO] Produto não encontrado.");
        return -1;
    }

    public int removeProdutoPeloNome(String nomeProduto, int qtdRemover) {

        for (int i = 0; i < listaProdutos.size(); i++) {

            Produto produto = listaProdutos.get(i);

            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                
                int qtdAtual = quantidadeComprada.get(i);


                if (qtdAtual >= qtdRemover) {

                    quantidadeComprada.set(i, qtdAtual - qtdRemover);
                    
                    qtdItens -= qtdRemover;
                    if (quantidadeComprada.get(i) == 0) {

                        listaProdutos.remove(i);
                        quantidadeComprada.remove(i);
                    }
                    produto.adicionarEstoque(qtdRemover);
                    return 1; // Produto removido
                } else {
                    return -1; // Quantidade removida > quantidade no carrinho
                }
            }
        }
        return 0; // Produto não encontrado
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

    public void listarProdutos() {
        StringBuilder resultado = new StringBuilder();

        resultado.append(String.format("%-5s %-10s %-30s %-10s %-15s %-15s%n", "Índice", "ID", "Nome do Produto", "Quantidade", "Vlr.Unit.", "Total"));

        int i = 0;
        for (Produto produto : this.listaProdutos) {
            double precoUnitario = produto.getPreco();
            int quantidade = this.quantidadeComprada.get(i);
            double total = precoUnitario * quantidade;

            resultado.append(String.format("%-5s %-10s %-30s %-10s %-15.2f %-15.2f%n", i, produto.getId(), produto.getNomeProduto(),
                    quantidade, precoUnitario, total));
            i++;
        }

        System.out.println(resultado.toString());
    }

    public void gerarPrecoTotal(){
        double precoTotal = 0;
        int i;

        for (i = 0 ; i < this.listaProdutos.size() ; i++){

            precoTotal += quantidadeComprada.get(i) * listaProdutos.get(i).getPreco();

        }
        this.precoTotal = precoTotal;
    }
    public Produto procuraProdutoCarrinho(String nome){
        int i;
        for (i = 0 ; i < this.listaProdutos.size() ; i++){
            if (this.getListaProdutos().get(i).procuraProdutoNome(nome) == 1)
                return this.listaProdutos.get(i);
        }
        return null;
    }
}
