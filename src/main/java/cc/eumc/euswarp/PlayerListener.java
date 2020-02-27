package cc.eumc.euswarp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PlayerListener implements Listener {
    EusWarp plugin;

    public PlayerListener(EusWarp instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        Item item = e.getItemDrop();
        if (Config.CreationItems.contains(item.getItemStack().getType())) {
            if (item.getItemStack().getAmount() == 1) {
                Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
                    @Override
                    public void run() {
                        if (item.isOnGround()) {
                            Set<Block> blockSet = new HashSet<>();

                            Block block = item.getLocation().getBlock();
                            if (block.getType() == Material.WATER && block.getRelative(BlockFace.DOWN).getType() != Material.WATER) {
                                blockSet.add(block);
                                if (block) {

                                }
                            }
                        }
                    }
                }, 20);
            }
        }
    }

    void createPortal(Set<Block> blockSet, Item droppedItem) {
        blockSet.forEach(block -> block.setType(Material.END_PORTAL));
        droppedItem.remove();
        plugin.
    }
}
