package staffmode.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import staffmode.main.Main;
import staffmode.main.UpdateChecker;
import staffmode.utils.VanishManager;


public class PlayerJoin implements Listener {
	
	protected UpdateChecker updateChecker;
	private Main main;
	public PlayerJoin(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (p.isOp() || p.hasPermission("StaffMode.Updater")) {
			this.updateChecker = new UpdateChecker(main,
					"http://dev.bukkit.org/bukkit-plugins/staffmode-sm/files.rss");

			if (this.updateChecker.updateNeeded()) {
				p.sendMessage(ChatColor.AQUA + "[StaffMode Updater] "
						+ ChatColor.DARK_AQUA + "Version: "
						+ this.updateChecker.getVersion()
						+ " has been released! Download it here: "
						+ ChatColor.RED + this.updateChecker.getLink());
			}
		}

		if (p.hasPermission("StaffMode.Vanish.See")) {
			for (Player Vanished : VanishManager.getInstance().listInVanish()) {
				p.showPlayer(Vanished);
			}
		} else {
			for (Player Vanished : VanishManager.getInstance().listInVanish()) {
				p.hidePlayer(Vanished);
		}
	}
	}
}