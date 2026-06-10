package game.abilities;

import game.characters.Player;
import game.characters.Enemy;
import game.interfaces.SpecialAbility;

/**
 * Classe base para todas as habilidades. Controle do limite de usos.
 */
public abstract class Ability implements SpecialAbility {
    protected String nome;
    protected int limiteUsos;
    protected int usosAtuais;

    public Ability(String nome, int limiteUsos) {
        this.nome = nome;
        this.limiteUsos = limiteUsos; // 1 ou 2 usos, dependendo do herói
        this.usosAtuais = 0;
    }

    @Override
    public String getNome() {
        return nome + " (Usos: " + (limiteUsos - usosAtuais) + ")";
    }

    @Override
    public boolean podeUsar() {
        return usosAtuais < limiteUsos;
    }

    @Override
    public void consumirUso() {
        this.usosAtuais++;
    }

    // O método ativar será implementado por cada herói individualmente (Polimorfismo)
    public abstract void ativar(Player heroi, Enemy akumatizado);
}
