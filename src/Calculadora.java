import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora  implements ActionListener {
    JFrame frame; //frame principal
    JTextField input; //input calculadora
    JButton[] numerosArr = new JButton[10]; //arreglo de numeros
    JButton[] funcionesArr = new JButton[8]; //arreglo de funciones
    JButton sumar,restar,dividir,multiplicar; //botones de operaciones
    JButton decimal, igual, borrar, limpiar; //botones de funciones
    JButton botonCero; //boton numero 0
    JPanel containerNumeros = new JPanel(); //contenedor botones numeros
    JPanel containerFunciones = new JPanel(); //contenedor botones funciones
    Font font = new Font("Monaco", Font.BOLD, 25); //tipo de letra
    char operacion; //tipo de operacion
    double numero, numeroAux, resultado; //variables

    Calculadora() {
        //JFrame configuracion
        frame = new JFrame();
        frame.setTitle("Calculadora"); //titulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar
        frame.setLayout(null); //layout
        frame.setResizable(false);
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

        //layout containerFunciones
        containerFunciones.setLayout(new GridLayout(2, 4, 5,5));
        containerFunciones.setBounds(10, 80, 290, 85);

        //for funciones botones
        for (int i = 0; i < 8; i++) {
            funcionesArr[i].setFont(font);
            funcionesArr[i].addActionListener(this);
            funcionesArr[i].setFocusable(false);
            funcionesArr[i].setBackground(new Color(255, 243, 7));

            //si es igual a Del o CE la letra sera mas pequeña
            if (i == 6 || i == 7) {
                Font fontF = new Font("Monaco", Font.BOLD, 20);
                funcionesArr[i].setFont(fontF);
            }
        }

        //layout containerNumeros
        containerNumeros.setLayout(new GridLayout(4,3, 5, 5));
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

        //configuracion boton 0
        botonCero = new JButton("0");
        botonCero.setBounds(10, 324, 290, 50);
        botonCero.setFont(font);
        botonCero.addActionListener(this);
        botonCero.setFocusable(false);
        botonCero.setBackground(new Color(255, 243, 7));

        //agregar atributos al frame
        frame.add(botonCero); //agregar boton 0
        frame.add(containerNumeros); //agregar containerNumeros
        frame.add(containerFunciones);//agregar containerFunciones
        frame.add(input); //agregar input
        frame.setVisible(true); //visibilidad
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //mostrar digitos
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numerosArr[i]) {
                if(resultado > 0) {
                    input.setText("");
                    resultado=0;
                }
                input.setText(input.getText().concat(String.valueOf(i)));
            }
        }

        //boton Cero
        if(e.getSource()==botonCero) {
            if(resultado > 0) {
                input.setText("");
                resultado=0;
            }
            input.setText(input.getText().concat("0"));
        }

        //boton sumar
        if(e.getSource() == sumar) {
            numero = Double.parseDouble(input.getText());
            operacion='+';
            input.setText("");
        }

        //boton restar
        if(e.getSource() == restar) {
            numero = Double.parseDouble(input.getText());
            operacion='-';
            input.setText("");
        }

        //boton multiplicar
        if(e.getSource() == multiplicar) {
            numero = Double.parseDouble(input.getText());
            operacion='*';
            input.setText("");
        }

        //boton dividir
        if(e.getSource() == dividir) {
            numero = Double.parseDouble(input.getText());
            operacion='/';
            input.setText("");
        }

        //boton decimales
        if(e.getSource() == decimal) {
            input.setText(input.getText().concat("."));
        }

        //boton limpiar
        if(e.getSource() == limpiar) {
            input.setText("");
            numero=0;
            resultado=0;
            numeroAux=0;
        }

        //boton borra
        if(e.getSource() == borrar) {
            String string = input.getText();
            input.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                input.setText(input.getText()+string.charAt(i));
                if(i == 0) {
                    numero=0;
                    resultado=0;
                    numeroAux=0;
                }
            }
        }

        //operaciones
        if(e.getSource() == igual) {
            numeroAux = Double.parseDouble(input.getText());
            switch (operacion) {
                case '+':
                    resultado = numero+numeroAux;
                    break;
                case '-':
                    resultado = numero-numeroAux;
                    break;
                case '/':
                    resultado = numero/numeroAux;
                    break;
                case '*':
                    resultado = numero*numeroAux;
                    break;
            }
            input.setText(String.valueOf(resultado));
            numero=resultado;
        }
    }

    public static void main(String[] args) {
        new Calculadora(); //nueva instancia de calculadora
    }
}
