import java.time.LocalDateTime;
import java.util.UUID;
public class Produto {
    private String nomeProduto;
    private String id;

    private double preco;
    private int quantidadeEstoque;


    public Produto(String nomeProduto, double preco,int quantidadeEstoque){
        setNomeProduto(nomeProduto);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
        setId();
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public int verificaEstoque(int qtdComprada){
        if(this.getQuantidadeEstoque() > qtdComprada)
            return 1;
        else return 0;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }


    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void removeEstoque(int qtdRemover){
        this.quantidadeEstoque = quantidadeEstoque - qtdRemover;
    }
    public void adicionarEstoque(int qtdAdd){
        this.quantidadeEstoque = quantidadeEstoque + qtdAdd;
    }

}