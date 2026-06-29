package game.characters;

import game.abilities.DoubleDamageAbility;

public class CatNoir extends Character {
    //construtor
    public CatNoir() {
        super("Cat Noir", 900, 280, 40);
        this.habilidade = new DoubleDamageAbility();
    }
}