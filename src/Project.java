import java.util.ArrayList;

public class Project {
    String name;
    int days;
    int score;
    int bestBefore;
    ArrayList<Skill> roles;

    Project(String name, int days, int score, int endDay, ArrayList<Skill> roles) {
        this.name = name;
        this.days = days;
        this.bestBefore = endDay;
        this.roles = roles;
    }
}
