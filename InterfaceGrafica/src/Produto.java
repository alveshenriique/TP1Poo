import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
public class Produto {
    private String nomeProduto;
    private String id;

    private static int proximoId = 100000000; // Inicia com o valor mínimo

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

    private static String gerarCodigoSupermercado() {

        Random random = new Random();

        // Gera um número aleatório entre 100000000 e 999999999
        int numeroAleatorio = proximoId + random.nextInt(900000000);

        // Incrementa o próximo ID
        proximoId++;

        return String.valueOf(numeroAleatorio);
    }

    public void setId() {
        this.id = gerarCodigoSupermercado();
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