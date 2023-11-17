package angga7togk.coins.command;

import angga7togk.coins.Coins;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class myCoins extends Command {

    public Coins plugin;

    public myCoins(Coins plugin) {
        super("mycoin", "My Coins");
        this.setPermission("mycoin.command");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!testPermission(sender)){
            return false;
        }
        if(sender instanceof Player){
            if(this.plugin.data.exists(sender.getName().toLowerCase())){
                sender.sendMessage(this.plugin.prefix + TextFormat.GREEN + this.plugin.data.getInt(sender.getName().toLowerCase()) + " Coins");
            }
        }else {
            sender.sendMessage(this.plugin.prefix + TextFormat.RED + "please use command in game!");
        }
        return true;
    }
}
