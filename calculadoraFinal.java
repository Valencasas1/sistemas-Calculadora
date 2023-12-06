import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//el display se usa para mostrar texto en la pantalla
public class calculadoraFinal extends JFrame implements ActionListener {

  private JTextField display;
  private double num1;
  private double num2;
  private double resultado;
  private String operacion;


//en esta parte se configura la interfaz grafica de la calculadora
  
  public calculadoraFinal() {


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar la ventana
   
   //setSize se usa para elegir el tamaño de la ventana, en este caso es de 300, 400
   setSize(300, 400);
   setLayout(new BorderLayout());
   
   //pantalla
   display = new JTextField();
   display.setEditable(false);
   add(display, BorderLayout.NORTH);
   
   //aca se organizan los botnes
   JPanel PBotones = new JPanel();
   //establece el diseño de la calculadora, tiene 5 filas y 4 columnas
   PBotones.setLayout(new GridLayout(5, 4));
   
   //diseño del tablero
   String[] botones = {

       "7", "8", "9", "/",
       "4", "5", "6", "*",
       "3", "2", "1", "-",
       "0", ".", "=", "+",
       "<-", "CE",
       };

   for (String BotonesDeTexto : botones) {
       JButton boton = new JButton(BotonesDeTexto);

       //this indica la instancia actual de la clase
       boton.addActionListener(this);
       PBotones.add(boton);
       }

   add(PBotones, BorderLayout.CENTER);
      }
  
  @Override
  public void actionPerformed(ActionEvent e) {
      String comando = e.getActionCommand();
      
         switch (comando) {
             case "=":
                num2 = Double.parseDouble(display.getText());
                calcular();
                display.setText(String.valueOf(resultado));
                break;
             
             case "+":
             case "-":
             case "*":
             case "/":
             
                operacion = comando;
                num1 = Double.parseDouble(display.getText());
                display.setText("");
                break;
            
            //con esto borra un solo dijito
            case "<-":
                     String texto = display.getText();
                     if (!texto.isEmpty()) {
                         display.setText(texto.substring(0,texto.length() - 1));
                         }
                break;

            //este se usa para borrar todo 
            case "CE":
                      display.setText("");
                break;
             
             default:
                     display.setText(display.getText() + comando);
             }
      } 
      
      private void calcular() {
          switch (operacion) {
              
              case "+":
                       resultado = num1 + num2;
                       break;
              case "-":
                       resultado = num1 - num2;
                       break;
              case "*":
                       resultado = num1 * num2;
                       break;
              case "/":
                       if (num2 != 0) {
                          resultado = num1 / num2;
                           }
                       else {
                           display.setText("Error, no se puede dividir ente cero");
                           }
                       break;
              }
          }
   public static void main (String[] args) {
       SwingUtilities.invokeLater(() -> {
           calculadoraFinal calculadora = new calculadoraFinal();
           calculadora.setVisible(true);
           });
       }
  }