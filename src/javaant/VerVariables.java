
package javaant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import models.PuntajeEspecifico;
import models.VariableReporteria;

public class VerVariables {
    LinkedList<VariableReporteria> variables = null;
    Map<String, Double> pgsVar = new HashMap<String, Double>();
    Map<String, String> strVars = new HashMap<String, String>();
    Map<String, Double> nums = new HashMap<String, Double>();
    Map<String, PuntajeEspecifico> pesVar = new HashMap<String, PuntajeEspecifico>();
    double total = 0;
    
    public VerVariables(LinkedList<VariableReporteria> variables, double total) {
        this.variables = variables;
        this.total = total;
        capturarVariables();
    }
    
    private void capturarVariables() {
        System.out.println("===============VARIALBES=================");
        for (VariableReporteria variable: this.variables) {
            switch(variable.tipo) {
                case "STRING":
                    System.out.println("Tipo: "+variable.tipo+", Nombre: "+variable.nombre+", Valor: "+variable.valorStr);
                    this.strVars.put(variable.nombre, variable.valorStr);
                    break;
                case "INT":
                    System.out.println("Tipo: "+variable.tipo+", Nombre: "+variable.nombre+", Valor: "+variable.valorInt);
                    this.nums.put(variable.nombre, Double.valueOf(variable.valorInt));
                    break;
                case "DOUBLE":
                    System.out.println("Tipo: "+variable.tipo+", Nombre: "+variable.nombre+", Valor: "+variable.valorDbl);
                    this.nums.put(variable.nombre, variable.valorDbl);
                    break;
                case "PUNTAJE GENERAL":
                    System.out.println("Tipo: "+variable.tipo+", Nombre: "+variable.nombre+", Valor: "+variable.pungen.tipo);
                    this.pgsVar.put(variable.nombre, this.total);
                    break;
                case "PUNTAJE ESPECIFICO":
                    System.out.println("Tipo: "+variable.tipo+", Nombre: "+variable.nombre+", Archivo: "+variable.punes.archivo+ ", Campo1: "+variable.punes.campo1+", Campo2: "+variable.punes.campo2);
                    this.pesVar.put(variable.nombre, variable.punes);
                    break;
            }
        }
    }
}
