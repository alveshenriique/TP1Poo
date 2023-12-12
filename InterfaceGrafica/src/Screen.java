import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame{
    private CarrinhoDeCompras carrinho;
    private Catalogo catalogo;
    private JTextField textFieldNomeProduto;
    private JTextField textFieldQuantidade;

    public Screen() {

        catalogo = new Catalogo();
        carrinho = new CarrinhoDeCompras();
        //Layout Caixa
        setVisible(true);
        setSize(800,500);
        setTitle("Supermercado POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

       // Título
        JLabel jLabel = new JLabel("Carrinho de Compras");
        jLabel.setBounds(180, 10, 400, 50);
        jLabel.setFont(new Font("Arial", Font.BOLD, 35));
        add(jLabel);

        // Botão "Mostrar Lista de Produtos"
        JButton jButtonMostrarLista = new JButton();
        jButtonMostrarLista.setText("Mostrar Lista de Produtos");
        jButtonMostrarLista.setBounds(200, 90, 350, 70);
        jButtonMostrarLista.setFont(new Font("Arial", Font.BOLD, 25));
        jButtonMostrarLista.setForeground(new Color(50, 50, 50));
        jButtonMostrarLista.setBackground(new Color(200, 200, 200));
        jButtonMostrarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarListaProdutosCarrinhoEcatalogo();
                catalogo.imprimeCatalogo();
            }
        });
        add(jButtonMostrarLista);

        // Botão Adicionar Produto
        JButton jButtonAdicionarProduto = new JButton("Adicionar Produto");
        jButtonAdicionarProduto.setBounds(300, 220, 250, 30);
        jButtonAdicionarProduto.setFont(new Font("Arial", Font.BOLD, 15));
        jButtonAdicionarProduto.setForeground(new Color(50, 50, 50));
        jButtonAdicionarProduto.setBackground(new Color(200, 200, 200));
        jButtonAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoAoCarrinho();
            }
        });
        add(jButtonAdicionarProduto);

        // Botão Remover Produto
        JButton jButtonRemoverProduto = new JButton("Remover Produto");
        jButtonRemoverProduto.setBounds(300, 300, 250, 30);
        jButtonRemoverProduto.setFont(new Font("Arial", Font.BOLD, 15));
        jButtonRemoverProduto.setForeground(new Color(50, 50, 50));
        jButtonRemoverProduto.setBackground(new Color(200, 200, 200));
        jButtonRemoverProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProdutoDoCarrinho();
            }
        });
        add(jButtonRemoverProduto);

        //nome para add
        textFieldNomeProduto = new JTextField();
        textFieldNomeProduto.setBounds(200, 180, 350, 30);
        add(textFieldNomeProduto);
        //quantidade para add
        textFieldQuantidade = new JTextField();
        textFieldQuantidade.setBounds(200, 220, 80, 30);
        add(textFieldQuantidade);

        //nome para remover
        JTextField textFieldNomeProdutoRemover = new JTextField();
        textFieldNomeProdutoRemover.setBounds(200, 260, 350, 30);
        add(textFieldNomeProdutoRemover);
        //quantidade para remover
        JTextField textFieldQuantidadeRemover = new JTextField();
        textFieldQuantidadeRemover.setBounds(200, 300, 80, 30);
        add(textFieldQuantidadeRemover);

        //Parte para escrever nome do produto e quantidade na frase nas caixas de texto
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel labelNomeProdutoAdicionar = new JLabel("Nome do Produto:");
        labelNomeProdutoAdicionar.setBounds(90, 180, 150, 30);
        add(labelNomeProdutoAdicionar);
        JLabel labelQuantidadeAdicionar = new JLabel("Quantidade:");
        labelQuantidadeAdicionar.setBounds(125, 220, 100, 30);
        add(labelQuantidadeAdicionar);

        JLabel labelNomeProdutoRemover = new JLabel("Nome do Produto:");
        labelNomeProdutoRemover.setBounds(90, 260, 150, 30);
        add(labelNomeProdutoRemover);
        JLabel labelQuantidadeRemover = new JLabel("Quantidade:");
        labelQuantidadeRemover.setBounds(125, 300, 100, 30);
        add(labelQuantidadeRemover);

        JButton jButtonConcluirVenda = new JButton("Concluir Venda");
        jButtonConcluirVenda.setBounds(300, 350, 250, 30);
        jButtonConcluirVenda.setFont(new Font("Arial", Font.BOLD, 15));
        jButtonConcluirVenda.setForeground(new Color(50, 50, 50));
        jButtonConcluirVenda.setBackground(new Color(200, 200, 200));
        jButtonConcluirVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                concluirVenda();
            }
        });
        add(jButtonConcluirVenda);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Screen();
        });
    }
    private void mostrarListaProdutosCarrinhoEcatalogo() {
        JFrame listaProdutosFrame = new JFrame("Catálogo de Produtos e Carrinho");
        JTextArea listaProdutosTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(listaProdutosTextArea);
        listaProdutosFrame.add(scrollPane);
    
        StringBuilder produtos = new StringBuilder("---- Catálogo de Produtos ----\n");
        // Adiciona produtos do catálogo
        for (Produto produto : catalogo.produtossDisponiveis) {
            produtos.append(produto.getNomeProduto()).append(" - R$").append(produto.getPreco()).append("\n");
        }
        produtos.append("\n---- Produtos no Carrinho ----\n");
        double total = 0.0;
        // Adiciona produtos do carrinho
        if (carrinho != null) {
            for (int i = 0; i < carrinho.getListaProdutos().size(); i++) {
                Produto produto = carrinho.getListaProdutos().get(i);
                int quantidade = carrinho.getQuantidadeComprada().get(i);
                double preco = produto.getPreco();
                double subtotal = preco * quantidade;
                produtos.append(produto.getNomeProduto()).append(" - R$").append(preco)
                    .append(" - Quantidade: ").append(quantidade).append(" - Subtotal: R$")
                    .append(subtotal).append("\n");
                total += subtotal;
            }
            produtos.append("Valor Total: R$").append(total).append("\n");
        } else {
            produtos.append("Carrinho não inicializado.");
        }
        
        listaProdutosTextArea.setText(produtos.toString());
    
        listaProdutosFrame.setSize(400, 300);
        listaProdutosFrame.setVisible(true);
        listaProdutosFrame.setLocationRelativeTo(null);
    }
    
    
    private void adicionarProdutoAoCarrinho() {
    if (carrinho != null) {
        String nomeProduto = textFieldNomeProduto.getText();
        Produto produtoEncontrado = encontrarProdutoNoCatalogo(nomeProduto);

        if (produtoEncontrado != null) {
            try {
                int quantidadeDesejada = Integer.parseInt(textFieldQuantidade.getText()); // Obtenha o valor do JTextField
                int resultado = carrinho.adicionaProduto(produtoEncontrado, quantidadeDesejada);

                if (resultado == 1) {
                    JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
                } else {
                    JOptionPane.showMessageDialog(this, "[ERRO] Não foi possível adicionar o produto ao carrinho. Verifique o estoque!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite uma quantidade válida!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado no catálogo!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Carrinho não inicializado!");
    }
}

    //remover produto do carrinho pelo nome e quantidade
    private void removerProdutoDoCarrinho() {
        if (carrinho != null) {
            String nomeProduto = textFieldNomeProduto.getText();
            int quantidadeRemover = Integer.parseInt(textFieldQuantidade.getText());

            int resultado = carrinho.removeProdutoPeloNome(nomeProduto, quantidadeRemover);

            if (resultado == 1) {
                JOptionPane.showMessageDialog(this, "Produto removido do carrinho!");
            } else if (resultado == 0) {
                JOptionPane.showMessageDialog(this, "Produto não encontrado no carrinho.");
            } else if (resultado == -1) {
                JOptionPane.showMessageDialog(this, "Quantidade a ser removida é maior que a quantidade no carrinho.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Carrinho não inicializado!");
        }
    }

    private Produto encontrarProdutoNoCatalogo(String nomeProduto) {
        for (Produto produto : catalogo.produtossDisponiveis) {
            if (produto.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    private void concluirVenda() {
        if (carrinho != null) {
            Venda.tipoVenda tipo = Venda.tipoVenda.DINHEIRO; 
            Venda venda = new Venda(carrinho, tipo);

            NotaFiscal notaFiscal = new NotaFiscal(venda);
            notaFiscal.imprimeNotaFiscal();
            notaFiscal.escreverNotaFiscalEmArquivo();
        } else {
            JOptionPane.showMessageDialog(this, "Carrinho não inicializado!");
        }
    }
    
}
