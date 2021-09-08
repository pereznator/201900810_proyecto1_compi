//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package LenguajeCopias;

import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.ErrorLex;
import models.Token;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/

%%

%{
    public LinkedList<ErrorLex> errores = new LinkedList<ErrorLex>();
    public LinkedList<String> comentarios = new LinkedList<String>();
    public LinkedList<Token> tkns = new LinkedList<Token>();
%}

%public
%class LexerCopias
%cup
%type java_cup.runtime.Symbol
%column
%line
%char
%full
//%ignorecase
%unicode

numero=[0-9]+
decimal={numero}+("."){numero}{1,2}
espacio=[ \n\t\r]+
letra=[a-zA-Z]+

%%

//Tercera Parte
/*-----------------------------------Reglas Lexicas-------------------------------------*/

<YYINITIAL> "/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*"/"
                            {
                                System.out.println("Comentario multilinea: "+yytext());
                                comentarios.add(yytext());
                                tkns.add(new Token("comentario_multilinea", yycolumn, yyline, yytext()));
                            }
<YYINITIAL> "//".*            
                            {
                                System.out.println("Comentario de una linea: "+yytext());
                                comentarios.add(yytext());
                                tkns.add(new Token("comentario", yycolumn, yyline, yytext()));
                            }
<YYINITIAL> class           {
                                System.out.println(yytext() + " Token: CLASS");
                                tkns.add(new Token("class", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CLASS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> var             {
                                System.out.println(yytext() + " Token: VAR");
                                tkns.add(new Token("var", yycolumn, yyline, yytext()));
                                return new Symbol(sym.VAR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> let             {
                                System.out.println(yytext() + " Token: LET");
                                tkns.add(new Token("let", yycolumn, yyline, yytext()));
                                return new Symbol(sym.LET, yycolumn, yyline, yytext());
                            }
<YYINITIAL> const           {
                                System.out.println(yytext() + " Token: CONST");
                                tkns.add(new Token("const", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CONST, yycolumn, yyline, yytext());
                            }
<YYINITIAL> true            {
                                System.out.println(yytext() + " Token: TRUE");
                                tkns.add(new Token("true", yycolumn, yyline, yytext()));
                                return new Symbol(sym.TRUE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> false           {
                                System.out.println(yytext() + " Token: FALSE");
                                tkns.add(new Token("false", yycolumn, yyline, yytext()));
                                return new Symbol(sym.FALSE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> if              {
                                System.out.println(yytext() + " Token: IF");
                                tkns.add(new Token("if", yycolumn, yyline, yytext()));
                                return new Symbol(sym.IF, yycolumn, yyline, yytext());
                            }
<YYINITIAL> else            {
                                System.out.println(yytext() + " Token: ELSE");
                                tkns.add(new Token("else", yycolumn, yyline, yytext()));
                                return new Symbol(sym.ELSE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> for             {
                                tkns.add(new Token("for", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: FOR");
                                return new Symbol(sym.FOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> do              {
                                System.out.println(yytext() + " Token: DO");
                                tkns.add(new Token("do", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> while           {
                                tkns.add(new Token("while", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: WHILE");
                                return new Symbol(sym.WHILE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> switch          {
                                tkns.add(new Token("switch", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: SWITCH");
                                return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());
                            }
<YYINITIAL> case            {
                                System.out.println(yytext() + " Token: CASE");
                                tkns.add(new Token("case", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CASE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> break           {
                                System.out.println(yytext() + " Token: BREAK");
                                tkns.add(new Token("break", yycolumn, yyline, yytext()));
                                return new Symbol(sym.BREAK, yycolumn, yyline, yytext());
                            }
<YYINITIAL> default         {
                                System.out.println(yytext() + " Token: DEFAULT");
                                tkns.add(new Token("defualt", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());
                            }
<YYINITIAL> console"."log   {
                                System.out.println(yytext() + " Token: CONSOLELOG");
                                tkns.add(new Token("conoslelog", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CONSOLELOG, yycolumn, yyline, yytext());
                            }
<YYINITIAL> require         {
                                System.out.println(yytext() + " Token: REQUIRE");
                                tkns.add(new Token("require", yycolumn, yyline, yytext()));
                                return new Symbol(sym.REQUIRE, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "("             {
                                System.out.println(yytext() + " Token: PARENTESIS_A");
                                tkns.add(new Token("parentesi_a", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ")"             {
                                System.out.println(yytext() + " Token: PARENTESIS_C");
                                tkns.add(new Token("parentesi_c", yycolumn, yyline, yytext()));
                                return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "{"             {
                                tkns.add(new Token("llave_a", yycolumn, yyline, yytext()));
                                System.out.println(yytext() + " Token: LLAVE_A");
                                return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "}"             {
                                System.out.println(yytext() + " Token: LLAVE_C");
                                tkns.add(new Token("llave_c", yycolumn, yyline, yytext()));
                                return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext());
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
<YYINITIAL> "="             {
                                System.out.println(yytext() + " Token: IGUAL");
                                tkns.add(new Token("igual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "=="            {
                                System.out.println(yytext() + " Token: DOBLE_IGUAL");
                                tkns.add(new Token("doble_igual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOBLE_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "!="            {
                                System.out.println(yytext() + " Token: DESIGUAL");
                                tkns.add(new Token("desigual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DESIGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "<"             {
                                System.out.println(yytext() + " Token: MENOR");
                                tkns.add(new Token("menor", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MENOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "<="            {
                                System.out.println(yytext() + " Token: MENOR_IGUAL");
                                tkns.add(new Token("menor_igual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MENOR_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ">"             {
                                System.out.println(yytext() + " Token: MAYOR");
                                tkns.add(new Token("mayor", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ">="            {
                                System.out.println(yytext() + " Token: MAYOR_IGUAL");
                                tkns.add(new Token("mayor_igual", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MAYOR_IGUAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "&&"            {
                                System.out.println(yytext() + " Token: AND");
                                tkns.add(new Token("and", yycolumn, yyline, yytext()));
                                return new Symbol(sym.AND, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "||"            {
                                System.out.println(yytext() + " Token: OR");
                                tkns.add(new Token("or", yycolumn, yyline, yytext()));
                                return new Symbol(sym.OR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "!"             {
                                System.out.println(yytext() + " Token: NOT");
                                tkns.add(new Token("not", yycolumn, yyline, yytext()));
                                return new Symbol(sym.NOT, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "+"             {
                                System.out.println(yytext() + " Token: MAS");
                                tkns.add(new Token("mas", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "-"             {
                                System.out.println(yytext() + " Token: MENOS");
                                tkns.add(new Token("menos", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MENOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "*"             {
                                System.out.println(yytext() + " Token: ASTERISCO");
                                tkns.add(new Token("asterisco", yycolumn, yyline, yytext()));
                                return new Symbol(sym.ASTERISCO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "/"             {
                                System.out.println(yytext() + " Token: DIAGONAL");
                                tkns.add(new Token("diagonal", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DIAGONAL, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "**"            {
                                System.out.println(yytext() + " Token: POTENCIA");
                                tkns.add(new Token("potencia", yycolumn, yyline, yytext()));
                                return new Symbol(sym.POTENCIA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "%"             {
                                System.out.println(yytext() + " Token: MODULO");
                                tkns.add(new Token("modulo", yycolumn, yyline, yytext()));
                                return new Symbol(sym.MODULO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "++"            {
                                System.out.println(yytext() + " Token: DOBLE_MAS");
                                tkns.add(new Token("doble_mas", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOBLE_MAS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> "--"            {
                                System.out.println(yytext() + " Token: DOBLE_MENOS");
                                tkns.add(new Token("doble_menos", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOBLE_MENOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> ":"             {
                                System.out.println(yytext() + " Token: DOS_PUNTOS");
                                tkns.add(new Token("dos_puntos", yycolumn, yyline, yytext()));
                                return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());
                            }
<YYINITIAL> (\")[^\"]*(\")
| (\')[^\']*(\')            {
                                System.out.println(yytext() + " Token: CADENA");
                                tkns.add(new Token("cadena", yycolumn, yyline, yytext()));
                                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {numero}
| {decimal}                 {
                                System.out.println(yytext() + " Token: NUMERO");
                                tkns.add(new Token("numero", yycolumn, yyline, yytext()));
                                return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {letra}(_|{letra}|{numero})* 
                            {
                                System.out.println(yytext() + " Token: IDENTIFICADOR");
                                tkns.add(new Token("identificador", yycolumn, yyline, yytext()));
                                return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
                            }
<YYINITIAL> {espacio}       {
                                /*Ignorar*/
                            }
<YYINITIAL> .               {
                                System.out.println("[ERROR] "+yytext());
                                ErrorLex err = new ErrorLex("Error Lexico", yytext(), yyline, yycolumn);
                                errores.add(err);
                            }