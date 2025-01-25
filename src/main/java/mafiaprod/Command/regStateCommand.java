package mafiaprod.Command;

import mafiaprod.Listener.ChatListenerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static mafiaprod.Utils.generalModel.isPlayer;
import static mafiaprod.Utils.stateManager.isPlayerRuler;

public class regStateCommand implements CommandExecutor {
    public static String[] WaitingMessageType = new String[] {"Name", "Desc", "Polity", "Border"};

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(isPlayer(sender))) return false;

        Player player = (Player) sender;
        UUID playerUUID = player.getUniqueId();

        if(isPlayerRuler(playerUUID)) {
            player.sendMessage(ChatColor.RED + "Вы уже являетесь правителем!");
            return false;
        }

        ChatListenerManager.addPlayer(playerUUID);
        player.sendTitle("Введите название вашей страны.", "", 10, 10, 10);

        return true;
    }

}
