package game.characters;

import game.abilities.ShieldAbility;

public class Carapace extends Character {
    //construtor
    public Carapace () {
        super("Carapace", 1200, 180, 80);
        this.habilidade = new ShieldAbility();
    }
}