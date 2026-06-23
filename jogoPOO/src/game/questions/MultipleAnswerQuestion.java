package game.questions;

import game.exceptions.EntradaInvalidaException;
import java.util.HashSet;

public class MultipleAnswerQuestion extends Question {
    /*atributo específico*/
    private String[] alternativas;

    /*construtor de Question + atributo específico*/
    public MultipleAnswerQuestion(String enunciado, String respostaCerta, int dificuldade, String[] alternativas) {
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
        String respostaNormalizada = respostaJogador.toLowerCase().replace(" ", "");
        String[] respostas = respostaNormalizada.split(",");
        HashSet<String> alternativasValidas = new HashSet<>();
        for (String alternativa : alternativas) {
            alternativasValidas.add(alternativa.substring(0, 1).toLowerCase());
        }
        HashSet<String> respostasUsadas = new HashSet<>();
        for (String resposta : respostas) {
            if (resposta.isEmpty()) {
                throw new EntradaInvalidaException("Entrada inválida! Use o formato a,c ou a,b,d.");
            }
            if (!alternativasValidas.contains(resposta)) {
                throw new EntradaInvalidaException("Alternativa inválida: " + resposta + ". Escolha apenas alternativas exibidas.");
            }
            if (respostasUsadas.contains(resposta)) {
                throw new EntradaInvalidaException("Entrada inválida! Não repita alternativas.");
            }
            respostasUsadas.add(resposta);
        }
    }

    @Override //reescrita de exibirAlternativas para se adaptar à subclasse
    public void exibirAlternativas() {
        for (String alternativa : alternativas) {
            System.out.println(alternativa);
        }

        System.out.println();
        System.out.println("Digite as letras separadas por vírgula.");
        System.out.println("Exemplo: a,c");
    }

    @Override //reescrita de verificarResposta para recebeer mais alternativas e se adaptar à ordem do usuário
    public boolean verificarResposta(String respostaJogador) {
        //1º) deixar resposta case insensitive e sem espaços
        String respostaNormalizada = respostaJogador.toLowerCase().replace(" ", "");
        String respostaCorretaNormalizada = respostaCerta.toLowerCase().replace(" ", "");
        //2º) separar as alternativas pela vírgula e guardar em arrays
        String[] alternativasJogador = respostaNormalizada.split(",");
        String[] alternativasCorretas = respostaCorretaNormalizada.split(",");
        //3º) organização
        java.util.Arrays.sort(alternativasJogador);
        java.util.Arrays.sort(alternativasCorretas);
        //4º) comparação
        return java.util.Arrays.equals(alternativasJogador, alternativasCorretas);
    }
}
