/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import models.PuntajeGeneral;
import models.PuntajeEspecifico;

/**
 *
 * @author jorge
 */
public class VariableReporteria {
    public String tipo, nombre, valorStr;
    public int valorInt;
    public double valorDbl;
    public PuntajeGeneral pungen;
    public PuntajeEspecifico punes;
    public VariableReporteria(String tipo, String nombre, String valorStr, int valorInt, double valorDbl, PuntajeGeneral pungen, PuntajeEspecifico punes){
        this.tipo = tipo;
        this.nombre = nombre;
        this.valorStr = valorStr;
        this.valorInt = valorInt;
        this.valorDbl = valorDbl;
        this.pungen = pungen;
        this.punes = punes;
    }
}
