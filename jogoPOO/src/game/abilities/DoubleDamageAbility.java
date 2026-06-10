package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

public class DoubleDamageAbility extends Ability {
    public DoubleDamageAbility() {
        super("Cataclismo (Dobrar Dano)", 1); // 1 uso (é muito forte)
    }

    @Override
    public void ativar(Player heroi, Enemy akumatizado) {
        heroi.getPersonagemSelecionado().ativarDanoDobrado();
        System.out.println("\n🐾 CATACLISMO!");
        System.out.println("O poder da destruição foi ativado! Seu próximo acerto causará o dobro de dano no akumatizado!");
        consumirUso();
    }
}