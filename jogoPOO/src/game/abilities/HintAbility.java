package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class HintAbility extends Ability {
    public HintAbility() {
        super("Realidade (Revelar Alternativa Errada)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        heroi.getPersonagemSelecionado().ativarMiragem();
        System.out.println("\n🦊 REALIDADE!");
        consumirUso();
    }
}