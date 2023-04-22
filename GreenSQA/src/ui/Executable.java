package ui;
import java.util.Scanner;
import model.Controller;

public class Executable{
private Scanner reader;
private Controller controller;

public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

    public static void main(String[] args) throws Exception {
        Executable exe = new Executable();
		exe.menu();
    }

    public void menu() {

		boolean cond = false;

        while (!cond) {

		System.out.println("WELCOME USER, WHAT WOULD YOU LIKE TO DO?");
		System.out.println("1) REGISTER A NEW PROJECT");
		System.out.println("2) FINISH THE STAGE OF A PROJECT");
		System.out.println("3) REGISTER KNOWLEDGE UNIT");
		System.out.println("4) APPROVE KNOWLEDGE UNIT");
        System.out.println("5) POST KNOWLEDGE UNIT");
		System.out.println("6) SEARCH REGISTERED UNITS BY TYPE ");
		System.out.println("7) CONSULT A LIST OF LEARNED LESSONS BY STAGE ");
		System.out.println("8) CONSUL THE PROJECT WITH MOST UNITS REISTERED");
        System.out.println("9) CONSULT IF A COLLABORATOR HAS REGISTERED A KNOWLEDGE UNIT");
		System.out.println("10) CONSULT THE INFORMATION OF A KNOWLEDGE UNIT BY HASHTAG");
        System.out.println("11) EXIT");
	
	
	
		int action= reader.nextInt();

		switch(action){
			case 1: 
            RegisterProject();
			break;

			case 2: 
			showRegisteredP();
			endStagesExe();
			break;

			case 3:
			showRegisteredP();
			registerKnowledgeUnit();
			break;

            case 4:
			
			approveKnowledgeUnit();
			break;
            
            case 5:
			publishUnit();
			break;

			case 6: 
			registeredCapsuleType();
			break;

			case 7:
			registeredUnitLesson();
			break;

			case 8:
			showBiggestProject();
			break;

			case 9:
			showCollabUnits();
			break;

			case 10:
			showUnitByHashtag();
			break;


			case 11:
			cond=true;
			break;

		}
	}

	}
	/**
     * This method allows to ask for the information to call the methos register project in the controller
     */


    public void RegisterProject() {

		reader.nextLine();

		System.out.println("INSERT THE NAME OF THE PROJECT");
		String name= reader.nextLine();

		System.out.println("INSERT THE NAME OF THE CLIENT");
		String clientName= reader.nextLine();


		System.out.println("INSERT THE INITIAL DATE");
		System.out.println("INSERT THE DAY ");
		int day = reader.nextInt();

		System.out.println("INSERT THE MONTH ");
		int month = reader.nextInt();

		System.out.println("INSERT THE YEAR ");
		int year = reader.nextInt();

		System.out.println("INSERT THE BUDGET");
		double budget= reader.nextDouble();

        reader.nextLine();

        System.out.println("INSERT THE NAME OF THE GREENSQA MANAGER");
		String managerNameG= reader.nextLine();

        System.out.println("INSERT THE NUMBER OF THE GREENSQA MANAGER");
		String managerNumG= reader.nextLine();

        System.out.println("INSERT THE NAME OF THE CLIENT MANAGER");
		String managerNameC= reader.nextLine();

        System.out.println("INSERT THE NUMBER OF THE CLIENT MANAGER");
		String managerNumC= reader.nextLine();



		System.out.println("INSERT THE DURATION OF THE FIRST STAGE IN MONTHS");
		int durationStage1 = reader.nextInt();

		System.out.println("INSERT THE DURATION OF THE SECOND STAGE IN MONTHS");
		int durationStage2 = reader.nextInt();

		System.out.println("INSERT THE DURATION OF THE THIRD STAGE IN MONTHS");
		int durationStage3= reader.nextInt();

		System.out.println("INSERT THE DURATION OF THE 4 STAGE IN MONTHS");
		int durationStage4 = reader.nextInt();

		System.out.println("INSERT THE DURATION OF THE 5 STAGE IN MONTHS");
		int durationStage5 = reader.nextInt();

		System.out.println("INSERT THE DURATION OF THE 6 STAGE IN MONTHS");
		int durationStage6 = reader.nextInt();


		if (controller.RegisterProject(name, clientName,  budget,   day,  month,  year, managerNameG,
		managerNumG, managerNameC, managerNumC,durationStage1, durationStage2, durationStage3, durationStage4
		, durationStage5, durationStage6)==true) {


			System.out.println("Succesfull register");


		} else {


			System.out.println("Memory full, unable to register the project");


		}


	}

	/**
     * This method allows to show the user all the registered projects
     */

	public void showRegisteredP(){
		System.out.println(controller.getRegisteredProjects());
	}

	/**
     * This method allows to ask for the information to the user, for ending the actual stage of a project
     */

