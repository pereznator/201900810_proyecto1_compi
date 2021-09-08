
package vistas;

import Reporteria.AnalizarReporteria;
import Reporteria.LexerReporteriaCup;
import Reporteria.ReporteriaParser;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaant.Comparador;
import javaant.LectorProyectos;
import javaant.Total;
import javaant.VerGraficas;
import javaant.VerVariables;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.ErrorLex;
import models.Puntaje;
import models.PuntajeEspecifico;
import models.SetArchivo;
import models.Token;

public class Menu extends javax.swing.JFrame {

    Map<Integer, JButton> botones = new HashMap<Integer, JButton>();
    Map<Integer, JPanel> paneles = new HashMap<Integer, JPanel>();
    Map<Integer, JTextArea> textos = new HashMap<Integer, JTextArea>();
    Map<Integer, String> guardarRutas = new HashMap<Integer, String>();
    Map<Integer, LinkedList<ErrorLex>> panelErroes = new HashMap<Integer, LinkedList<ErrorLex>>();
    Map<Integer, LinkedList<Token>> panelTokens = new HashMap<Integer, LinkedList<Token>>();
    Map<Integer, LinkedList<SetArchivo>> panelArchivos = new HashMap<Integer, LinkedList<SetArchivo>>();
    Map<Integer, Map<String, String>> panelGraficas = new HashMap<Integer, Map<String, String>>();
    Map<Integer, LinkedList<PuntajeEspecifico>> panelPuntajesE = new HashMap<Integer, LinkedList<PuntajeEspecifico>>();
    Map<Integer, Double> panelPuntajeG = new HashMap<Integer, Double>();
    
    int panelActual = 1;
    int cantPestanas = 1;
    JPanel consola = null;
    JTextArea txtConsola = null;
    
    public Menu() {
        initComponents();
        iniciarPantalla();
        setTitle("COPY ANALYZER");
        this.setLocationRelativeTo(null);
        setResizable(false);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }
    
