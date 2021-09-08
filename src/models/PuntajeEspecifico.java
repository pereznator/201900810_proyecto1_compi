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
public class PuntajeEspecifico {
    public String tipo = "ESPECIFICO";
    public String  archivo, campo1, campo2 = null;
    public double valor = 0;
    public PuntajeEspecifico(String archivo, String campo1, String campo2) {
        this.archivo = archivo;
        this.campo1 = campo1;
        this.campo2 = campo2;
    }
    
}
