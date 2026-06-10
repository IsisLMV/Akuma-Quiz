package game.characters;

import game.abilities.SecondChanceAbility;

public class Viperion extends Character {
    //construtor
    public Viperion() {
        super("Viperion", 1000, 200, 50);
        this.habilidade = new SecondChanceAbility();
    }
}