
package Reporteria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaant.Comparador;
import javaant.Javaant;
import javaant.LectorProyectos;
import javaant.Total;
import models.ErrorLex;
import models.Grafica;
import models.Puntaje;
import models.VariableReporteria;

public class AnalizarReporteria {
    String ruta = null;
    Reader lector = null;
    LexerReporteriaCup lexer = null;
    ReporteriaParser parser = null;
    
    
    
    public AnalizarReporteria(String ruta) {
        this.ruta = ruta;
    }
    
    public String analizarReporteria() throws IOException {
        String estado = "";
        try {
            this.lector = new BufferedReader(new FileReader(this.ruta));
            estado = "Archivo encontrado";
        } catch (FileNotFoundException ex) {
            estado = "No se encontro el archivo";
            Logger.getLogger(Javaant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
    
    public String iniciarLexerReporteria() {
        String estado = "";
        if (this.lector != null) {
            this.lexer = new LexerReporteriaCup(this.lector);
            LinkedList<ErrorLex> errores = this.lexer.errores;
            System.out.println("Errores size: "+errores.size());
            if (errores.size() > 0) {
                estado += "Errores Lexicos:\n";
                for (ErrorLex err : errores) {
                    estado += "Simbolo no reconocido: "+err.valor+" en la linea "+err.linea+" en la columna "+err.columna+".\n";
                }
            }else {
                estado += "No hay errores lexicos!";
            }
        }else {
            System.out.println("No se puede iniciar el lexer");
            estado = "No se puede iniciar el lexer";
        }
        return estado;
    }
    
    public void analiadorSintactico(){
        if (this.lexer != null) {
            this.parser = new ReporteriaParser(this.lexer);
            try {
                this.parser.parse();
                System.out.println("Ya hizo el parse");
            } catch (Exception ex) {
                Logger.getLogger(AnalizarReporteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            System.out.println("No hay lexer");
        }
    }
    
    public void analizarCopias() throws IOException {
        String estados = "";
        this.parser = new ReporteriaParser(lexer);
            try {
                this.parser.parse();
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
                if (parser.rutas[0] != null && parser.rutas[1] != null) {
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
