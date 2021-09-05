
package models;

import java.util.LinkedList;
import models.Clase;

public class Archivo {
    public LinkedList<Clase> clases = new LinkedList<Clase>();
    public LinkedList<String> comentarios = new LinkedList<String>();
    public LinkedList<String> variables = new LinkedList<String>();
    public String nombre = null;
}
