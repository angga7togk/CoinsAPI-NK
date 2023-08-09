package angga7togk.coins.command;

import angga7togk.coins.Coins;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;

public class setCoins extends Command {

    public Coins plugin;

    public setCoins(Coins plugin) {
        super("setcoin", "Set Coins Player", "/setcoin <player> <coin>");
        this.setPermission("setcoin.command");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(Arrays.stream(args).count() < 2){
            sender.sendMessage(this.getUsage());
            return false;
        }
        if(!this.plugin.data.exists(args[0].toLowerCase())){
            sender.sendMessage(this.plugin.prefix + TextFormat.RED + "player not found!");
            return false;
        }
        if(!isNumeric(args[1])){
            sender.sendMessage(this.plugin.prefix + TextFormat.RED + "please enter a number!");
            return false;
        }

        this.plugin.getCoinsManager().setCoinsByName(args[0].toLowerCase(), Integer.parseInt(args[1]));
        sender.sendMessage(this.plugin.prefix + TextFormat.GREEN + "succesfuly to set coin " + args[0].toLowerCase() + " " + args[1]);
        return true;
    }

    protected static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
