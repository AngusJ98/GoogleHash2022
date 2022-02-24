import java.util.ArrayList;

public class Combiner {
    public Combiner(ArrayList<Project> projects, ArrayList<Contributor> contributors){
        int projectsComplete = 0;
        int days = 0;
        int score = 0;
        while(projectsComplete < projects.size()){
            for (int i = 0; i < projects.size(); i++){
                if(projects.get(i).getComplete()){
                    score = score + projects.get(i).getScore(days);
                    projectsComplete += 1;
                }
            }

            // Code here for assigning people


            for (int i = 0; i < projects.size(); i++){
                if(!projects.get(i).getComplete()){
                    if(projects.get(i).readyToGo()){
                        projects.get(i).daysWorkedOn += 1;
                    }
                }
            }



            days = days+1;
        }
    }
}
