/*Controla como deve ser feita a progressão das fases*/
package game.core;


import game.characters.Enemy;
import game.questions.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Level {
    /*atributos*/
    private String nomeFase;
    private Enemy vilao;
    private boolean perguntasCronometradas;
    //cópias das listas inalteradas para ajudar no reset da fase em caso de derrota
    private List<Question> todasFaceis;
    private List<Question> todasMedias;
    private List<Question> todasDificeis;
    //listas que vão sendo usadas e alteradas
    private List<Question> faceis;
    private List<Question> medias;
    private List<Question> dificeis;
    //contadores
    private int faceisUsadas;
    private int mediasUsadas;
    private int dificeisUsadas;

    /*construtores*/
    //padrão: fases comuns
    public Level(String nomeFase, Enemy vilao) {
        this(nomeFase, vilao, false);
    }
    //fase final (inclusão do cronômetro)
    public Level(String nomeFase, Enemy vilao, boolean perguntasCronometradas) {
        this.nomeFase = nomeFase;
        this.vilao = vilao;
        this.perguntasCronometradas = perguntasCronometradas;
        this.todasFaceis = new ArrayList<>();
        this.todasMedias = new ArrayList<>();
        this.todasDificeis = new ArrayList<>();
        this.faceis = new ArrayList<>();
        this.medias = new ArrayList<>();
        this.dificeis = new ArrayList<>();
        this.faceisUsadas = 0;
        this.mediasUsadas = 0;
        this.dificeisUsadas = 0;
    }


    /*getter*/
    public Enemy getVilao() {
        return vilao;
    }

    public String getNome() {
        return nomeFase;
    }


    /*métodos*/
    public void reset() {
        //reinicia contadores, as listas e a vida do vilão da fase
        faceisUsadas = 0;
        mediasUsadas = 0;
        dificeisUsadas = 0;
        faceis = new ArrayList<>(todasFaceis);
        medias = new ArrayList<>(todasMedias);
        dificeis = new ArrayList<>(todasDificeis);
        vilao.getPersonagem().restaurarEstado();
    }

    private Question prepararPergunta(Question pergunta) {
        if (perguntasCronometradas) {
            pergunta.ativarTempo();
        }

        return pergunta;
    }

    public void adicionarPergunta(Question pergunta) {
        switch (pergunta.getDificuldade()) {
            case 1:
                faceis.add(pergunta);
                todasFaceis.add(pergunta);
                break;
            case 2:
                medias.add(pergunta);
                todasMedias.add(pergunta);
                break;
            case 3:
                dificeis.add(pergunta);
                todasDificeis.add(pergunta);
                break;
        }
    }

    private Question selecionarPorRegra(int maxFaceis, int maxMedias, int maxDificeis) {
        Random random = new Random();
        if (faceisUsadas < maxFaceis){
            if (!faceis.isEmpty()) {
                faceisUsadas++;
                return prepararPergunta(faceis.remove(random.nextInt(faceis.size())));
            }
        }
        if (mediasUsadas < maxMedias){
            if(!medias.isEmpty()) {
                mediasUsadas++;
                return prepararPergunta(medias.remove(random.nextInt(medias.size())));
            }
        }
        if (dificeisUsadas < maxDificeis){
            if(!dificeis.isEmpty()) {
                dificeisUsadas++;
                return prepararPergunta(dificeis.remove(random.nextInt(dificeis.size())));
            }
        }
        return null;
    }

    //método essêncial para diferenciar as fases (cada uma tem uma proporção diferente)
    public Question getProximaPergunta() {
        //fase 1: 10 fáceis, 6 médias, 4 difíceis
        if (nomeFase.equals("Fase 1")) {
            return selecionarPorRegra(10, 6, 4);
        }
        //fase 2: 6 fáceis, 10 médias, 4 difíceis
        if (nomeFase.equals("Fase 2")) {
            return selecionarPorRegra(6, 10, 4);
        }
        //fase 3: 4 fáceis, 6 médias, 10 difíceis
        if (nomeFase.equals("Fase 3")) {
            return selecionarPorRegra(4, 6, 10);
        }
        //fase final: 2 fácil, 8 médias, 10 difíceis
        if (nomeFase.equals("Fase Final")) {
            return selecionarPorRegra(2, 8, 10);
        }
        return null;
    }
}