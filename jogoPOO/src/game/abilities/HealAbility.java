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
        heroi.getPersonagemSelecionado().recuperarVida(300);
        System.out.println("As joaninhas mágicas consertaram os danos! Você recuperou 300 pontos de vida.");
        consumirUso();
    }
}