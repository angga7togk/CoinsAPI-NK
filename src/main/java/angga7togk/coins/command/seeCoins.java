package angga7togk.coins.command;

import angga7togk.coins.Coins;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;

public class seeCoins extends Command {

    public Coins plugin;

    public seeCoins(Coins plugin) {
        super("seecoin", "See Coins Player", "/seecoin <player>");
        this.setPermission("seecoin.command");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!testPermission(sender)){
            return false;
        }
        if(Arrays.stream(args).findAny().isEmpty()){
            sender.sendMessage(this.getUsage());
            return false;
        }
        if(!this.plugin.data.exists(args[0].toLowerCase())){
            sender.sendMessage(this.plugin.prefix + TextFormat.RED + "player not found!");
            return false;
        }
        sender.sendMessage(this.plugin.prefix + TextFormat.GREEN + args[0].toLowerCase() + " Coins is " + this.plugin.getPlayerCoinsByName(args[0].toLowerCase()));
        return true;
    }
}
