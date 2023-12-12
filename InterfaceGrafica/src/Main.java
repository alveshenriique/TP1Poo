import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        Catalogo catalogo = new Catalogo();

        SwingUtilities.invokeLater(() -> {
            new Screen();
        });
    }
}
