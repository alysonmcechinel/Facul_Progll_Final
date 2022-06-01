
import java.util.Stack;

public class Compilador {

    public void init(){
        //- Programa a ser analisado
        String programa = 
                "PROGRAM OUTRO ; "
                + " VAR "
                + "   X , Y , Z : INTEGER ; "
                + "BEGIN "
                + "   X := 10 ; "
                + "   Y := 20 ; "
                + "   Z := 30 ; "
                + "  REPEAT "
                + "    BEGIN "
                + "      WRITELN ( X , Y , Z ) ; "
                + "    END "
                + "  UNTIL X H> 10 ; "
                + "END ."
                ;
        
        //Fase 1: Análise léxica simples onde o separador será sempre um espaço para facilitar
        Stack<String> tokens = new AnalisadorLexico().gerarTokens(programa);
//          while(!tokens.isEmpty()) {
//                System.out.println("[" + tokens.pop() + "]");
//          }

        //Fase 2: Análise sintática, verificando se o código respeita a gramática
        new AnalisadorSintatico().analisar(tokens);
             
    }

    //executa o programa
    public static void main(String args[]) {
        new Compilador().init();
    }

}