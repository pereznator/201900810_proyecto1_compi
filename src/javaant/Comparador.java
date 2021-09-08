
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
import models.ErrorLex;
import models.Metodo;
import models.Puntaje;
import models.PuntajeEspecifico;
import models.Token;

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
    
    public LinkedList<PuntajeEspecifico> puntajes = new LinkedList<PuntajeEspecifico>();
    
    public LinkedList<ErrorLex> erroresLex = new LinkedList<ErrorLex>();
    public LinkedList<ErrorLex> erroresSin = new LinkedList<ErrorLex>();
    public LinkedList<Token> tkns = new LinkedList<Token>();
    
    public Comparador(String ruta1, String ruta2) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
        
        abrirArchivos();
    }
    
    public void abrirArchivos() {
        Optional<String> extension = Optional.ofNullable(this.ruta1).filter(f -> f.contains(".")).map(f -> f.substring(this.ruta1.lastIndexOf(".") + 1));
        if (extension.get().equals("js")) {
            System.out.println("=======Arvhivo 1==========" + this.ruta1);
            this.archivo1.nombre = new File(this.ruta1).getName();
            CopiasParser parser1 = analizador(this.ruta1, true);
            if (parser1 != null) {
                this.archivo1.clases = parser1.clases;
                this.archivo1.variables = parser1.variables;
                
                for (Clase clase : this.archivo1.clases) {
                    this.contClases.put(clase.nombre, 0);
                    PuntajeEspecifico puntaje = new PuntajeEspecifico(this.archivo1.nombre, "clase", clase.nombre);
                    this.puntajes.add(puntaje);
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
                        for (PuntajeEspecifico p : this.puntajes) {
                            if (p.archivo.equals(p.archivo)) {
                                p.valor += 0.2;
                            }
                        }
                    }else {
                        PuntajeEspecifico puntaje = new PuntajeEspecifico(this.archivo2.nombre, "clase", clase.nombre);
                        this.puntajes.add(puntaje);
                    }
                }
                
                compararClases();
                compararMetodos();
                compararVariables();
                compararComentarios();
                imprimirPuntaje();
            }
            System.out.println("===========FIN===========");
        }
    }
    
    public CopiasParser analizador(String ruta, boolean primero) {
        CopiasParser parser = null;
        Reader lector = null;
            try {
                lector = new BufferedReader(new FileReader(ruta));
            } catch (FileNotFoundException ex) {
                System.out.println("No se encontro el archivo "+this.ruta1);
                Logger.getLogger(Javaant.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (lector != null)  {
                LexerCopias lexer = new LexerCopias(lector);
                if (primero == true) {
                    this.archivo1.comentarios = lexer.comentarios;
                }else {
                    this.archivo2.comentarios = lexer.comentarios;
                }
                
                parser = new CopiasParser(lexer);
                try{
                    parser.parse();
                    for (ErrorLex err : lexer.errores) {
                        err.archivo = this.archivo1.nombre;
                    }
                    for (Token tkn : lexer.tkns) {
                        if (primero == true) {
                            tkn.archivo = "proyecto1/"+this.archivo1.nombre;
                        }else {
                            tkn.archivo = "proyecto2/"+this.archivo1.nombre;
                        }
                    }
                    this.tkns.addAll(lexer.tkns);
                    for (ErrorLex err : parser.errores) {
                        err.archivo = this.archivo1.nombre;
                    }
                    this.erroresLex.addAll(lexer.errores);
                    this.erroresSin.addAll(parser.errores);
                } catch (Exception ex) {
                    Logger.getLogger(CrearSintactico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
            }
        return parser;
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
            double puntaje = 0;
            if (clases1.get(x).lineas == clases2.get(x).lineas) {
                this.puntaje.repitenciaLineasClase += 0.4;
                puntaje += 0.4;
            }
            Map<String, Integer> contMetodos = new HashMap<String, Integer>();
            for (Metodo met : clases1.get(x).metodos) {
                contMetodos.put(met.nombre, 0);
            }
            for (Metodo met : clases2.get(x).metodos) {
                if (contMetodos.containsKey(met.nombre)) {                   
                    contMetodos.put(met.nombre, 1);
                    this.puntaje.repitenciaMetodosClase += 0.4;
                    puntaje += 0.4;
                }
            }
            
            for (PuntajeEspecifico p : this.puntajes) {
                if (p.archivo.equals(clases1.get(x).nombre)) {
                    p.valor += puntaje;
                }
            }
        }
    }
    
    public void compararMetodos() {
        LinkedList<Metodo> metodos1 = new LinkedList<Metodo>();
        for (Clase clase : this.archivo1.clases) {
            for (Metodo metodo : clase.metodos) {
                metodos1.add(metodo);
                puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "metodo", metodo.nombre));
            }
        }
        for (Clase clase : this.archivo2.clases) {
            System.out.println("[METODOS EN LA CLASE: "+clase.nombre+"]");
            for (Metodo metodo : clase.metodos) {
                boolean repetido = false;
                System.out.println("- "+metodo.nombre);
                for (Metodo met1 : metodos1) {
                    if (metodo.nombre.equals(met1.nombre)) {
                        repetido = true;
                        double puntajeMetodo = 0.4;
                        
                        this.metodosRepetidos += 1;
                        this.puntaje.repitenciaIdentificadorMetodo += 0.4;
                        if (metodo.params.size() == met1.params.size()) {
                            this.puntaje.repitenciaParamsMetodo += 0.3;
                            puntajeMetodo += 0.3;
                        }
                        if (metodo.lineas == met1.lineas) {
                            this.puntaje.repitenciaLineasMetodo += 0.3;
                            puntajeMetodo += 0.3;
                        }
                        
                        for (PuntajeEspecifico p : this.puntajes) {
                            if (p.campo1.equals("metodo") && p.campo2.equals(metodo.nombre)) {
                                p.valor += puntajeMetodo;
                            }
                        }
                    }
                }
                if (!repetido) {
                    this.puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "metodo", metodo.nombre));
                }
            }
        }
    }
    
    private void compararVariables() {
        LinkedList<String> variables = new LinkedList<String>();
        for (String variable : this.archivo1.variables) {
            variables.add(variable);
            this.puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "variable", variable));
        }
        for (String variable : this.archivo2.variables) {
            if (variables.contains(variable)) {
                this.variablesRepetidas += 1;
                this.puntaje.repitenciaVariables += 1;
                for (PuntajeEspecifico p : this.puntajes) {
                    if (p.campo1.equals("variable") && p.campo2.equals(variable)) {
                        p.valor += 1;
                    }
                }
            }else {
               this.puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "variable", variable)); 
            }
        }
    }
    
    private void compararComentarios() {
        Map<String, Integer> comentarios = new HashMap<String, Integer>();
        for (String comentario : this.archivo1.comentarios) {
            comentarios.put(comentario, 0);
            this.puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "comentario", comentario));
        }
        for (String comentario : this.archivo2.comentarios) {
            if (comentarios.containsKey(comentario)) {
                comentarios.put(comentario, 1);
                this.puntaje.repitenciaComentarios += 1;
                this.comentariosRepetidos += 1;
                for (PuntajeEspecifico p : this.puntajes) {
                    if (p.campo1.equals("comentario") && p.campo2.equals(comentario)) {
                        p.valor += 1;
                    }
                }
            }else {
                this.puntajes.add(new PuntajeEspecifico(this.archivo1.nombre, "comentario", comentario));
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
