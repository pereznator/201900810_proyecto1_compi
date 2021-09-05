//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package Reporteria;

import java_cup.runtime.*;
import utils.TknsReporteria;
import models.TokenReporteria;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%
%public
%type TokenReporteria
%class LexerReporteria
%column
%line
%char
%full
%ignorecase
%unicode

numero=[0-9]+
decimal={numero}+("."){numero}{1,2}
espacio=[ ,\n,\t,\r]+
letra=[a-zA-Z]+

%%

//Tercera Parte
/*-----------------------------------Reglas Lexicas-------------------------------------*/

<YYINITIAL> ("#*")(.|{espacio})*("*#")  {
                                return new TokenReporteria(TknsReporteria.COMENTARIO_MULTI, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "##".*"\n"      {
                                return new TokenReporteria(TknsReporteria.COMENTARIO_LINEAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> definirglobales {
                                return new TokenReporteria(TknsReporteria.DEFINIR_GLOBALES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> generarreporteestadistico {
                                return new TokenReporteria(TknsReporteria.GENERAR_REPORTE_ESTADISTICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficabarras   {
                                return new TokenReporteria(TknsReporteria.GRAFICA_BARRAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficapie      {
                                return new TokenReporteria(TknsReporteria.GRAFICA_PIE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> graficalineas   {
                                return new TokenReporteria(TknsReporteria.GRAFICA_LINEAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> puntajeGeneral  {
                                return new TokenReporteria(TknsReporteria.PUNTAJE_GENERAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> PUNTAJE_ESPECIFICO {
                                return new TokenReporteria(TknsReporteria.PUNTAJE_ESPECIFICO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "$"             {
                                return new TokenReporteria(TknsReporteria.DOLLAR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "{"             {
                                return new TokenReporteria(TknsReporteria.LLAVE_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "}"             {
                                return new TokenReporteria(TknsReporteria.LLAVE_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> compare         {
                                return new TokenReporteria(TknsReporteria.COMPARE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "("             {
                                return new TokenReporteria(TknsReporteria.PARENTESIS_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ")"             {
                                return new TokenReporteria(TknsReporteria.PARENTESIS_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "["             {
                                return new TokenReporteria(TknsReporteria.CUADRADA_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "]"             {
                                return new TokenReporteria(TknsReporteria.CUADRADA_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ","             {
                                return new TokenReporteria(TknsReporteria.COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ";"             {
                                return new TokenReporteria(TknsReporteria.P_COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ":"             {
                                return new TokenReporteria(TknsReporteria.DOS_PUNTOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "="             {
                                return new TokenReporteria(TknsReporteria.IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> (\").*(\")
| (\').*(\')                {
                                return new TokenReporteria(TknsReporteria.CADENA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> string          {
                                return new TokenReporteria(TknsReporteria.STRING, yycolumn, yyline, yytext());
                            }
<YYINITIAL> double          {
                                return new TokenReporteria(TknsReporteria.DOUBLE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulo          {
                                return new TokenReporteria(TknsReporteria.TITULO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ejex            {
                                return new TokenReporteria(TknsReporteria.EJEX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> valores         {
                                return new TokenReporteria(TknsReporteria.VALORES, yycolumn, yyline, yytext());
                            }
<YYINITIAL> titulox         {
                                return new TokenReporteria(TknsReporteria.TITULOX, yycolumn, yyline, yytext());
                            }
<YYINITIAL> tituloy         {
                                return new TokenReporteria(TknsReporteria.TITULOY, yycolumn, yyline, yytext());
                            }
<YYINITIAL> archivo         {
                                return new TokenReporteria(TknsReporteria.ARCHIVO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {decimal}       {
                                return new TokenReporteria(TknsReporteria.DECIMAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {numero}        {
                                return new TokenReporteria(TknsReporteria.NUMERO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {letra}({letra}|{numero})* {
                                return new TokenReporteria(TknsReporteria.IDENTIFICADOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {espacio}       {
                                /*IGNORE*/
                            }
<YYINITIAL> .               {
                                return new TokenReporteria(TknsReporteria.ERROR, yycolumn, yyline, yytext());
                            }
