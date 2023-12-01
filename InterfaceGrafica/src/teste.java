import java.util.ArrayList;
public class teste {
    public static void main(String[] args) {

        //Catálogo de produtos:
        Produto[] listaProdutos = new Produto[13];

        listaProdutos[0] = new Produto("Bexiga", 2, 100);
        listaProdutos[1] = new Produto("Salgadinho", 15, 50);
        listaProdutos[2] = new Produto("Garrafa de Refrigerante", 5, 30);
        listaProdutos[3] = new Produto("Pão de Hambúrguer", 3, 40);
        listaProdutos[4] = new Produto("Bolo", 25, 1);
        listaProdutos[5] = new Produto("Doce", 10, 60);
        listaProdutos[6] = new Produto("Frutas Variadas", 8, 20);
        listaProdutos[7] = new Produto("Copo Descartável", 1, 200);
        listaProdutos[8] = new Produto("Chocolates", 6, 50);
        listaProdutos[9] = new Produto("Sabonete Perfumado", 3, 30);
        listaProdutos[10] = new Produto("Café em Pó", 10, 15);
        listaProdutos[11] = new Produto("Luz Decorativa", 20, 10);
        listaProdutos[12] = new Produto("Guardanapo", 2.5, 80);

        ArrayList<Produto> produtos = new ArrayList<>();

        // Adicionando os produtos do array ao ArrayList
        for (Produto produto : listaProdutos) {
            produtos.add(produto);
        }

        CarrinhoDeCompras c1 = new CarrinhoDeCompras();


        String nomeLido1 = "Bexiga";
        String nomeLido2 = "Salgadinho";
        String nomeLido3 = "Garrada de Refrigerante";
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
        c1.adicionaProdutoPeloNome(nomeLido5,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido6,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido7,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido8,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido9,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido10,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido11,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido12,1,produtos);
        c1.adicionaProdutoPeloNome(nomeLido13,1,produtos);


        /*
        c1.adicionaProduto(p1, 2);
        c1.adicionaProduto(p2, 1);
        c1.adicionaProduto(p3, 1);
        c1.adicionaProduto(p4, 3);
        c1.adicionaProduto(p5, 2);
        c1.adicionaProduto(p6, 1);
        c1.adicionaProduto(p7, 5);
        c1.adicionaProduto(p8, 3);
        c1.adicionaProduto(p9, 2);
        c1.adicionaProduto(p10, 1);
        c1.adicionaProduto(p11, 2);
        c1.adicionaProduto(p12, 1);
        c1.adicionaProduto(p13, 4);
        */

        Venda v1 = new Venda(c1, Venda.tipoVenda.CRÉDITO);
        NotaFiscal nf1 = new NotaFiscal(v1);
        nf1.imprimeNotaFiscal();


    }
}