	public void endStagesExe(){

		reader.nextLine();

		System.out.println("INSERT THE NAME OF THE PROJECT");
		String name= reader.nextLine();

		System.out.println("INSERT THE REAL END DATE");
		
		System.out.println("INSERT THE DAY ");
		int day = reader.nextInt();

		System.out.println("INSERT THE MONTH ");
		int month = reader.nextInt();

		System.out.println("INSERT THE YEAR ");
		int year = reader.nextInt();

		reader.nextLine();


		System.out.println("INSERT THE INITIAL DATE");
		System.out.println("Insert the new status: 1) Approved 2) Not approved");
		int newStageStatus = reader.nextInt();

		controller.endStages( name,  day, month, year,  newStageStatus);
	}

	/**
     * This method allows to ask for the information to call the methos register knowledge unit
     */
	

    public void registerKnowledgeUnit() {
		reader.nextLine();

		System.out.println("The unit will be created in the current active stage");
		System.out.println("Type the name of the project to create the Unit");
		String projectName= reader.nextLine();
		

        System.out.println("Write the information of a knowledge Unit");


        System.out.println("insert the id");
        String id = reader.nextLine();


        System.out.println("insert the description");
        String description = reader.nextLine();


        System.out.println("insert the type: \n 1)Technician \n 2)Experiences \n 3)Management\n 4)Domain  ");
        int type = reader.nextInt();
        reader.nextLine();
            
        System.out.println("insert the learned lessons");
        String learnedLessons = reader.nextLine();

        System.out.println("insert the name of the colaborator");
        String nameColab = reader.nextLine();

        System.out.println("insert the job of the colaborator");
        String jobColab = reader.nextLine();

		System.out.println("Type some hashtag for identify the unit later");
        String hashtag = reader.nextLine();


        
            if (controller.registerKnowledgeUnit( projectName, id,  description,  type,  learnedLessons, nameColab, jobColab, hashtag)) {


                System.out.println("Succesfull register");


            } else {


                System.out.println("Memory full, unable to register the knowledge unit");


            }
            
        

        



    }

	/**
     * This method allows to ask for the information to approve or not a registered unit
     */

	public void approveKnowledgeUnit(){
		System.out.println("Registered Knowledge Units: ");
		System.out.println(controller.consultUnits());

		reader.nextLine();

		
        System.out.println("insert the id");
        String id = reader.nextLine();


        System.out.println("insert the new status\n 1)Approved \n 2)Not Approved");
        int newStatus = reader.nextInt();

		if (newStatus==1){

		System.out.println("INSERT THE APPROVE DATE");
		reader.nextLine();
		System.out.println("INSERT THE DAY ");
		int day = reader.nextInt();

		System.out.println("INSERT THE MONTH ");
		int month = reader.nextInt();

		System.out.println("INSERT THE YEAR ");
		int year = reader.nextInt();

		controller.approveKnowledgeUnit(id, newStatus, day ,month, year);

		if (controller.approveKnowledgeUnit(id, newStatus, newStatus, newStatus, newStatus)==true){
			System.out.println("The date has been registered");
		}
			
		}
	else {
		controller.approveKnowledgeUnit(id, newStatus, 0 ,0, 0);
		}

	
	/**
     * This method allows to ask the information to publish a unit that has been approved before
     */
	
	}

	public void publishUnit(){
		System.out.println("Registered Knowledge Units: ");
		reader.nextLine();
		System.out.println(controller.consultUnits());

		System.out.println("insert the id");
        String id = reader.nextLine();
		System.out.println(controller.publishUnit(id));

		

	}

	/**
     * This method allows to show the user the amount of units registered depending of the type
     */

	public void registeredCapsuleType(){
			System.out.println("The amount of units registered of technical type is : "+controller.getUnitTypeTec());
			System.out.println("The amount of units registered of Experience type is : "+controller.getUnitTypeEXP());
			System.out.println("The amount of units registered of Managment type is : "+controller.getUnitTypeMAN());
			System.out.println("The amount of units registered of Domain type is : "+controller.getUnitTypeDOM());
			
	}

	/**
     * This method allows to ask for the learned lessons of a unit depending on the type of unit
     */

	public void registeredUnitLesson(){
		reader.nextLine();

		System.out.println("For consulting the lessons type the name of the stage of units you want to see:");
		System.out.println(" \n Start \n Analysis \n Design\n Execution \n Closing \n Control ");
		String changes= reader.nextLine();
		System.out.println(controller.getUnitLesson2(changes));
	}
	/**
     * This method allows to show if a collaborator has registered at least one knowledge unit
     */

	public void showCollabUnits(){

		System.out.println("Type the name of the collaborator u want to search ");
		reader.nextLine();
		String nameCollab = reader.nextLine();
		


		System.out.println(controller.UnitsByCollab(nameCollab));
	}

	/**
     * This method allows to show the user the project with most knowledge units registered
     */

	public void showBiggestProject(){
		System.out.println("The project with most Knowledge Units registered is: "+ controller.countKnowUnits());
	}

	/**
     * This method allows to search a unit by the hashtags
     */

	public void showUnitByHashtag(){

		reader.nextLine();
		System.out.println("Type the hashtag to search the knowledge unit ");
		String searchHashtg= reader.nextLine();
		System.out.println(controller.showUnitByHashtag(searchHashtg));

	}




		

}