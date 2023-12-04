import java.util.ArrayList;
public class teste {
    public static void main(String[] args) {

        Catalogo produtos = new Catalogo();

        CarrinhoDeCompras c1 = new CarrinhoDeCompras();

        String nomeLido1 = "Bexiga";
        String nomeLido2 = "Salgadinho";
        String nomeLido3 = "Garrafa de Refrigerante";
        String nomeLido4 = "Pão de Hambúrger";
        String nomeLido5 = "Bolo";
        String nomeLido6 = "Doce";
        String nomeLido7 = "Frutas Variadas";
        String nomeLido8 = "Copo Descartável";
        String nomeLido9 = "Chocolates";
        String nomeLido10 = "Sabonete Perfumado";
        String nomeLido11 = "Café em Pó";
        String nomeLido12 = "Luz Decorativa";
        String nomeLido13 = "Guardanapo";

        c1.adicionaProdutoPeloNome(nomeLido1,20,produtos);
        c1.adicionaProdutoPeloNome(nomeLido2,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido3,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido4,20,produtos);
        c1.adicionaProdutoPeloNome(nomeLido5,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido6,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido7,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido8,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido9,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido10,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido11,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido12,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido13,1,produtos);

        Venda v1 = new Venda(c1, Venda.tipoVenda.CRÉDITO);
        NotaFiscal nf1 = new NotaFiscal(v1);
        nf1.imprimeNotaFiscal();

    }
}
