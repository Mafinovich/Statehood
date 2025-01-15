package mafiaprod.Utils;

import java.util.ArrayList;
import java.util.List;

public class stateManager {
    private static final List<State> states = new ArrayList<>();

    public static void addState(State state) {
        states.add(state);
    }

    public static boolean isPlayerRuler(String playerName) {
        for (State state : states) {
            //if (state.getState_ruler().equalsIgnoreCase(playerName)) {
            //    return true;
           // }
        }
        return false;
    }
}