    private void iniciarPantalla() {
        JPanel primerPanel = new JPanel();
        primerPanel.setBackground(new java.awt.Color(255, 153, 153));
        this.getContentPane().add(primerPanel);
        primerPanel.setSize(750, 700);
        primerPanel.setLocation(20, 100);
        this.paneles.put(1, primerPanel);
        this.paneles.get(1).setVisible(true);
        
        JTextArea primerTexto = new JTextArea();
        primerTexto.setBackground(new java.awt.Color(255, 153, 153));
        primerTexto.setColumns(65);
        primerTexto.setRows(28);
        primerTexto.setFont(new Font("Consolas", Font.BOLD, 20));
        primerTexto.setLocation(0, 0);
        JScrollPane scroll = new JScrollPane (primerTexto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        primerPanel.add(scroll);
        
        this.textos.put(1, primerTexto);
        
        JButton btnPrimer = new JButton();
        btnPrimer.setText("Pestana 1");
        btnPrimer.setLocation(5, 5);
        btnPrimer.setSize(100, 30);
        btnPrimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPestana(evt, 1);
            }
        });
        
        pestanas.add(btnPrimer);
        this.botones.put(1, btnPrimer);
        
        this.consola = new JPanel();
        this.consola.setBackground(new java.awt.Color(51, 51, 51));
        this.getContentPane().add(this.consola);
        this.consola.setSize(520, 700);
        this.consola.setLocation(800, 100);
        this.consola.setVisible(true);
        
        this.txtConsola = new JTextArea();
        this.txtConsola.setBackground(new java.awt.Color(51, 51, 51));
        this.txtConsola.setColumns(45);
        this.txtConsola.setRows(28);
        this.txtConsola.setLocation(0, 0);
        this.txtConsola.setFont(new Font("Consolas", Font.BOLD, 20));
        this.txtConsola.setForeground(Color.WHITE);
        JScrollPane scroll1 = new JScrollPane (this.txtConsola, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.txtConsola.setEditable(false);
        this.consola.add(scroll1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArchivo = new javax.swing.JButton();
        btnReporteTokens = new javax.swing.JButton();
        btnReportJson = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnCrearPes = new javax.swing.JButton();
        btnCerrarPes = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnReporteErrores = new javax.swing.JButton();
        btnReporteEstadistico = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pestanas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArchivo.setText("Abrir");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnReporteTokens.setText("Reporte de Tokens");
        btnReporteTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTokensActionPerformed(evt);
            }
        });

        btnReportJson.setText("Reporte JSON");
        btnReportJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportJsonActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarComo.setText("Guardar Como");
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });

        btnCrearPes.setText("Crear Pestaña");
        btnCrearPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPesActionPerformed(evt);
            }
        });

        btnCerrarPes.setText("Cerrar Pestaña");
        btnCerrarPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarPesActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnReporteErrores.setText("Reporte de Errores");
        btnReporteErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteErroresActionPerformed(evt);
            }
        });

        btnReporteEstadistico.setText("Reporte Estadístico");
        btnReporteEstadistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteEstadisticoActionPerformed(evt);
            }
        });

        pestanas.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout pestanasLayout = new javax.swing.GroupLayout(pestanas);
        pestanas.setLayout(pestanasLayout);
        pestanasLayout.setHorizontalGroup(
            pestanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pestanasLayout.setVerticalGroup(
            pestanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarComo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearPes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrarPes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEjecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporteErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporteEstadistico, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporteTokens, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReportJson, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pestanas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarComo)
                    .addComponent(btnCrearPes)
                    .addComponent(btnCerrarPes)
                    .addComponent(btnEjecutar)
                    .addComponent(btnReporteErrores)
                    .addComponent(btnReporteEstadistico)
                    .addComponent(btnReporteTokens)
                    .addComponent(btnReportJson))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(705, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarPestana(java.awt.event.ActionEvent evt, int num) {
        System.out.println("Cambiando a pestana: "+num);
        if (this.panelActual == num) {
            return;
        }
        this.paneles.get(this.panelActual).setVisible(false);
        this.paneles.get(num).setVisible(true);
        this.panelActual = num;
        
    }
    
    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser buscador = new JFileChooser("C:\\Users\\jorge\\Documents\\USAC DOCUMENTS\\Segundo Semestre 2021\\compi\\laboratorio\\proyectos");
        //buscador.setCurrentDirectory(new File(System.getProperty("user.home")));
        buscador.setFileFilter(new FileNameExtensionFilter("fca files (*.fca)", "fca"));
        int resultado = buscador.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File doc = buscador.getSelectedFile();
            String contenido = "";
            try {
                Scanner scan = new Scanner(doc);
                while (scan.hasNextLine()) {
                    contenido = contenido + scan.nextLine() + "\n";
                }
                scan.close();
            } catch(Exception e) {
                System.out.println(e);
            }
            
            if (textos.get(panelActual).getText().length() == 0) {
                textos.get(panelActual).setText(contenido);
            }else {
                btnCrearPesActionPerformed(evt);
                textos.get(panelActual).setText(contenido);
            }
            guardarRutas.put(panelActual, doc.getAbsolutePath());
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnCrearPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPesActionPerformed
        this.paneles.get(this.panelActual).setVisible(false);
        
        JPanel nuevoPanel = new JPanel();
        nuevoPanel.setBackground(new java.awt.Color(255, 153, 153));
        this.getContentPane().add(nuevoPanel);
        nuevoPanel.setSize(750, 700);
        nuevoPanel.setLocation(20, 100);
        
        JTextArea newText = new JTextArea();
        newText.setBackground(new java.awt.Color(255, 153, 153));
        newText.setColumns(65);
        newText.setRows(28);
        newText.setFont(new Font("Consolas", Font.BOLD, 20));
        newText.setLocation(0, 0);
        
        JScrollPane scroll = new JScrollPane (newText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        nuevoPanel.add(scroll);
        
        this.paneles.put(this.cantPestanas+1, nuevoPanel);
        this.textos.put(this.cantPestanas+1, newText);

        this.panelActual = this.paneles.size();
        this.paneles.get(this.panelActual).setVisible(true);
        this.cantPestanas++;
        int aux = cantPestanas;
        JButton btnNuevo = new JButton("Pestaña "+(this.panelActual));
        btnNuevo.setLocation((this.cantPestanas-1)*110, 5);
        btnNuevo.setSize(100, 30);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPestana(evt, aux);
            }
        });
        this.pestanas.add(btnNuevo);
        this.botones.put(this.cantPestanas, btnNuevo);
    }//GEN-LAST:event_btnCrearPesActionPerformed

    private void btnCerrarPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarPesActionPerformed
        this.paneles.get(this.panelActual).setVisible(false);
        this.paneles.get(1).setVisible(true);
        this.panelActual = 1;
    }//GEN-LAST:event_btnCerrarPesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (guardarRutas.containsKey(panelActual)) {
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(guardarRutas.get(panelActual)));
                escritor.write(textos.get(panelActual).getText());
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            btnGuardarComoActionPerformed(evt);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        String contenido = textos.get(panelActual).getText();
        JFileChooser fc = new JFileChooser("C:\\Users\\jorge\\Documents\\USAC DOCUMENTS\\Segundo Semestre 2021\\compi\\laboratorio\\proyectos");
        fc.setFileFilter(new FileNameExtensionFilter("fca files (*.fca)", "fca"));
        fc.setDialogTitle("Guardar como");
        int opcion = fc.showSaveDialog(this.getContentPane());
 
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File docGuardado = fc.getSelectedFile();
            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(docGuardado));
                escritor.write(contenido);
                escritor.close();
                guardarRutas.put(panelActual, docGuardado.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        if (guardarRutas.get(panelActual) == null) {
            System.out.println("No hay ruta!");
            return;
        }
        try {
            String acciones = "Iniciando analizador lexico \n";
            
            Reader lector = new BufferedReader(new FileReader(guardarRutas.get(panelActual)));
            LexerReporteriaCup lexer = new LexerReporteriaCup(lector);
            ReporteriaParser parser = new ReporteriaParser(lexer);
            
            try {
                parser.parse();
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            for (ErrorLex err : lexer.errores) {
                err.archivo = new File(guardarRutas.get(panelActual)).getName();
            }
            LinkedList<ErrorLex> errores = lexer.errores;
            LinkedList<Token> tokens = lexer.tkns;
            for (Token tk : tokens) {
                tk.archivo = new File(guardarRutas.get(panelActual)).getName();
            }
            if (errores.size() > 0) {
                acciones += "Errores Lexicos:\n";
                for (ErrorLex err : errores) {
                    acciones += "Simbolo no reconocido: "+err.valor+" en la linea "+err.linea+" en la columna "+err.columna+".\n";
                }
                acciones += "Fin analizador lexico";
            }else {
                acciones += "No hay errores lexicos! \n";
            }
            acciones += "Fin Analisis Lexico \n";
            acciones += "Inicio Analizador Sintactico \n";
            if (parser.errores.size() > 0) {
                acciones += "Errores Sintacticos \n";
                for (ErrorLex error : parser.errores) {
                    error.archivo = new File(guardarRutas.get(panelActual)).getName();
                    errores.add(error);
                    acciones += error.mensaje +": " + error.valor + " en linea: " + error.linea + " columna: " + error.columna + "\n";
                }
            }
            acciones += "Fin Analizador Sintactico\n";
            if (parser.rutas[0] != null && parser.rutas[1] != null) {
                String ruta1 = parser.rutas[0].replace("\"", "");
                String ruta2 = parser.rutas[1].replace("\"", "");
                
                acciones += "Analizando las rutas para comparar \n";
                
                LectorProyectos proyectos = new LectorProyectos(ruta1, ruta2);
                
                if (proyectos.error == false) {
                    if (proyectos.rutas1.size() > 0 && proyectos.rutas2.size() > 0) {
                        LinkedList<Puntaje> puntajes = new LinkedList<Puntaje>();
                        LinkedList<Comparador> comparadores = new LinkedList<Comparador>();
                        LinkedList<PuntajeEspecifico> pes = new LinkedList<PuntajeEspecifico>();
                        LinkedList<SetArchivo> archvs = new LinkedList<SetArchivo>();
                        for (int x = 0; x < proyectos.rutas1.size(); x++) {
                            Comparador comp = new Comparador(proyectos.rutas1.get(x), proyectos.rutas2.get(x));
                            puntajes.add(comp.puntaje);
                            comparadores.add(comp);
                            for (PuntajeEspecifico pe: comp.puntajes) {
                                pes.add(pe);
                            }
                            errores.addAll(comp.erroresLex);
                            errores.addAll(comp.erroresSin);
                            tokens.addAll(comp.tkns);
                            
                            archvs.add(new SetArchivo(comp.archivo1, comp.archivo2));
                        }
                        panelErroes.put(this.panelActual, errores);
                        panelTokens.put(this.panelActual, tokens);
                        panelArchivos.put(this.panelActual, archvs);
                        panelPuntajesE.put(this.panelActual, pes);
                        
                        Total total = new Total(comparadores);
                        panelPuntajeG.put(this.panelActual, total.total);
                        VerVariables vars = new VerVariables(parser.variables, total.total);
                        VerGraficas grafs = new VerGraficas(parser.graficas, vars, pes, comparadores);
                        panelGraficas.put(this.panelActual, grafs.rutas);
                        acciones += grafs.acciones;
                    }
                }else {
                    acciones += "Las rutas para comparar no existen \n";
                }
            }else {
                acciones += "No se han encontrado rutas para analizar. \n";
            }
            
            this.txtConsola.setText(acciones);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnReporteErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteErroresActionPerformed
        if (panelErroes.containsKey(this.panelActual)) {
            ReporteErrores reporte = new ReporteErrores(panelErroes.get(this.panelActual));
            reporte.generarReporte();
            String consol = txtConsola.getText() + reporte.estado;
            txtConsola.setText(consol);
        }else {
            System.out.println("Aun no hay erroes!!");
        }
    }//GEN-LAST:event_btnReporteErroresActionPerformed

    private void btnReporteTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTokensActionPerformed
        if (panelTokens.containsKey(this.panelActual)) {
            ReporteTokens reporte = new ReporteTokens(panelTokens.get(this.panelActual));
            reporte.generarReporte();
            String consol = txtConsola.getText() + reporte.estado;
            txtConsola.setText(consol);
        }else {
            System.out.println("Aun no hay tokens!");
        }
    }//GEN-LAST:event_btnReporteTokensActionPerformed

    private void btnReporteEstadisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteEstadisticoActionPerformed
        if (panelArchivos.containsKey(this.panelActual) && panelGraficas.containsKey(this.panelActual)) {
            ReporteEstadistico reporte = new ReporteEstadistico(panelArchivos.get(this.panelActual), panelGraficas.get(this.panelActual));
            reporte.generarReporte();
            String consol = txtConsola.getText() + reporte.estado;
            txtConsola.setText(consol);
        }else {
            System.out.println("Aun no hay archivos y graficas!");
        }
    }//GEN-LAST:event_btnReporteEstadisticoActionPerformed

    private void btnReportJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportJsonActionPerformed
        if (panelPuntajesE.containsKey(this.panelActual) && panelPuntajeG.containsKey(this.panelActual)) {
            ReporteJson reporte = new ReporteJson(panelPuntajesE.get(this.panelActual), panelPuntajeG.get(this.panelActual));
            reporte.generarReporte();
            String consol = txtConsola.getText() + reporte.estado;
            txtConsola.setText(consol);
        }else {
            System.out.println("Aun no hay archivos y graficas!");
        }
    }//GEN-LAST:event_btnReportJsonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnCerrarPes;
    private javax.swing.JButton btnCrearPes;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnReportJson;
    private javax.swing.JButton btnReporteErrores;
    private javax.swing.JButton btnReporteEstadistico;
    private javax.swing.JButton btnReporteTokens;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pestanas;
    // End of variables declaration//GEN-END:variables
}
