package angga7togk.coins;

import angga7togk.coins.command.*;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

public class Coins extends PluginBase {

    private static Coins instance;
    public Config data;
    public Config cfg;
    public String prefix;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new CoinsListener(this), this);

        this.prefix = this.cfg.getString("prefix");
        this.saveResource("coins.yml");
        this.saveResource("config.yml");
        this.data = new Config(this.getDataFolder()+"/coins.yml", Config.YAML);
        this.cfg = new Config(this.getDataFolder()+"/config.yml", Config.YAML);

        this.getServer().getCommandMap().register("setcoins", new setCoins(this));
        this.getServer().getCommandMap().register("addcoins", new addCoins(this));
        this.getServer().getCommandMap().register("reducecoins", new reduceCoins(this));
        this.getServer().getCommandMap().register("mycoins", new myCoins(this));
        this.getServer().getCommandMap().register("seecoins", new seeCoins(this));
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    public int getPlayerCoins(Player player){
        String playerName = player.getName().toLowerCase();
        return this.data.getInt(playerName);
    }

    public int getPlayerCoinsByName(String name){
        return this.data.getInt(name.toLowerCase());
    }

    public static Coins getInstance(){
        return instance;
    }

    public CoinsManager getCoinsManager(){
        return new CoinsManager(this);
    }
}
