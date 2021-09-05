/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.LinkedList;
import models.Metodo;

/**
 *
 * @author jorge
 */
public class Clase {
    public String nombre = null;
    public int lineas = -1;
    public LinkedList<Metodo> metodos = new LinkedList<Metodo>();
}
