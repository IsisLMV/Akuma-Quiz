/*Placeholder pra entrega 3*/

package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class TimeFreezeAbility extends Ability {
    public TimeFreezeAbility() {
        super("Ferroada (Paralisar Temporizador)", 1);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        System.out.println("\n🐝 FERROADA!");
        System.out.println("O tempo foi paralisado! Você tem tempo infinito para responder a esta pergunta.");
        // Lógica a ser conectada com a TimedQuestion
        consumirUso();
    }
}