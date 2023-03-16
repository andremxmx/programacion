import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener {
    private JLabel labelBase, labelAltura, labelResultado;
    private JTextField campoBase, campoAltura, campoResultado;
    private JButton botonCalcular;
    public Main() {
        setTitle("Cálculo del área de un rectángulo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        labelBase = new JLabel("Base:");
        campoBase = new JTextField();
        campoBase.setColumns(10);

        labelAltura = new JLabel("Altura:");
        campoAltura = new JTextField();
        campoAltura.setColumns(10);

        botonCalcular = new JButton("Calcular");
        botonCalcular.addActionListener(this);

        labelResultado = new JLabel("Resultado:");
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        campoResultado.setColumns(10);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 2, 5, 5));
        panelPrincipal.add(labelBase);
        panelPrincipal.add(campoBase);
        panelPrincipal.add(labelAltura);
        panelPrincipal.add(campoAltura);
        panelPrincipal.add(new JLabel());
        panelPrincipal.add(botonCalcular);
        panelPrincipal.add(labelResultado);
        panelPrincipal.add(campoResultado);

        setContentPane(panelPrincipal);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCalcular) {
            try {
                double base = Double.parseDouble(campoBase.getText());
                double altura = Double.parseDouble(campoAltura.getText());
                double area = base * altura;
                campoResultado.setText(String.format("%.2f", area));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Main ventana = new Main();
        ventana.setVisible(true);
    }
}
