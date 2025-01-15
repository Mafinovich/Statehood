package mafiaprod.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static mafiaprod.Utils.generalModel.isPlayer;
import static mafiaprod.Utils.stateManager.isPlayerRuler;



public class regStateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(isPlayer(sender))) return false;

        Player player = (Player) sender;

        if(isPlayerRuler(player.getUniqueId())) {
            player.sendMessage(ChatColor.RED + "Вы уже являетесь правителем!");
            return false;
        }



        return true;
    }

}
