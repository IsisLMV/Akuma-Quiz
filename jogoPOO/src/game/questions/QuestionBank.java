/*Armazenamento dos objetos do tipo Question*/
package game.questions;

import java.util.ArrayList;
import java.util.Random;
import game.exceptions.PerguntaIndisponivelException;

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
        /*Múltipla escolha - Fácil (Fundamental I)*/
        String[] alternativasF1 = {
            "a) 27",
            "b) 35",
            "c) 29",
            "d) 25"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quanto é 16 + 19?",
                "b",
                1,
                alternativasF1
            )
        );

        String[] alternativasF2 = {
            "a) Azul",
            "b) Verde",
            "c) Roxo",
            "d) Laranja"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual cor resulta da mistura de azul e amarelo?",
                "b",
                1,
                alternativasF2
            )
        );

        String[] alternativasF3 = {
            "a) África",
            "b) Europa",
            "c) América do Sul",
            "d) Oceania"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Em qual continente fica a Inglaterra?",
                "b",
                1,
                alternativasF3
            )
        );

        String[] alternativasF4 = {
            "a) 5",
            "b) 6",
            "c) 7",
            "d) 8"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quantos dias tem uma semana?",
                "c",
                1,
                alternativasF4
            )
        );

        String[] alternativasF5 = {
            "a) Cachorro",
            "b) Cobra",
            "c) Sapo",
            "d) Peixe"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual destes animais é um mamífero?",
                "a",
                1,
                alternativasF5
            )
        );

        String[] alternativasF6 = {
            "a) Machado de Assis",
            "b) Monteiro Lobato",
            "c) Cecília Meireles",
            "d) Ziraldo"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem criou o Sítio do Picapau Amarelo?",
                "b",
                1,
                alternativasF6
            )
        );

        String[] alternativasF7 = {
            "a) Janeiro",
            "b) Março",
            "c) Julho",
            "d) Dezembro"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o sétimo mês do ano?",
                "c",
                1,
                alternativasF7
            )
        );

        String[] alternativasF8 = {
            "a) Netuno",
            "b) Lua",
            "c) Júpiter",
            "d) Saturno"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual o oitavo planeta do Sistema Solar?",
                "a",
                1,
                alternativasF8
            )
        );

        String[] alternativasF9 = {
            "a) 64",
            "b) 56",
            "c) 63",
            "d) 59"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quanto é 7 × 9?",
                "c",
                1,
                alternativasF9
            )
        );

        String[] alternativasF10 = {
            "a) Nariz",
            "b) Orelha",
            "c) Olho",
            "d) Boca"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual órgão usamos para enxergar?",
                "c",
                1,
                alternativasF10
            )
        );

        /*Múltipla Escolha - Média (Fundamental II)*/
        String[] alternativasM11 = {
            "a) Oceano Atlântico",
            "b) Oceano Pacífico",
            "c) Oceano Índico",
            "d) Oceano Ártico"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o maior oceano da Terra?",
                "b",
                2,
                alternativasM11
            )
        );

        String[] alternativasM12 = {
            "a) Mercúrio",
            "b) Vênus",
            "c) Terra",
            "d) Marte"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o planeta conhecido como Planeta Vermelho?",
                "d",
                2,
                alternativasM12
            )
        );

        String[] alternativasM13 = {
            "a) 54",
            "b) 50",
            "c) 42",
            "d) 48"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o resultado de 6 × 8?",
                "d",
                2,
                alternativasM13
            )
        );

        String[] alternativasM14 = {
            "a) Pedro Álvares Cabral",
            "b) Dom Pedro I",
            "c) Vasco da Gama",
            "d) Cristovão Colombo"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem liderou a expedição portuguesa que chegou ao Brasil em 1500?",
                "a",
                2,
                alternativasM14
            )
        );

        String[] alternativasM15 = {
            "a) Nitrogênio",
            "b) Oxigênio",
            "c) Hidrogênio",
            "d) Gás Carbônico"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o gás mais abundante na atmosfera terrestre?",
                "a",
                2,
                alternativasM15
            )
        );

        String[] alternativasM16 = {
            "a) Machado de Assis",
            "b) Monteiro Lobato",
            "c) José de Alencar",
            "d) Clarice Lispector"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem escreveu o livro 'Dom Casmurro'?",
                "a",
                2,
                alternativasM16
            )
        );

        String[] alternativasM17 = {
            "a) Ásia",
            "b) África",
            "c) América",
            "d) Europa"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o continente mais populoso do mundo?",
                "a",
                2,
                alternativasM17
            )
        );

        String[] alternativasM18 = {
            "a) H2O",
            "b) CO2",
            "c) O2",
            "d) NaCl"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é a fórmula química da água?",
                "a",
                2,
                alternativasM18
            )
        );

        String[] alternativasM19 = {
            "a) 1789",
            "b) 1822",
            "c) 1889",
            "d) 1500"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Em que ano foi proclamada a Independência do Brasil?",
                "b",
                2,
                alternativasM19
            )
        );

        String[] alternativasM20 = {
            "a) Java",
            "b) HTML",
            "c) Python",
            "d) CSS"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual destas opções NÃO é uma linguagem de programação?",
                "b",
                2,
                alternativasM20
            )
        );

        String[] alternativasM21 = {
            "a) Substantivo",
            "b) Verbo",
            "c) Adjetivo",
            "d) Pronome"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Na frase 'A menina correu rapidamente', qual é a classe gramatical da palavra 'menina'?",
                "a",
                2,
                alternativasM21
            )
        );

        String[] alternativasM22 = {
            "a) Book",
            "b) Table",
            "c) School",
            "d) Window"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual palavra em inglês significa 'livro'?",
                "a",
                2,
                alternativasM22
            )
        );

        String[] alternativasM23 = {
            "a) Sujeito",
            "b) Predicado",
            "c) Objeto direto",
            "d) Vocativo"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Na frase 'O cachorro latiu durante a noite', qual é o termo 'O cachorro'?",
                "a",
                2,
                alternativasM23
            )
        );

        String[] alternativasM24 = {
            "a) Run",
            "b) Eat",
            "c) Blue",
            "d) Sleep"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual destas palavras em inglês representa uma cor?",
                "c",
                2,
                alternativasM24
            )
        );

        String[] alternativasM25 = {
            "a) Feliz",
            "b) Alegre",
            "c) Contente",
            "d) Triste"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual palavra é antônimo de 'feliz'?",
                "d",
                2,
                alternativasM25
            )
        );

        /*Múltipla Escolha - Difícil (Ensino Médio)*/
        String[] alternativasD26 = {
            "a) Mitocôndria",
            "b) Ribossomo",
            "c) Núcleo",
            "d) Complexo de Golgi"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual organela celular é responsável pela produção da maior parte da energia utilizada pela célula?",
                "a",
                3,
                alternativasD26
            )
        );

        String[] alternativasD27 = {
            "a) Isaac Newton",
            "b) Galileu Galilei",
            "c) Albert Einstein",
            "d) Johannes Kepler"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem formulou a Teoria da Relatividade?",
                "c",
                3,
                alternativasD27
            )
        );

        String[] alternativasD28 = {
            "a) Na",
            "b) N",
            "c) Ne",
            "d) Ni"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o símbolo químico do elemento Nitrogênio?",
                "b",
                3,
                alternativasD28
            )
        );

        String[] alternativasD29 = {
            "a) 12",
            "b) 10",
            "c) 8",
            "d) 6"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o valor de x na equação 2x + 4 = 20?",
                "c",
                3,
                alternativasD29
            )
        );

        String[] alternativasD30 = {
            "a) Revolução Francesa",
            "b) Revolução Industrial",
            "c) Guerra Fria",
            "d) Primeira Guerra Mundial"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual acontecimento histórico teve início em 1789?",
                "a",
                3,
                alternativasD30
            )
        );

        String[] alternativasD31 = {
            "a) Oceania",
            "b) Europa",
            "c) Ásia",
            "d) África"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é o maior continente em extensão territorial?",
                "c",
                3,
                alternativasD31
            )
        );

        String[] alternativasD32 = {
            "a) Machado de Assis",
            "b) Carlos Drummond de Andrade",
            "c) José de Alencar",
            "d) Clarice Lispector"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Quem escreveu a obra 'Memórias Póstumas de Brás Cubas'?",
                "a",
                3,
                alternativasD32
            )
        );

        String[] alternativasD33 = {
            "a) 9,8 m/s²",
            "b) 5 m/s²",
            "c) 20 m/s²",
            "d) 1 m/s²"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual é aproximadamente o valor da aceleração da gravidade na superfície da Terra?",
                "a",
                3,
                alternativasD33
            )
        );

        String[] alternativasD34 = {
            "a) CPU",
            "b) RAM",
            "c) SSD",
            "d) GPU"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual componente é responsável por executar instruções e realizar cálculos em um computador?",
                "a",
                3,
                alternativasD34
            )
        );

        String[] alternativasD35 = {
            "a) HCl",
            "b) NaCl",
            "c) H2SO4",
            "d) NH3"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual composto químico é conhecido popularmente como sal de cozinha?",
                "b",
                3,
                alternativasD35
            )
        );

                String[] alternativasD36 = {
            "a) Barroco",
            "b) Arcadismo",
            "c) Realismo",
            "d) Modernismo"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "A obra 'Memórias Póstumas de Brás Cubas' pertence principalmente a qual movimento literário?",
                "c",
                3,
                alternativasD36
            )
        );

        String[] alternativasD37 = {
            "a) Simple Present",
            "b) Present Continuous",
            "c) Present Perfect",
            "d) Simple Past"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Na frase 'She has studied English for years', qual tempo verbal é utilizado?",
                "c",
                3,
                alternativasD37
            )
        );

        String[] alternativasD38 = {
            "a) Metáfora",
            "b) Hipérbole",
            "c) Eufemismo",
            "d) Antítese"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Na frase 'Ele chorou rios de lágrimas', qual figura de linguagem aparece?",
                "b",
                3,
                alternativasD38
            )
        );

        String[] alternativasD39 = {
            "a) Acento diferencial",
            "b) Crase",
            "c) Concordância verbal",
            "d) Regência nominal"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Em 'Vou à escola', o uso do acento grave indica qual fenômeno gramatical?",
                "b",
                3,
                alternativasD39
            )
        );

        String[] alternativasD40 = {
            "a) Actually",
            "b) Library",
            "c) College",
            "d) Pretend"
        };
        perguntas.add(
            new MultipleChoiceQuestion(
                "Qual palavra em inglês é considerada um falso cognato, podendo ser confundida com 'atualmente'?",
                "a",
                3,
                alternativasD40
            )
        );

        /*Verdadeiro ou Falso - Fácil (Fundamental I)*/
        perguntas.add(
            new TrueFalseQuestion(
                "O Brasil fica na América do Sul.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A água é importante para a vida dos seres vivos.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Um ano possui 12 meses.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Os peixes vivem principalmente na água.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O Sol é um planeta.",
                "F",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O número 10 é maior que o número 5.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "As plantas precisam de luz para crescer.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A girafa é um animal marinho.",
                "F",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A língua oficial do Brasil é o português.",
                "V",
                1
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Uma semana possui 10 dias.",
                "F",
                1
            )
        );

        /*Verdadeiro ou Falso - Médio (Fundamental II)*/
        perguntas.add(
            new TrueFalseQuestion(
                "A camada de ozônio ajuda a proteger a Terra da radiação ultravioleta do Sol.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A Amazônia é a maior floresta tropical do mundo.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Os morcegos são aves porque conseguem voar.",
                "F",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O Brasil possui cinco regiões geográficas oficiais.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O número pi possui valor exato igual a 3.",
                "F",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A velocidade da luz é maior que a velocidade do som.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A fotossíntese é o processo pelo qual as plantas produzem seu próprio alimento.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O Oceano Pacífico é menor que o Oceano Atlântico.",
                "F",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A Terra realiza movimentos de rotação e translação.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Todo número primo é divisível apenas por 1 e por ele mesmo.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Em português, substantivos podem nomear pessoas, lugares, objetos, sentimentos ou ideias.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Em inglês, a palavra 'teacher' significa professor ou professora.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Na frase 'Eles estudam todos os dias', a palavra 'estudam' é um verbo.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Em inglês, o plural regular de muitos substantivos é formado com o acréscimo de 's'.",
                "V",
                2
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A palavra 'jogador' é um verbo.",
                "F",
                2
            )
        );

        /*Verdadeiro ou Falso - Difícil (Ensino Médio)*/
        perguntas.add(
            new TrueFalseQuestion(
                "A mitose produz duas células-filhas geneticamente idênticas à célula original.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A velocidade da luz no vácuo é aproximadamente 300.000 km/s.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O carbono possui número atômico 12.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A Segunda Guerra Mundial terminou em 1945.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Um triângulo pode possuir dois ângulos retos.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A camada de ozônio está localizada principalmente na estratosfera.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O DNA humano utiliza as bases adenina, timina, uracila e guanina.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A meiose produz duas células-filhas geneticamente idênticas à célula original.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A Revolução Francesa ocorreu antes da Independência do Brasil.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Todo número racional é também um número real.",
                "V",
                3
            )
        );

                perguntas.add(
            new TrueFalseQuestion(
                "A crase ocorre, em muitos casos, pela fusão da preposição 'a' com o artigo definido feminino 'a'.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Na voz ativa, o sujeito sofre a ação verbal.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "Em inglês, 'actually' significa sempre 'atualmente'.",
                "F",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "O modo subjuntivo pode expressar hipótese, dúvida ou possibilidade.",
                "V",
                3
            )
        );

        perguntas.add(
            new TrueFalseQuestion(
                "A função metalinguística ocorre quando a linguagem é usada para explicar a própria linguagem.",
                "V",
                3
            )
        );

        /*Múltiplas Respostas - Fácil (Fundamental I)*/
        String[] alternativasF81 = {
            "a) Cachorro",
            "b) Gato",
            "c) Pedra",
            "d) Coelho"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes são animais?",
                "a,b,d",
                1,
                alternativasF81
            )
        );

        String[] alternativasF82 = {
            "a) Vermelho",
            "b) Azul",
            "c) Elefante",
            "d) Amarelo"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são cores?",
                "a,b,d",
                1,
                alternativasF82
            )
        );

        String[] alternativasF83 = {
            "a) Janeiro",
            "b) Fevereiro",
            "c) Julio",
            "d) Março"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são meses do ano?",
                "a,b,d",
                1,
                alternativasF83
            )
        );

        String[] alternativasF84 = {
            "a) Olhos",
            "b) Orelhas",
            "c) Boca",
            "d) Bico"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas partes pertencem ao corpo humano?",
                "a,b,c",
                1,
                alternativasF84
            )
        );

        String[] alternativasF85 = {
            "a) Maçã",
            "b) Banana",
            "c) Cenoura",
            "d) Mesa"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são alimentos?",
                "a,b,c",
                1,
                alternativasF85
            )
        );

        String[] alternativasF86 = {
            "a) Minhoca",
            "b) Lua",
            "c) Estrela",
            "d) Caderno"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes corpos podem ser observados no céu?",
                "b,c",
                1,
                alternativasF86
            )
        );

        String[] alternativasF87 = {
            "a) Adição",
            "b) Subtração",
            "c) Multiplicação",
            "d) Plantação"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções representam operações matemáticas?",
                "a,b,c",
                1,
                alternativasF87
            )
        );

        String[] alternativasF88 = {
            "a) Brasil",
            "b) Madrid",
            "c) Pernambuco",
            "d) Chile"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes são países?",
                "a,d",
                1,
                alternativasF88
            )
        );

        String[] alternativasF89 = {
            "a) Leão",
            "b) Tigre",
            "c) Árvore",
            "d) Gato"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes são animais selvagens?",
                "a,b",
                1,
                alternativasF89
            )
        );

        String[] alternativasF90 = {
            "a) Quadrado",
            "b) Panela",
            "c) Círculo",
            "d) Geladeira"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são figuras geométricas?",
                "a,c",
                1,
                alternativasF90
            )
        );

        /*Múltiplas Respostas - Médio (Fundamental II)*/
        String[] alternativasM91 = {
            "a) Mercúrio",
            "b) Marte",
            "c) Vênus",
            "d) Júpiter"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes são planetas rochosos do Sistema Solar?",
                "a,b,c",
                2,
                alternativasM91
            )
        );

        String[] alternativasM92 = {
            "a) Oxigênio",
            "b) Hidrogênio",
            "c) Água",
            "d) Gás Carbônico"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são elementos químicos?",
                "a,b",
                2,
                alternativasM92
            )
        );

        String[] alternativasM93 = {
            "a) Equador",
            "b) Venezuela",
            "c) Argentina",
            "d) Chile"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes países fazem fronteira com o Brasil?",
                "b,c",
                2,
                alternativasM93
            )
        );

        String[] alternativasM94 = {
            "a) Exponenciação",
            "b) Divisão",
            "c) Fotossíntese",
            "d) Fatoração"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções representam operações matemáticas?",
                "a,b,d",
                2,
                alternativasM94
            )
        );

        String[] alternativasM95 = {
            "a) Cnidários",
            "b) Répteis",
            "c) Anfíbios",
            "d) Poríferos"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes grupos pertencem à classificação dos animais vertebrados?",
                "b,c",
                2,
                alternativasM95
            )
        );

        String[] alternativasM96 = {
            "a) Dom Pedro I",
            "b) Tiradentes",
            "c) Pedro Álvares Cabral",
            "d) Getúlio Vargas"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes personagens fazem parte da História do Brasil Colonial ou Imperial?",
                "a,b,c",
                2,
                alternativasM96
            )
        );

        String[] alternativasM97 = {
            "a) Pepsina",
            "b) Amilase",
            "c) Pepsi",
            "d) Lipase"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são enzimas?",
                "a,b,d",
                2,
                alternativasM97
            )
        );

        String[] alternativasM98 = {
            "a) África",
            "b) Ásia",
            "c) Oceania",
            "d) Amazônia"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são continentes?",
                "a,b,c",
                2,
                alternativasM98
            )
        );

        String[] alternativasM99 = {
            "a) Pulmões",
            "b) Coração",
            "c) Pele",
            "d) Sandália"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes órgãos fazem parte do corpo humano?",
                "a,b,c",
                2,
                alternativasM99
            )
        );

        String[] alternativasM100 = {
            "a) Fotossíntese",
            "b) Respiração",
            "c) Digestão",
            "d) Programação"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destes processos ocorrem em seres vivos?",
                "a,b,c",
                2,
                alternativasM100
            )
        );
        String[] alternativasM101 = {
            "a) Estrelado",
            "b) Escola",
            "c) Frequentemente",
            "d) Cidade"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras são substantivos?",
                "b,d",
                2,
                alternativasM101
            )
        );

        String[] alternativasM102 = {
            "a) Red",
            "b) Blue",
            "c) Chair",
            "d) Green"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras em inglês representam cores?",
                "a,b,d",
                2,
                alternativasM102
            )
        );

        String[] alternativasM103 = {
            "a) Cantando",
            "b) Estudar",
            "c) Dorme",
            "d) Dormir"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras são verbos no infinitivo?",
                "b,d",
                2,
                alternativasM103
            )
        );

        String[] alternativasM104 = {
            "a) I",
            "b) You",
            "c) They",
            "d) There"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras são pronomes pessoais em inglês?",
                "a,b,c",
                2,
                alternativasM104
            )
        );

        String[] alternativasM105 = {
            "a) Mas",
            "b) Porém",
            "c) Entretanto",
            "d) Portanto"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras podem funcionar como conectivos de oposição?",
                "a,b,c",
                2,
                alternativasM105
            )
        );

        /*Múltiplas Respostas - Difícil (Ensino Médio)*/
        String[] alternativas106 = {
            "a) Oxigênio",
            "b) Hidrogênio",
            "c) Carbono",
            "d) Nitrogênio"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais elementos estão presentes na molécula de glicose (C6H12O6)?",
                "a,b,c",
                3,
                alternativas106
            )
        );

        String[] alternativas107 = {
            "a) Parábola",
            "b) Elipse",
            "c) Circunferência",
            "d) Hipérbole"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais são exemplos de seções cônicas?",
                "a,b,c,d",
                3,
                alternativas107
            )
        );

        String[] alternativas108 = {
            "a) Mitose",
            "b) Meiose",
            "c) Fecundação",
            "d) Clonagem"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais processos envolvem divisão celular?",
                "a,b",
                3,
                alternativas108
            )
        );

        String[] alternativas109 = {
            "a) Brasil",
            "b) Rússia",
            "c) Índia",
            "d) China"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais países fazem parte do grupo BRICS desde sua formação original?",
                "a,b,c,d",
                3,
                alternativas109
            )
        );

        String[] alternativas110 = {
            "a) Júpiter",
            "b) Vênus",
            "c) Saturno",
            "d) Netuno"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais planetas são classificados como planetas gasosos?",
                "a,c,d",
                3,
                alternativas110
            )
        );

        String[] alternativas111 = {
            "a) Seno",
            "b) Cosseno",
            "c) Tangente",
            "d) Logaritmo"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais são funções trigonométricas básicas?",
                "a,b,c",
                3,
                alternativas111
            )
        );

        String[] alternativas112 = {
            "a) Fotossíntese",
            "b) Respiração celular",
            "c) Fermentação",
            "d) Digestão"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais processos produzem energia para as células?",
                "b,c",
                3,
                alternativas112
            )
        );

        String[] alternativas113 = {
            "a) Newton",
            "b) Joule",
            "c) Watt",
            "d) Kelvin"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais são unidades derivadas do Sistema Internacional de Unidades (SI)?",
                "a,b,c",
                3,
                alternativas113
            )
        );

        String[] alternativas114 = {
            "a) Dom Casmurro",
            "b) Memórias Póstumas de Brás Cubas",
            "c) O Cortiço",
            "d) Iracema"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais obras foram escritas por Machado de Assis?",
                "a,b",
                3,
                alternativas114
            )
        );

        String[] alternativas115 = {
            "a) ATP",
            "b) DNA",
            "c) RNA",
            "d) Ácido Fosforoso"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais das opções contêm fósforo em sua estrutura?",
                "a,b,c,d",
                3,
                alternativas115
            )
        );

                String[] alternativasD116 = {
            "a) Metáfora",
            "b) Hipérbole",
            "c) Ironia",
            "d) Comparação"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são figuras de linguagem?",
                "a,b,c,d",
                3,
                alternativasD116
            )
        );

        String[] alternativasD117 = {
            "a) Actually",
            "b) Pretend",
            "c) Library",
            "d) House"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas palavras em inglês podem ser consideradas falsos cognatos para falantes de português?",
                "a,b,c",
                3,
                alternativasD117
            )
        );

        String[] alternativasD118 = {
            "a) Realismo",
            "b) Romantismo",
            "c) Modernismo",
            "d) Fototropismo"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são movimentos literários?",
                "a,b,c",
                3,
                alternativasD118
            )
        );

        String[] alternativasD119 = {
            "a) Present Perfect",
            "b) Simple Past",
            "c) Future with will",
            "d) Predicate"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções representam tempos ou estruturas verbais em inglês?",
                "a,b,c",
                3,
                alternativasD119
            )
        );

        String[] alternativasD120 = {
            "a) Sujeito",
            "b) Predicado",
            "c) Objeto direto",
            "d) Advérbio"
        };
        perguntas.add(
            new MultipleAnswerQuestion(
                "Quais destas opções são termos estudados na análise sintática?",
                "a,b,c",
                3,
                alternativasD120
            )
        );
    }

    //retorna uma pergunta aleatória e tira do banco (vai perder o uso no jogo principal)
    //se der tempo, criamos outros métodos de jogo
    public Question getPerguntaAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(perguntas.size());
        return perguntas.remove(indice);
    }

    //retorna pergunta aleatória filtrada por dificuldade + tratativa de erro
    public Question getPerguntaAleatoriaPorDificuldade(int dificuldade) throws PerguntaIndisponivelException {
        ArrayList<Question> perguntasFiltradas = new ArrayList<>();
        //percorre todas as perguntas para criar uma nova lista filtrada
        for (Question pergunta : perguntas) {
            if (pergunta.getDificuldade() == dificuldade) {
                perguntasFiltradas.add(pergunta);
            }
        }
        if (perguntasFiltradas.isEmpty()) {
            throw new PerguntaIndisponivelException("Não há perguntas disponíveis para a dificuldade " + dificuldade + ".");
        }

        //sorteio dentro das filtradas
        Random random = new Random();
        Question perguntaEscolhida = perguntasFiltradas.get(random.nextInt(perguntasFiltradas.size()));
        perguntas.remove(perguntaEscolhida); //remove do banco original
        return perguntaEscolhida;
    }
}