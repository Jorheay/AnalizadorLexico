/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author jorhe
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSumatoria = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtOriginal = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSelec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSelec.setText("Seleccionar Archivo y Analizar\n");
        btnSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtSumatoria.setColumns(20);
        txtSumatoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSumatoria.setRows(5);
        jScrollPane2.setViewportView(txtSumatoria);

        txtOriginal.setColumns(20);
        txtOriginal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtOriginal.setRows(5);
        jScrollPane3.setViewportView(txtOriginal);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Texto Original:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Analisis:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Contador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelec)
                .addGap(237, 237, 237))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnSelec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        txtOriginal.setText(null);
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while (linea != null) {
                txtOriginal.append(linea + "\n");
                linea = leer.readLine();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int reservada = 0, id = 0, ent = 0, palabra = 0, coma = 0, punycom = 0, suma = 0, resta = 0;
        int asignacion = 0, paraper = 0, parcier = 0, error = 0;
        String sumatoria = "";
        
        try {
            Reader lector = new BufferedReader(new FileReader(archivo));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN DE ANALISIS";
                    txtResultado.setText(resultado);
                    sumatoria += "El Total de ID es: " + id + "\n";
                    sumatoria += "El Total de Enteros es: " + ent + "\n";
                    sumatoria += "El Total de Reservadas es: " + reservada + "\n";
                    sumatoria += "El Total de Palabras es: " + palabra + "\n";
                    sumatoria += "El Total de Punto y Coma es: " + punycom + "\n";
                    sumatoria += "El Total de Suma es: " + suma + "\n";
                    sumatoria += "El Total de Resta es: " + resta + "\n";
                    sumatoria += "El Total de Asignacion es: " + asignacion + "\n";
                    sumatoria += "El Total de Paraper es: " + paraper + "\n";
                    sumatoria += "El Total de Parcier es: " + parcier + "\n";
                    sumatoria += "El Total de Comas es: " + coma + "\n";
                    sumatoria += "El Total de Errores es: " + error + "\n";
                    txtSumatoria.setText(sumatoria);
                    return;
                }
                switch (tokens) {
                    case Error:
                        resultado += "Error Lexico\n";
                        error += 1;
                        break;
                    case Id:
                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
                        id += 1;
                        break;
                    case Entero:
                        resultado += lexer.lexeme + ": Es un " + tokens + "\n";
                        ent += 1;
                        break;
                    case Reservada:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        reservada += 1;
                        break;
                    case Palabra:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        palabra += 1;
                        break;
                    case PuntoYComa:
                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
                        punycom += 1;
                        break;
                    case Suma:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        suma += 1;
                        break;
                    case Resta:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        resta += 1;
                        break;
                    case Asignacion:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        asignacion += 1;
                        break;
                    case Paraper:
                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
                        paraper += 1;
                        break;
                    case Parcier:
                        resultado += lexer.lexeme + " : Es un " + tokens + "\n";
                        parcier += 1;
                        break;
                    case Coma:
                        resultado += lexer.lexeme + " : Es una " + tokens + "\n";
                        coma += 1;
                        break;
                    default:
                        resultado += "Token: " + tokens + "\n";
                        break;
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtOriginal;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextArea txtSumatoria;
    // End of variables declaration//GEN-END:variables
}
