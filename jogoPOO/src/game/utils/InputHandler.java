package game.utils;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    //Lê uma string simples (como o nome do jogador ou uma resposta V/F)
    
    public String lerString(String mensagem) {
        System.out.print(mensagem + " ");
        return scanner.nextLine().trim();
    }

    //Lê um número inteiro garantindo que o programa não quebre se o usuário digitar uma letra
    
    public int lerInteiro(String mensagem, int min, int max) {
        int escolha = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem + " [" + min + "-" + max + "]: ");
            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
                if (escolha >= min && escolha <= max) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida! Escolha um número entre " + min + " e " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
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
        System.out.println("--------------------------------------------------");
    }

    // Fecha o scanner quando o jogo acabar
    public void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
