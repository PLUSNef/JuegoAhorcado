/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Neftali Aguilar
 * 
 */
public class Ahorcado extends javax.swing.JFrame {

    private String[] imagenes={"ahorcado01.png", "ahorcado02.png", 
    "ahorcado03.png", "ahorcado04.png", "ahorcado05.png",
    "ahorcado06.png", "ahorcado07.png"};
    private String[] palabras = new String[20];
    
    private char letra;
    private int aciertos;
    private String display;
    private boolean[] correctas;
    
    
    //Almacena las palabras leidas desde el archivo
    private Map<String, String> listaPalabras = new HashMap<>();
    private Integer intentos = 1;// almacena el numero de intentos
    private Integer contador = 0;// cuenta las palabras de la lista
    //palabra a adivinar
    private StringBuilder palabra = new StringBuilder();
    
    public Ahorcado() {
        initComponents();
        centrarForma();
        
        
    }
    
    private void leerArchivo(File aFile){
        int conta = 0;
        
        try{
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try{
                String line = null;//se extrae linea por linea de texto
                while ((line = input.readLine()) != null){
                    //coleccion Map (clave, valor)
                    listaPalabras.put("" + conta,line);
                    conta++;
                }
            }  finally {
                input.close();
            } 
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void loadNextWord(int indice){
        
        String line = listaPalabras.get("" + indice);
        StringBuilder wordConGuion = new StringBuilder();
        //simbolo de diferencia entre palabra y descripcion
        String[] datos = line.split(":");
        
        palabra = new StringBuilder();
        
        
        //palabra a cargar en los controles
        for (Character car : datos[0].toUpperCase().toCharArray()) {
            palabra.append(car);
            palabra.append(" ");
            wordConGuion.append("_");
            wordConGuion.append(" ");
        }
        
        txtDescripcion.setText(datos[1]);
        txtPalabra.setText(wordConGuion.toString());
        txtAdivinar.setText("");
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        lblIntentos = new javax.swing.JLabel();
        lblNoIntentos = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPalabra = new javax.swing.JLabel();
        txtPalabra = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblAdivinar = new javax.swing.JLabel();
        txtAdivinar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtErradas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(436, 677));

        jLabel1.setBackground(new java.awt.Color(0, 86, 42));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/juego-ahorcado-art.jpg"))); // NOI18N
        jLabel1.setText("JUEGO DEL AHORCADO");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        btnStart.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblIntentos.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        lblIntentos.setForeground(new java.awt.Color(255, 255, 255));
        lblIntentos.setText("INTENTOS");

        lblNoIntentos.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lblNoIntentos.setText("0");

        btnReset.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblNoIntentos))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart)
                            .addComponent(lblIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblIntentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNoIntentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel2.add(jPanel4);

        lblImagen.setBackground(new java.awt.Color(102, 102, 102));
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ahorcado01.png"))); // NOI18N
        lblImagen.setOpaque(true);
        jPanel2.add(lblImagen);

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(4, 2));

        lblPalabra.setBackground(new java.awt.Color(51, 51, 51));
        lblPalabra.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        lblPalabra.setForeground(new java.awt.Color(255, 255, 255));
        lblPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPalabra.setText("PALABRA");
        lblPalabra.setOpaque(true);
        jPanel3.add(lblPalabra);
        jPanel3.add(txtPalabra);

        lblDescripcion.setBackground(new java.awt.Color(51, 51, 51));
        lblDescripcion.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcion.setText("DESCRIPCIÓN");
        lblDescripcion.setOpaque(true);
        jPanel3.add(lblDescripcion);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel3.add(jScrollPane1);

        lblAdivinar.setBackground(new java.awt.Color(51, 51, 51));
        lblAdivinar.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        lblAdivinar.setForeground(new java.awt.Color(255, 255, 255));
        lblAdivinar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdivinar.setText("ADIVINAR");
        lblAdivinar.setOpaque(true);
        jPanel3.add(lblAdivinar);

        txtAdivinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdivinarActionPerformed(evt);
            }
        });
        txtAdivinar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdivinarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdivinarKeyTyped(evt);
            }
        });
        jPanel3.add(txtAdivinar);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Rockwell Condensed", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LETRAS ERRADAS");
        jLabel5.setOpaque(true);
        jPanel3.add(jLabel5);
        jPanel3.add(txtErradas);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        
        File archivo = new File("C:\\Users\\Texas\\Documents\\ahorcado.txt"); //    F:\\3Cuatrimestre\\DesarrolloApp1(Barron)\\JuegoAhorcado1\\ahorcado.txt
        leerArchivo(archivo);//para leer el archivo de texto metodo
        
        loadNextWord(contador);//cargar la primera palabra
        txtAdivinar.requestFocus();//posiciona el cursor sobre el componente 
        
        txtDescripcion.setEnabled(false);
        txtPalabra.setEnabled(false);
           
    }//GEN-LAST:event_btnStartActionPerformed

      private void reiniciar(){
         
        txtPalabra.setEnabled(false);
        txtDescripcion.setEnabled(false);
        
        txtErradas.setText("");
        if (contador < 3) {
        loadNextWord(contador);
        } else {
            JOptionPane.showMessageDialog(null, "Juego Terminado");
            System.exit(0);
        }
        intentos = 1;
        lblNoIntentos.setText(intentos.toString());
       lblImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + imagenes[intentos-1])));
    }
    
    
    
    private void txtAdivinarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdivinarKeyTyped
        // TODO add your handling code here
        
        char car= evt.getKeyChar();
       String letra="" + car;
       letra = letra.toUpperCase();
       car = letra.charAt(0);
     int pos= palabra.indexOf(""+ car);
         
              
     if(pos>=0){ // exito
               
             
           StringBuilder word= new StringBuilder(txtPalabra.getText());
           //System.out.println(pos);
           word.replace(pos, pos+1, "" + car);
           txtPalabra.setText(word.toString());
           if (verificarGano()) {
                   JOptionPane.showMessageDialog(this, "GANASTE MEN :Y");
                   contador++;
                   reiniciar();
               }
        
      
          
       }else{ //  no exitoso
              
             lblImagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + imagenes[intentos])));
              lblNoIntentos.setText(intentos.toString());
               txtErradas.setText(txtErradas.getText()+ car);
                
               
               
               if ( intentos >= 6 ) {
                   JOptionPane.showMessageDialog(this, "Estas AHORCADO!!, la palabra es " + palabra);
                   reiniciar();
               }
                intentos++;
               }
        

        /*
        txtErradas.setText(txtErradas.getText()+ " " + car); // 
       if(car == KeyEvent.VK_BACKSPACE){
        txtErradas.setText(txtErradas.getText().substring(0, txtErradas.getText().length()-2));
     }*/
    }//GEN-LAST:event_txtAdivinarKeyTyped

    private void txtAdivinarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdivinarKeyReleased
        // TODO add your handling code here:
        txtAdivinar.setText("");
        
    }//GEN-LAST:event_txtAdivinarKeyReleased

    private void txtAdivinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdivinarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdivinarActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        
        reiniciar();
        
        
    }//GEN-LAST:event_btnResetActionPerformed

 
    
    /**
     * @param args the command line arguments
     */
    
    private void centrarForma(){
        
        //Dimension de la pantalla ANCHO Y ALTO
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension de la ventana
        Dimension ventana = this.getSize();
        //posicion del borde superior izquierdo de la pantalla
        double posX = (pantalla.getWidth() - ventana.getWidth())/2.0;
        double posY = (pantalla.getHeight() - ventana.getHeight())/2.0;
        
        //Establece la posicion
        this.setLocation((int)posX, (int)posY);
    }
    
    public boolean verificarGano(){
        String palabra2="";
        for(int i=0 ; i<palabra.length() ; i++){
            palabra2+= palabra.charAt(i);
            
        }
      return (txtPalabra.getText().equalsIgnoreCase(palabra2));
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdivinar;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblNoIntentos;
    private javax.swing.JLabel lblPalabra;
    private javax.swing.JTextField txtAdivinar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtErradas;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
