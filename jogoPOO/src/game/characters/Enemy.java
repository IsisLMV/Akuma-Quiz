package game.characters;

public class Enemy {
    //atributo
    private Character personagemInimigo;

    // construtor
    public Enemy(Character personagem) {
        this.personagemInimigo = personagem;
    }

    // getter
    public Character getPersonagem() {
        return personagemInimigo;
    }
}
