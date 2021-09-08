
package models;

public class Token {
    public String lexema;
    public int columna, linea;
    public String archivo, token = "";
    public Token(String token, int columna, int linea, String lexema) {
        this.token = token;
        this.columna = columna;
        this.linea = linea;
        this.lexema = lexema;
    }
}
