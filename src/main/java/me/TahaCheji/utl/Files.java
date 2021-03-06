package me.TahaCheji.utl;

import me.TahaCheji.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Files {
	
	
	static File configFile = new File("plugins/Renter/config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(configFile);
	
	public static void initFiles() throws FileNotFoundException, IOException, InvalidConfigurationException {
		
		if(!new File("plugins/Renter").exists()) {
			new File("plugins/Renter").mkdir();
		}
		
		if(!configFile.exists()) {
			Main.getInstance().saveDefaultConfig();
		}
		
		File playerData = new File("plugins/Renter/playerData");
		File st = new File("plugins/Renter/storageStash");
		File listingData = new File("plugins/Renter/listings");
		File loanedItems = new File("plugins/Renter/loanedItems");
		if(!playerData.exists()) {
			playerData.mkdir();
		}
		if(!st.exists()) {
			st.mkdir();
		}
		if(!loanedItems.exists()) {
			loanedItems.mkdir();
		}
		if(!listingData.exists()) {
			listingData.mkdir();
		}
		
		loadFiles();
		
	}

	private static void loadFiles() throws FileNotFoundException, IOException, InvalidConfigurationException {
		cfg.load(configFile);
	}


	private static void loadFile(InputStream paramInputStream, File paramFile) throws IOException, InvalidConfigurationException {

		if(!paramFile.exists()) {
			FileUtils.copyInputStreamToFile(paramInputStream, paramFile);
		}
		((FileConfiguration)YamlConfiguration.loadConfiguration(paramFile)).load(paramFile);
	}
	
}
