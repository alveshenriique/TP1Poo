import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotaFiscal {
    private Venda venda;

    public NotaFiscal(Venda venda){
        this.venda = new Venda(venda.getListaProdutos(),venda.getTipo());
    }

    public void imprimeNotaFiscal() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("                                 SUPERMERCADO POO                                ");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("--------------------------------- Itens Comprados -------------------------------");

        venda.getListaProdutos().listarProdutos();

        System.out.println("---------------------------------------------------------------------------------");

        String totalFormatado = String.format("Total a pagar: R$%63.2f", this.venda.getListaProdutos().getPrecoTotal());
        System.out.println(totalFormatado);

        System.out.printf("%-25s %54s%n", "Data da compra:", this.venda.getDataHora());
        System.out.printf("%-25s %54s%n", "Forma de pagamento:", this.venda.getTipo());
        System.out.printf("%-25s %54s%n", "Quantidade de Itens:", this.venda.getListaProdutos().getQtdItens());

        System.out.println("--------------------------------------------------------------------------------");
    }

    // Possibilidade
    private void escreverNotaFiscalEmArquivo() {

    }

}
