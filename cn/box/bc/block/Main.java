package cn.box.bc.block;

import net.md_5.bungee.config.*;
import java.io.*;
import net.md_5.bungee.api.plugin.*;

public class Main extends Plugin
{
    public static Configuration con;
    public static File dir;
    public static String Plugin_Name;
    public static double Plugin_Version;
    
    static {
        Main.Plugin_Name = "CBL";
        Main.Plugin_Version = 1.2;
    }
    
    public static Configuration getConfig() {
        try {
            Main.con = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(new File(Main.dir, "config.yml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Main.con;
    }
    
    public void onEnable() {
    	this.getLogger().info("§e§l>> §c§lVersion: 1.1");
    	this.getLogger().info("§e§l>> §c§lCBL已启用");
    	this.getLogger().info("§e§l>> §c§l配置文件读取完成");
        final File conf = new File(this.getDataFolder() + File.separator + "config.yml");
        if (!conf.exists()) {
            (Main.dir = new File(new StringBuilder().append(this.getDataFolder()).toString())).mkdirs();
            try {
                final FileWriter aiapeleaia = new FileWriter(conf);
                final BufferedWriter grandepeleaia = new BufferedWriter(aiapeleaia);
                grandepeleaia.write("command:\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write(" global:\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write("  - help:*\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write("  - server\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write(" lobby:\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write("  - bukkit\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.write("  - worldedit:*\n".replaceAll("\n", System.getProperty("line.separator")));
                grandepeleaia.close();
                aiapeleaia.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        Main.dir = this.getDataFolder();
        getConfig();
        this.getProxy().getPluginManager().registerListener((Plugin)this, (Listener)new ms());
        this.getProxy().getPluginManager().registerCommand((Plugin)this, (net.md_5.bungee.api.plugin.Command)new Command());
    }
}
