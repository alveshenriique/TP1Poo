import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{
    public Screen() {

        //Layout Caixa
        setVisible(true);
        setSize(800,500);
        setTitle("Supermercado POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);


        //Título
        JLabel jLabel = new JLabel("Carrinho de Compras");
        jLabel.setBounds(this.getX()/2, 1, 400,200);
        jLabel.setFont(new Font("Arial", Font.BOLD,35));

        add(jLabel);


        //Botões
        JButton jButtonAdicionar = new JButton();
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setBounds(200,290,150,70);
        jButtonAdicionar.setFont(new Font("Arial", Font.BOLD, 25));
        jButtonAdicionar.setForeground(new Color(4, 187, 20));
        jButtonAdicionar.setBackground(new Color(10, 9, 9));

        JButton jButtonRemover = new JButton();
        jButtonRemover.setText("Remover");
        jButtonRemover.setBounds(400,290,150,70);
        jButtonRemover.setFont(new Font("Arial", Font.BOLD, 25));
        jButtonRemover.setForeground(new Color(182, 4, 4));
        jButtonRemover.setBackground(new Color(5, 5, 5));


        add(jButtonAdicionar);
        add(jButtonRemover);
    }
}
