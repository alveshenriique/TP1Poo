import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class NotaFiscal {
    private Venda venda;

    public NotaFiscal(Venda venda){
        this.venda = new Venda(venda.getListaProdutos(),venda.getTipo());
    }

    /*public void imprimeNotaFiscal() {
       this.cabecalhoCF();
        venda.getListaProdutos().listarProdutos();
        this.footer();
    }*/

    // Possibilidade
    public void escreverNotaFiscalEmArquivo() {

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formatoDataHora = agora.format(formatter);

        // Obtém o caminho absoluto do diretório onde o JAR está localizado
        String diretorioAtual = System.getProperty("user.dir");

        // Gera o nome do arquivo com o caminho absoluto
        String nomeArquivo = diretorioAtual + "/NotaFiscal_" + formatoDataHora + ".txt";
    
        // Gera o nome do arquivo
        nomeArquivo = "NotaFiscal_" + formatoDataHora + ".txt";
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            // Escreve as informações da nota fiscal no arquivo
            writer.write("---------------------------------------------------------------------------------\n");
            writer.write("SUPERMERCADO DAMASCO COMERCIO E INDUSTRIA LTDA\n");
            writer.write("FLORESTAL - MINAS GERAIS\n");
            writer.write("CNPJ: 77.777.777/0001-77\n");
            writer.write("---------------------------------------------------------------------------------\n");
            writer.write(venda.getDataHora() + "\n");
            writer.write("---------------------------------------------------------------------------------\n");
            writer.write("                                   CUPOM FISCAL          \n");
            writer.write("---------------------------------------------------------------------------------\n");
    
            // Escreve os detalhes de cada produto vendido
            writer.write("Detalhes dos Produtos:\n");
            for (int i = 0; i < venda.getListaProdutos().getListaProdutos().size(); i++) {
                Produto produto = venda.getListaProdutos().getListaProdutos().get(i);
                int quantidade = venda.getListaProdutos().getQuantidadeComprada().get(i);
                double valorUnitario = produto.getPreco();
                double valorTotalItem = valorUnitario * quantidade;
    
                writer.write("Nome do Produto: " + produto.getNomeProduto() + "\n");
                writer.write("Valor Unitário: R$" + valorUnitario + "\n");
                writer.write("Quantidade: " + quantidade + "\n");
                writer.write("Valor Total do Item: R$" + valorTotalItem + "\n");
                writer.write("\n");
            }
    
            // Escreve o total da compra e outras informações da venda
            String totalFormatado = String.format("Total a pagar: R$%63.2f", venda.getListaProdutos().getPrecoTotal());
            writer.write("---------------------------------------------------------------------------------\n");
            writer.write(totalFormatado + "\n");
            writer.write(String.format("%-25s %54s%n", "Data da compra:", venda.getDataHora()));
            writer.write(String.format("%-25s %54s%n", "Forma de pagamento:", venda.getTipo()));
            writer.write(String.format("%-25s %54s%n", "Quantidade de Itens:", venda.getListaProdutos().getQtdItens()));
            writer.write("--------------------------------------------------------------------------------\n");
    
            JOptionPane.showMessageDialog(null, "Nota fiscal salva em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar nota fiscal em arquivo.");
        }
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

    public void imprimeNotaFiscal() {
        this.cabecalhoCF();
        System.out.println("Detalhes dos Produtos:");
    
        double valorTotal = 0.0;
    
        ArrayList<Produto> produtos = venda.getListaProdutos().getListaProdutos();
        ArrayList<Integer> quantidades = venda.getListaProdutos().getQuantidadeComprada();
    
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            double precoUnitario = produto.getPreco();
            double totalItem = quantidade * precoUnitario;
    
            System.out.println("Nome do Produto: " + produto.getNomeProduto());
            System.out.println("Valor da Unidade: R$" + precoUnitario);
            System.out.println("Quantidade: " + quantidade);
            System.out.println("Valor Total: R$" + totalItem);
    
            valorTotal += totalItem;
        }
    
        this.footer(valorTotal);
    }

    public void footer(double valorTotal) {
        System.out.println("---------------------------------------------------------------------------------");
        String totalFormatado = String.format("Total a pagar: R$%63.2f", valorTotal);
        System.out.println(totalFormatado);
        System.out.printf("%-25s %54s%n", "Data da compra:", this.venda.getDataHora());
        System.out.printf("%-25s %54s%n", "Forma de pagamento:", this.venda.getTipo());
        System.out.printf("%-25s %54s%n", "Quantidade de Itens:", this.venda.getListaProdutos().getQtdItens());
        System.out.println("--------------------------------------------------------------------------------");
    }
}
