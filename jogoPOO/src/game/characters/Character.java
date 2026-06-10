/*A base/modelo para os personagens, tanto dos jogadores quanto dos adversários */

package game.characters;

import game.abilities.Ability;

public abstract class Character {
    //atributos básicos
    protected String nomePersonagem;
    protected int hp;
    protected int ataque;
    protected int defesa;
    protected int hpMaximo;
    protected Ability habilidade;
    //atributos de estado/efeito temporário (nem todos precisam ativar)
    protected boolean escudoAtivo;
    protected boolean danoDobrado;
    
    //construtor
        public Character(String nome, int hp, int ataque, int defesa) {
            this.nomePersonagem = nome;
            this.hp = hp;
            this.hpMaximo = hp;
            this.ataque = ataque;
            this.defesa = defesa;
    }

    //métodos
    public boolean estaVivo() {
        return hp > 0;
    }
    public void atacar(Character alvo) { //usar: inimigo->jogador (mais básico)
        alvo.receberDano(this.ataque);
    }
    public void ativarEscudo() {
        escudoAtivo = true;
    }
    public void ativarDanoDobrado() {
        danoDobrado = true;
    }
    public void recuperarVida(int quantidade) {
        hp += quantidade;
        if (hp > hpMaximo) {
            hp = hpMaximo;
        }
    }
    //usar: jogador->inimigo
    public int calcularDano(int dificuldade) {
        int dano = ataque;
        if (danoDobrado) {
            dano *= 2;
            System.out.println(nomePersonagem + " usou dano dobrado!");
            danoDobrado = false;
        }

        if (dificuldade == 2) {
            dano = (int)(dano * 1.5);
        }
        if (dificuldade == 3) {
            dano *= 2;
        }
        return dano;
    }
    public int receberDano(int dano) {
        if (escudoAtivo) {
            escudoAtivo = false;
            System.out.println(nomePersonagem + " bloqueou o ataque com o escudo!");
            return 0;
        }
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
    public boolean isEscudoAtivo() {
        return escudoAtivo;
    }
    public boolean isDanoDobrado() {
        return danoDobrado;
    }
    public Ability getHabilidade() {
        return habilidade;
    }

    //setter
    public void setHabilidade(Ability habilidade) {
        this.habilidade = habilidade;
    }
}