package game.questions;

public class MultipleAnswerQuestion extends Question {
    //atributo específico
    private String[] alternativas;

    //construtor de Question + atributo específico
    public MultipleAnswerQuestion(String enunciado, String respostaCerta, int dificuldade, String[] alternativas) {
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
