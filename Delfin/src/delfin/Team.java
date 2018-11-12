package delfin;

import java.util.ArrayList;

public class Team {
    private String TeamID;
    private String Name;
    ArrayList<Swimmers> members = new ArrayList();

    public Team(String team_id, String teamName, ArrayList<Swimmers> members) {
        this.TeamID = TeamID;
        this.Name = teamName;
        this.members = members;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String TeamID) {
        this.TeamID = TeamID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Swimmers> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Swimmers> members) {
        this.members = members;
    }
    
    @Override
    public String toString() {
        return "Team{" + "teamID=" + TeamID + ", teamName=" + Name + ", users=" + members + '}';
    }

   
}