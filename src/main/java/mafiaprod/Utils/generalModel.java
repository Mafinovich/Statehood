package mafiaprod.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class generalModel {
    public static Boolean isPlayer(CommandSender sender){
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Эту команду может использовать только игрок!");
            return false;
        } else{
            return true;
        }
    };
}
