import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario4 extends JFrame {
    private JRadioButton mujerRadioButton;
    private JRadioButton hombreRadioButton;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    private JTextField telefono;
    private JComboBox comboBox1;
    private JCheckBox fútbolCheckBox;
    private JTable table1;
    private JButton registrarButton;
    private JButton limpiarButton;
    private JPanel Panel4;
    private JCheckBox chkBasquet;
    private JCheckBox chkTenis;
    private JCheckBox chkNatacion;

    private DefaultTableModel modelo;

    public Formulario4() {
        setTitle("Formulario 4 - Registro de Persona");
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Panel4);
        setLocationRelativeTo(null);
        setVisible(true);

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(hombreRadioButton);
        grupoGenero.add(mujerRadioButton);

        comboBox1.addItem("La Floresta");
        comboBox1.addItem("Chillogallo");
        comboBox1.addItem("Carcelén");
        comboBox1.addItem("El Condado");

        modelo = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Edad", "Teléfono", "Género", "Deportes", "Barrio"}, 0);
        table1.setModel(modelo);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nombre.getText().trim();
                String ape = apellido.getText().trim();
                String ed = edad.getText().trim();
                String tel = telefono.getText().trim();
                String genero = hombreRadioButton.isSelected() ? "Hombre" : mujerRadioButton.isSelected() ? "Mujer" : "";
                String barrio = (String) comboBox1.getSelectedItem();

                if (nom.isEmpty() || ape.isEmpty() || ed.isEmpty() || tel.isEmpty() || genero.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completa todos los campos obligatorios.");
                    return;
                }
                StringBuilder deportes = new StringBuilder();
                if (fútbolCheckBox.isSelected()) deportes.append("Fútbol ");
                if (chkBasquet.isSelected()) deportes.append("Básquet ");
                if (chkTenis.isSelected()) deportes.append("Tenis ");
                if (chkNatacion.isSelected()) deportes.append("Natación ");


                modelo.addRow(new Object[]{nom, ape, ed, tel, genero, deportes, barrio});

            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText("");
                apellido.setText("");
                edad.setText("");
                telefono.setText("");
                grupoGenero.clearSelection();
                fútbolCheckBox.setSelected(false);
                comboBox1.setSelectedIndex(0);
            }
        });
    }
}

