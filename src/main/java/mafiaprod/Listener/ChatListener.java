package mafiaprod.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        UUID playerUUID = event.getPlayer().getUniqueId();

        if(ChatListenerManager.isWaiting(playerUUID)){
            String message = event.getMessage();

            ChatListenerManager.removePlayer(playerUUID);
            ChatListenerManager.addMessage(message, playerUUID);

            event.setCancelled(true);
        }
    }
}
