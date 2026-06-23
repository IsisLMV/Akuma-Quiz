/*Classe base para todas as habilidades (com controle do limite de usos) */

package game.abilities;

import game.characters.Player;
import game.characters.Enemy;
import game.interfaces.SpecialAbility;

public abstract class Ability implements SpecialAbility {
    protected String nome;
    protected int limiteUsos;
    protected int usosAtuais;

    public Ability(String nome, int limiteUsos) {
        this.nome = nome;
        this.limiteUsos = limiteUsos; // 1 ou 2 usos, dependendo do herói
        this.usosAtuais = 0;
    }

    /*métodos*/
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
        if (usosAtuais < limiteUsos) {
            usosAtuais++;
        }
    }
    //inportante para o reset e para o início de novas fases
    public void resetarUsos() {
        this.usosAtuais = 0;
    }
    //o método ativar será implementado por cada herói individualmente (Polimorfismo)
    public abstract void ativar(Player heroi, Enemy akumatizado);
}
