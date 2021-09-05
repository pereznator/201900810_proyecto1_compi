/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import utils.TknsReporteria;

/**
 *
 * @author jorge
 */
public class TokenReporteria {
    public TknsReporteria token;
    public String lexema;
    public int columna, linea;
    public TokenReporteria(TknsReporteria token, int columna, int linea, String lexema) {
        this.token = token;
        this.columna = columna;
        this.linea = linea;
        this.lexema = lexema;
    }
    
    
}
