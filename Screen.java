/**
 *
 * @author Ricardo García
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Screen extends JFrame {
    private cifradoCesar cesar = new cifradoCesar();
    // Componentes
    private JPanel jPanelBase;
    public static JTextField jTextClave;
    private JButton jButtonCifrar, jButtonDescifrar, jButtonLimpiar;
    private JTextArea jAreaLlano, jAreaCifrado, jAreaDescifrado;
    private JLabel lbClave, lbLlano, lbCifrado, lbDescifrado;
    //Colores
    private final Color azulFuerte = new Color(20, 40, 80);
    private final Color azul = new Color(39, 73, 109);
    private final Color blanco = new Color(255, 255, 255);
    //Fuentes
    private final Font placeholder = new Font("Calibri Light",Font.PLAIN, 18);
    private final Font Cuadrostexto = new Font("Calibri Light",Font.LAYOUT_LEFT_TO_RIGHT, 18);

    public Screen(){
        this.setSize(800, 670);
        this.setUndecorated(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        initComponents();
    }
    
    private void initComponents(){
       
        jButtonCifrar = new JButton("CIFRAR MENSAJE");
        jButtonCifrar.setBackground(azulFuerte);
        jButtonCifrar.setForeground(blanco);
        jButtonCifrar.setEnabled(true);
        jButtonCifrar.setBorder(BorderFactory.createLineBorder(blanco, 1));
        jButtonCifrar.setBounds(250, 210, 300, 40);
        jButtonCifrar.setToolTipText("CIFRAR MENSAJE");
        
        jButtonDescifrar = new JButton("DESCIFRAR MENSAJE");
        jButtonDescifrar.setBackground(azulFuerte);
        jButtonDescifrar.setForeground(blanco);
        jButtonDescifrar.setEnabled(true);
        jButtonDescifrar.setBorder(BorderFactory.createLineBorder(blanco, 1));
        jButtonDescifrar.setBounds(250, 400, 300, 40);
        jButtonDescifrar.setToolTipText("DESCIFRAR MENSAJE");

        jButtonLimpiar = new JButton("LIMPIAR");
        jButtonLimpiar.setBackground(azulFuerte);
        jButtonLimpiar.setForeground(blanco);
        jButtonLimpiar.setEnabled(true);
        jButtonLimpiar.setBorder(BorderFactory.createLineBorder(blanco, 1));
        jButtonLimpiar.setBounds(250, 590, 300, 40);
        jButtonLimpiar.setToolTipText("LIMPIAR");
        
        jTextClave = new JTextField(200);
        jTextClave.setEditable(true);
        jTextClave.setBackground(blanco);
        jTextClave.setFont(Cuadrostexto);
        jTextClave.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jTextClave.setBounds(420,20,220,30);
        TextPrompt textUser = new TextPrompt("Ejemplo:-5, 1, 10, 16, etc.",jTextClave );
        textUser.setFont(placeholder);
   
        jPanelBase = new JPanel();
        jPanelBase.setLayout(null);
        jPanelBase.setBackground(azul);
        jPanelBase.setVisible(true);
            
        lbClave = new JLabel("Ingrese el número de corrimientos: ");
        lbClave.setFont(Cuadrostexto);
        lbClave.setBounds(140,20, 300, 30);
        lbClave.setForeground(blanco);

        lbLlano = new JLabel("Texto llano");
        lbLlano.setFont(Cuadrostexto);
        lbLlano.setBounds(30,70, 200, 30);
        lbLlano.setForeground(blanco);

        lbCifrado = new JLabel("Texto cifrado");
        lbCifrado.setFont(Cuadrostexto);
        lbCifrado.setBounds(30,260, 200, 30);
        lbCifrado.setForeground(blanco);

        lbDescifrado = new JLabel("Texto Descifrado");
        lbDescifrado.setFont(Cuadrostexto);
        lbDescifrado.setBounds(30,450, 200, 30);
        lbDescifrado.setForeground(blanco);

        jAreaLlano = new JTextArea();
        jAreaLlano.setFont(Cuadrostexto);
        jAreaLlano.setBackground(blanco);
        jAreaLlano.setBounds(30, 100, 730, 100);
        jAreaLlano.setLineWrap(true);
        
        jAreaCifrado = new JTextArea();
        jAreaCifrado.setFont(Cuadrostexto);
        jAreaCifrado.setBackground(blanco);
        jAreaCifrado.setBounds(30, 290, 730, 100);
        jAreaCifrado.setLineWrap(true);

        jAreaDescifrado = new JTextArea();
        jAreaDescifrado.setFont(Cuadrostexto);
        jAreaDescifrado.setBackground(blanco);
        jAreaDescifrado.setBounds(30, 480, 730, 100);
        jAreaDescifrado.setLineWrap(true);

        jPanelBase.add(jButtonCifrar);
        jPanelBase.add(jButtonDescifrar);
        jPanelBase.add(jTextClave);
        jPanelBase.add(jAreaLlano);
        jPanelBase.add(jAreaCifrado);
        jPanelBase.add(jAreaDescifrado);
        jPanelBase.add(lbClave);
        jPanelBase.add(lbLlano);
        jPanelBase.add(lbCifrado);
        jPanelBase.add(lbDescifrado);
        jPanelBase.add(jButtonLimpiar);
        
        this.getContentPane().add(jPanelBase);
        
        jButtonCifrar.addActionListener((ActionEvent e) -> {
            int flag = 1;
            if(!jTextClave.getText().isEmpty()){

                if(!(""+jTextClave.getText().charAt(0)).equals("-")){
                    for (int i = 0; i < jTextClave.getText().length(); i++) {
                        if (!Character.isDigit(jTextClave.getText().charAt(i)))
                            flag = 0;
                    }
                } else {
                    for (int i = 1; i < jTextClave.getText().length(); i++) {
                        if (!Character.isDigit(jTextClave.getText().charAt(i)))
                            flag = 0;
                    }
                }
                
                if(flag == 1){
                    if(!jAreaLlano.getText().isEmpty()){
                        cesar.cifrar(jAreaLlano.getText(), Integer.parseInt(jTextClave.getText()));
                        jAreaCifrado.setText(cesar.getCadenaCifrada());
                    } else 
                    mensaje("Llenar el campo con el mensaje a cifrar");
                } else 
                mensaje("Ingresar dígitos en el número de corrimientos");
            } else 
            mensaje("Llenar el campo con el número de corrimientos");

            actualizarPantalla();
        });

        jButtonDescifrar.addActionListener((ActionEvent e) -> {
            int flag = 1;
            if(!jTextClave.getText().isEmpty()){
                if(!(""+jTextClave.getText().charAt(0)).equals("-")){
                    for (int i = 0; i < jTextClave.getText().length(); i++) {
                        if (!Character.isDigit(jTextClave.getText().charAt(i)))
                            flag = 0;
                    }
                } else {
                    for (int i = 1; i < jTextClave.getText().length(); i++) {
                        if (!Character.isDigit(jTextClave.getText().charAt(i)))
                            flag = 0;
                    }
                }
                if(flag == 1){
                    if(!jAreaCifrado.getText().isEmpty()){
                        cesar.descifrar(jAreaCifrado.getText(), Integer.parseInt(jTextClave.getText()));
                        jAreaDescifrado.setText(cesar.getCadenaDescifrada());
                    } else mensaje("Llenar el campo con el mensaje a descifrar");
                } else 
                mensaje("Ingresar dígitos en el número de corrimientos");
            } else 
            mensaje("Llenar el campo con el número de corrimientos");

            actualizarPantalla();
        });
        
        jButtonLimpiar.addActionListener((ActionEvent e) -> {
            jTextClave.setText("");
            jAreaLlano.setText("");
            jAreaCifrado.setText("");
            jAreaDescifrado.setText("");
            actualizarPantalla();
        });
    }

    public void actualizarPantalla(){
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void mensaje(String texto){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, texto);

    }
}
