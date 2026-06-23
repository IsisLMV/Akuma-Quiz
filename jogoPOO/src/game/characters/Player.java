package game.characters;

public class Player {
    //atributos
    private String nomeUsuario;
    private int pontuacao;
    private Character personagemSelecionado;

    //construtor
    public Player(String nomeUsuario, Character personagemSelecionado) {

        this.nomeUsuario = nomeUsuario;
        this.personagemSelecionado = personagemSelecionado;
        this.pontuacao = 0;

    }

    //getters
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Character getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    //método
    public void adicionarPontuacao(int pontos) {
        pontuacao += pontos;
    }

}