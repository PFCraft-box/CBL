package cn.box.bc.block;

import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.config.*;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.event.*;

public class ms implements Listener
{
    public boolean cb(final String msg, final String target) {
        final Configuration config = Main.getConfig();
        for (String a : config.getStringList("command." + target)) {
            a = "/" + a;
            final String special = String.valueOf(msg) + ":*";
            if (a.contains(":*") && special.contains(a)) {
                return true;
            }
            if (a.equalsIgnoreCase(msg)) {
                return true;
            }
        }
        for (String a : config.getStringList("command.global")) {
            a = "/" + a;
            final String special = String.valueOf(msg) + ":*";
            if (a.contains(":*") && special.contains(a)) {
                return true;
            }
            if (a.equalsIgnoreCase(msg)) {
                return true;
            }
        }
        return false;
    }
    
    @EventHandler(priority = 64)
    public void BungeeChat(final ChatEvent event) {
        final ProxiedPlayer p = (ProxiedPlayer)event.getSender();
        String msg = event.getMessage();
        final String target = p.getServer().getInfo().getName();
        if (msg.length() > 1) {
            final String[] arg = msg.split(" ");
            msg = arg[0];
        }
        final Boolean check = this.cb(msg, target);
        if (check) {
            if (!p.hasPermission("cbl.admin")) {
                final Configuration config = Main.getConfig();
                p.sendMessage((BaseComponent)new TextComponent(config.getString("message").replaceAll("&", "¡ì")));
                event.setCancelled(true);
            }
            else {
                event.setCancelled(false);
            }
        }
    }
}
