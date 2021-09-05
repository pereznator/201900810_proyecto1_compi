
package javaant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import Reporteria.LexerReporteria;
import Reporteria.LexerReporteriaCup;
import Reporteria.ReporteriaParser;
import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.Grafica;
import models.TokenReporteria;
import models.VariableReporteria;
import models.PuntajeGeneral;
import models.PuntajeEspecifico;
import sun.misc.IOUtils;
import javaant.LectorProyectos;
import javaant.Comparador;
import models.Puntaje;

import vistas.Menu;

public class Javaant {
    public static void main(String[] args) throws IOException {
        //generarSintactico("C:/Users/jorge/Documents/NetBeansProjects/javaant/src/Reporteria");
        //generarLexerCup();
        Menu menu = new Menu();
        menu.setVisible(true);
    }
    
    public static void generarSintactico(String ruta) {
        try {
            String[] instrucciones = {"-destdir", ruta, "-parser", "ReporteriaParser", ruta+"/ReporteriaSintactico.cup"};
            java_cup.Main.main(instrucciones);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void generarLexerCup() throws IOException {
        Reader lector = null;
        try {
            lector = new BufferedReader(new FileReader("C:/Users/jorge/Documents/NetBeansProjects/javaant/src/javaant/test.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
            Logger.getLogger(Javaant.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lector != null) {
            LexerReporteriaCup lexer = new LexerReporteriaCup(lector);
            /*while(true){
                Symbol sim = lexer.next_token();
                if (sim.value == null){
                    break;
                }
                System.out.println(sim.value);
            }*/
            ReporteriaParser parser = new ReporteriaParser(lexer);
            try {
                parser.parse();
                LinkedList<VariableReporteria> vars = parser.variables;
                System.out.println("================================");
                for (int x = 0; x < vars.size(); x++) {
                    switch(vars.get(x).tipo) {
                        case "STRING":
                            System.out.println("Tipo: "+parser.variables.get(x).tipo+", Nombre: "+parser.variables.get(x).nombre+", Valor: "+parser.variables.get(x).valorStr);
                            break;
                        case "INT":
                            System.out.println("Tipo: "+parser.variables.get(x).tipo+", Nombre: "+parser.variables.get(x).nombre+", Valor: "+parser.variables.get(x).valorInt);
                            break;
                        case "DOUBLE":
                            System.out.println("Tipo: "+parser.variables.get(x).tipo+", Nombre: "+parser.variables.get(x).nombre+", Valor: "+parser.variables.get(x).valorDbl);
                            break;
                        case "PUNTAJE GENERAL":
                            System.out.println("Tipo: "+parser.variables.get(x).tipo+", Nombre: "+parser.variables.get(x).nombre+", Valor: "+parser.variables.get(x).pungen.tipo);
                            break;
                        case "PUNTAJE ESPECIFICO":
                            System.out.println("Tipo: "+parser.variables.get(x).tipo+", Nombre: "+parser.variables.get(x).nombre+", Archivo: "+parser.variables.get(x).punes.archivo+ ", Campo1: "+parser.variables.get(x).punes.campo1+", Campo2: "+parser.variables.get(x).punes.campo2);
                            break;
                    }
                }
                System.out.println("Ruta 1: "+parser.rutas[0]+", Ruta 2: "+parser.rutas[1]);
                LinkedList<Grafica> grfs = parser.graficas;
                for (int n = 0; n < grfs.size(); n++) {
                    System.out.println("============GRAFICA=============");
                    System.out.println("Tipo: "+grfs.get(n).tipo);
                    System.out.println("Titulo: "+grfs.get(n).titulo);
                    System.out.println("EjeX: "+grfs.get(n).ejex.toString());
                    System.out.println("Valores: "+grfs.get(n).valores.toString());
                    System.out.println("TituloX: "+grfs.get(n).titulox);
                    System.out.println("TituloY: "+grfs.get(n).tituloy);
                    System.out.println("Archivo: "+grfs.get(n).archivo);
                }
                if (parser.rutas.length == 2) {
                    String ruta1 = parser.rutas[0].replace("\"", "");
                    String ruta2 = parser.rutas[1].replace("\"", "");
                    
                    LectorProyectos proyectos = new LectorProyectos(ruta1, ruta2);
                    
                    LinkedList<Puntaje> puntajes = new LinkedList<Puntaje>();
                    LinkedList<Comparador> comparadores = new LinkedList<Comparador>();
                    
                    for (int x = 0; x < proyectos.rutas1.size(); x++) {
                        System.out.println(proyectos.rutas1.get(x));
                        Comparador comp = new Comparador(proyectos.rutas1.get(x), proyectos.rutas2.get(x));
                        puntajes.add(comp.puntaje);
                        comparadores.add(comp);
                    }
                    
                    Total total = new Total(comparadores);
                }
                
            } catch (Exception e) {
                System.out.println("algo salio mal en el parser!");
                System.out.println(e);
            }
        }
    }

 
    
}
