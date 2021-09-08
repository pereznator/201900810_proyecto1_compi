
package vistas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ErrorLex;
import models.Token;

public class ReporteTokens {
    LinkedList<Token> tokens = null;
    public String estado = "";
    public ReporteTokens(LinkedList<Token> tokens) {
        this.tokens = tokens;
    }
    
    public void generarReporte() {
        File f = new File(System.getProperty("user.dir")+"\\salidas\\ReporteTokens.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("<html> <head> <title>Reporte de Tokens</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
            bw.write("</head> <body> <div class=\"container\"> <h1 class=\"mt-3\">Reporte de Tokens</h1> <hr> <table class=\"table table-striped\">");
            bw.write("<thead> <tr> <th>Lexema</th> <th>Token</th> <th>Linea</th> <th>Columna</th> <th>Archivo</th> </tr> </thead> <tbody> <tr>");
            for (Token tkn : this.tokens) {
                bw.write("<td>"+tkn.lexema+"</td> <td>"+tkn.token+"</td> <td>"+tkn.linea+"</td> <td>"+tkn.columna+"</td> <td>"+tkn.archivo+"</td> </tr>");
            }
            bw.write("</tbody> </table> </div> </body> </html>");
            bw.close();
            this.estado = "Reporte de tokens creado \n";
        } catch (IOException ex) {
            Logger.getLogger(ReporteErrores.class.getName()).log(Level.SEVERE, null, ex);
            this.estado = "Error al crear reporte de tokens! \n";
        }
    }
}
