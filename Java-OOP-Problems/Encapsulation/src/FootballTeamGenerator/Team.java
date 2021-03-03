package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name){
        this.setName(name);
        this.players = new ArrayList<>();
    }
    private void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(String player){
        int index = -1;
        for (int i = 0; i <this.players.size() ; i++) {
            if(this.players.get(i).getName().equals(player)){
               index = i;
               break;
            }
        }
        if(index != -1){
            this.players.remove(index);
        }else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",player,this.getName()));
        }
    }
    public double getRating(){

        return this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f",this.name,this.getRating());
    }
}
