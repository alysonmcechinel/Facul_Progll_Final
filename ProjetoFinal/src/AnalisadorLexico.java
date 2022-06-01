
import java.util.Stack;

public class AnalisadorLexico{
    
    public Stack gerarTokens(String programa){
        int i;
        Stack<String> pilha = new Stack<String>();//cria a pilha
        String[] textoSeparado = programa.split(" ");//recebe a pilha
        String palavra = "";//separa a pilha por espaço
        
        for(i = textoSeparado.length-1; i >= 0; i--){//inverte a pilha
            palavra = textoSeparado[i].trim();//tirar os espaços em branco
            if (palavra.length() != 0){//verifica se a pilha nao ta vazia
               pilha.push(palavra);//puxa a string pra pilha   
            }
        }
        return pilha;
    }
}