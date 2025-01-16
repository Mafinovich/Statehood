package mafiaprod.Utils.Predetermined;

import java.util.List;

public class Polity {
    private String polityName;
    private String polityDesc;
    private Boolean election;

    public Polity(String polityName, String polityDesc, Boolean election){
        this.polityName = polityName;
        this.polityDesc = polityDesc;
        this.election = election;
    }

    public void changeName(String polityName){
        this.polityName = polityName;
    }

    public void changeDesc(String polityDesc){
        this.polityDesc = polityDesc;
    }

    public void changeElection(Boolean election){
        this.election = election;
    }

    public String getPolityName(){
        return polityName;
    }

    public String getPolityDesc(){
        return polityDesc;
    }

    public Boolean getElection(){
        return election;
    }

}
