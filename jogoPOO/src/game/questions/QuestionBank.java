/*Armazenamento dos objetos do tipo Question*/
package game.questions;

import java.util.ArrayList;
import java.util.Random;

public class QuestionBank {

    //atributo para lista de perguntas
    private ArrayList<Question> perguntas;

    //construtor
    public QuestionBank() {

        perguntas = new ArrayList<>();

        carregarPerguntas();

    }

    //métodos
    private void carregarPerguntas() {
        /*Múltipla escolha*/
        String[] alternativas1 = {
            "a) Brasil, Argentina e Uruguai",
            "b) Estados Unidos, Canadá e México",
            "c) Alemanha, França e Itália",
            "d) Espanha, Portugal e Marrocos"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "A Copa do Mundo FIFA de 2026 será histórica por ser sediada em três países simultaneamente. Quais são esses países?",
                "b",
                1,
                alternativas1
            )
        );

        String[] alternativas2 = {
            "a) Vênus",
            "b) Júpiter",
            "c) Marte",
            "d) Saturno"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual planeta do sistema solar é conhecido como Planeta Vermelho?",
                "c",
                1,
                alternativas2
            )
        );

        String[] alternativas3 = {
            "a) Oceano Atlântico",
            "b) Oceano Índico",
            "c) Oceano Ártico",
            "d) Oceano Pacífico"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o maior oceano da Terra?",
                "d",
                1,
                alternativas3
            )
        );

        String[] alternativas4 = {
            "a) 16",
            "b) 24",
            "c) 32",
            "d) 48"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quantas seleções participarão da Copa do Mundo de 2026?",
                "d",
                2,
                alternativas4
            )
        );

        String[] alternativas5 = {
            "a) Jardins Suspensos da Babilônia",
            "b) Colosso de Rodes",
            "c) Farol de Alexandria",
            "d) Grande Pirâmide de Gizé"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual das Sete Maravilhas do Mundo Antigo ainda existe?",
                "d",
                2,
                alternativas5
            )
        );

        String[] alternativas6 = {
            "a) Leopardo",
            "b) Guepardo",
            "c) Leão",
            "d) Antílope"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o animal terrestre mais rápido do mundo?",
                "b",
                2,
                alternativas6
            )
        );

        String[] alternativas7 = {
            "a) Tungstênio",
            "b) Bismuto",
            "c) Potássio",
            "d) Rádio"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual elemento químico possui símbolo 'W'?",
                "a",
                3,
                alternativas7
            )
        );

        String[] alternativas8 = {
            "a) Rússia",
            "b) Estados Unidos",
            "c) França",
            "d) China"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual país possui o maior número de fusos horários?",
                "c",
                3,
                alternativas8
            )
        );

        String[] alternativas9 = {
            "a) Aldous Huxley",
            "b) Ray Bradbury",
            "c) George Orwell",
            "d) Isaac Asimov"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem escreveu o livro '1984'?",
                "c",
                3,
                alternativas9
            )
        );

        String[] alternativas10 = {
            "a) 7",
            "b) 8",
            "c) 9",
            "d) 10"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quantos planetas existem oficialmente no Sistema Solar?",
                "b",
                1,
                alternativas10
            )
        );

        String[] alternativas11 = {
            "a) Brasília",
            "b) Rio de Janeiro",
            "c) São Paulo",
            "d) Salvador"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é a capital do Brasil?",
                "a",
                1,
                alternativas11
            )
        );

        String[] alternativas12 = {
            "a) Machado de Assis",
            "b) José de Alencar",
            "c) Carlos Drummond de Andrade",
            "d) Clarice Lispector"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem escreveu 'Dom Casmurro'?",
                "a",
                2,
                alternativas12
            )
        );

        String[] alternativas13 = {
            "a) H2O",
            "b) CO2",
            "c) O2",
            "d) NaCl"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é a fórmula química da água?",
                "a",
                1,
                alternativas13
            )
        );

        String[] alternativas14 = {
            "a) 1914",
            "b) 1939",
            "c) 1945",
            "d) 1960"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Em que ano começou a Segunda Guerra Mundial?",
                "b",
                2,
                alternativas14
            )
        );

        String[] alternativas15 = {
            "a) Linux",
            "b) Windows",
            "c) Java",
            "d) Python"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual das opções abaixo é uma linguagem de programação?",
                "c",
                1,
                alternativas15
            )
        );

        String[] alternativas16 = {
            "a) Mercúrio",
            "b) Vênus",
            "c) Terra",
            "d) Marte"
        };
        perguntas.add(
            new TimedMultipleChoiceQuestion(
                "Qual é o terceiro planeta do Sistema Solar?",
                "c",
                1,
                alternativas16,
                10
            )
        );

        String[] alternativas17 = {
            "a) 100",
            "b) 206",
            "c) 300",
            "d) 150"
        };
        perguntas.add(
            new TimedMultipleChoiceQuestion(
                "Quantos ossos possui o corpo humano adulto?",
                "b",
                2,
                alternativas17,
                8
            )
        );

        String[] alternativas18 = {
            "a) Java",
            "b) Python",
            "c) HTML",
            "d) C"
        };
        perguntas.add(
            new TimedMultipleChoiceQuestion(
                "Qual destas NÃO é uma linguagem de programação?",
                "c",
                2,
                alternativas18,
                7
            )
        );

        /*Múltiplas alternativas*/
        String[] alternativas19 = {
            "a) Java",
            "b) HTML",
            "c) Python",
            "d) CSS"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas são linguagens de programação?",
                "a,c",
                2,
                alternativas19
            )
        );

        String[] alternativas20 = {
            "a) Mamífero",
            "b) Ave",
            "c) Réptil",
            "d) Peixe"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes grupos possuem espécies que podem voar?",
                "a,b",
                2,
                alternativas20
            )
        );

        String[] alternativas21 = {
            "a) Mercúrio",
            "b) Marte",
            "c) Vênus",
            "d) Júpiter"
        };

        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes são planetas rochosos?",
                "a,b,c",
                3,
                alternativas21
            )
        );

        /*V ou F*/
        perguntas.add(
            new TrueFalseQuestion("Java é uma linguagem orientada a objetos.", "V", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("O Sol é um planeta.", "F", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("A água ferve a 100 graus Celsius ao nível do mar.", "V", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("HTML é uma linguagem de programação.", "F", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("O Brasil fica na América do Sul.", "V", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("A velocidade da luz é maior que a velocidade do som.", "V", 2)
        );
        perguntas.add(
            new TrueFalseQuestion("Os morcegos são aves.", "F", 2)
        );
        perguntas.add(
            new TrueFalseQuestion("A Terra possui apenas um satélite natural.", "V", 2)
        );
        perguntas.add(
            new TrueFalseQuestion("Python foi criada antes da linguagem Java.", "V", 3)
        );
        perguntas.add(
            new TrueFalseQuestion("O Monte Everest é a montanha mais alta do mundo.", "V", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("O Japão está localizado na Europa.", "F", 1)
        );
        perguntas.add(
            new TrueFalseQuestion("A Amazônia é a maior floresta tropical do mundo.", "V", 2)
        );
        perguntas.add(new TrueFalseQuestion("O número pi possui valor exato igual a 3.", "F", 2)
        );
        perguntas.add(
            new TrueFalseQuestion("A linguagem Java foi criada pela Sun Microsystems.", "V", 3)
        );
        perguntas.add(
            new TrueFalseQuestion("O ser humano possui 206 ossos no corpo adulto.", "V", 2)
        );
        perguntas.add(
            new TimedTrueFalseQuestion("A Lua é um planeta.", "F", 1, 8)
        );
        perguntas.add(
            new TimedTrueFalseQuestion(
                "A velocidade da luz é maior que a velocidade do som.", "V", 2, 6)
        );
        perguntas.add(
            new TimedTrueFalseQuestion("O Brasil possui cinco regiões geográficas.", "V", 1, 8)
        );
    }

    // retorna pergunta aleatória
    public Question getPerguntaAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(perguntas.size());
        return perguntas.get(indice);
    }
}