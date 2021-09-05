/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author jorge
 */
public class ErrorLex {
    public String mensaje, valor = null;
    public int linea, columna = 0;
    public ErrorLex(String mensaje, String valor, int linea, int columna) {
        this.mensaje = mensaje;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }
}
