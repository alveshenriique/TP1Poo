import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class HistoricoVendas {

    private ArrayList<Venda> listaVendas;
    private String dataHoraHistorico;

    public HistoricoVendas() {
        this.listaVendas = new ArrayList<>();
        try {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            this.dataHoraHistorico = agora.format(formatter);
        } catch (Exception e) {
            System.err.println("Erro ao obter data e hora do histórico: " + e.getMessage());
        }
    }

    public void adicionarVenda(Venda venda) {
        try {
            if (venda != null) {
                this.listaVendas.add(venda);
            } else {
                throw new NullPointerException("Venda é nula.");
            }
        } catch (NullPointerException e) {
            System.err.println("Erro ao adicionar venda: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao adicionar venda: " + e.getMessage());
        }
    }

    public void listarVendas() {
        System.out.println("----------------------Histórico de Vendas----------------------");
        try {
            if (!listaVendas.isEmpty()) {
                for (Venda venda : listaVendas) {
                    System.out.println("---------------------------------------------------");
                    venda.imprimeVenda();
                }
            } else {
                System.out.println("Histórico de vendas está vazio.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro ao listar vendas: Índice inválido no ArrayList.");
        } catch (Exception e) {
            System.err.println("Erro ao listar vendas: " + e.getMessage());
        } finally {
            System.out.println("-----------------------------------------------------------");
        }
    }

    public String getDataHoraHistorico() {
        return dataHoraHistorico;
    }

    public void setDataHoraHistorico(String dataHoraHistorico) {
        try {
            this.dataHoraHistorico = dataHoraHistorico;
        } catch (Exception e) {
            System.err.println("Erro ao definir data e hora do histórico: " + e.getMessage());
        }
    }
}
