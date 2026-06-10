/*Placeholder pra entrega 3*/
package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class HintAbility extends Ability {
    public HintAbility() {
        super("Miragem (Criar Ilusão nas Alternativas)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        System.out.println("\n🦊 MIRAGEM!");
        System.out.println("Uma ilusão escondeu algumas das alternativas erradas!");
        // Lógica a ser conectada com a Question atual na rodada
        consumirUso();
    }
}