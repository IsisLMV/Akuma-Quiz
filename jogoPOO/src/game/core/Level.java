/*Controla como deve ser feita a progressão das fases e a narrativa*/
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
    private int dificuldadeCronometrada;
    private boolean todasCronometradas;
    
    // Atributos da narrativa
    private String contexto;
    private String fraseMotivacional;
    private String fraseVitoria;
    private String fraseDerrota;
    
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
    //fase sem cronômetro
    public Level(String nomeFase, Enemy vilao) {
        this(nomeFase, vilao, 0, false);
    }
    
    //fases comuns -> apenas uma dificuldade cronometrada
    public Level(String nomeFase, Enemy vilao, int dificuldadeCronometrada) {
        this(nomeFase, vilao, dificuldadeCronometrada, false);
    }
    
    //fase final -> inclusão do cronômetro em todas as perguntas
    public Level(String nomeFase, Enemy vilao, boolean todasCronometradas) {
        this(nomeFase, vilao, 0, todasCronometradas);
    }
    
    //padrão comum
    public Level(String nomeFase, Enemy vilao, int dificuldadeCronometrada, boolean todasCronometradas) {
        this.nomeFase = nomeFase;
        this.vilao = vilao;
        this.dificuldadeCronometrada = dificuldadeCronometrada;
        this.todasCronometradas = todasCronometradas;
        this.todasFaceis = new ArrayList<>();
        this.todasMedias = new ArrayList<>();
        this.todasDificeis = new ArrayList<>();
        this.faceis = new ArrayList<>();
        this.medias = new ArrayList<>();
        this.dificeis = new ArrayList<>();
        this.faceisUsadas = 0;
        this.mediasUsadas = 0;
        this.dificeisUsadas = 0;
        
        // Configura as frases da história baseado na fase
        configurarNarrativa(this.nomeFase);
    }

    /*método de configuração da história*/
    private void configurarNarrativa(String nomeFase) {
        if (nomeFase.equals("FASE 1")) {
            this.contexto = "Furiosa por ter perdido um concurso sobre meteorologia, Aurora foi akumatizada como TORMENTA e agora quer mergulhar Paris em um inverno eterno de ignorância, congelando todo o progresso científico e tecnológico da cidade.";
            this.fraseMotivacional = "A tempestade lá fora é forte, mas a sua vontade constante de aprender brilha muito mais. Derreta o gelo da TORMENTA com o seu conhecimento!";
            this.fraseVitoria = "O clima esquentou! Você dissipou as nuvens da ignorância e trouxe a luz da educação de volta para Paris!";
            this.fraseDerrota = "Alerta de nevasca! Suas respostas congelaram e a TORMENTA soterrou a cidade no gelo. Aqueça a mente e tente de novo!";
        } 
        else if (nomeFase.equals("FASE 2")) {
            this.contexto = "Depois de uma discussão, o genial e competitivo Max foi akumatizado como JOGADOR e transformou a cidade inteira em um videogame de arena gigante. Ele quer provar que sua tecnologia pode dominar a humanidade e desafia você para um Quiz de Sobrevivência.";
            this.fraseMotivacional = "Ele pode ter os melhores gráficos e algoritmos, mas você tem a melhor estratégia. Suba de nível e mostre que não existe cheat (trapaça) para a verdadeira inteligência!";
            this.fraseVitoria = "Game Over para o JOGADOR! Sua pontuação bateu todos os recordes do servidor. Você zerou essa fase com pura lógica!";
            this.fraseDerrota = "Continue? 9... 8... 7... O JOGADOR zerou sua barra de vida e Paris foi deletada. Volte para o checkpoint e estude um pouco mais os padrões do inimigo!";
        } 
        else if (nomeFase.equals("FASE 3")) {
            this.contexto = "Obcecado por mitologia e frustrado com novas descobertas históricas, Jalil foi akumatizado como FARAÓ e quer reescrever a história e usar rituais antigos para sacrificar o futuro de Paris, trancando todo o conhecimento atual em hieróglifos indecifráveis.";
            this.fraseMotivacional = "O FARAÓ quer nos prender no passado, mas sua mente aberta e disposição de aprender são as chaves para o futuro. Quebre esse feitiço antigo com a sua sabedoria!";
            this.fraseVitoria = "Uma vitória para a modernidade! Você decifrou os enigmas do FARAÓ e protegeu o desenvolvimento da humanidade!";
            this.fraseDerrota = "Você foi mumificado pelas dúvidas... O FARAÓ trancou o conhecimento do mundo em sua pirâmide. Estude os pergaminhos e exija sua revanche!";
        } 
        else if (nomeFase.equals("FASE FINAL")) {
            this.contexto = "Cansado de ver seus akumas falharem, HAWK MOTH sai das sombras e transforma o topo da Torre Eiffel em uma arena de batalha decisiva. Diante de toda Paris, ele ataca sua mente com ilusões e testes de conhecimento extremos para exaurir sua energia e reescrever a realidade com os Miraculous.";
            this.fraseMotivacional = "A ignorância e a manipulação são as maiores armas dele, mas o seu conhecimento é o escudo perfeito. Chegou a hora de purificar Paris de uma vez por todas!";
            this.fraseVitoria = "Miraculous Ladybug! HAWK MOTH recuou da Torre Eiffel para as sombras. Sua inteligência salvou o futuro da cidade e do mundo, e os Miraculous estão seguros!";
            this.fraseDerrota = "Akumas cobriram a Torre Eiffel e toda Paris... HAWK MOTH venceu. Mas um verdadeiro herói sempre aprende com os erros e se levanta para lutar de novo!";
        }
    }

    /*getters*/
    public Enemy getVilao() {
        return vilao;
    }

    public String getNome() {
        return nomeFase;
    }

    public String getContexto() {
        return contexto;
    }

    public String getFraseMotivacional() {
        return fraseMotivacional;
    }

    public String getFraseVitoria() {
        return fraseVitoria;
    }

    public String getFraseDerrota() {
        return fraseDerrota;
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
        //fase 1 = fáceis cronometradas
        //fase 2 = médias cronometradas
        //fase 3 = difíceis cronometradas
        //fase final = todas cronometradas
        if (todasCronometradas || (pergunta.getDificuldade() == dificuldadeCronometrada)) {
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
        //fase 1: 8 fáceis, 8 médias, 4 difíceis
        if (nomeFase.equals("FASE 1")) {
            return selecionarPorRegra(8, 8, 4);
        }
        //fase 2: 4 fáceis, 10 médias, 6 difíceis
        if (nomeFase.equals("FASE 2")) {
            return selecionarPorRegra(4, 10, 6);
        }
        //fase 3: 4 fáceis, 4 médias, 12 difíceis
        if (nomeFase.equals("FASE 3")) {
            return selecionarPorRegra(4, 4, 12);
        }
        //fase final: 2 fácil, 6 médias, 12 difíceis
        if (nomeFase.equals("FASE FINAL")) {
            return selecionarPorRegra(2, 6, 12);
        }
        return null;
    }
}
