package cc.eumc.euswarp;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EusWarp extends JavaPlugin {// implements PluginMessageListener {
    FileConfiguration portalsConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        reloadConfig();
        File portalFile = new File(getDataFolder(), "portals.yml");
        if (!portalFile.exists()) {
            saveResource("portals.yml", false);
        }
        portalsConfig = YamlConfiguration.loadConfiguration(portalFile);

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        //this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /*
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        //if (subchannel.equals("SomeSubChannel")) {
            // Use the code sample in the 'Response' sections below to read
            // the data.
        //}
    }*/

    public void tpServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    }

    public void savePortal(Location location) {

    }
}
