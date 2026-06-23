/*Classe base para todos os tipos de perguntas (package inteiro)*/

package game.questions;

import game.interfaces.TimedQuestion;
import game.exceptions.EntradaInvalidaException;

public abstract class Question implements TimedQuestion {
    /*atributos*/
    protected String enunciado;
    protected String respostaCerta;
    protected int dificuldade;
    protected boolean possuiTempo;
    protected int tempoLimite;
    
    /*construtor*/
    public Question(String enunciado, String respostaCerta, int dificuldade) {
        this.enunciado = enunciado;
        this.respostaCerta = respostaCerta;
        this.dificuldade = dificuldade;
        this.possuiTempo = false;
        this.tempoLimite = 0;
    }

    /*getters*/
    public String getEnunciado() {
        return enunciado;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public boolean possuiTempo() {
        return possuiTempo;
    }

    @Override //sobescrita do getter da interface TimedQuestion
    public int getTempoLimite() {
        return tempoLimite;
    }

    /*métodos*/
    //garantia que nem toda pergunta precisa estar cronometrada, mas se for, já ter um tempo padrão
    public void ativarTempo() {
        possuiTempo = true;
        definirTempoPorDificuldade();
    }
    private void definirTempoPorDificuldade() {
        switch (dificuldade) {
            case 1:
                tempoLimite = 10;
                break;
            case 2:
                tempoLimite = 15;
                break;
            case 3:
                tempoLimite = 20;
                break;
            default:
                tempoLimite = 15;
        }
    }

    //método base para validação de resposta (refinamento posterior nas subclasses)
    public void validarResposta(String respostaJogador) throws EntradaInvalidaException {
        if (respostaJogador == null || respostaJogador.trim().isEmpty()) {
            throw new EntradaInvalidaException("Entrada inválida! Digite uma resposta.");
        }
    }

    public boolean verificarResposta(String respostaJogador) {
        return respostaJogador.equalsIgnoreCase(respostaCerta);
    }

    public void exibirPergunta() {
        System.out.println(enunciado);
        exibirAlternativas();

    } 

    public String obterAlternativaErrada() {
        return null;
    }

    @Override //sobescrita do método da interface TimedQuestion para perguntas cronometradas
    public boolean tempoEsgotado(long tempoInicio) {
        if (!possuiTempo()) {
            return false;
        }
        long tempoAtual = System.currentTimeMillis();
        long tempoDecorrido = (tempoAtual - tempoInicio) / 1000; //cálculo do tempo decorrido e conversão para segundos
        return tempoDecorrido >= tempoLimite;
    }
    //método abstrato
    public abstract void exibirAlternativas();
}