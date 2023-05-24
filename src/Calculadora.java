import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora  implements ActionListener {
    JFrame frame;
    JTextField input;
    JButton[] numerosArr = new JButton[10];
    JButton[] funcionesArr = new JButton[8];
    JButton sumar,restar,dividir,multiplicar;
    JButton decimal, igual, borrar, limpiar;
    JPanel containerNumeros = new JPanel();
    JPanel containerFunciones = new JPanel();
    Font font = new Font("Monaco", Font.BOLD, 25);

    Calculadora() {
        //JFrame configuracion
        frame = new JFrame();
        frame.setTitle("Calculadora"); //titulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar
        frame.setLayout(null); //layout
        frame.setBackground(new Color(154, 154, 154)); //color
        frame.setSize(320, 420); //tamaño

        //input configuracion
        input = new JTextField(); //instanciar input
        input.setBounds(10, 25, 290, 50);
        input.setEditable(false); //dehabilitar escritura
        input.setFont(font); //tipo de letra
        input.setFocusable(false); //no enfocar
        input.setBackground(new Color(255, 255, 255));//fondo

        //botones funciones
        sumar = new JButton("+"); //boton sumar
        containerFunciones.add(sumar);
        restar = new JButton("-"); //boton restar
        containerFunciones.add(restar);
        dividir = new JButton("/"); //boton dividir
        containerFunciones.add(dividir);
        multiplicar = new JButton("*"); //boton multiplicar
        containerFunciones.add(multiplicar);
        decimal = new JButton("."); //boton decimal
        containerFunciones.add(decimal);
        igual = new JButton("="); //boton igual
        containerFunciones.add(igual);
        borrar = new JButton("Del"); //boton borrar
        containerFunciones.add(borrar);
        limpiar = new JButton("CE"); //boton limpiar
        containerFunciones.add(limpiar);

        //asignar al arreglo para simplificacion
        funcionesArr[0] = sumar;
        funcionesArr[1] = restar;
        funcionesArr[2] = dividir;
        funcionesArr[3] = multiplicar;
        funcionesArr[4] = decimal;
        funcionesArr[5] = igual;
        funcionesArr[6] = borrar;
        funcionesArr[7] = limpiar;

        containerFunciones.setLayout(new GridLayout(2, 4, 5,5));
        containerFunciones.setBounds(10, 80, 290, 85);

        //for funciones botones
        for (int i = 0; i < 8; i++) {
            funcionesArr[i].setFont(font);
            funcionesArr[i].addActionListener(this);
            funcionesArr[i].setFocusable(false);
            funcionesArr[i].setBackground(new Color(255, 243, 7));

            if (i == 6 || i == 7) {
                Font fontF = new Font("Monaco", Font.BOLD, 20);
                funcionesArr[i].setFont(fontF);
            }
        }

        containerNumeros.setLayout(new GridLayout(3,3, 5, 5));
        containerNumeros.setBounds(10, 170, 290, 200);

        //botones numeros
        for (int i = 1; i < 10; i++) {
            numerosArr[i] = new JButton(String.valueOf(i));
            numerosArr[i].setFont(font);
            numerosArr[i].addActionListener(this);
            numerosArr[i].setFocusable(false);
            numerosArr[i].setBackground(new Color(255, 243, 7));
            containerNumeros.add(numerosArr[i]);
        }

        frame.add(containerNumeros);
        frame.add(containerFunciones);
        frame.add(input); //agregar input
        frame.setVisible(true); //visibilidad
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
