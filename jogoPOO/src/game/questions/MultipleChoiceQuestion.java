package game.questions;

import java.util.ArrayList;
import java.util.Random;

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
    
    //para a habilidade da Rena Rouge
    @Override //reescrita de obterAlternativaErrada para se adaptar à subclasse (escolher uma alternativa errada aleatoriamente)
    public String obterAlternativaErrada() {
        ArrayList<String> alternativasErradas = new ArrayList<>();
        for (String alternativa : alternativas) {
            String letra = alternativa.substring(0, 1);
            if (!letra.equalsIgnoreCase(getRespostaCerta())) {
                alternativasErradas.add(letra);
            }
        }
        Random random = new Random();
        int indice = random.nextInt(alternativasErradas.size());
        return alternativasErradas.get(indice);
    }
}