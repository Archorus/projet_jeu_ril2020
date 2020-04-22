package mental.bo;

public class Utilisateur {
    int id;
    String name;
    String email;
    String password;
    int score_max;

    public Utilisateur(int id, String name, String email, String password, int score_max) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.score_max = score_max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore_max() {
        return score_max;
    }

    public void setScore_max(int score_max) {
        this.score_max = score_max;
    }
}
