
package LenguajeCopias;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

import javaant.Javaant;
import LenguajeCopias.LexerCopias;
import java.util.LinkedList;
import models.Clase;
import models.ErrorLex;

public class CrearSintactico {

 
    public static void main(String[] args) throws IOException {
        generarSintactico("C:/Users/jorge/Documents/NetBeansProjects/javaant/src/LenguajeCopias");
        //verTokens();
    }
    
    public static void generarSintactico(String ruta) {
        try {
            String[] instrucciones = {"-destdir", ruta, "-parser", "CopiasParser", ruta+"/CopiasSintactico.cup"};
            java_cup.Main.main(instrucciones);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void verTokens() throws IOException {
        Reader lector = null;
        try {
            lector = new BufferedReader(new FileReader("C:/Users/jorge/Documents/USAC DOCUMENTS/Segundo Semestre 2021/compi/laboratorio/proyectos/proyecto1/src/scripts/main.js"));
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
            Logger.getLogger(Javaant.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lector != null) {
            LexerCopias lexer = new LexerCopias(lector);
            LinkedList<String> comentarios = lexer.comentarios;
            /*while(true){
                Symbol sim = lexer.next_token();
                if (sim.value == null){
                    break;
                }
            }*/
            CopiasParser parser = new CopiasParser(lexer);
            try {
                parser.parse();
                System.out.println("========Errores========");
                for (ErrorLex err : parser.errores) {
                    System.out.println(err.mensaje + ": "+ err.valor + " en linea: " + err.linea + " columna: " + err.columna);
                }
                System.out.println("========Comentarios========");
                for(int x = 0; x < comentarios.size(); x++) {
                    System.out.println("Comentario: "+comentarios.get(x));
                }
                LinkedList<Clase> clases = parser.clases;
                System.out.println("=========CLASES=========");
                for (int x = 0; x < clases.size(); x++) {
                    System.out.println("Nombre: "+clases.get(x).nombre+", Lineas: "+clases.get(x).lineas);
                    System.out.println("Metodos:");
                    for (int y = 0; y < clases.get(x).metodos.size(); y++) {
                        System.out.println("    Nombre: "+clases.get(x).metodos.get(y).nombre+", Params: "+clases.get(x).metodos.get(y).params.toString()+", Lineas: "+clases.get(x).metodos.get(y).lineas);
                    }
                }
                System.out.println("========Variables========");
                for (int y = 0; y < parser.variables.size(); y++) {
                    System.out.println("Nombre: "+parser.variables.get(y));
                }
            } catch (Exception ex) {
                Logger.getLogger(CrearSintactico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
