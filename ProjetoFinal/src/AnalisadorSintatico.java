
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

class AnalisadorSintatico {

    void analisar(Stack<String> tokens) {
        Stack<String> pilha_A = new Stack();//cria nova pilha A
        Stack<Integer> pilha_X = new Stack();//cria outra pilha X
        pilha_A = tokens;//a pilha A recebe as strings
        pilha_X.add(52);//Inicializa a PilhaX com 52

        while (!pilha_A.isEmpty() && !pilha_X.isEmpty()) {//verifica se a pilha X ou A esta vazia
            Integer x = pilha_X.peek();//variavel x recebe a pilha X
            String aa = pilha_A.peek();//variavel aa recebe a pilha A
            Integer a = Gramatica.TERMINAIS_E_NAO_TERMINAIS.get(aa);//variavel a recebe o valor da variavel aa

            if (a == null) {//verifica se a variavel a nao esta vazia
                try {
                    Integer.parseInt(aa);//veriica se é interger
                    a = 26;
                } catch (NumberFormatException e) {//verifica se é string
                    a = 25;
                }

            }

            if (x < 52) {//se x é terminal
               
                if (x.equals(a)) {//compara x com a
                    pilha_X.pop();//retira o topo da pilha X
                    pilha_A.pop();//retira o topo da pilha A
                    System.out.println(aa);//imprime aa
                    

                } else {
                    System.out.println("Erro: A:"+ a +" X:"+ x);//mostra o erro
                    break;
                }
            } else {

                String derivacao = Gramatica.GRAMATICA.get(x + "," + a);                           
                Integer[] y1y2 = Gramatica.geraDadosCruzamentoTabParsingToken(derivacao);//variavel y1y2 recebe derivação                
                pilha_X.pop();//retira o topo da pilha X      
                if (derivacao != null) {//verifica se y1y2 esta vazia
                            
                    for (int i = y1y2.length - 1; i >= 0; i--) {//loop
                        pilha_X.push(y1y2[i]);//puxa a pilha X e coloca na pilha y1y2

                }
                   
                }
                
            }
        }

    }
}
