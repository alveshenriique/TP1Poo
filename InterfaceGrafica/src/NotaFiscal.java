import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotaFiscal {
    private Venda venda;

    public NotaFiscal(Venda venda){
        this.venda = new Venda(venda.getListaProdutos(),venda.getTipo());
    }
    public void imprimeNotaFiscal(){
        System.out.println("---------------------------------------------------------");
        System.out.println("                   Supermercado POO                      ");
        System.out.println("---------------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("---------------------Itens Comprados---------------------");
        venda.getListaProdutos().listarProdutos();
        String numeroFormatado = String.format("%.2f", this.venda.getListaProdutos().getPrecoTotal());
        System.out.println("Total a pagar: R$" + numeroFormatado);
        System.out.println("Data da compra: " + this.venda.getDataHora());
        System.out.println("Forma de pagamento: " + this.venda.getTipo());
        System.out.println("Quantidade de Itens: " + venda.getListaProdutos().getQtdItens());
        System.out.println("---------------------------------------------------------");
    }

}
