/*Responsável pelas estatísticas do jogo*/
package game.core;

public class GameStats {
    //atributos
    private int fasesConcluidas;
    private int tentativas;
    private int perguntasRespondidas;
    private int acertos;
    private int erros;

    //construtor
    public GameStats() {
        this.fasesConcluidas = 0;
        this.tentativas = 0;
        this.perguntasRespondidas = 0;
        this.acertos = 0;
        this.erros = 0;
    }

    //getters
    public int getFasesConcluidas() {
        return fasesConcluidas;
    }

    public int getTentativas() {
        return tentativas;
    }

    public int getPerguntasRespondidas() {
        return perguntasRespondidas;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    //métodos
    public void registrarTentativa() {
        tentativas++;
    }

    public void registrarFaseConcluida() {
        fasesConcluidas++;
    }

    public void registrarResposta(boolean acertou) {
        perguntasRespondidas++;

        if (acertou) {
            acertos++;
        } else {
            erros++;
        }
    }

    public double calcularTaxaAcerto() {
        if (perguntasRespondidas == 0) {
            return 0;
        }

        return (acertos * 100.0) / perguntasRespondidas;
    }
}