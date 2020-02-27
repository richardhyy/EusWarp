package cc.eumc.euswarp;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class Config {
    public static boolean TargetAtSpawn;
    public static String TargetServerName;
    public static Set<Material> CreationItems = new HashSet<>();
    public static Set<Material> Flowers = new HashSet<>();

    public Config(EusWarp instance) {
        TargetAtSpawn = instance.getConfig().getBoolean("Settings.Landing.TargetAtSpawn", false);
        
        TargetServerName = instance.getConfig().getString("Settings.Portal.TargetServerName");
        if (TargetServerName == null) {
            instance.getLogger().warning("Target Server was not defined.");
        }
        for (String s : instance.getConfig().getStringList("Settings.CreationItems")) {
            Material material = org.bukkit.Material.getMaterial(s.toUpperCase());
            if (material == null) {
                instance.getLogger().warning("Material §n" + s.toUpperCase() + "§r does not exist.");
            }
            else {
                CreationItems.add(material);
            }
        }
        for (String s : instance.getConfig().getStringList("Settings.Flowers")) {
            Material material = org.bukkit.Material.getMaterial(s.toUpperCase());
            if (material == null) {
                instance.getLogger().warning("Material §n" + s.toUpperCase() + "§r does not exist.");
            }
            else {
                Flowers.add(material);
            }
        }
    }
}
