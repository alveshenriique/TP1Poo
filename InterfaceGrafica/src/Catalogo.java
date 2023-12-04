import java.util.ArrayList;
public class Catalogo {
    public ArrayList<Produto> produtossDisponiveis;

    public Catalogo() {

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

        this.produtossDisponiveis = new ArrayList<>();

        for (Produto produto : listaProdutos) {
            this.produtossDisponiveis.add(produto);
        }

    }
    public void imprimeCatalogo(){
        int i;
        for (i = 0 ; i < produtossDisponiveis.size() ; i++){
            produtossDisponiveis.get(i).imprimeProduto();
        }
    }
}