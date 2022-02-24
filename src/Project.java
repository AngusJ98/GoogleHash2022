
import java.util.ArrayList;

public class Project {
    String name;
    int days;
    int score;
    int bestBefore;
    ArrayList<Skill> roles;
    int daysWorkedOn;
    ArrayList<WorkingOn> woking;
    Project(String name, int days, int score, int endDay, ArrayList<Skill> roles) {
        this.name = name;
        this.days = days;
        this.bestBefore = endDay;
        this.roles = roles;
        this.score = score;
    }
    public int getLastestFullDay(){
        return bestBefore-days;
    }
    public boolean readyToGo(){
        if (woking.size() != roles.size()){
            return false;
        } else{
            return true;
        }
    }

}
