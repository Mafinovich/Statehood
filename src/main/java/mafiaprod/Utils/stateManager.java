package mafiaprod.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class stateManager {
    private static final List<State> states = new ArrayList<>();

    public static void addState(State state) {
        states.add(state);
    }

    public static boolean isPlayerRuler(UUID player) {
        for (State state : states) {
            if (state.getState_ruler().equals(player)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNameAvailable(String name, Player player) {
        for (State state : states) {
            if (state.getState_name().equals(name)) {
                player.sendMessage(ChatColor.RED + "Данное название уже занято! Попробуйте другое");
                return false;
            }
        }
        return true;
    }

    public static boolean descLenghtControl(String desc, Player player) {
        if(desc.length() > 1000){
            player.sendMessage(ChatColor.RED + "Ваше описание слишком длинное!");
            return false;
        } else if (desc.length() < 10) {
            player.sendMessage(ChatColor.RED + "Ваше описание слишком короткое!");
            return false;
        }
        return true;
    }
}
