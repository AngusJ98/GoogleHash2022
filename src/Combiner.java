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



            //sort incompleteProjs
            Collections.sort(incompleteProjs, Comparator.comparingDouble(proj -> proj.scorePerDay()));

            for (Project i : incompleteProjs) {

                ArrayList<Contributor> availableConts = new ArrayList<>();
                for (Contributor j : contributors) {
                    if (!j.isWorking) {
                        availableConts.add(j);
                    }
                }
                ArrayList<Skill> requiredSkills = i.roles;
                boolean personFound = false;
                int roleLooking = 0;
                boolean canMentor = false;
                int skillReq = i.roles.get(roleLooking).skillLevel;
                for (int people = 0; people < i.woking.size(); people++){
                    if (i.woking.get(people).contrib.getSkill(i.roles.get(roleLooking).skillName).skillLevel >= skillReq){
                        canMentor = true;
                    }
                }
                int valueLookingFor;
                if (canMentor){
                    valueLookingFor = 1;
                } else {
                    valueLookingFor = 2;
                }
                int increment = 0;
                boolean cantComplete = false;
                while(!personFound){
                    increment += 1;
                    if (increment == availableConts.size()){
                        if (valueLookingFor == 1){
                            valueLookingFor = 2;
                        } else{
                            personFound = true;
                            cantComplete = true;
                        }
                    }
                }
                //grab people



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
