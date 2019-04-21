package cn.box.bc.block;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.config.*;

public class Command extends net.md_5.bungee.api.plugin.Command
{
    public Command() {
        super("cbl");
    }
    
    public void execute(final CommandSender commandSender, final String[] s) {
        final Configuration config = Main.getConfig();
        if (commandSender.hasPermission("cbl.admin")) {
            commandSender.sendMessage((BaseComponent)new TextComponent(ChatColor.RED + "CBL 1.1"));
        }
        else {
            commandSender.sendMessage((BaseComponent)new TextComponent(config.getString("message").replaceAll("&", "¡ì")));
        }
    }
}
