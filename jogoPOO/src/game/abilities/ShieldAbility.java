package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class ShieldAbility extends Ability {
    public ShieldAbility() {
        super("Proteção (Escudo Temporário)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        heroi.getPersonagemSelecionado().ativarEscudo();
        System.out.println("\n🐢 PROTEÇÃO!");
        System.out.println("Um campo de força verde protege você. O próximo erro não causará dano!");
        consumirUso();
    }
}