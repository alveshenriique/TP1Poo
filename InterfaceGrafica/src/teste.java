public class teste {
    public static void main(String[] args) {

        Produto p1 = new Produto("Bexigas", 2, 100);
        Produto p2 = new Produto("Salgadinhos", 15, 50);
        Produto p3 = new Produto("Garrafa de Refrigerante", 5, 30);
        Produto p4 = new Produto("Pães de Hambúrguer", 3, 40);
        Produto p5 = new Produto("Bolo", 25, 1);
        Produto p6 = new Produto("Doces", 10, 60);
        Produto p7 = new Produto("Frutas Variadas", 8, 20);
        Produto p8 = new Produto("Copo Descartável", 1, 200);
        Produto p9 = new Produto("Chocolates", 6, 50);
        Produto p10 = new Produto("Sabonetes Perfumados", 3, 30);
        Produto p11 = new Produto("Café em Pó", 10, 15);
        Produto p12 = new Produto("Luzes Decorativas", 20, 10);
        Produto p13 = new Produto("Guardanapos", 2.5, 80);


        CarrinhoDeCompras c1 = new CarrinhoDeCompras();

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

        Venda v1 = new Venda(c1, Venda.tipoVenda.CRÉDITO);

        NotaFiscal nf1 = new NotaFiscal(v1);
        nf1.imprimeNotaFiscal();


    }
}
