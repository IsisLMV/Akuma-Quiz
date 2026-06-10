package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class HealAbility extends Ability {
    public HealAbility() {
        super("Miraculous Ladybug (Recuperar Vida)", 2); // 2 usos
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        System.out.println("\n🐞 MIRACULOUS LADYBUG!");
        System.out.println("As joaninhas mágicas consertaram os danos! Você recuperou 30 de vida.");
        // heroi.getPersonagemSelecionado().recuperarVida(30); // Lembre de criar este método no Character
        consumirUso();
    }
}
