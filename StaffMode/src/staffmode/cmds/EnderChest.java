package staffmode.cmds;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import staffmode.utils.ChatMessages;


public class EnderChest implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED
					+ "Only Players Can Do This Command");
			return true;
			
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("EnderChest")) {
			if (!sender.hasPermission("StaffMode.EnderChest")) {
				ChatMessages.getInstance().Nopermissions(sender);
				return true;
			}
			p.openInventory(p.getEnderChest());
			return false;
			
		}
		return false;
	}
}