package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class SecondChanceAbility extends Ability {
    public SecondChanceAbility() {
        super("Segunda Chance (Tentar Novamente)", 2);
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        heroi.getPersonagemSelecionado().ativarSegundaChance();
        System.out.println("\n🐍 SEGUNDA CHANCE!");
        System.out.println("Você poderá tentar responder novamente caso erre a próxima pergunta.");
        consumirUso();
    }
}
