package game.interfaces;

public interface TimedQuestion {

    int getTempoLimite();
    boolean tempoEsgotado(long tempoInicio);
}