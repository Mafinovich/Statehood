package mafiaprod;

import mafiaprod.Command.regStateCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Statehood extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "Statehood enabled!");

        getServer().getPluginCommand("regState").setExecutor(new regStateCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
