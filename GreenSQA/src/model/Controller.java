package model;

import java.util.Calendar;
import java.util.GregorianCalendar;




public class Controller {

	private Project[] projects;

    

	public Controller() {

    
		projects = new Project[10];
      
	
	}

    /**
     * This method register the info of  the projects 
     * 
     * @param name           String name of the project
     * @param description    String description of a project
     * @param budget         double  budget of an unit
     * @param day             int  initial day of project
     * @param month           int  initial month of project
     * @param year           int  initial month of project
     * @param managerNameG String name of the manager from greenSQA
     * @param managerNameC String name of the manager from client
     * @param managerNumC String number of the manager from client
     * @param managerNumG String number of the manager from greenSQA
     * @param durationStage1    int expected duration of the stage 1
     * @param durationStage2    int expected duration of the stage 2
     * @param durationStage3    int expected duration of the stage 3
     * @param durationStage4    int expected duration of the stage 4
     * @param durationStage5    int expected duration of the stage 5
     * @param durationStage6    int expected duration of the stage 6
     * @return boolean 
     */

    public boolean RegisterProject(String name, String clientName, double budget,  int day, int month, 
    int year, String managerNameG, String managerNumG, String managerNameC, String managerNumC,int durationStage1,
    int durationStage2, int durationStage3, int durationStage4, int durationStage5, int durationStage6) {

		Calendar initialDate = new GregorianCalendar(year,month,day); 
        

        Calendar date1 = initialDate;

        date1.add(Calendar.MONTH, durationStage1);
        Calendar date2 = date1;

        date2.add(Calendar.MONTH, durationStage2);
        Calendar date3 = date2;

        date3.add(Calendar.MONTH, durationStage3);
        Calendar date4 = date3;

        date4.add(Calendar.MONTH, durationStage4);
        Calendar date5 = date4;

        date5.add(Calendar.MONTH, durationStage5);
        Calendar date6 = date5;

		Calendar finalPlannedDate = date6;
        
      

        Stages[] stages= {new Stages("Start", true, null,null),
             new Stages("Analysis", false,null,null), 
             new Stages("Design", false,null,null),
             new Stages("Execution", false,null,null), 
             new Stages("Closing", false,null,null),
             new Stages("Control", false,null,null)};
             stages[0].setState(true);
             stages[0].setRealStart(initialDate);

             

           
		Project newProject = new Project(name , clientName, initialDate, budget,managerNameG,managerNumG, managerNameC, managerNumC, stages);
		for (int i = 0; i < projects.length; i++) {


            if (projects[i] == null && stages[i]!=null) {


                projects[i] = newProject;
               

                return true;


            }


        }


		return false;
	}

    /**
     * This method allows to show the registered projects
     * 
     * @return msg string message with the information of a project
     */

    public String getRegisteredProjects() {

        String msg = "";

        int x=0;

        for (int i = 0; i < projects.length; i++) {

            if (projects[i] != null && projects[i].getStages()[i]!=null) {

                for(int y=0; y< projects[i].getStages().length; y++){
                    if (projects[i].getStages()[y].getState()==true){
                        x=y;

                    }
                }

                

                msg += projects[i].toString(x) + "\n";

            }

          


        }

        return msg;

       
    }

    /**
     * This method allows to end the state of a stage
     * 
     * @param name           String name of the project to end one stage
     * @param day            int   day of ending of a stage
     * @param month          int   month of of ending of a stage
     * @param year           int   year of of ending of a stage
     * @param newStatus      int  assignates the new status
     * @return void
     */



