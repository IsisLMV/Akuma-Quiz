/*A base/modelo para os personagens, tanto dos jogadores quanto dos adversários */

package game.characters;

public abstract class Character {
    //atributos
    protected String nomePersonagem;
    protected int hp;
    protected int ataque;
    protected int defesa;
    
    //construtor
        public Character(String nome, int hp, int ataque, int defesa) {
        this.nomePersonagem = nome;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    //métodos
    public boolean estaVivo() {
        return hp > 0;
    }
    public int receberDano(int dano) {
        int danoReal = dano - defesa;
        
        if (danoReal < 0) { // estabelece dano mínimo e evita dano negativo
            danoReal = 0;
        }
        hp -= danoReal;
        // evita hp negativo
        if (hp < 0) {
            hp = 0;
        }
        return danoReal;
    }
    public void atacar(Character alvo) {
        alvo.receberDano(this.ataque);
    }

    //getters (importante para a escrever no console/ mostrar na interface)
    public String getNomePersonagem() {
    return nomePersonagem;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }
}