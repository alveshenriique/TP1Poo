import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private CarrinhoDeCompras listaProdutos;
    private String dataHora;

    public enum tipoVenda {
        PIX , CRÉDITO , DÉBITO , DINHEIRO;
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
        removeEstoque();
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
        System.out.println("---------------------Itens Comprados---------------------");
        this.listaProdutos.listarProdutos();
        System.out.println("-------------------Resumo da Compra----------------------");
        String numeroFormatado = String.format("%.2f", listaProdutos.getPrecoTotal() );
        System.out.println("Total a pagar: R$" + numeroFormatado);
        System.out.println(this.dataHora);
        System.out.println("Forma de pagamento: " + getTipoVenda());
        System.out.println("Quantidade de Itens: " + listaProdutos.getQtdItens());
        System.out.println("---------------------------------------------------------");
    }
    public void removeEstoque(){
        int i;
        for (i = 0 ; i < listaProdutos.getListaProdutos().size() ; i++){
            listaProdutos.getListaProdutos().get(i).removeEstoque(listaProdutos.getQuantidadeComprada().get(i));
        }
    }

}

