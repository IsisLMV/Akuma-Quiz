/*Classe base para todos os tipos de perguntas (package inteiro)*/

package game.questions;

public abstract class Question {
    //atributos
    protected String enunciado;
    protected String respostaCerta;
    protected int dificuldade;
    //protected String categoria; 

    //construtor
    public Question(String enunciado, String respostaCerta, int dificuldade) {

        this.enunciado = enunciado;
        this.respostaCerta = respostaCerta;
        this.dificuldade = dificuldade;
    }

    //getters
    public String getEnunciado() {
        return enunciado;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    //método
    public boolean verificarResposta(String respostaJogador) {
        return respostaJogador.equalsIgnoreCase(respostaCerta);
    }
    public void exibirPergunta() {
        System.out.println(enunciado);
        exibirAlternativas();

    }
    //método abstrato
    public abstract void exibirAlternativas();
}