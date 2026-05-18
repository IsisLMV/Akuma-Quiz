package game.questions;

public class MultipleChoiceQuestion extends Question {
    //atributo específico
    private String[] alternativas;

    //construtor de Question + atributo específico
    public MultipleChoiceQuestion(String enunciado, String respostaCerta, int dificuldade, String[] alternativas) {
        super(enunciado, respostaCerta, dificuldade);
        this.alternativas = alternativas;
    }

    //getter
    public String[] getAlternativas() {
        return alternativas;
    }

    @Override //reescrita de exibirAlternativas para se adaptar à subclasse
    public void exibirAlternativas() {
        for (String alternativa : alternativas) {
            System.out.println(alternativa);
        }
    }
}