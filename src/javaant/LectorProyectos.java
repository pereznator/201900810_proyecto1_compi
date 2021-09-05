package javaant;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class LectorProyectos {
    
    public Map<String, Integer> Archivos = new HashMap<String, Integer>();
    public LinkedList<String> rutas = new LinkedList<String>();
    public LinkedList<String> rutas1 = new LinkedList<String>();
    public LinkedList<String> rutas2 = new LinkedList<String>();
    
    private int contador = 0;
    public LectorProyectos(String ruta1, String ruta2){
        getArchivos(ruta1, ruta2);
        filtrarRutas();
    }
    
    public void getArchivos(String ruta1, String ruta2){
        File doc1 = new File(ruta1);
        File doc2 = new File(ruta2);
        verArchivos(doc1.listFiles());
        verArchivos2(doc2.listFiles());
        System.out.println(Archivos.toString());
        System.out.println("Rutas 1: "+rutas1.toString());
        System.out.println("Rutas 2: "+rutas2.toString());
    }
    
    public void verArchivos(File[] archivos) {
        for (File archivo : archivos) {
            if (archivo.isDirectory()){
                verArchivos(archivo.listFiles());
            } else {
                Archivos.put(archivo.getName(), contador);
                rutas.add(archivo.getAbsolutePath());
                contador++;
            }
        }
    }
    
    public void verArchivos2(File[] archivos) {
        for (File archivo : archivos) {
            if (archivo.isDirectory()){
                verArchivos2(archivo.listFiles());
            } else {
                if (Archivos.containsKey(archivo.getName())) {
                    rutas1.add(rutas.get(Archivos.get(archivo.getName())));
                    rutas2.add(archivo.getAbsolutePath());
                }
            }
        }
    }
    
    private void filtrarRutas() {
        int x = 0;
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for (String ruta : this.rutas1) {
            Optional<String> extension = Optional.ofNullable(ruta).filter(f -> f.contains(".")).map(f -> f.substring(ruta.lastIndexOf(".") + 1));
            if (!extension.get().equals("js")){
                System.out.println("Ruta incorrecta "+extension.get());
                nums.add(x);
            }
            x++;
        }
        for (Integer n : nums) {
            this.rutas1.remove(n.intValue());
            this.rutas2.remove(n.intValue());
        }
    }
}
