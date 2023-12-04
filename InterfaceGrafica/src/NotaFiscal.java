import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotaFiscal {
    private Venda venda;

    public NotaFiscal(Venda venda){
        this.venda = new Venda(venda.getListaProdutos(),venda.getTipo());
    }

    public void imprimeNotaFiscal() {
       this.cabecalhoCF();
        venda.getListaProdutos().listarProdutos();
        this.footer();
    }

    // Possibilidade
    private void escreverNotaFiscalEmArquivo() {

    }
    public void cabecalhoCF(){
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("SUPERMERCADO DAMASCO COMERCIO E INDUSTRIA LTDA");
        System.out.println("FLORESTAL - MINAS GERAIS");
        System.out.println("CNPJ: 77.777.777/0001-77");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(this.venda.getDataHora());
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("                                   CUPOM FISCAL          ");
        System.out.println("---------------------------------------------------------------------------------");

    }
    public void footer(){
        System.out.println("---------------------------------------------------------------------------------");
        String totalFormatado = String.format("Total a pagar: R$%63.2f", this.venda.getListaProdutos().getPrecoTotal());
        System.out.println(totalFormatado);
        System.out.printf("%-25s %54s%n", "Data da compra:", this.venda.getDataHora());
        System.out.printf("%-25s %54s%n", "Forma de pagamento:", this.venda.getTipo());
        System.out.printf("%-25s %54s%n", "Quantidade de Itens:", this.venda.getListaProdutos().getQtdItens());
        System.out.println("--------------------------------------------------------------------------------");
    }
}
