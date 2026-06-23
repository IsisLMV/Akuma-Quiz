/*Gerencia a criação dos personagens (ajuda a desacoplar de Game.java)*/
package game.characters;

public class CharacterFactory {
    // método principal
    public static Character criar(int escolha) {
        switch (escolha) {
            case 1: return new Ladybug();
            case 2: return new CatNoir();
            case 3: return new Carapace();
            case 4: return new RenaRouge();
            case 5: return new Viperion();
            case 6: return new Vesperia();
            default: return new Ladybug();
        }
    }
}