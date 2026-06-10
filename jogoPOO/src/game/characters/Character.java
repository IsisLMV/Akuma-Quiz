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
    //atributos de estado/efeito temporário para as habilidades (nem todos precisam ativar)
    protected boolean escudoAtivo; //Carapace
    protected boolean danoDobrado; //Cat Noir
    protected boolean segundaChanceAtiva; //Viperion
    protected boolean tempoCongelado; //Vesperia
    protected boolean miragemAtiva; //Rena Rouge
    
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
    public void ativarEscudo() {
        escudoAtivo = true;
    }
    public void ativarDanoDobrado() {
        danoDobrado = true;
    }
    public void ativarSegundaChance() {
        segundaChanceAtiva = true;
    }
    public void desativarSegundaChance() {
        segundaChanceAtiva = false;
    }
    public void ativarTempoCongelado() {
        tempoCongelado = true;
    }
    public void desativarTempoCongelado() {
        tempoCongelado = false;
    }
    public void ativarMiragem() {
        miragemAtiva = true;
    }
    public void desativarMiragem() {
        miragemAtiva = false;
    }
    public void recuperarVida(int quantidade) {
        hp += quantidade;
        if (hp > hpMaximo) {
            hp = hpMaximo;
        }
    }
    public void atacar(Character alvo) { //usar: inimigo->jogador (mais básico)
        alvo.receberDano(this.ataque);
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
    public Ability getHabilidade() {
        return habilidade;
    }
    public boolean isEscudoAtivo() {
        return escudoAtivo;
    }
    public boolean isDanoDobrado() {
        return danoDobrado;
    }
    public boolean isSegundaChanceAtiva() {
        return segundaChanceAtiva;
    }
    public boolean isTempoCongelado() {
        return tempoCongelado;
    }
    public boolean isMiragemAtiva() {
        return miragemAtiva;
    }

    //setter
    public void setHabilidade(Ability habilidade) {
        this.habilidade = habilidade;
    }
}