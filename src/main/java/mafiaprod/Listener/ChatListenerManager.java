package mafiaprod.Listener;

import java.net.http.WebSocket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ChatListenerManager {
    private static final Set<UUID> waitingForReply = new HashSet<>();
    private static final HashMap<UUID, String> replyMessageDict = new HashMap<>();

    public static void addPlayer(UUID playerUUID){
        waitingForReply.add(playerUUID);
    }

    public static void removePlayer(UUID playerUUID){
        waitingForReply.remove(playerUUID);
    }

    public static boolean isWaiting(UUID playerUUID){
        return waitingForReply.contains(playerUUID);
    }

    public static void addMessage(String message, UUID playerUUID){
        replyMessageDict.put(playerUUID, message);
    }

    public static String getMessage(UUID playerUUID){
        return replyMessageDict.get(playerUUID);
    }

    public static void removeMessage(UUID playerUUID){
        replyMessageDict.remove(playerUUID);
    }
}
