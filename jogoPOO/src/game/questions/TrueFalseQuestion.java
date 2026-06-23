package game.questions;

import game.exceptions.EntradaInvalidaException;

public class TrueFalseQuestion extends Question {
    /*construtor de Question*/
    public TrueFalseQuestion(String enunciado, String respostaCerta, int dificuldade) {
        super(enunciado, respostaCerta, dificuldade);
    }

    /*métodos*/
    @Override //reescrita de validarResposta para se adaptar à subclasse
    public void validarResposta(String respostaJogador) throws EntradaInvalidaException {
        super.validarResposta(respostaJogador); //chama da classe mãe
        String resposta = respostaJogador.trim().toLowerCase();
        if (!resposta.equals("v") && !resposta.equals("f")) {
            throw new EntradaInvalidaException("Entrada inválida! Digite apenas V para verdadeiro ou F para falso.");
        }
    }

    @Override //reescrita de exibirAlternativas para se adaptar à subclasse
    public void exibirAlternativas() {
        System.out.println("V) Verdadeiro");
        System.out.println("F) Falso");
    }
}