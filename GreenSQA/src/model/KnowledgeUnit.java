package model;
import java.util.Calendar;

public class KnowledgeUnit {


    private String id;
    private String description;
    private Type type;
    private String learnedLessons;
    private Status status;
    private String nameColab;
    private String jobColab;
    private Calendar approveDateUnit;
    private String hashtag;
    private PublishState publishState;


   

    public KnowledgeUnit(String id, String description, Type type, String learnedLessons, String nameColab, String jobColab) {


        this.id = id;
        this.description = description;
        this.type = type;
        this.learnedLessons = learnedLessons;
        this.status = Status.POR_DEFINIR;
        this.nameColab=nameColab;
        this.jobColab=jobColab;
        this.approveDateUnit =approveDateUnit;
        this.hashtag= hashtag;
        this.publishState= PublishState.NOT_PUBLISHED;
    }

    public Calendar getApproveDateUnit(){
        return approveDateUnit;
    }

    public void setApproveDateUnit(Calendar approveDateUnit) {
        this.approveDateUnit = approveDateUnit;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public PublishState getPublishState() {
        return publishState;
    }

    public void setPublishState(PublishState publishState) {
        this.publishState = publishState;
    }



    /**
       *This method register the value of the id
       *@return id String
       */
    public String getId() {
        return id;
    }

/**
       *This method modify the value of a variable
       *@param id String identifier of a  unit
       */
    public void setId(String id) {
        this.id = id;
    }

    /**
       *This method register the value of the description
       *@return description String
       */
    public String getDescription() {
        return description;
    }

/**
       *This method modify the value of a variable
       *@param description String description of a  unit
       */
    public void setDescription(String description) {
        this.description = description;
    }

/**
       *This method register the value of the type
       *@return type String
       */
    public Type getType() {
        return type;
    }

/**
       *This method modify the value of a variable
       *@param type String type of a  unit
       */
    public void setType(Type type) {
        this.type = type;
    }

/**
       *This method register the value of the learned lessons
       *@return learnedLessons String
       */
    public String getLearnedLessons() {
        return learnedLessons;
    }

/**
       *This method modify the value of a variable
       *@param  learnedLessons String learned lessons of a  unit
       */
    public void setLearnedLessons(String learnedLessons) {
        this.learnedLessons = learnedLessons;
    }

/**
       *This method register the value of the status
       *@return status String
       */
    public Status getStatus(){
        return status;
    }
/**
       *This method modify the value of a variable
       *@param  status String status pf approve of a  unit
       */

    public void setStatus(Status status){
        this.status= status;
    }

    public String getNameColab() {
        return nameColab;
    }


    public String getJobColab() {
        return jobColab;
    }
/**
       *This method allows to concatenate the information of a unit in a string
       *@return  msg String message with all the info of a unit
       */
    public String toString() {


        String msg = "";


        msg = "The ID is:  " + id + "\n The description: " + description + "\n This is the type: " + type + "\n This is the actual status " + getStatus() +" \n This is the number of learned lessons: "+ learnedLessons;


        return msg;


    }


   


}














