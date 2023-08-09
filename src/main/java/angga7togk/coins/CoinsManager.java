package angga7togk.coins;

import cn.nukkit.Player;

import java.util.ArrayList;

public class CoinsManager {

    public Coins plugin;

    public CoinsManager(Coins plugin){
        this.plugin = plugin;
    }

    public void setCoins(Player player, int coins){
        String playerName = player.getName().toLowerCase();
        this.plugin.data.set(playerName, coins);
        this.plugin.data.save();
    }

    public void addCoins(Player player, int coins){
        String playerName = player.getName().toLowerCase();
        this.plugin.data.set(playerName, this.plugin.getPlayerCoins(player) + coins);
        this.plugin.data.save();
    }

    public void reduceCoins(Player player, int coins){
        String playerName = player.getName().toLowerCase();
        this.plugin.data.set(playerName, this.plugin.getPlayerCoins(player) - coins);
        this.plugin.data.save();
    }

    public void setCoinsByName(String name, int coins){
        this.plugin.data.set(name.toLowerCase(), coins);
        this.plugin.data.save();
    }

    public void addCoinsByName(String name, int coins){
        this.plugin.data.set(name.toLowerCase(), this.plugin.getPlayerCoinsByName(name.toLowerCase()) + coins);
        this.plugin.data.save();
    }

    public void reduceCoinsByName(String name, int coins){
        this.plugin.data.set(name.toLowerCase(), this.plugin.getPlayerCoinsByName(name.toLowerCase()) - coins);
        this.plugin.data.save();
    }
}
