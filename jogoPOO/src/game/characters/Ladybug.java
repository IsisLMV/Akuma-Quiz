package game.characters;

import game.abilities.HealAbility;

public class Ladybug extends Character {
    //construtor
    public Ladybug() {
        super("Ladybug", 1000, 220, 50);
        this.habilidade = new HealAbility();
    }
}