import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario2 extends JFrame {
    private JButton inactivarButton;
    private JButton verResultadoButton;
    private JButton limpiarButton;
    private JRadioButton p1a;
    private JRadioButton p2a;
    private JRadioButton p3a;
    private JRadioButton p1b;
    private JRadioButton p2b;
    private JRadioButton verdadero;
    private JRadioButton falso;
    private JRadioButton p3b;
    private JPanel Principal2;
    private JLabel pregunta1;
    private JLabel pregunta2;
    private JLabel resultado;

    public Formulario2() {
        setTitle("Test POO - Java");
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(Principal2);
        setLocationRelativeTo(null);
        setVisible(true);

        pregunta1.setText("1. ¿Qué es el polimorfismo en Java?");
        p1a.setText("A) La capacidad de sobrecargar variables");
        p2a.setText("B) La capacidad de una clase de comportarse de múltiples formas");
        p3a.setText("C) Usar múltiples clases en un solo archivo");

        pregunta2.setText("2. ¿Cuál es el modificador de acceso que permite visibilidad en todo el paquete?");
        p1b.setText("A) private");
        p2b.setText("B) public");
        p3b.setText("C) default");
        resultado.setText("Resultado: -");

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(p1a);
        grupo1.add(p2a);
        grupo1.add(p3a);

        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(p1b);
        grupo2.add(p2b);
        grupo2.add(p3b);

        ButtonGroup grupo3 = new ButtonGroup();
        grupo3.add(verdadero);
        grupo3.add(falso);

        verResultadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int puntos = 0;
                if (p2a.isSelected()) puntos += 5; // respuesta correcta de pregunta 1
                if (p3b.isSelected()) puntos += 5; // respuesta correcta de pregunta 2
                if (verdadero.isSelected()) puntos += 5; // respuesta correcta de pregunta 3
                resultado.setText("Resultado: " + puntos + " / 15");
            }
        });

        inactivarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1a.setEnabled(false);
                p2a.setEnabled(false);
                p3a.setEnabled(false);
                p1b.setEnabled(false);
                p2b.setEnabled(false);
                p3b.setEnabled(false);
                verdadero.setEnabled(false);
                falso.setEnabled(false);
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grupo1.clearSelection();
                grupo2.clearSelection();
                grupo3.clearSelection();
                resultado.setText("Resultado: -");
                p1a.setEnabled(true);
                p2a.setEnabled(true);
                p3a.setEnabled(true);
                p1b.setEnabled(true);
                p2b.setEnabled(true);
                p3b.setEnabled(true);
                verdadero.setEnabled(true);
                falso.setEnabled(true);
            }
        });
    }
}