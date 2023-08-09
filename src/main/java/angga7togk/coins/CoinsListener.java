package angga7togk.coins;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class CoinsListener implements Listener {

    public Coins plugin;
    public CoinsListener(Coins plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName().toLowerCase();
        if (!this.plugin.data.exists(playerName)){
            this.plugin.data.set((String) playerName, this.plugin.cfg.getInt("startCoins"));
            this.plugin.data.save();
        }
    }
}
