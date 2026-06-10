package game.characters;

import game.abilities.TimeFreezeAbility;

public class Vesperia extends Character {
    //construtor
    public Vesperia() {
        super("Vesperia", 950, 250, 40);
        this.habilidade = new TimeFreezeAbility();
    }
}