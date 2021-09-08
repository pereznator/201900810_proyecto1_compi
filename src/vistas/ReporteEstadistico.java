
package vistas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Archivo;
import models.Clase;
import models.SetArchivo;
import models.Token;
import models.Metodo;

public class ReporteEstadistico {
    LinkedList<SetArchivo> archivos = null;
    public String estado = "";
    Map<String, String> rutas = null;
    public ReporteEstadistico(LinkedList<SetArchivo> archivos, Map<String, String> rutas) {
        this.archivos = archivos;
        this.rutas = rutas;
    }
    
    public void generarReporte() {
        File f = new File(System.getProperty("user.dir")+"\\salidas\\ReporteEstaditico.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html> <head> <title>Reporte Estadistico</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
            bw.write("</head> <body> <div class=\"container\"> <h1 class=\"mt-3\">Reporte Estadistico</h1> <hr> <h2 class=\"fw-light\">Resumen</h2> <table class=\"table table-striped\">");
            bw.write("<thead> <tr> <th>Tipo</th> <th>Proyecto A</th> <th>Proyecto B</th> </tr> </thead> <tbody>");
            for (SetArchivo set : this.archivos) {
                bw.write("<tr><td></td><th colspan=\"2\" class=\"text-center\">"+set.archivo1.nombre+"</th></tr>");
                bw.write("<tr> <th>Total Variables</th> <td>"+set.archivo1.variables.size()+"</td> <td>"+set.archivo2.variables.size()+"</td> </tr>");
                bw.write("<tr> <th>Total Clases</th> <td>"+set.archivo1.clases.size()+"</td> <td>"+set.archivo2.clases.size()+"</td> </tr>");
                int metodos1 = 0;
                int metodos2 = 0;
                for (Clase clase : set.archivo1.clases){
                    metodos1 += clase.metodos.size();
                }
                for (Clase clase : set.archivo2.clases){
                    metodos2 += clase.metodos.size();
                }
                bw.write("<tr> <th>Total Metodos</th> <td>"+metodos1+"</td> <td>"+metodos2+"</td> </tr>");
                bw.write("<tr> <th>Total Comentarios</th> <td>"+set.archivo1.comentarios.size()+"</td> <td>"+set.archivo2.comentarios.size()+"</td> </tr>");
            }
            
            bw.write("</tbody> </table>");
            
            String htmlLineas = "";
            String htmlBarras = "<h2 class=\"fw-light mt-3\">Graficas de Barras</h2>";
            String htmlPie = "<h2 class=\"fw-light mt-3\">Graficas Pie</h2>";
            int lineas = 0;
            int barras = 0;
            int pies = 0;
            
            for (Map.Entry<String, String> ruta : this.rutas.entrySet()) {
                if (ruta.getValue().equals("lineas")) {
                    htmlLineas += "<img src=\""+ruta.getKey()+"\" class=\"img-fluid\">";
                    lineas++;
                }else if (ruta.getValue().equals("barras")) {
                    htmlBarras += "<img src=\""+ruta.getKey()+"\" class=\"img-fluid\">";
                    barras++;
                }else if (ruta.getValue().equals("pie")) {
                    htmlPie += "<img src=\""+ruta.getKey()+"\" class=\"img-fluid\">";
                    pies++;
                }
            }
            
            if (lineas == 0) {
                htmlLineas += "<div class=\"alert alert-warning\">No hay graficas de lineas </div>";
            }
            if (barras == 0) {
                htmlBarras += "<div class=\"alert alert-warning\">No hay graficas de barras </div>";
            }
            if (pies == 0) {
                htmlPie += "<div class=\"alert alert-warning\">No hay graficas Pie </div>";
            }
            
            bw.write(htmlLineas);
            bw.write(htmlBarras);
            bw.write(htmlPie);
            bw.write("</div> </body> </html>");
            bw.close();
            this.estado = "Reporte Estadistico creado \n";
        } catch (IOException ex) {
            Logger.getLogger(ReporteErrores.class.getName()).log(Level.SEVERE, null, ex);
            this.estado = "Error al crear reporte estadistico! \n";
        }
    }
}
