package game.abilities;

import game.characters.Player;
import game.characters.Enemy;

/**
 * Interface que define o contrato para poderes especiais.
 * Atende ao requisito "Uso de interfaces" da Entrega 2.
 */
public interface SpecialAbility {
    String getNome();
    boolean podeUsar();
    void consumirUso();
    void ativar(Player heroi, Enemy akumatizado);
}
