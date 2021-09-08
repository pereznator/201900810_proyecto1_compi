
package vistas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ErrorLex;

public class ReporteErrores {
    LinkedList<ErrorLex> errores = null;
    public String estado = "";
    public ReporteErrores(LinkedList<ErrorLex> errores) {
        this.errores = errores;
    }
    
    public void generarReporte() {
        File f = new File(System.getProperty("user.dir")+"\\salidas\\ReporteErrores.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html> <head> <title>Reporte de Errores</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
            bw.write("</head> <body> <div class=\"container\"> <h1 class=\"mt-3\">Reporte de Errores</h1> <hr> <table class=\"table table-striped\">");
            bw.write("<thead> <tr> <th>Lexema</th> <th>Tipo</th> <th>Linea</th> <th>Columna</th> <th>Archivo</th> </tr> </thead> <tbody> <tr>");
            for (ErrorLex error : this.errores) {
                bw.write("<td>"+error.valor+"</td> <td>"+error.mensaje+"</td> <td>"+error.linea+"</td> <td>"+error.columna+"</td> <td>"+error.archivo+"</td> </tr>");
            }
            bw.write("</tbody> </table> </div> </body> </html>");
            bw.close();
            this.estado = "Reporte de errores creado \n";
        } catch (IOException ex) {
            Logger.getLogger(ReporteErrores.class.getName()).log(Level.SEVERE, null, ex);
            this.estado = "Error al crear reporte de errores! \n";
        }
    }
}
