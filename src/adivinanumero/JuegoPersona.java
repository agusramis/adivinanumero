package adivinanumero;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JuegoPersona {
 
  
  public static final Random RANDOM = new Random();
  public int numero;
  public int intentos;
  public boolean adivinanza;
  public JTextPane titulo;
  public JTextField campoTexto;

  //Generamos un numero de 4 cifras
  public void generadorNumero() {
    do {
      numero = RANDOM.nextInt(9000) + 1000;
    } while ( duplicado( numero ));
  }
// verifica que no se dupliquen digitos
  public boolean duplicado(int numero) {
    boolean[] digitos = new boolean[10];

    while (numero > 0) {
      int ultDigito = numero % 10;

      if (digitos[ultDigito]) return true;

      digitos[ultDigito] = true;
      numero = numero / 10;
    }

    return false;
  }

  // devuelve la cantidad de Bien y Regular
  public int[] cantBienReg(int numeroIngresado) {
    int bien = 0;
    int regular = 0;

    String numeroIngresadoSrt = String.valueOf(numeroIngresado);
    String numeroStr = String.valueOf(numero);

    for (int i = 0; i < numeroStr.length(); i++) {
      char c = numeroIngresadoSrt.charAt(i);

      if (c == numeroStr.charAt(i)) {
        bien++;
      } else if (numeroStr.contains(String.valueOf(c))) {
        regular++;
      }
    }

    return new int[] {bien,regular};
  }

  public void jugar() {
    JFrame frame = new JFrame("Adivinador");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();

    JPanel botonesPanel = new JPanel();

    JLabel ingresar = new JLabel("Ingresar :");
    botonesPanel.add(ingresar, BorderLayout.LINE_START);

    campoTexto = new JTextField(15);
    campoTexto.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        BotonOk();
      }
    });
    botonesPanel.add(campoTexto, BorderLayout.LINE_START);

    JButton BotonOk = new JButton("OK");
    BotonOk.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        BotonOk();
      }
    });

    botonesPanel.add(BotonOk, BorderLayout.LINE_END);

    JButton NuevoJuego = new JButton("Nuevo Juego");
    NuevoJuego.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        iniciar();
      }
    });

    botonesPanel.add(NuevoJuego, BorderLayout.LINE_END);
    contentPane.add(botonesPanel, BorderLayout.PAGE_END);

    // agregar un area de texto
    titulo = new JTextPane();
    titulo.setEditable(false);
    JScrollPane jscrollpane = new JScrollPane(titulo);

    SimpleAttributeSet bSet = new SimpleAttributeSet();
    StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
    StyleConstants.setFontSize(bSet, 20);
    StyledDocument doc = titulo.getStyledDocument();
    doc.setParagraphAttributes(0, doc.getLength(), bSet, false);

    contentPane.add(jscrollpane, BorderLayout.CENTER);
    frame.setMinimumSize(new Dimension(600, 400));

    //Dimensiones del Frame
    Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
    int iCoordX = (objDimension.width - frame.getWidth()) / 2;
    int iCoordY = (objDimension.height - frame.getHeight()) / 2;
    frame.setLocation(iCoordX, iCoordY);
    frame.pack();
    frame.setVisible(true);

    iniciar();
  }

  public void BotonOk() {
    String userInput = campoTexto.getText();
    int numeroIngresado = -1;

    try {
      numeroIngresado = Integer.parseInt(userInput);
    } catch(Exception e) {
      campoTexto.setText("");
      JOptionPane.showMessageDialog(null, "Debes ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (duplicado(numeroIngresado) || numeroIngresado < 1000 || numeroIngresado > 9999) {
      campoTexto.setText("");
      JOptionPane.showMessageDialog(null, "Debes ingresar un numero de 4 digitos no repetidos", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    intentos++;

    int[] answer = cantBienReg(numeroIngresado);

    if (answer[0] == 4) {
      adivinanza = true;
    } else {
      ingresarTexto(numeroIngresado + "\t\t" + answer[0] + " Bien y " + answer[1] + " regular");
    }

    if (adivinanza) {
      ingresarTexto("\n" + numeroIngresado + "\n\nGanaste en " + intentos + " intentos!");
    }

    campoTexto.setText("");
  }
 public void ingresarTexto(String txt) {
    titulo.setText(titulo.getText() + "\n" + txt);
  }

 
  public void iniciar() {
    generadorNumero();
    intentos = 0;
    adivinanza = false;
    titulo.setText("Adivinar numero de 4 digitos sin repetir");
    campoTexto.setText("");
  }



}

