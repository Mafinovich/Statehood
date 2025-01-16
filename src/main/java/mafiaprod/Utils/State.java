package mafiaprod.Utils;

import mafiaprod.Utils.Predetermined.Polity;
import org.bukkit.Location;

import java.util.List;
import java.util.UUID;

public class State {
    //Основное
    private String state_name;
    private String state_desc;
    private Polity polit_system;
    private UUID state_ruler;
    private List<UUID> citz_list;
    private List<Location> border;

    //Ресурсы
    private int treasury;
    private int military_force;

    //Хуета
    private int step = 0;


    public State(String state_name, String state_desc, Polity polit_system,
                 UUID state_ruler, List<UUID> citz_list, List<Location> border) {
        this.state_name = state_name;
        this.state_desc = state_desc;
        this.polit_system = polit_system;
        this.state_ruler = state_ruler;
        this.citz_list = citz_list;
        this.border = border;

        this.treasury = 0;
        this.military_force = 0;
    }

    public void changeState_name(String state_name){
        this.state_name = state_name;
    }

    public void changeState_desc(String state_desc){
        this.state_desc = state_desc;
    }

    public void changePolit_system(Polity polit_system){
        this.polit_system = polit_system;
    }

    public void changeRuler(UUID new_ruler){
        this.state_ruler = new_ruler;
    }

    public void addCitz(UUID new_citz){
        this.citz_list.add(new_citz);
    }

    public void changeBorder(List<Location> new_border){
        this.border = new_border;
    }

    public void changeTreasury(int new_value){
        this.treasury = new_value;
    }

    public void changeMilitary_force(int value, Boolean type){
        if(type = true){
            if(this.military_force + value <= this.citz_list.size()){
                this.military_force = this.military_force + value;
            }
        } else {
            if(this.military_force - value > 0){
                this.military_force = this.military_force - value;
            }
        }
    }

    public String getState_name(){
        return state_name;
    }

    public String getState_desc(){
        return state_desc;
    }

    public Polity getPolit_system(){
        return polit_system;
    }

    public UUID getState_ruler(){
        return state_ruler;
    }

    public List<UUID> getCitz_list(){
        return citz_list;
    }

    public List<Location> getBorder(){
        return border;
    }

    public int getTreasury(){
        return treasury;
    }

    public int getMilitary_force(){
        return military_force;
    }

    public int getStep(){
        return step;
    }

    public void nextStep(){
        step++;
    }
}
