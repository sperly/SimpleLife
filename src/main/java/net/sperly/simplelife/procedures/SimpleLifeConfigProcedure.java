package net.sperly.simplelife.procedures;

import net.sperly.simplelife.SimplelifeModVariables;
import net.sperly.simplelife.SimplelifeMod;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class SimpleLifeConfigProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldLoad(WorldEvent.Load event) {
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies){
		if ((!SimplelifeModVariables.ConfigFile.exists())) {SimplelifeModVariables.ConfigFile = new File(((FMLPaths.GAMEDIR.get().toString())+""+("/")+""+("mods")), File.separator + "SimpleLifeConfig.json");
    if (!SimplelifeModVariables.ConfigFile.exists()) {
        try {
            SimplelifeModVariables.ConfigFile.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
{
	Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
	JsonObject SimpleLifeConfig = new JsonObject();
	JsonObject SolarFurnace = new JsonObject();
SolarFurnace.addProperty("Enabled", 1);SolarFurnace.addProperty("SpeedModifier1Ratio", 0.75);
SimpleLifeConfig.add("SolarFurnace", SolarFurnace);JsonObject SolarHarvester = new JsonObject();
SolarHarvester.addProperty("Enabled", 1);SolarHarvester.addProperty("SpeedModifier1Ratio", 0.75);
SimpleLifeConfig.add("SolarHarvester", SolarHarvester);JsonObject SolarGrinder = new JsonObject();
SolarGrinder.addProperty("Enabled", 1);SolarGrinder.addProperty("SpeedModifier1Ratio", 0.75);
SimpleLifeConfig.add("SolarGrinder", SolarGrinder);
	try {
  		FileWriter ConfigFilefw = new FileWriter(SimplelifeModVariables.ConfigFile);
  		ConfigFilefw.write(mainGSONBuilderVariable.toJson(SimpleLifeConfig));
  		ConfigFilefw.close();
	} catch (IOException exception) {
  		exception.printStackTrace();
  	}	
}{
	try {
		BufferedReader ConfigFileReader = new BufferedReader(new FileReader(SimplelifeModVariables.ConfigFile));
		StringBuilder jsonstringbuilder = new StringBuilder();
		String line;
		while((line = ConfigFileReader.readLine()) != null) {
			jsonstringbuilder.append(line);
		}
		ConfigFileReader.close();
		JsonObject SimpleLifeConfig = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
  
	} catch (IOException e) {
		e.printStackTrace();
	}
}}
	}
}
