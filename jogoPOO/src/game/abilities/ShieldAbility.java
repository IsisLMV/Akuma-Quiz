package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class ShieldAbility extends Ability {
    public ShieldAbility() {
        super("Casulo (Escudo Temporário)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        System.out.println("\n🐢 CASULO!");
        System.out.println("Um campo de força verde protege você. O próximo erro não causará dano!");
        // heroi.getPersonagemSelecionado().setEscudoAtivo(true);
        consumirUso();
    }
}
