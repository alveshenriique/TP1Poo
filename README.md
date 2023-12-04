Supermercado Virtual Damasco - Projeto Java
Este projeto em Java é um Supermercado Virtual Damasco que utiliza conceitos de programação orientada a objetos para simular a interação entre clientes, produtos e vendas. O sistema é composto por diversas classes, cada uma desempenhando um papel específico no funcionamento do supermercado.

Classes Principais:
Produto: Representa um item disponível para venda, com atributos como nome, preço e quantidade em estoque. Permite adição e remoção de itens no estoque.

CarrinhoDeCompras: Modela o carrinho virtual de um cliente, permitindo adicionar e remover produtos, gerar o preço total da compra e listar os produtos presentes no carrinho.

Venda: Representa uma transação de compra, vinculando um carrinho de compras, data/hora e tipo de pagamento. Realiza a manipulação do estoque dos produtos vendidos.

NotaFiscal: Gera e imprime notas fiscais para vendas, exibindo detalhes como itens comprados, total a pagar, data da compra e forma de pagamento.

HistoricoVendas: Mantém um histórico das vendas realizadas, permitindo adicionar novas vendas e listar todas as vendas registradas.

Como Usar:
Catálogo de Produtos: O projeto já possui um catálogo inicial de produtos. Para adicionar novos produtos, basta criar instâncias da classe Produto e adicioná-los à lista de produtos disponíveis.

Teste: O arquivo teste.java contém um exemplo de como utilizar as classes do supermercado. Você pode personalizar este arquivo para testar diferentes cenários de compra.
