package delfin;

import java.util.ArrayList;

/**
 *
 * @author Rasmus P, Ditlev, Emil og Rasmus H.
 */
public class Team {

    private String TeamID;
    private String Name;
    ArrayList<Swimmer> members = new ArrayList();

    public Team(String team_id, String teamName, ArrayList<Swimmer> members) {
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

    public ArrayList<Swimmer> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Swimmer> members) {
        this.members = members;
    }

    public void addMembers(Swimmer member) {
        members.add(member);
    }

    @Override
    public String toString() {
        return "Team{" + "teamID=" + TeamID + ", teamName=" + Name + ", users=" + members + '}';
    }

}
