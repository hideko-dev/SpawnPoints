package dev.hideko.spawnpoints.commands

import dev.hideko.spawnpoints.SpawnPoints
import dev.hideko.spawnpoints.utils.LocationReader
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SpawnTP: CommandExecutor {
    override fun onCommand(sender: CommandSender?, cmd: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender !is Player) return false
        if (args == null) {
            sender.sendMessage("§cIDを指定してください")
        } else {
            val id = args[0]
            sender.teleport(LocationReader().readLocation(id))
        }
        return true
    }
}