    public void endStages(String name, int day, int month, int year, int newStageStatus){
       
        Calendar realEnd= new GregorianCalendar(year,month,day); 
        
        boolean stageChanged = false;

        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                if (projects[i].getName().equals(name)) {
                   
                    Stages[] stages = projects[i].getStages();
                   

                    for(int j=0; j<stages.length && !stageChanged ; j++){
                        
                        if(projects[i].getStages()[j].getState()==true ){
                           

                            if (newStageStatus==1) {
                               
                                    projects[i].getStages()[j].setState(false);
                                    stages[j].setRealEnd(realEnd);
                                

                                

                                if(j<stages.length-1){
                                    projects[i].getStages()[j+1].setState(true);
                                    stages[j+1].setRealStart(realEnd);
                                    
                                }
                                
                                stageChanged=true;
                                //mensaje de prueba
                                
                                System.out.println("The stage "+ projects[i].getStages()[j+1].getNameE()+ " is activated now");
                                
                                
                            }

                        }
                    }

                }

            }

        }



    }
    
    /**
     * This method register the information of a knowledge units
     * 
     * @param projectName    String name of the project where is going to create the unit
     * @param id             int identifier of a knowledge unit
     * @param description    String description of a unit
     * @param type           int variable that assign the type of stage
     * @param learnedLessons String lessons of a unit
     * @param nameColab      String name of the collaborator 
     * @param jobColab       String job of the collaborator 
     * @return boolean
     */
    


    public boolean registerKnowledgeUnit(String projectName, String id, String description, int type, String learnedLessons, String nameColab,String jobColab, String hashtag) {

        Type typeKU = Type.TECHNICIAN;
        if (type == 1) {
            typeKU = Type.TECHNICIAN;
        }  else if(type==2) {
            typeKU = Type.EXPERIENCES;
        }
        else if(type==3){
            typeKU = Type.MANAGEMENT;
        }
        else if(type==4){
            typeKU = Type.DOMAIN;
        }

        KnowledgeUnit firstUnit = new KnowledgeUnit(id, description, typeKU, learnedLessons, nameColab, jobColab);
        

        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                if (projects[i].getName().equals(projectName)) {
                    
                    Stages[] stages= projects[i].getStages();

                    for(int j=0; j < stages.length; j++){
                        if(stages[j].getState()== true){
                            

                            KnowledgeUnit[]units= stages[j].getUnits();

                           
                            for(int k=0;k <units.length; k++){
                               
                                if (units[k] == null) {

                                    units[k] = firstUnit;
                                    units[k].setStatus(Status.POR_DEFINIR);
                                    units[k].setHashtag(hashtag);
                                  
                                    return true;
                                    
                    
                                }
                            }
                        

                        }
                    }

                    
                }
            }

            

        }

        return false;
    }

    /**
     * This method allows to show the registered knowledge units
     * 
     * @return msg string  message with the basic information
     */

    public String consultUnits(){
        String msg="";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                
                                 msg+="\nID: "+ projects[i].getStages()[x].getUnits()[y].getId()+"\n"+ "Brief Description: "+
                                 projects[i].getStages()[x].getUnits()[y].getDescription()  ; 
                                
                            }
                        }
                    }
                }
            }
        }


        return msg;

    }

    
    /**
     * This method allows to approve or not the state of a knowledge unit
     * 
     * @param id             String identifier of the unit to approve
     * @param day            int   day of approval of a stage
     * @param month          int   month of approval of a stage
     * @param year           int   year of approval of a stage
     * @param newStatus      int  assignates the new status of the knowledge unit
     * @return boolean 
     */
    

    public boolean approveKnowledgeUnit(String id, int newStatus, int day, int month, int year) {
        Calendar approveDateUnit= new GregorianCalendar(year, month, day);
        boolean var= false;

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){
                                    if(newStatus == 1){
                                        projects[i].getStages()[x].getUnits()[y].setStatus(Status.APPROVED);
                                        projects[i].getStages()[x].getUnits()[y].setApproveDateUnit(approveDateUnit);
                                        var=true;
                                    }
                                    else if(newStatus == 2){
                                        projects[i].getStages()[x].getUnits()[y].setStatus(Status.NOT_APPROVED);
                                        projects[i].getStages()[x].getUnits()[y].setApproveDateUnit(null);
                                        var=true;

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return var;

    }

    /**
     * This method allows to generate the link of the unit
     * @param id             String identifier of the unit to publish
     * @return msg string   message of the generated link
     */


    public String publishUnit(String id){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                if(projects[i].getStages()[x].getUnits()[y].getId().equals(id)){

                                    if (projects[i].getStages()[x].getUnits()[y].getStatus()==Status.APPROVED){

                                        msg="https/GreenCapsule" +  "/"+projects[i].getStages()[x].getUnits()[y].getId() + "/"+
                                        projects[i].getStages()[x].getUnits()[y].getType()+".net";
                                        projects[i].getStages()[x].getUnits()[y].setPublishState(PublishState.PUBLISHED);

                                    }

                                    else{
                                        msg= "you cant publish this unit because inst approved";
                                    }
                                   
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * This method allows to count the amount of units registered in Technical type
     * @return counter int This returns the amount of units registered in Technical type 
     */


    public int getUnitTypeTec( ){
        

        int counter=0;

        

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getType().equals(Type.TECHNICIAN)){
                                        counter+=1;

                                  

                                    
                                }
                            }
                        }
                    }
                }
            }
        }



        return counter;
    }

    /**
     * This method allows to count the amount of units registered in Experiences type
     * @return counter int This returns the amount of units registered in Experiences type 
     */

    public int getUnitTypeEXP( ){
        

        int counter=0;

        

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getType().equals(Type.EXPERIENCES)){
                                        counter+=1;

                                  

                                    
                                }
                            }
                        }
                    }
                }
            }
        }



        return counter;
    }

    /**
     * This method allows to count the amount of units registered in Management type
     * @return counter int This returns the amount of units registered in Management type 
     */


    public int getUnitTypeMAN( ){
        

        int counter=0;

        

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getType().equals(Type.MANAGEMENT)){
                                        counter+=1;

                                  

                                    
                                }
                            }
                        }
                    }
                }
            }
        }



        return counter;
    }

    /**
     * This method allows to count the amount of units registered in Domain type
     * @return counter int This returns the amount of units registered in Domain type 
     */


    public int getUnitTypeDOM( ){
        

        int counter=0;

        

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getType().equals(Type.DOMAIN)){
                                        counter+=1;

                                  

                                    
                                }
                            }
                        }
                    }
                }
            }
        }

        return counter;
    }

    /**
     * This method allows to show the user the unit lessons registered by choosing the stage of a unit
     * @param changes int indicates the name of stage of  the units they want to consult
     * @return msg string This returns a concatenation of information incluiding the lessosn of a unit
     */


    public String getUnitLesson2(String changesE){
        String msg="";
        
        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getNameE().equals(changesE)){
                                       
                                        msg += " Stage Name: "+projects[i].getStages()[x].getNameE() + "\n ID: "+ projects[i].getStages()[x].getUnits()[y].getId()+ "\n Learned Lesson: "+ 
                                        projects[i].getStages()[x].getUnits()[y].getLearnedLessons();
                                  

                                    
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }


    /**
     * This method allows to find the project with most registered knowledge units
     * @return nameProject String the name of the project with most registered knowledgeunits
     */

    public String countKnowUnits(){
        
        int count=0;
        String nameProject="";
        int count2;

        for(int i = 0; i < projects.length; i++){
            count=0;

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        
                        count2=0;
                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            
                            if(projects[i].getStages()[x].getUnits()[y] != null){
                                 count++;
                                 count2= count;

                                 if(count2<count){

                                 }

                                 nameProject= projects[i].getName();

                            }
                        }
                    }
                }
            }
        }

        return nameProject; 
    }

      /**
     * This method allows to consult if a collaborator has registered at least one knowledge unit
     * @param nameCollab String The name of the collaborator to search the register in a unit 
     * @return msg string This returns a message if the collaborator has registered a unit
     */

    public String UnitsByCollab(String nameCollab){
        String msg="";

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getNameColab().equals(nameCollab)){
                                       
                                        msg = "The collaborator "+ projects[i].getStages()[x].getUnits()[y].getNameColab()+ "Has worked in at least one project";
                                  

                                    
                                }

                                else{
                                    msg="The collaborator  "+ projects[i].getStages()[x].getUnits()[y].getNameColab()+ "Has never registered a Knowledge Unit" ;
                                }
                            }
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * This method allows to consult the information of a knowledge unit by searching the hashtags
     * @param searchHashtg String The hashtag to find the unit
     * @return msg string This returns the information of the unit recognized for the hashtags
     */

    public String showUnitByHashtag(String searchHashtg){
        String msg= "";

        for(int i = 0; i < projects.length; i++){

            if(projects[i] != null){

                for(int x = 0; x < projects[i].getStages().length; x++){

                    if(projects[i].getStages()[x] != null){
                        

                        for(int y = 0; y < projects[i].getStages()[x].getUnits().length; y++){
                            if(projects[i].getStages()[x].getUnits()[y] != null){


                                    if (projects[i].getStages()[x].getUnits()[y].getHashtag().contains(searchHashtg)){

                                        if (projects[i].getStages()[x].getUnits()[y].getStatus().equals(Status.APPROVED)){

                                            KnowledgeUnit unit1= projects[i].getStages()[x].getUnits()[y];

                                            if (unit1.getPublishState().equals(PublishState.PUBLISHED)){
                                                msg = "The unit ID is:  "+ unit1.getId()+ "\n The learned Lessons are:"+ unit1.getLearnedLessons();
 

                                            }

                                            else if(unit1.getPublishState().equals(PublishState.NOT_PUBLISHED)){
                                                msg= "The hashtag of the unit that you inserted is not published, please try again with another";
                                            }

                                        }
                                       
                                    
                                }

                               
                            }
                        }
                    }
                }
            }
        }

        return msg;

    }



    
    
}