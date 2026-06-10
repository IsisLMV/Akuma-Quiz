package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

/**
 * Interface que define o contrato para poderes especiais.
 */
public interface SpecialAbility {
    String getNome();
    boolean podeUsar();
    void consumirUso();
    void ativar(Player heroi, Enemy akumatizado);
}
