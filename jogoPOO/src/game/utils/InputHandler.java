/*Responsável por cuidar das entradas do usuário*/
package game.utils;

import java.util.Scanner;
import game.exceptions.EntradaInvalidaException;

public class InputHandler {
    /*atributo*/
    private Scanner scanner;

    /*construtor*/
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /*métodos*/
    //Lê uma string simples (como o nome do jogador ou uma resposta V/F)
    public String lerString(String mensagem) {
        System.out.print(mensagem + " ");
        return scanner.nextLine().trim();
    }

    //validação interna para a entrada de inteiros
    private void validarIntervalo(int valor, int min, int max) throws EntradaInvalidaException {
        if (valor < min || valor > max) {
            throw new EntradaInvalidaException("Opção inválida! Escolha um número entre " + min + " e " + max + ".");
        }
    }
    //Lê um número inteiro garantindo que o programa não quebre se o usuário digitar uma letra ou um número fora do intervalo
    public int lerInteiro(String mensagem, int min, int max) {
        int escolha = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem + " [" + min + "-" + max + "]: ");
            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
                validarIntervalo(escolha, min, max);
                valido = true;
            } catch (NumberFormatException e) { //exception nativa
                System.out.println("Entrada inválida! Por favor, digite um número.");
            } catch (EntradaInvalidaException e) { //exception criada
                System.out.println(e.getMessage());
            }
        }
        return escolha;
    }

    //Pausa o jogo até o jogador apertar ENTER
    public void esperarEnter() {
        System.out.println("\nPressione [ENTER] para continuar...");
        scanner.nextLine();
    }

    //Imprime uma linha divisória para deixar o console mais organizado
    public void imprimirLinha() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Fecha o scanner quando o jogo acabar
    public void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
