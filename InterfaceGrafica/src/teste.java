public class teste {
    public static void main(String[] args) {
        Produto p1 = new Produto("Ovo",13,20);
        Produto p2 = new Produto("Requeijão",9,53);
        Produto p3 = new Produto("Garrafa d'agua",3.5,92);

        CarrinhoDeCompras c1 = new CarrinhoDeCompras();

        c1.adicionaProduto(p1,2);
        c1.adicionaProduto(p2,1);
        c1.adicionaProduto(p3,1);


        Venda v1 = new Venda(c1, Venda.tipoVenda.CRÉDITO);

        v1.imprimeVenda();


    }
}
