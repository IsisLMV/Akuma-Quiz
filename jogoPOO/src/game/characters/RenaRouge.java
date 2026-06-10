package game.characters;

import game.abilities.HintAbility;

public class RenaRouge extends Character {
    //construtor
    public RenaRouge() {
        super("RenaRouge", 900, 220, 40);
        this.habilidade = new HintAbility();
    }
}