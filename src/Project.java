import java.util.ArrayList;

public class Project {
    String name;
    int days;
    int score;
    int endDay;
    ArrayList<Skill> roles;

    Project(String name, int days, int score, int endDay, ArrayList<Skill> roles) {
        this.name = name;
        this.days = days;
        this.endDay = endDay;
        this.roles = roles;
    }
}
