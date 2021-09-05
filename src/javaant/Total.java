
package javaant;

import java.util.LinkedList;
import models.Puntaje;
import javaant.Comparador;
import models.Clase;

public class Total {
    
    LinkedList<Comparador> comparadores = null;
    public double total = 0;
    
    public Total(LinkedList<Comparador> comparadores) {
        this.comparadores = comparadores;
        verPuntajes();
    }
    
    private void verPuntajes() {
        float puntajeComentarios = 0, puntajeVariables = 0, puntajeMetodos = 0, puntajeClases = 0;
        float comentariosTotales = 0, variablesTotales = 0, clasesTotales = 0, metodosTotales = 0;
        float comentariosRepetidos = 0, variablesRepetidas = 0, clasesRepetidas = 0, metodosRepetidos = 0;
        
        for (Comparador compa : this.comparadores) {
            comentariosTotales += compa.archivo1.comentarios.size() + compa.archivo2.comentarios.size();
            
            variablesTotales += compa.archivo1.variables.size() + compa.archivo2.variables.size();
            
            clasesTotales += compa.archivo1.clases.size() + compa.archivo2.clases.size();
            
            for (Clase clase : compa.archivo1.clases) {
                metodosTotales += clase.metodos.size();
            }
            
            for (Clase clase : compa.archivo2.clases) {
                metodosTotales += clase.metodos.size();
            }
            comentariosRepetidos += compa.comentariosRepetidos;
            variablesRepetidas += compa.variablesRepetidas;
            clasesRepetidas += compa.clasesRepetidas;
            metodosRepetidos += compa.metodosRepetidos;
            System.out.println("No. clases repetidas de "+compa.archivo1.nombre+": "+compa.clasesRepetidas);
            System.out.println("No. metodos repetidos de "+compa.archivo1.nombre+": "+compa.metodosRepetidos);
            System.out.println("No. variables repetidos de "+compa.archivo1.nombre+": "+compa.variablesRepetidas);
            System.out.println("No. comentarios repetidos de "+compa.archivo1.nombre+": "+compa.comentariosRepetidos);
            System.out.println("================================");
        }
        
        System.out.println("Clases totales: "+clasesTotales);
        System.out.println("Metodos totales: "+metodosTotales);
        System.out.println("Variables totales: "+variablesTotales);
        System.out.println("Comentarios totales: "+comentariosTotales);
        
        puntajeComentarios = (comentariosRepetidos / comentariosTotales) * (float)0.2;
        puntajeVariables = variablesRepetidas / variablesTotales * (float)0.2;
        puntajeClases = clasesRepetidas / clasesTotales * (float)0.3;
        puntajeMetodos = metodosRepetidos / metodosTotales * (float)0.3;
        
        System.out.println("PuntajeClaes: "+puntajeClases);
        System.out.println("PuntajeMetodos: "+puntajeMetodos);
        System.out.println("PuntajeVariables: "+puntajeVariables);
        System.out.println("PuntajeComentarios: "+puntajeComentarios);
        
        this.total = puntajeComentarios + puntajeVariables + puntajeClases + puntajeMetodos;
        System.out.println("TOTAL: "+total);

    }
    
}
