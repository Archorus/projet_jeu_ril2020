package mental.bo;

public class Game {
    int id;
    int score;
    int level;
    int difficulte;


    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    int utilisateurId;

    public Game() {
    }

    public Game(int id, int score, int level) {
        this.id = id;
        this.score = score;
        this.level = level;
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

    public Game(int id, int score, int level, int utilisateurId,int difficulte) {
        this.id = id;
        this.score = score;
        this.level = level;
        this.utilisateurId = utilisateurId;
        this.difficulte=difficulte;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
