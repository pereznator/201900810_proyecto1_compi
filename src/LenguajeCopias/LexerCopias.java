// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: CopiasLexer.jflex

//Primera Parte
/*----------------------------------Codigo de Usuario-----------------------------------*/
package LenguajeCopias;

import java.util.LinkedList;
import java_cup.runtime.Symbol;
import models.ErrorLex;

//Segunda Parte
/*-----------------------------------Opciones y Declaraciones---------------------------*/


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class LexerCopias implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\1\u0400\266\u0200\10\u0500\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\1\22\0\1\1\1\4"+
    "\1\5\2\0\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\12\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\0\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\40\1\43\1\44\1\40\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\3\40\6\0\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\40\1\43\1\44\1\40\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\53\3\40\1\54\1\55\1\56"+
    "\7\0\1\3\252\0\2\57\115\0\1\60\u01a8\0\2\3"+
    "\u0100\0\1\61\325\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\15\22\1\23\1\1\1\24"+
    "\2\1\1\25\1\0\1\26\1\27\1\0\1\30\1\31"+
    "\1\32\3\0\1\33\1\34\1\35\5\22\1\36\3\22"+
    "\1\37\6\22\1\40\1\37\2\0\1\41\1\14\2\22"+
    "\1\0\4\22\1\0\1\22\1\42\1\43\2\22\1\0"+
    "\1\22\1\44\1\22\1\0\1\45\1\22\2\46\1\22"+
    "\1\0\1\22\1\0\1\22\2\47\1\22\1\0\2\22"+
    "\1\0\1\50\1\22\1\0\2\51\2\52\1\22\1\53"+
    "\1\0\1\53\1\22\2\54\1\22\1\0\1\22\1\0"+
    "\2\55\1\22\1\0\2\22\1\0\2\56\1\22\1\0"+
    "\1\57\2\60\3\0\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\62\0\372\0\u012c"+
    "\0\62\0\62\0\u015e\0\u0190\0\62\0\u01c2\0\u01f4\0\u0226"+
    "\0\62\0\62\0\u0258\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352"+
    "\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e\0\u04b0\0\u04e2"+
    "\0\u0514\0\u0546\0\62\0\u0578\0\62\0\u05aa\0\u05dc\0\62"+
    "\0\310\0\62\0\62\0\u012c\0\62\0\62\0\62\0\u060e"+
    "\0\u0640\0\u0672\0\62\0\62\0\62\0\u06a4\0\u06d6\0\u0708"+
    "\0\u073a\0\u076c\0\u02ee\0\u079e\0\u07d0\0\u0802\0\u02ee\0\u0834"+
    "\0\u0866\0\u0898\0\u08ca\0\u08fc\0\u092e\0\62\0\62\0\u0960"+
    "\0\u0992\0\u0640\0\u0672\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c"+
    "\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u02ee\0\u02ee\0\u0b86\0\u0bb8"+
    "\0\u0bea\0\u0c1c\0\u02ee\0\u0c4e\0\u0c80\0\u060e\0\u0cb2\0\u02ee"+
    "\0\62\0\u0ce4\0\u0d16\0\u0d48\0\u0d7a\0\u0dac\0\u02ee\0\62"+
    "\0\u0dde\0\u0e10\0\u0e42\0\u0e74\0\u0ea6\0\u02ee\0\u0ed8\0\u0f0a"+
    "\0\u02ee\0\62\0\u02ee\0\62\0\u0f3c\0\u02ee\0\u0f6e\0\62"+
    "\0\u0fa0\0\u02ee\0\62\0\u0fd2\0\u1004\0\u1036\0\u1068\0\u02ee"+
    "\0\62\0\u109a\0\u10cc\0\u10fe\0\u1130\0\u1162\0\u02ee\0\62"+
    "\0\u1194\0\u11c6\0\u02ee\0\u02ee\0\62\0\u11f8\0\u122a\0\u125c"+
    "\0\62";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\2\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\2\26\1\34\2\26\1\35"+
    "\3\26\1\36\1\37\1\40\1\26\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\2\63\0\2\3\104\0"+
    "\1\50\34\0\5\51\1\52\54\51\7\0\1\53\52\0"+
    "\10\54\1\52\51\54\13\0\1\55\62\0\1\56\63\0"+
    "\1\57\56\0\1\60\4\0\1\61\60\0\1\62\1\0"+
    "\1\20\65\0\1\63\61\0\1\64\61\0\1\65\55\0"+
    "\1\26\5\0\25\26\27\0\1\26\5\0\17\26\1\66"+
    "\5\26\27\0\1\26\5\0\1\67\12\26\1\70\1\26"+
    "\1\71\7\26\27\0\1\26\5\0\4\26\1\72\10\26"+
    "\1\73\7\26\27\0\1\26\5\0\13\26\1\74\11\26"+
    "\27\0\1\26\5\0\1\75\14\26\1\76\7\26\27\0"+
    "\1\26\5\0\5\26\1\77\17\26\27\0\1\26\5\0"+
    "\4\26\1\100\20\26\27\0\1\26\5\0\4\26\1\101"+
    "\20\26\27\0\1\26\5\0\24\26\1\102\27\0\1\26"+
    "\5\0\17\26\1\103\5\26\27\0\1\26\5\0\1\104"+
    "\24\26\27\0\1\26\5\0\7\26\1\105\15\26\63\0"+
    "\1\106\40\0\1\107\100\0\1\110\6\0\3\60\1\0"+
    "\7\60\1\111\46\60\1\0\1\61\1\112\16\0\1\61"+
    "\5\0\25\61\27\0\1\113\61\0\1\26\5\0\4\26"+
    "\1\114\20\26\27\0\1\26\5\0\20\26\1\115\4\26"+
    "\4\0\1\116\22\0\1\26\5\0\1\117\24\26\27\0"+
    "\1\26\5\0\14\26\1\120\10\26\27\0\1\26\5\0"+
    "\5\26\1\121\17\26\27\0\1\26\5\0\20\26\1\122"+
    "\4\26\4\0\1\123\22\0\1\26\5\0\13\26\1\124"+
    "\11\26\27\0\1\26\5\0\17\26\1\125\5\26\27\0"+
    "\1\26\5\0\21\26\1\126\3\26\27\0\1\26\5\0"+
    "\16\26\1\127\6\26\27\0\1\26\5\0\10\26\1\130"+
    "\14\26\3\0\1\131\23\0\1\26\5\0\22\26\1\132"+
    "\2\26\27\0\1\26\5\0\17\26\1\133\5\26\27\0"+
    "\1\26\5\0\10\26\1\134\14\26\3\0\1\135\41\0"+
    "\1\131\17\0\1\131\2\0\3\60\1\0\7\60\1\111"+
    "\4\60\1\136\41\60\21\0\1\26\5\0\1\137\24\26"+
    "\27\0\1\26\5\0\4\26\1\140\20\26\41\0\1\141"+
    "\47\0\1\26\5\0\20\26\1\142\4\26\4\0\1\143"+
    "\22\0\1\26\5\0\20\26\1\144\4\26\4\0\1\145"+
    "\22\0\1\26\5\0\1\146\24\26\27\0\1\26\5\0"+
    "\4\26\1\147\20\26\41\0\1\150\47\0\1\26\5\0"+
    "\20\26\1\151\4\26\4\0\1\152\22\0\1\26\5\0"+
    "\22\26\1\153\2\26\27\0\1\26\5\0\21\26\1\154"+
    "\3\26\56\0\1\155\32\0\1\26\5\0\4\26\1\156"+
    "\20\26\27\0\1\26\5\0\13\26\1\157\11\26\50\0"+
    "\1\160\40\0\1\26\5\0\12\26\1\161\12\26\5\0"+
    "\1\162\21\0\1\26\5\0\20\26\1\163\4\26\4\0"+
    "\1\164\50\0\1\164\10\0\1\164\22\0\1\26\5\0"+
    "\15\26\1\165\3\26\1\166\3\26\52\0\1\167\3\0"+
    "\1\170\32\0\1\26\5\0\22\26\1\171\2\26\27\0"+
    "\1\26\5\0\4\26\1\172\20\26\41\0\1\173\47\0"+
    "\1\26\5\0\10\26\1\174\14\26\3\0\1\175\23\0"+
    "\1\26\5\0\2\26\1\176\22\26\37\0\1\177\51\0"+
    "\1\26\5\0\4\26\1\200\20\26\41\0\1\201\47\0"+
    "\1\26\5\0\13\26\1\202\11\26\50\0\1\203\40\0"+
    "\1\26\5\0\13\26\1\204\11\26\27\0\1\26\5\0"+
    "\17\26\1\205\5\26\54\0\1\206\34\0\1\26\5\0"+
    "\7\26\1\207\15\26\44\0\1\210\44\0\1\26\5\0"+
    "\4\26\1\211\20\26\41\0\1\212\47\0\1\26\5\0"+
    "\21\26\1\213\3\26\27\0\1\26\5\0\4\26\1\214"+
    "\20\26\41\0\1\215\45\0\1\216\1\0\1\26\5\0"+
    "\25\26\25\0\1\216\104\0\1\217\63\0\1\220\52\0"+
    "\1\221\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4750];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\2\11\2\1\1\11"+
    "\3\1\2\11\20\1\1\11\1\1\1\11\2\1\1\11"+
    "\1\0\2\11\1\0\3\11\3\0\3\11\20\1\2\11"+
    "\2\0\4\1\1\0\4\1\1\0\5\1\1\0\3\1"+
    "\1\0\3\1\1\11\1\1\1\0\1\1\1\0\2\1"+
    "\1\11\1\1\1\0\2\1\1\0\2\1\1\0\1\1"+
    "\1\11\1\1\1\11\2\1\1\0\1\11\2\1\1\11"+
    "\1\1\1\0\1\1\1\0\1\1\1\11\1\1\1\0"+
    "\2\1\1\0\1\1\1\11\1\1\1\0\2\1\1\11"+
    "\3\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[145];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    public static LinkedList<ErrorLex> errores = new LinkedList<ErrorLex>();
    public LinkedList<String> comentarios = new LinkedList<String>();


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexerCopias(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("[ERROR] "+yytext());
                                ErrorLex err = new ErrorLex("No es parte del lenguaje actual", yytext(), yyline, yycolumn);
                                errores.add(err);
            }
            // fall through
          case 50: break;
          case 2:
            { /*Ignorar*/
            }
            // fall through
          case 51: break;
          case 3:
            { System.out.println(yytext() + " Token: NOT");
                                return new Symbol(sym.NOT, yycolumn, yyline, yytext());
            }
            // fall through
          case 52: break;
          case 4:
            { System.out.println(yytext() + " Token: MODULO");
                                return new Symbol(sym.MODULO, yycolumn, yyline, yytext());
            }
            // fall through
          case 53: break;
          case 5:
            { System.out.println(yytext() + " Token: PARENTESIS_A");
                                return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());
            }
            // fall through
          case 54: break;
          case 6:
            { System.out.println(yytext() + " Token: PARENTESIS_C");
                                return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());
            }
            // fall through
          case 55: break;
          case 7:
            { System.out.println(yytext() + " Token: ASTERISCO");
                                return new Symbol(sym.ASTERISCO, yycolumn, yyline, yytext());
            }
            // fall through
          case 56: break;
          case 8:
            { System.out.println(yytext() + " Token: MAS");
                                return new Symbol(sym.MAS, yycolumn, yyline, yytext());
            }
            // fall through
          case 57: break;
          case 9:
            { System.out.println(yytext() + " Token: COMA");
                                return new Symbol(sym.COMA, yycolumn, yyline, yytext());
            }
            // fall through
          case 58: break;
          case 10:
            { System.out.println(yytext() + " Token: MENOS");
                                return new Symbol(sym.MENOS, yycolumn, yyline, yytext());
            }
            // fall through
          case 59: break;
          case 11:
            { System.out.println(yytext() + " Token: DIAGONAL");
                                return new Symbol(sym.DIAGONAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 60: break;
          case 12:
            { System.out.println(yytext() + " Token: NUMERO");
                                return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());
            }
            // fall through
          case 61: break;
          case 13:
            { System.out.println(yytext() + " Token: DOS_PUNTOS");
                                return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline, yytext());
            }
            // fall through
          case 62: break;
          case 14:
            { System.out.println(yytext() + " Token: P_COMA");
                                return new Symbol(sym.P_COMA, yycolumn, yyline, yytext());
            }
            // fall through
          case 63: break;
          case 15:
            { System.out.println(yytext() + " Token: MENOR");
                                return new Symbol(sym.MENOR, yycolumn, yyline, yytext());
            }
            // fall through
          case 64: break;
          case 16:
            { System.out.println(yytext() + " Token: IGUAL");
                                return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 65: break;
          case 17:
            { System.out.println(yytext() + " Token: MAYOR");
                                return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());
            }
            // fall through
          case 66: break;
          case 18:
            { System.out.println(yytext() + " Token: IDENTIFICADOR");
                                return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());
            }
            // fall through
          case 67: break;
          case 19:
            { System.out.println(yytext() + " Token: LLAVE_A");
                                return new Symbol(sym.LLAVE_A, yycolumn, yyline, yytext());
            }
            // fall through
          case 68: break;
          case 20:
            { System.out.println(yytext() + " Token: LLAVE_C");
                                return new Symbol(sym.LLAVE_C, yycolumn, yyline, yytext());
            }
            // fall through
          case 69: break;
          case 21:
            { System.out.println(yytext() + " Token: DESIGUAL");
                                return new Symbol(sym.DESIGUAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 70: break;
          case 22:
            { System.out.println(yytext() + " Token: CADENA");
                                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());
            }
            // fall through
          case 71: break;
          case 23:
            { System.out.println(yytext() + " Token: AND");
                                return new Symbol(sym.AND, yycolumn, yyline, yytext());
            }
            // fall through
          case 72: break;
          case 24:
            { System.out.println(yytext() + " Token: POTENCIA");
                                return new Symbol(sym.POTENCIA, yycolumn, yyline, yytext());
            }
            // fall through
          case 73: break;
          case 25:
            { System.out.println(yytext() + " Token: DOBLE_MAS");
                                return new Symbol(sym.DOBLE_MAS, yycolumn, yyline, yytext());
            }
            // fall through
          case 74: break;
          case 26:
            { System.out.println(yytext() + " Token: DOBLE_MENOS");
                                return new Symbol(sym.DOBLE_MENOS, yycolumn, yyline, yytext());
            }
            // fall through
          case 75: break;
          case 27:
            { System.out.println(yytext() + " Token: MENOR_IGUAL");
                                return new Symbol(sym.MENOR_IGUAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 76: break;
          case 28:
            { System.out.println(yytext() + " Token: DOBLE_IGUAL");
                                return new Symbol(sym.DOBLE_IGUAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 77: break;
          case 29:
            { System.out.println(yytext() + " Token: MAYOR_IGUAL");
                                return new Symbol(sym.MAYOR_IGUAL, yycolumn, yyline, yytext());
            }
            // fall through
          case 78: break;
          case 30:
            { System.out.println(yytext() + " Token: DO");
                                return new Symbol(sym.DO, yycolumn, yyline, yytext());
            }
            // fall through
          case 79: break;
          case 31:
            { System.out.println(yytext() + " Token: IF");
                                return new Symbol(sym.IF, yycolumn, yyline, yytext());
            }
            // fall through
          case 80: break;
          case 32:
            { System.out.println(yytext() + " Token: OR");
                                return new Symbol(sym.OR, yycolumn, yyline, yytext());
            }
            // fall through
          case 81: break;
          case 33:
            { System.out.println(yytext() + " Token: COMENTARIO_UNA_LINEA");
                                comentarios.add(yytext());
            }
            // fall through
          case 82: break;
          case 34:
            { System.out.println(yytext() + " Token: FOR");
                                return new Symbol(sym.FOR, yycolumn, yyline, yytext());
            }
            // fall through
          case 83: break;
          case 35:
            { System.out.println(yytext() + " Token: LET");
                                return new Symbol(sym.LET, yycolumn, yyline, yytext());
            }
            // fall through
          case 84: break;
          case 36:
            { System.out.println(yytext() + " Token: VAR");
                                return new Symbol(sym.VAR, yycolumn, yyline, yytext());
            }
            // fall through
          case 85: break;
          case 37:
            { System.out.println("Comentario multilinea: "+yytext());
                                comentarios.add(yytext());
            }
            // fall through
          case 86: break;
          case 38:
            { System.out.println(yytext() + " Token: CASE");
                                return new Symbol(sym.CASE, yycolumn, yyline, yytext());
            }
            // fall through
          case 87: break;
          case 39:
            { System.out.println(yytext() + " Token: ELSE");
                                return new Symbol(sym.ELSE, yycolumn, yyline, yytext());
            }
            // fall through
          case 88: break;
          case 40:
            { System.out.println(yytext() + " Token: TRUE");
                                return new Symbol(sym.TRUE, yycolumn, yyline, yytext());
            }
            // fall through
          case 89: break;
          case 41:
            { System.out.println(yytext() + " Token: BREAK");
                                return new Symbol(sym.BREAK, yycolumn, yyline, yytext());
            }
            // fall through
          case 90: break;
          case 42:
            { System.out.println(yytext() + " Token: CLASS");
                                return new Symbol(sym.CLASS, yycolumn, yyline, yytext());
            }
            // fall through
          case 91: break;
          case 43:
            { System.out.println(yytext() + " Token: CONST");
                                return new Symbol(sym.CONST, yycolumn, yyline, yytext());
            }
            // fall through
          case 92: break;
          case 44:
            { System.out.println(yytext() + " Token: FALSE");
                                return new Symbol(sym.FALSE, yycolumn, yyline, yytext());
            }
            // fall through
          case 93: break;
          case 45:
            { System.out.println(yytext() + " Token: WHILE");
                                return new Symbol(sym.WHILE, yycolumn, yyline, yytext());
            }
            // fall through
          case 94: break;
          case 46:
            { System.out.println(yytext() + " Token: SWITCH");
                                return new Symbol(sym.SWITCH, yycolumn, yyline, yytext());
            }
            // fall through
          case 95: break;
          case 47:
            { System.out.println(yytext() + " Token: DEFAULT");
                                return new Symbol(sym.DEFAULT, yycolumn, yyline, yytext());
            }
            // fall through
          case 96: break;
          case 48:
            { System.out.println(yytext() + " Token: REQUIRE");
                                return new Symbol(sym.REQUIRE, yycolumn, yyline, yytext());
            }
            // fall through
          case 97: break;
          case 49:
            { System.out.println(yytext() + " Token: CONSOLELOG");
                                return new Symbol(sym.CONSOLELOG, yycolumn, yyline, yytext());
            }
            // fall through
          case 98: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
