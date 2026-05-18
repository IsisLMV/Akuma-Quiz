package game.questions;

public class TrueFalseQuestion extends Question {

    //construtor de Question
    public TrueFalseQuestion(String enunciado, String respostaCerta, int dificuldade) {
        super(enunciado, respostaCerta, dificuldade);
    }

    @Override //reescrita de exibirAlternativas para se adaptar à subclasse
    public void exibirAlternativas() {
        System.out.println("V) Verdadeiro");
        System.out.println("F) Falso");
    }
}