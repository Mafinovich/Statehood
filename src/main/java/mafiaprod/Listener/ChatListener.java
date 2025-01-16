package mafiaprod.Listener;

import mafiaprod.Utils.State;
import mafiaprod.Utils.stateManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import mafiaprod.Utils.polityManager;

import java.util.UUID;

public class ChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        UUID playerUUID = event.getPlayer().getUniqueId();
        Player player = event.getPlayer();

        if(ChatListenerManager.isWaiting(playerUUID)){
            event.setCancelled(true);

            State newState = new State(null, null, null, playerUUID, null, null);
            String message = event.getMessage();

            switch (newState.getStep()){
                case 0:
                    if(stateManager.isNameAvailable(message, player)){
                        newState.changeState_name(message);
                        newState.nextStep();
                        player.sendTitle("Введите описание вашей страны", "", 10, 10, 10);
                    }
                case 1:
                    if(stateManager.descLenghtControl(message, player)){
                        newState.changeState_desc(message);
                        newState.nextStep();

                        player.sendTitle("Введите политический строй из списка", polityManager.outputPolity(), 10, 10, 10);
                    }
                case 2:
                    if(polityManager.getPolity(message) != null){
                        newState.changePolit_system(polityManager.getPolity(message));
                        newState.nextStep();

                        player.sendTitle("Обозначьте границы вашей страны", "Отметьте ключевые точки командой /addborder (они должны замыкаться)", 10, 10, 10);
                    } else{
                        player.sendMessage(ChatColor.RED + "Введите корректный политический строй ("+polityManager.outputPolity()+")");
                    }
            }

            ChatListenerManager.removePlayer(playerUUID);
            ChatListenerManager.addMessage(message, playerUUID);
        }
    }
}
