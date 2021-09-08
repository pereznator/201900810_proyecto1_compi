
package javaant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Clase;
import models.Grafica;
import models.PuntajeEspecifico;
import models.PuntajeGeneral;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class VerGraficas {
    public LinkedList<Grafica> graficas = null;
    public  VerVariables variables = null;
    public LinkedList<PuntajeEspecifico> pes = null;
    public String acciones = "";
    public boolean error = false;
    LinkedList<Comparador> comp = null;
    public Map<String, String> rutas = new HashMap<String, String>();
    
    public VerGraficas(LinkedList<Grafica> graficas, VerVariables variables, LinkedList<PuntajeEspecifico> pes, LinkedList<Comparador> comp) {
        this.graficas = graficas;
        this.variables = variables;
        this.pes = pes;
        this.comp = comp;
        captarGraficas();
        hacerGraficas();
    }
    
    public void captarGraficas() {
        for (Grafica graf : this.graficas) {
            System.out.println("============GRAFICA=============");
            System.out.println("Tipo: "+graf.tipo);
            System.out.println("Titulo: "+graf.titulo);
            System.out.println("EjeX: "+graf.ejex.toString());
            System.out.println("Valores: "+graf.valores.toString());
            System.out.println("TituloX: "+graf.titulox);
            System.out.println("TituloY: "+graf.tituloy);
            System.out.println("Archivo: "+graf.archivo);
        }
    }
    
    public void hacerGraficas() {
        for (Grafica graf : this.graficas) {
            String titulo = "";
            LinkedList<String> ejex = new LinkedList<String>();
            LinkedList<Double> valores = new LinkedList<Double>();
            String ruta = "";
            switch(graf.tipo) {
                case "BARRAS":
                    this.acciones += "Generando grafica de barras. \n";
                    DefaultCategoryDataset data = new DefaultCategoryDataset();
                    String titulox = "";
                    String tituloy = "";
                    for (String element : graf.ejex) {
                        if (this.variables.strVars.containsKey(element)) {
                            ejex.add(quitarComillas(this.variables.strVars.get(element)));
                        }else {
                            ejex.add(quitarComillas(element));
                        }
                    }
                    for (Object element : graf.valores) {
                        if (element.getClass() == PuntajeGeneral.class) {
                            valores.add(this.variables.total);
                        }else if (element.getClass() == PuntajeEspecifico.class) {
                            PuntajeEspecifico pEspe = (PuntajeEspecifico) element;
                            this.pes.stream().filter((pe) -> (pe.archivo.equals(quitarComillas(pEspe.archivo)) && pe.campo1.equals(quitarComillas(pEspe.campo1)) && pe.campo2.equals(quitarComillas(pEspe.campo2)))).forEachOrdered((pe) -> {
                                valores.add(pe.valor);
                            });
                        }else {
                            if (this.variables.nums.containsKey(element.toString())) {
                                valores.add(this.variables.nums.get(element));
                            }else if (this.variables.pgsVar.containsKey(element.toString())) {
                                valores.add(this.variables.total);
                            }else if (this.variables.pesVar.containsKey(element.toString())) {
                                PuntajeEspecifico pEspe = this.variables.pesVar.get(element.toString());
                                this.pes.stream().filter((pe) -> (pe.archivo.equals(quitarComillas(pEspe.archivo)) && pe.campo1.equals(quitarComillas(pEspe.campo1)) && pe.campo2.equals(quitarComillas(pEspe.campo2)))).forEachOrdered((pe) -> {
                                    valores.add(pe.valor);
                                });
                            }
                            else {
                                valores.add(new Double(element.toString()));
                            }
                        }
                    }
                    if (this.variables.strVars.containsKey(graf.titulo)) {
                        titulo = quitarComillas(this.variables.strVars.get(graf.titulo));
                    }else {
                        titulo = quitarComillas(graf.titulo);
                    }
                    if (this.variables.strVars.containsKey(graf.titulox)) {
                        titulox = quitarComillas(this.variables.strVars.get(graf.titulox));
                    }else {
                        titulox = quitarComillas(graf.titulox);
                    }
                    if (this.variables.strVars.containsKey(graf.tituloy)) {
                        tituloy = quitarComillas(this.variables.strVars.get(graf.tituloy));
                    }else {
                        tituloy = quitarComillas(graf.tituloy);
                    }
                    
                    System.out.println(ejex.toString());
                    System.out.println(valores.toString());
                    
                    if (ejex.size() == valores.size()) {
                        for (int x = 0; x < ejex.size(); x++) {
                            data.setValue(valores.get(x), "valores", ejex.get(x));
                        }

                        JFreeChart grafica = ChartFactory.createBarChart(titulo, titulox, tituloy, data,
                                PlotOrientation.VERTICAL, true, true, false);
                        OutputStream out = null;
                        ruta = System.getProperty("user.dir")+"\\salidas\\"+titulo+".png";
                        try {
                            out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\salidas\\"+titulo+".png"));
                        } catch (FileNotFoundException ex) {
                            System.out.println("No se encontro la ruta de salida para la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            ChartUtilities.writeChartAsPNG(out, grafica, 600, 600);
                            this.rutas.put(ruta, "barras");
                        } catch (IOException ex) {
                            System.out.println("No se pudo crear la imagen de la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else {
                        this.acciones += "Error al crear grafica de barras :(\n";
                        this.error = true;
                    }
                    break;
                case "PIE":
                    this.acciones += "Generando grafica de pie. \n";
                    DefaultPieDataset dataPie = new DefaultPieDataset();
                    for (String element : graf.ejex) {
                        if (this.variables.strVars.containsKey(element)) {
                            ejex.add(quitarComillas(this.variables.strVars.get(element)));
                        }else {
                            ejex.add(quitarComillas(element));
                        }
                    }
                    for (Object element : graf.valores) {
                        if (element.getClass() == PuntajeGeneral.class) {
                            valores.add(this.variables.total);
                        }else if (element.getClass() == PuntajeEspecifico.class) {
                            PuntajeEspecifico pEspe = (PuntajeEspecifico) element;
                            this.pes.stream().filter((pe) -> (pe.archivo.equals(quitarComillas(pEspe.archivo)) && pe.campo1.equals(quitarComillas(pEspe.campo1)) && pe.campo2.equals(quitarComillas(pEspe.campo2)))).forEachOrdered((pe) -> {
                                valores.add(pe.valor);
                            });
                        }else {
                            if (this.variables.nums.containsKey(element.toString())) {
                                valores.add(this.variables.nums.get(element));
                            }else if (this.variables.pgsVar.containsKey(element.toString())) {
                                valores.add(this.variables.total);
                            }else if (this.variables.pesVar.containsKey(element.toString())) {
                                PuntajeEspecifico pEspe = this.variables.pesVar.get(element.toString());
                                this.pes.stream().filter((pe) -> (pe.archivo.equals(quitarComillas(pEspe.archivo)) && pe.campo1.equals(quitarComillas(pEspe.campo1)) && pe.campo2.equals(quitarComillas(pEspe.campo2)))).forEachOrdered((pe) -> {
                                    valores.add(pe.valor);
                                });
                            }
                            else {
                                valores.add(new Double(element.toString()));
                            }
                        }
                    }
                    if (this.variables.strVars.containsKey(graf.titulo)) {
                        titulo = quitarComillas(this.variables.strVars.get(graf.titulo));
                    }else {
                        titulo = quitarComillas(graf.titulo);
                    }
                    
                    System.out.println(ejex.toString());
                    System.out.println(valores.toString());
                    
                    if (ejex.size() == valores.size()) {
                        for (int x = 0; x < ejex.size(); x++) {
                            dataPie.setValue(ejex.get(x), valores.get(x));
                        }

                        JFreeChart grafica = ChartFactory.createPieChart(titulo, dataPie);
                        OutputStream out = null;
                        ruta = System.getProperty("user.dir")+"\\salidas\\"+titulo+".png";
                        try {
                            out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\salidas\\"+titulo+".png"));
                        } catch (FileNotFoundException ex) {
                            System.out.println("No se encontro la ruta de salida para la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            ChartUtilities.writeChartAsPNG(out, grafica, 600, 600);
                            rutas.put(ruta, "pie");
                        } catch (IOException ex) {
                            System.out.println("No se pudo crear la imagen de la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else {
                        this.acciones += "Error al crear grafica pie :(\n";
                        this.error = true;
                    }
                    break;
                case "LINEAS":
                    this.acciones += "Generando grafica de lineas. \n";
                    DefaultCategoryDataset dataLineas = new DefaultCategoryDataset();
                    int cantClases1 = 0;
                    int cantClases2 = 0;
                    int cantVariables1 = 0;
                    int cantVariables2 = 0;
                    int cantMetodos1 = 0;
                    int cantMetodos2 = 0;
                    int cantComentarios1 = 0;
                    int cantComentarios2 = 0;
                    boolean encontrado = false;
                    String nombre = "";
                    if (this.variables.strVars.containsKey(graf.archivo)) {
                        nombre = quitarComillas(this.variables.strVars.get(graf.archivo));
                    }else {
                        nombre = quitarComillas(graf.archivo);
                    }
                    for (Comparador compi : this.comp){
                        if (compi.archivo1.nombre.equals(nombre)) {
                            encontrado = true;
                            cantClases1 = compi.archivo1.clases.size();
                            cantClases2 = compi.archivo2.clases.size();
                            
                            cantVariables1 = compi.archivo1.variables.size();
                            cantVariables2 = compi.archivo2.variables.size();
                            
                            for (Clase clase : compi.archivo1.clases) {
                                cantMetodos1 += clase.metodos.size();
                            }
                            
                            for (Clase clase : compi.archivo2.clases) {
                                cantMetodos2 += clase.metodos.size();
                            }
                            
                            cantComentarios1 = compi.archivo1.comentarios.size();
                            cantComentarios2 = compi.archivo2.comentarios.size();
                        }
                    }
                    if (encontrado == true) {
                        dataLineas.setValue(cantVariables1, "archivo 1", "variables");
                        dataLineas.setValue(cantMetodos1, "archivo 1", "metodos");
                        dataLineas.setValue(cantClases1, "archivo 1", "clases");
                        dataLineas.setValue(cantComentarios1, "archivo 1", "comentarios");

                        dataLineas.setValue(cantVariables2, "archivo 2", "variables");
                        dataLineas.setValue(cantMetodos2, "archivo 2", "metodos");
                        dataLineas.setValue(cantClases2, "archivo 2", "clases");
                        dataLineas.setValue(cantComentarios2, "archivo 2", "comentarios");

                        if (this.variables.strVars.containsKey(graf.titulo)) {
                            titulo = quitarComillas(this.variables.strVars.get(graf.titulo));
                        }else {
                            titulo = quitarComillas(graf.titulo);
                        }

                        JFreeChart lineas = ChartFactory.createLineChart(titulo, "Area", "Repeticiones", dataLineas);

                        OutputStream out = null;
                        ruta = System.getProperty("user.dir")+"\\salidas\\"+titulo+".png";
                        try {
                            out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\salidas\\"+titulo+".png"));
                        } catch (FileNotFoundException ex) {
                            System.out.println("No se encontro la ruta de salida para la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            ChartUtilities.writeChartAsPNG(out, lineas, 600, 600);
                            rutas.put(ruta, "lineas");
                        } catch (IOException ex) {
                            System.out.println("No se pudo crear la imagen de la grafica");
                            Logger.getLogger(VerGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else {
                        acciones += "No se ha encontrado el archivo para la grafica de lineas \n";
                    }
                    break;
            }
        }
    }
    
    private String quitarComillas(String cadena) {
        return cadena.replace("\"", "");
    }
}
