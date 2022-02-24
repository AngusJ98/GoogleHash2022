import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Combiner {
    public Combiner(ArrayList<Project> projects, ArrayList<Contributor> contributors){
        int projectsComplete = 0;
        int days = 0;
        int score = 0;
        while(projectsComplete < projects.size()){
            ArrayList<Project> incompleteProjs = new ArrayList<>();
            for (int i = 0; i < projects.size(); i++){
                if(projects.get(i).getComplete()){
                    score = score + projects.get(i).getScore(days);
                    projectsComplete += 1;
                } else if (projects.get(i).woking.size() == 0){
                    incompleteProjs.add(projects.get(i));
                }
            }

            // Code here for assigning people
            ArrayList<Contributor> availableConts = new ArrayList<>();
            for (Contributor i : contributors) {
                if (!i.isWorking) {
                    availableConts.add(i);
                } 
            }

            //sort incompleteProjs
            Collections.sort(incompleteProjs, Comparator.comparingDouble(proj -> proj.scorePerDay()));

            for (Project i : incompleteProjs) {

                

                //grab people
                ArrayList<Skill> requiredSkills = i.roles;
                ArrayList<Contributor> currentCont = new ArrayList<>();
                

                for (Skill j : requiredSkills) {
                    Collections.sort(availableConts, Comparator.comparingDouble(cont -> cont.perform(j.Skill)));
                }

            }




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
