package mafiaprod.Utils;

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
}
