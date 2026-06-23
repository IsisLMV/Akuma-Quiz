package game.questions;

import java.util.ArrayList;
import java.util.Random;
import game.exceptions.EntradaInvalidaException;

public class MultipleChoiceQuestion extends Question {
    /*atributo específico*/
    private String[] alternativas;

    /*construtor de Question + atributo específico*/
    public MultipleChoiceQuestion(String enunciado, String respostaCerta, int dificuldade, String[] alternativas) {
        super(enunciado, respostaCerta, dificuldade);
        this.alternativas = alternativas;
    }

    /*getter*/
    public String[] getAlternativas() {
        return alternativas;
    }

    /*métodos*/
    @Override //reescrita de validarResposta para se adaptar à subclasse
    public void validarResposta(String respostaJogador) throws EntradaInvalidaException {
        super.validarResposta(respostaJogador); //chama da classe mãe
        String resposta = respostaJogador.trim().toLowerCase();
        if (resposta.length() != 1) {
            throw new EntradaInvalidaException("Entrada inválida! Digite apenas uma alternativa, como a, b, c ou d.");
        }
        for (String alternativa : alternativas) {
            String letra = alternativa.substring(0, 1).toLowerCase();

            if (resposta.equals(letra)) {
                return;
            }
        }
        throw new EntradaInvalidaException("Alternativa inválida! Escolha uma das alternativas exibidas.");
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