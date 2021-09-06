package view;
import controllers.ChangeEvent;
import javax.swing.*;

public class Ventana extends JFrame{

    private JTextField textConsulta;

    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnAdd;

    private JPanel Ventana;

    private JTable table1;
    private JScrollBar scrollBar1;

    public Ventana() {
        setContentPane(Ventana);
        setTitle("RETO 5");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        btnSearch.addActionListener(new ChangeEvent(this));
        btnAdd.addActionListener(new ChangeEvent(this));
        btnUpdate.addActionListener(new ChangeEvent(this));
        btnDelete.addActionListener(new ChangeEvent(this));
    }


    public static void main(String[] args) {
        Ventana v1 = new Ventana();
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }
}
