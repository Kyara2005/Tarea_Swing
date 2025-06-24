import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Formulario3 extends JFrame {
    private JComboBox<String> comboBox1;
    private JPanel Panel3;
    private JTextField textField1;
    private JLabel precio;
    private JLabel subtotal;
    private JLabel Iva;
    private JLabel descuento;
    private JLabel total;
    private JTable table1;
    private JButton pagarButton;
    private JButton limpiarButton;
    private DefaultTableModel modelo;
    private HashMap<String, Double> precios;

    public Formulario3 (){
        setTitle("Formulario 3 - Test de Compras");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Panel3);
        setLocationRelativeTo(null);
        setVisible(true);

        precios = new HashMap<>();
        precios.put("Martillo", 10.00);
        precios.put("Clavos", 3.50);
        precios.put("Pintura Blanca", 15.00);
        precios.put("Taladro", 50.00);

        //COMBObox
        for (String producto : precios.keySet()) {
            comboBox1.addItem(producto);
        }
        // Configurar tabla
        modelo = new DefaultTableModel(new String[]{"Producto", "Cantidad", "P.Unitario", "Subtotal", "IVA", "Descuento", "Total"}, 0);
        table1.setModel(modelo);

        pagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = (String) comboBox1.getSelectedItem();
                double precioUnitario = precios.get(producto);

                int cantidad;
                try {
                    cantidad = Integer.parseInt(textField1.getText());
                    if (cantidad <= 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cantidad inválida");
                    return;
                }
                double sb = precioUnitario * cantidad;
                double iva = sb * 0.15;
                double descuento1 = sb * 0.20;
                double total1 = sb + iva - descuento1;

                modelo.addRow(new Object[]{
                        producto,
                        cantidad,
                        String.format("$%.2f", precioUnitario),
                        String.format("$%.2f", sb),
                        String.format("$%.2f", iva),
                        String.format("$%.2f", descuento1),
                        String.format("$%.2f", total1)
                });
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textField1.setText("");
                    precio.setText("-");
                    subtotal.setText("-");
                    Iva.setText("-");
                    descuento.setText("-");
                    total.setText("-");
                    modelo.setRowCount(0); // Borra todas las filas
            }
        });
    }
}
