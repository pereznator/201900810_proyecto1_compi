//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package Reporteria;

import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.ErrorLex;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%

%{
    public LinkedList<ErrorLex> errores = new LinkedList<ErrorLex>();
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
espaciocoment=[ \t\r]+

%%

//Tercera Parte
/*-----------------------------------Reglas Lexicas-------------------------------------*/

<YYINITIAL> ("#*")(.|{espacio}|{numero}|{decimal}|{letra})*("*#")
                            {
                                /*return new Symbol(sym.COMENTARIO_MULTI, yycolumn, yyline, yytext());*/
                                System.out.println("Comentario multilinea: "+yytext());
                            }
<YYINITIAL> ("##")(.|{numero}|{decimal}|{letra}|{espaciocoment})*("\n")
                            {
                                System.out.println("Comentario de una linea: "+yytext());
                                /*return new Symbol(sym.COMENTARIO_LINEAL, yycolumn, yyline, yytext());*/
                            }
<YYINITIAL> definirglobales {
                                System.out.println(yytext() + " Token: DEFINIR_GLOBALSE");
                                return new Symbol(sym.DEFINIR_GLOBALES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> generarreporteestadistico {
                                System.out.println(yytext() + " Token: DEFINIR_GLOBALSE");
                                return new Symbol(sym.GENERAR_REPORTE_ESTADISTICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficabarras   {
                                System.out.println(yytext() + " Token: GRAFICA_BARRAS");
                                return new Symbol(sym.GRAFICA_BARRAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficapie      {
                                System.out.println(yytext() + " Token: GRAFICA_PIE");
                                return new Symbol(sym.GRAFICA_PIE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficalineas   {
                                System.out.println(yytext() + " Token: GRAFICA_LINEAS");
                                return new Symbol(sym.GRAFICA_LINEAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> puntajegeneral  {
                                System.out.println(yytext() + " Token: PUNTAJE_GENERAL");
                                return new Symbol(sym.PUNTAJE_GENERAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> puntajeespecifico {
                                System.out.println(yytext() + " Token: PUNTAJE_ESPECIFICO");
                                return new Symbol(sym.PUNTAJE_ESPECIFICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "$"             {
                                System.out.println(yytext() + " Token: DOLLAR");
                                return new Symbol(sym.DOLLAR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "{"             {
                                System.out.println(yytext() + " Token: LLAVE_a");
                                return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "}"             {
                                System.out.println(yytext() + " Token: LLAVE_C");
                                return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> compare         {
                                System.out.println(yytext() + " Token: COMPARE");
                                return new Symbol(sym.COMPARE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "("             {
                                System.out.println(yytext() + " Token: PARENTESIS_A");
                                return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ")"             {
                                System.out.println(yytext() + " Token: PARENTESIS_C");
                                return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "["             {
                                System.out.println(yytext() + " Token: CUADRADA_A");
                                return new Symbol(sym.CUADRADA_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "]"             {
                                System.out.println(yytext() + " Token: CUADRADA_C");
                                return new Symbol(sym.CUADRADA_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ","             {
                                System.out.println(yytext() + " Token: COMA");
                                return new Symbol(sym.COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ";"             {
                                System.out.println(yytext() + " Token: P_COMA");
                                return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ":"             {
                                System.out.println(yytext() + " Token: DOS_PUNTOS");
                                return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "="             {
                                System.out.println(yytext() + " Token: IGUAL");
                                return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> (\")[^\"]*(\")
| (\')[^\']*(\')       {
                                System.out.println(yytext() + " Token: CADENA");
                                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> string          {
                                System.out.println(yytext() + " Token: STRING");
                                return new Symbol(sym.STRING, yycolumn, yyline, yytext());
                            }
<YYINITIAL> double          {
                                System.out.println(yytext() + " Token: DOUBLE");
                                return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulo          {
                                System.out.println(yytext() + " Token: TITULO");
                                return new Symbol(sym.TITULO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ejex            {
                                System.out.println(yytext() + " Token: EJEX");
                                return new Symbol(sym.EJEX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> valores         {
                                System.out.println(yytext() + " Token: VALORES");
                                return new Symbol(sym.VALORES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulox         {
                                System.out.println(yytext() + " Token: TITULOX");
                                return new Symbol(sym.TITULOX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> tituloy         {
                                System.out.println(yytext() + " Token: TITULOY");
                                return new Symbol(sym.TITULOY, yycolumn, yyline, yytext());
                            }
<YYINITIAL> archivo         {
                                System.out.println(yytext() + " Token: ARCHIVO");
                                return new Symbol(sym.ARCHIVO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {decimal}       {
                                System.out.println(yytext() + " Token: DECIMAL");
                                return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {numero}        {
                                System.out.println(yytext() + " Token: NUMERO");
                                return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {letra}({letra}|{numero})* {
                                System.out.println(yytext() + " Token: IDENTIFICADOR");
                                return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {espacio}       {
                                /*IGNORE*/
                            }
<YYINITIAL> .               {
                                System.out.println("[ERROR] "+yytext());
                                ErrorLex err = new ErrorLex("No es parte del lenguaje actual", yytext(), yyline, yycolumn);
                                errores.add(err);
                            }


