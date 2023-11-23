import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private CarrinhoDeCompras listaProdutos;
    private String dataHora;

    public enum tipoVenda {
        PIX , CREDITO , DÉBITO , DINHEIRO;
    }

    static tipoVenda tipoVenda;

    public Venda(CarrinhoDeCompras listaProdutos, tipoVenda tipoDaVenda){
        this.listaProdutos = new CarrinhoDeCompras();
        this.listaProdutos = listaProdutos;
        this.listaProdutos.gerarPrecoTotal();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatoDataHora = agora.format(formatter);
        setDataHora(formatoDataHora);
        this.tipoVenda = tipoDaVenda;
    }

    public String getDataHora() {
        return dataHora;
    }

    public CarrinhoDeCompras getListaProdutos() {
        return listaProdutos;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public void setListaProdutos(CarrinhoDeCompras listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public static Venda.tipoVenda getTipoVenda() {
        return tipoVenda;
    }

    public void imprimeVenda(){
        this.listaProdutos.listarProdutos();
        String numeroFormatado = String.format("%.2f",this.listaProdutos.getPrecoTotal() );
        System.out.println("Total a pagar: R$" + numeroFormatado);
        System.out.println(this.dataHora);
        System.out.println("Forma de pagamento: " + getTipoVenda());
    }
}
