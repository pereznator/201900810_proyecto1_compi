//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package Reporteria;

import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.ErrorLex;
import models.Token;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%

%{
    public LinkedList<ErrorLex> errores = new LinkedList<ErrorLex>();
    public LinkedList<Token> tkns = new LinkedList<Token>();

%}

%public
%class LexerReporteriaCup
%cup
%type java_cup.runtime.Symbol
%column
%line
%char
%full
%ignorecase
%unicode

numero=[0-9]+
decimal={numero}+("."){numero}{1,2}
espacio=[ \n\t\r]+
letra=[a-zA-Z]+
%%

//Tercera Parte
/*-----------------------------------Reglas Lexicas-------------------------------------*/

<YYINITIAL> #\*([^*]|[\r\n]|(\*+([^*#]|[\r\n])))*\*# 
                            {
                                System.out.println("Comentario multilinea: "+yytext());
                                tkns.add(new Token("comentario_ultilinea", yycolumn, yyline, yytext()));
                            }
<YYINITIAL> ##.*
                            {
                                System.out.println("Comentario de una linea: "+yytext());
                                tkns.add(new Token("comentario", yycolumn, yyline, yytext()));
                            }
<YYINITIAL> definirglobales {
                                System.out.println(yytext() + " Token: DEFINIR_GLOBALSE");
                                tkns.add(new Token("definirglobales", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DEFINIR_GLOBALES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> generarreporteestadistico {
                                System.out.println(yytext() + " Token: DEFINIR_GLOBALSE");
                                tkns.add(new Token("generarreporteestadistico", yycolumn, yyline, yytext()));
                                return new Symbol(sym.GENERAR_REPORTE_ESTADISTICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficabarras   {
                                System.out.println(yytext() + " Token: GRAFICA_BARRAS");
                                tkns.add(new Token("graficabarras", yycolumn, yyline, yytext()));
                                return new Symbol(sym.GRAFICA_BARRAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficapie      {
                                System.out.println(yytext() + " Token: GRAFICA_PIE");
                                tkns.add(new Token("graficapie", yycolumn, yyline, yytext()));
                                return new Symbol(sym.GRAFICA_PIE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficalineas   {
                                System.out.println(yytext() + " Token: GRAFICA_LINEAS");
                                tkns.add(new Token("graficalineas", yycolumn, yyline, yytext()));
                                return new Symbol(sym.GRAFICA_LINEAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> puntajegeneral  {
                                System.out.println(yytext() + " Token: PUNTAJE_GENERAL");
                                tkns.add(new Token("puntajegeneral", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PUNTAJE_GENERAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> puntajeespecifico {
                                System.out.println(yytext() + " Token: PUNTAJE_ESPECIFICO");
                                tkns.add(new Token("puntajeespecifico", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PUNTAJE_ESPECIFICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "$"             {
                                System.out.println(yytext() + " Token: DOLLAR");
                                tkns.add(new Token("dollar", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOLLAR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "{"             {
                                tkns.add(new Token("llave_a", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: LLAVE_a");
                                return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "}"             {
                                System.out.println(yytext() + " Token: LLAVE_C");
                                tkns.add(new Token("llave_ac", yycolumn, yyline, yytext()));
                                return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> compare         {
                                System.out.println(yytext() + " Token: COMPARE");
                                tkns.add(new Token("compare", yycolumn, yyline, yytext()));
                                return new Symbol(sym.COMPARE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "("             {
                                System.out.println(yytext() + " Token: PARENTESIS_A");
                                tkns.add(new Token("parentesis_a", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ")"             {
                                System.out.println(yytext() + " Token: PARENTESIS_C");
                                tkns.add(new Token("parentesis_c", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "["             {
                                System.out.println(yytext() + " Token: CUADRADA_A");
                                tkns.add(new Token("corchete_a", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CUADRADA_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "]"             {
                                System.out.println(yytext() + " Token: CUADRADA_C");
                                tkns.add(new Token("corchete_c", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CUADRADA_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ","             {
                                System.out.println(yytext() + " Token: COMA");
                                tkns.add(new Token("coma", yycolumn, yyline, yytext()));
                                return new Symbol(sym.COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ";"             {
                                System.out.println(yytext() + " Token: P_COMA");
                                tkns.add(new Token("p_coma", yycolumn, yyline, yytext()));
                                return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ":"             {
                                System.out.println(yytext() + " Token: DOS_PUNTOS");
                                tkns.add(new Token("dos_puntos", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "="             {
                                System.out.println(yytext() + " Token: IGUAL");
                                tkns.add(new Token("igual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> (\")[^\"]*(\")
| (\')[^\']*(\')       {
                                System.out.println(yytext() + " Token: CADENA");
                                tkns.add(new Token("cadena", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> string          {
                                System.out.println(yytext() + " Token: STRING");
                                tkns.add(new Token("string", yycolumn, yyline, yytext()));
                                return new Symbol(sym.STRING, yycolumn, yyline, yytext());
                            }
<YYINITIAL> double          {
                                System.out.println(yytext() + " Token: DOUBLE");
                                tkns.add(new Token("double", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulo          {
                                System.out.println(yytext() + " Token: TITULO");
                                tkns.add(new Token("titulo", yycolumn, yyline, yytext()));
                                return new Symbol(sym.TITULO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ejex            {
                                System.out.println(yytext() + " Token: EJEX");
                                tkns.add(new Token("ejex", yycolumn, yyline, yytext()));
                                return new Symbol(sym.EJEX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> valores         {
                                System.out.println(yytext() + " Token: VALORES");
                                tkns.add(new Token("valores", yycolumn, yyline, yytext()));
                                return new Symbol(sym.VALORES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulox         {
                                System.out.println(yytext() + " Token: TITULOX");
                                tkns.add(new Token("titulox", yycolumn, yyline, yytext()));
                                return new Symbol(sym.TITULOX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> tituloy         {
                                System.out.println(yytext() + " Token: TITULOY");
                                tkns.add(new Token("tituloy", yycolumn, yyline, yytext()));
                                return new Symbol(sym.TITULOY, yycolumn, yyline, yytext());
                            }
<YYINITIAL> archivo         {
                                System.out.println(yytext() + " Token: ARCHIVO");
                                tkns.add(new Token("archivo", yycolumn, yyline, yytext()));
                                return new Symbol(sym.ARCHIVO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {decimal}       {
                                System.out.println(yytext() + " Token: DECIMAL");
                                tkns.add(new Token("decimal", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {numero}        {
                                System.out.println(yytext() + " Token: NUMERO");
                                tkns.add(new Token("numero", yycolumn, yyline, yytext()));
                                return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {letra}({letra}|{numero})* {
                                tkns.add(new Token("identificador", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: IDENTIFICADOR");
                                return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {espacio}       {
                                /*IGNORE*/
                            }
<YYINITIAL> .               {
                                System.out.println("[ERROR] "+yytext());
                                ErrorLex err = new ErrorLex("Error Lexico", yytext(), yyline, yycolumn);
                                errores.add(err);
                            }


