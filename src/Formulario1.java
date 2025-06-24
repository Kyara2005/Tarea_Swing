import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

public class Formulario1 extends JFrame{
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JButton limpiraButton;
    private JButton verificarEdadButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel resultado;
    private JPanel Principal;

    public Formulario1() {
        setTitle("Formulario Edad");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal);
        setVisible(true);

        ButtonGroup genero = new ButtonGroup();
        genero.add(hombreRadioButton);
        genero.add(mujerRadioButton);

        limpiraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                genero.clearSelection();
                resultado.setText("");
            }
        });
        verificarEdadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = textField1.getText();
                    String apellido = textField2.getText();
                    int año = Integer.parseInt(textField3.getText());
                    int edad = Year.now().getValue() - año;
                    String sexo = hombreRadioButton.isSelected() ? "Hombre" : mujerRadioButton.isSelected() ? "Mujer" : "No especificado";

                    String texto = "<html>Nombre: " + nombre + " " + apellido + "<br>Género: "+sexo+"<br>Edad: " + edad + " años → ";
                    texto += (edad >= 18) ? "Mayor de edad" : "Menor de edad";
                    texto += "</html>";

                    resultado.setText(texto);
                } catch (Exception ex) {
                    resultado.setText("Datos inválidos");
                }
            }
        });
    }
}
