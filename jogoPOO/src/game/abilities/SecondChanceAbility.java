/*Placeholder pra entrega 3*/

package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class SecondChanceAbility extends Ability {
    public SecondChanceAbility() {
        super("Segunda Chance (Tentar Novamente)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        System.out.println("\n🐍 SEGUNDA CHANCE!");
        System.out.println("O ponto de salvamento temporal foi ativado. Se você errar, o tempo voltará para você tentar de novo.");
        // heroi.setSegundaChance(true);
        consumirUso();
    }
}
