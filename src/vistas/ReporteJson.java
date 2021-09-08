
package vistas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PuntajeEspecifico;

public class ReporteJson {
    LinkedList<PuntajeEspecifico> pes = null;
    double general = 0;
    public String estado = "";
    public ReporteJson(LinkedList<PuntajeEspecifico> pes, double general) {
        this.pes = pes;
        this.general = general;
    }
    
    public void generarReporte() {
        String contenido = "";
        File f = new File(System.getProperty("user.dir")+"\\salidas\\ReporteJson.json");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            contenido += "{\n   \"PuntajeGeneral\": "+this.general+",\n";
            contenido += "  \"PuntajeEspecifico\": [\n";
            for (PuntajeEspecifico pe: this.pes) {
                contenido += "          {\n";
                contenido += "              \"archivo\": \""+pe.archivo+"\",\n";
                contenido += "              \"tipo\": \""+pe.campo1+"\",\n";
                contenido += "              \"nombre\": \""+pe.campo2+"\",\n";
                contenido += "              \"puntaje\": "+pe.valor+"\n";
                contenido += "          },\n";
            }
            contenido += "  ]\n}";
            bw.write(contenido);
            bw.close();
            this.estado = "Reporte Json Creado";
        } catch (IOException ex) {
            this.estado = "Error al crear reporte json";
            Logger.getLogger(ReporteJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
