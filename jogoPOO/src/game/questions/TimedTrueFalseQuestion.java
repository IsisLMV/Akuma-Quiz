package game.questions;

import game.interfaces.TimedQuestion;

public class TimedTrueFalseQuestion extends TrueFalseQuestion implements TimedQuestion {
    //atributo específico
    private int tempoLimite;

    //construtor  de TrueFalseQuestion + atributo específico
    public TimedTrueFalseQuestion(String enunciado, String respostaCerta, int dificuldade, int tempoLimite) {
        super(enunciado, respostaCerta, dificuldade);
        this.tempoLimite = tempoLimite;
    }

    @Override //sobescrita do getter da interface TimedQuestion
    public int getTempoLimite() {
        return tempoLimite;
    }

    @Override //sobescrita do método da interface TimedQuestion
    public boolean tempoEsgotado(long tempoInicio) {
        long tempoAtual = System.currentTimeMillis();
        long tempoDecorrido = (tempoAtual - tempoInicio) / 1000; //cálculo do tempo decorrido e conversão para segundos
        return tempoDecorrido > tempoLimite;
    }
}
