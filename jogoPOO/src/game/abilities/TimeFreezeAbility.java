package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class TimeFreezeAbility extends Ability {
    public TimeFreezeAbility() {
        super("Ferroada (Paralisar Temporizador)", 1);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        heroi.getPersonagemSelecionado().ativarTempoCongelado();
        System.out.println("\n🐝 FERROADA!");
        System.out.println("O cronômetro foi paralisado! Você tem tempo a vontade para responder a esta pergunta.");
        consumirUso();
    }
}