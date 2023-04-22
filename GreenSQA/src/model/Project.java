package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class Project{
	
	private String name;
	private String clientName;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	
    private String managerNameG;
    private String managerNumG;
    private String managerNameC;
    private String managerNumC;
	private Stages[] stages; 

	private DateFormat formatter;

	public Project(String name, String clientName, Calendar initialDate, double budget,String managerNameG, String managerNumG, String managerNameC, String managerNumC, Stages[] stages){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");

		this.name = name;	
		this.clientName = clientName;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		
        this.managerNameC=managerNameC;
        this.managerNumC=managerNumC;
        this.managerNameG=managerNameG;
        this.managerNumG=managerNumG;
		this.stages=new Stages[6];
		this.stages=stages;
		//stages= 
		
	}

	

	public Stages[] getStages() {
		
		return stages;
	}



	public void setStages(Stages[] stages) {
		this.stages = stages;
	}



	public String getName(){
		return name;
	}

   
	
	public String getClientName(){
		return clientName;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;

	}


    public String getManagerNameG(){
		return managerNameG;
	}

    public String getManagerNameC(){
		return managerNameC;
	}

    public String getManagerNumG(){
		return managerNumG;
	}

	public String getManagerNumC(){
		return managerNumC;
	}




	public String getProjectInfo() throws ParseException{
		String msj="";
		msj="\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
		return msj;
	}

	public String toString( int x){
		String msj="";

		
		msj="\nName: " + name + "\nClient: " + clientName +  "\nTotalBudget: " + budget + ".\n"+"Actual Stage: "+getStages()[x].getNameE();
		return msj;
	}
	

}


