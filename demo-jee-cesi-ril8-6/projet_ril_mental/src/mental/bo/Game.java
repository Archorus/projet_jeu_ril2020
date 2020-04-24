package mental.bo;

public class Game {
    int id;
    int score;
    int level;


    Utilisateur utilisateur;

    public Game() {
    }

    public Game(int id, int score, int level) {
        this.id = id;
        this.score = score;
        this.level = level;
    }

    public Game(int id, int score, int level, Utilisateur utilisateur) {
        this.id = id;
        this.score = score;
        this.level = level;
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
