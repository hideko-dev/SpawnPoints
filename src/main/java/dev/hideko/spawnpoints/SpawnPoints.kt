package dev.hideko.spawnpoints

import dev.hideko.spawnpoints.commands.SpawnSet
import dev.hideko.spawnpoints.commands.SpawnTP
import dev.hideko.spawnpoints.listener.JoinQuit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class SpawnPoints : JavaPlugin() {

    companion object {
        lateinit var instance: SpawnPoints
        lateinit var configure: FileConfiguration
        lateinit var configureFile: File
    }

    override fun onEnable() {
        instance = this
        configureFile = File(dataFolder, "config.yml")
        configure = YamlConfiguration.loadConfiguration(configureFile)

        listOf(
            "spawnset" to SpawnSet(),
            "spawntp" to SpawnTP()
        ).forEach { (name, cmd) -> getCommand(name)?.executor = cmd }

        listOf(
            JoinQuit()
        ).forEach { server.pluginManager.registerEvents(it, this) }
    }

}
