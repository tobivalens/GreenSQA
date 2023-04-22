package model;

import java.util.Calendar;

public class Stages {
    private boolean state;
    private String nameE;
    private Calendar realStart;
    private Calendar realEnd;
    private KnowledgeUnit[] units;
    private Calendar plannedStart;
    private Calendar plannedEnd;



    public Stages(String nameE,boolean state, Calendar realStart, Calendar realEnd){
        this.state=false;
        this.realEnd= realEnd;
        this.realStart= realStart;
        this.nameE= nameE;
        this.units= new KnowledgeUnit[50];
		    this.units=units;
        this.plannedEnd= plannedEnd;
        this.plannedStart= plannedStart;


    }



    public KnowledgeUnit[] getUnits() {
		
      return units;
    }
    
    
    public Calendar getPlannedStart() {
      return plannedStart;
    }

    public void setPlannedStart(Calendar plannedStart) {
      this.plannedStart = plannedStart;
    }

    

    public Calendar getPlannedEnd() {
      return plannedEnd;
    }

    public void setPlannedEnd(Calendar plannedEnd) {
      this.plannedEnd = plannedEnd;
    }

  
    public void setKnowledgeUnits(KnowledgeUnit[] units) {
      this.units = units;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState(){
		return state;
	}
    public String getNameE(){
		return nameE;
	}

  public Calendar setRealStart(Calendar realStart){
    return realStart;
  }

  public Calendar setRealEnd(Calendar realEnd){
    return realEnd;
  }

 

}
