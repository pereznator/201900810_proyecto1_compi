
package javaant;

import LenguajeCopias.CopiasParser;
import LenguajeCopias.CrearSintactico;
import LenguajeCopias.LexerCopias;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Archivo;
import models.Clase;
import models.Metodo;
import models.Puntaje;

public class Comparador {
    
    String ruta1;
    String ruta2;
    
    public Archivo archivo1 = new Archivo();
    public Archivo archivo2 = new Archivo();
    
    public Puntaje puntaje = new Puntaje();
    
    Map<String, Integer> contClases = new HashMap<String, Integer>();
    
    int comentariosRepetidos = 0;
    int variablesRepetidas = 0;
    int metodosRepetidos = 0;
    int clasesRepetidas = 0;
    
    public Comparador(String ruta1, String ruta2) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
        
        abrirArchivos();
    }
    
    public void abrirArchivos() {
        Optional<String> extension = Optional.ofNullable(this.ruta1).filter(f -> f.contains(".")).map(f -> f.substring(this.ruta1.lastIndexOf(".") + 1));
        if (extension.get().equals("js")) {
            System.out.println("=======Arvhivo 1==========" + this.ruta1);
            CopiasParser parser1 = analizador(this.ruta1, true);
            if (parser1 != null) {
                this.archivo1.nombre = new File(this.ruta1).getName();
                this.archivo1.clases = parser1.clases;
                this.archivo1.variables = parser1.variables;
                
                for (Clase clase : this.archivo1.clases) {
                    this.contClases.put(clase.nombre, 0);
                }
            }
            System.out.println("=======Arvhivo 2==========" + this.ruta2);
            CopiasParser parser2 = analizador(this.ruta2, false);
            if (parser2 != null) {
                this.archivo2.nombre = new File(this.ruta2).getName();
                this.archivo2.clases = parser2.clases;
                this.archivo2.variables = parser2.variables;
                
                for (Clase clase : this.archivo2.clases) {
                    if (this.contClases.containsKey(clase.nombre)){
                        this.puntaje.repitenciaIdentificadorClase += 0.2;
                        this.clasesRepetidas += 1;
                        this.contClases.put(clase.nombre, 1);
                    }
                }
                
                compararClases();
                compararMetodos();
                compararVariables();
                compararComentarios();
                imprimirPuntaje();
            }
            System.out.println("===========FIN===========");
        } else {
            return;
        }
    }
    
    public CopiasParser analizador(String ruta, boolean primero) {
        Reader lector = null;
            try {
                lector = new BufferedReader(new FileReader(ruta));
            } catch (FileNotFoundException ex) {
                System.out.println("No se encontro el archivo "+this.ruta1);
                Logger.getLogger(Javaant.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (lector != null)  {
                LexerCopias lexer = new LexerCopias(lector);
                //LinkedList<String> comentarios = lexer.comentarios;
                if (primero == true) {
                    this.archivo1.comentarios = lexer.comentarios;
                }else {
                    this.archivo2.comentarios = lexer.comentarios;
                }
                
                CopiasParser parser = new CopiasParser(lexer);
                try{
                    parser.parse();
                    /*System.out.println("========Comentarios========");
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
                    }*/
                    return parser;
                } catch (Exception ex) {
                    Logger.getLogger(CrearSintactico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return null;
    }
    
    public void compararClases() {
        LinkedList<String> clasesRepetidas = new LinkedList<String>();
        for(Map.Entry<String, Integer> clase : this.contClases.entrySet()) {
            if (clase.getValue() == 1) {
                clasesRepetidas.add(clase.getKey());
            }
        }
        LinkedList<Clase> clases1 = new LinkedList<Clase>();
        LinkedList<Clase> clases2 = new LinkedList<Clase>();
 
        for (String nombre : clasesRepetidas) {
            for (Clase clase : this.archivo1.clases) {
                if (clase.nombre.equals(nombre)) {
                    clases1.add(clase);
                }
            }
            for (Clase clase : this.archivo2.clases) {
                if (clase.nombre.equals(nombre)) {
                    clases2.add(clase);
                }
            }
        }
        
        for (int x = 0; x < clases1.size(); x++) {
            if (clases1.get(x).lineas == clases2.get(x).lineas) {
                this.puntaje.repitenciaLineasClase += 0.4;
            }
            Map<String, Integer> contMetodos = new HashMap<String, Integer>();
            for (Metodo met : clases1.get(x).metodos) {
                contMetodos.put(met.nombre, 0);
            }
            for (Metodo met : clases2.get(x).metodos) {
                if (contMetodos.containsKey(met.nombre)) {                   
                    contMetodos.put(met.nombre, 1);
                    this.puntaje.repitenciaMetodosClase += 0.4;
                }
            }
        }
    }
    
    public void compararMetodos() {
        LinkedList<Metodo> metodos1 = new LinkedList<Metodo>();
        for (Clase clase : this.archivo1.clases) {
            for (Metodo metodo : clase.metodos) {
                metodos1.add(metodo);
            }
        }
        for (Clase clase : this.archivo2.clases) {
            for (Metodo metodo : clase.metodos) {
                for (Metodo met1 : metodos1) {
                    if (metodo.nombre.equals(met1.nombre)) {
                        this.metodosRepetidos += 1;
                        this.puntaje.repitenciaIdentificadorMetodo += 0.4;
                        if (metodo.params.size() == met1.params.size()) {
                            this.puntaje.repitenciaParamsMetodo += 0.3;
                        }
                        if (metodo.lineas == met1.lineas) {
                            this.puntaje.repitenciaLineasMetodo += 0.3;
                        }
                    }
                }
            }
        }
    }
    
    private void compararVariables() {
        LinkedList<String> variables = new LinkedList<String>();
        for (String variable : this.archivo1.variables) {
            variables.add(variable);
        }
        for (String variable : this.archivo2.variables) {
            if (variables.contains(variable)) {
                this.variablesRepetidas += 1;
                this.puntaje.repitenciaVariables += 1;
            }
        }
    }
    
    private void compararComentarios() {
        Map<String, Integer> comentarios = new HashMap<String, Integer>();
        for (String comentario : this.archivo1.comentarios) {
            comentarios.put(comentario, 0);
        }
        for (String comentario : this.archivo2.comentarios) {
            if (comentarios.containsKey(comentario)) {
                comentarios.put(comentario, 1);
                this.puntaje.repitenciaComentarios += 1;
                this.comentariosRepetidos += 1;
            }
        }
    }
    
    private void imprimirPuntaje() {
        System.out.println("================PUNTAJE================");
        System.out.println("Identificador Clase Repetido: "+this.puntaje.repitenciaIdentificadorClase);
        System.out.println("Lineas Clase Repetidas: "+this.puntaje.repitenciaLineasClase);
        System.out.println("Metodos Clase Repetidos: "+this.puntaje.repitenciaMetodosClase);
        System.out.println("Identificador Metodo Repetido: "+this.puntaje.repitenciaIdentificadorMetodo);
        System.out.println("Lineas Metodos Repetido: "+this.puntaje.repitenciaLineasMetodo);
        System.out.println("Parametros Metodos Repetidos: "+this.puntaje.repitenciaParamsMetodo);
        System.out.println("Variables Repetidas: "+this.puntaje.repitenciaVariables);
        System.out.println("Comentarios Repetidos: "+this.puntaje.repitenciaComentarios);
    }
}
