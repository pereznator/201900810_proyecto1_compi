//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package LenguajeCopias;

import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.ErrorLex;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%

%{
    public static LinkedList<ErrorLex> errores = new LinkedList<ErrorLex>();
    public LinkedList<String> comentarios = new LinkedList<String>();
%}

%public
%class LexerCopias
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

<YYINITIAL> ("/*")(.|{espacio})*("*/")
                            {
                                System.out.println("Comentario multilinea: "+yytext());
                                comentarios.add(yytext());
                            }
/*<YYINITIAL> ("//").*("\n")  {
                                System.out.println("Comentario de una linea: "+yytext());
                                comentarios.add(yytext());
                            }*/
<YYINITIAL> Class           {
                                System.out.println(yytext() + " Token: CLASS");
                                return new Symbol(sym.CLASS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> var             {
                                System.out.println(yytext() + " Token: VAR");
                                return new Symbol(sym.VAR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> let             {
                                System.out.println(yytext() + " Token: LET");
                                return new Symbol(sym.LET, yycolumn, yyline, yytext());
                            }
<YYINITIAL> const           {
                                System.out.println(yytext() + " Token: CONST");
                                return new Symbol(sym.CONST, yycolumn, yyline, yytext());
                            }
<YYINITIAL> true            {
                                System.out.println(yytext() + " Token: TRUE");
                                return new Symbol(sym.TRUE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> false           {
                                System.out.println(yytext() + " Token: FALSE");
                                return new Symbol(sym.FALSE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> if              {
                                System.out.println(yytext() + " Token: IF");
                                return new Symbol(sym.IF, yycolumn, yyline, yytext());
                            }
<YYINITIAL> else            {
                                System.out.println(yytext() + " Token: ELSE");
                                return new Symbol(sym.ELSE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> for             {
                                System.out.println(yytext() + " Token: FOR");
                                return new Symbol(sym.FOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> do              {
                                System.out.println(yytext() + " Token: DO");
                                return new Symbol(sym.DO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> while           {
                                System.out.println(yytext() + " Token: WHILE");
                                return new Symbol(sym.WHILE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> switch          {
                                System.out.println(yytext() + " Token: SWITCH");
                                return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());
                            }
<YYINITIAL> case            {
                                System.out.println(yytext() + " Token: CASE");
                                return new Symbol(sym.CASE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> break           {
                                System.out.println(yytext() + " Token: BREAK");
                                return new Symbol(sym.BREAK, yycolumn, yyline, yytext());
                            }
<YYINITIAL> default         {
                                System.out.println(yytext() + " Token: DEFAULT");
                                return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());
                            }
<YYINITIAL> console"."log   {
                                System.out.println(yytext() + " Token: CONSOLELOG");
                                return new Symbol(sym.CONSOLELOG, yycolumn, yyline, yytext());
                            }
<YYINITIAL> require         {
                                System.out.println(yytext() + " Token: REQUIRE");
                                return new Symbol(sym.REQUIRE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "("             {
                                System.out.println(yytext() + " Token: PARENTESIS_A");
                                return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ")"             {
                                System.out.println(yytext() + " Token: PARENTESIS_C");
                                return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "{"             {
                                System.out.println(yytext() + " Token: LLAVE_A");
                                return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "}"             {
                                System.out.println(yytext() + " Token: LLAVE_C");
                                return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ","             {
                                System.out.println(yytext() + " Token: COMA");
                                return new Symbol(sym.COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ";"             {
                                System.out.println(yytext() + " Token: P_COMA");
                                return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "="             {
                                System.out.println(yytext() + " Token: IGUAL");
                                return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "=="            {
                                System.out.println(yytext() + " Token: DOBLE_IGUAL");
                                return new Symbol(sym.DOBLE_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "!="            {
                                System.out.println(yytext() + " Token: DESIGUAL");
                                return new Symbol(sym.DESIGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "<"             {
                                System.out.println(yytext() + " Token: MENOR");
                                return new Symbol(sym.MENOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "<="            {
                                System.out.println(yytext() + " Token: MENOR_IGUAL");
                                return new Symbol(sym.MENOR_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ">"             {
                                System.out.println(yytext() + " Token: MAYOR");
                                return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ">="            {
                                System.out.println(yytext() + " Token: MAYOR_IGUAL");
                                return new Symbol(sym.MAYOR_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "&&"            {
                                System.out.println(yytext() + " Token: AND");
                                return new Symbol(sym.AND, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "||"            {
                                System.out.println(yytext() + " Token: OR");
                                return new Symbol(sym.OR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "!"             {
                                System.out.println(yytext() + " Token: NOT");
                                return new Symbol(sym.NOT, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "+"             {
                                System.out.println(yytext() + " Token: MAS");
                                return new Symbol(sym.MAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "-"             {
                                System.out.println(yytext() + " Token: MENOS");
                                return new Symbol(sym.MENOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "*"             {
                                System.out.println(yytext() + " Token: ASTERISCO");
                                return new Symbol(sym.ASTERISCO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "/"             {
                                System.out.println(yytext() + " Token: DIAGONAL");
                                return new Symbol(sym.DIAGONAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "//"({letra}|{numero}|{espacio})*"\n"
                            {
                                System.out.println(yytext() + " Token: COMENTARIO_UNA_LINEA");
                                comentarios.add(yytext());
                            }
<YYINITIAL> "**"            {
                                System.out.println(yytext() + " Token: POTENCIA");
                                return new Symbol(sym.POTENCIA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "%"             {
                                System.out.println(yytext() + " Token: MODULO");
                                return new Symbol(sym.MODULO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "++"            {
                                System.out.println(yytext() + " Token: DOBLE_MAS");
                                return new Symbol(sym.DOBLE_MAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "--"            {
                                System.out.println(yytext() + " Token: DOBLE_MENOS");
                                return new Symbol(sym.DOBLE_MENOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ":"             {
                                System.out.println(yytext() + " Token: DOS_PUNTOS");
                                return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> (\")[^\"]*(\")
| (\')[^\']*(\')            {
                                System.out.println(yytext() + " Token: CADENA");
                                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {numero}
| {decimal}                 {
                                System.out.println(yytext() + " Token: NUMERO");
                                return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {letra}({letra}|{numero})* 
                            {
                                System.out.println(yytext() + " Token: IDENTIFICADOR");
                                return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {espacio}       {
                                /*Ignorar*/
                            }
<YYINITIAL> .               {
                                System.out.println("[ERROR] "+yytext());
                                ErrorLex err = new ErrorLex("No es parte del lenguaje actual", yytext(), yyline, yycolumn);
                                errores.add(err);
                            }