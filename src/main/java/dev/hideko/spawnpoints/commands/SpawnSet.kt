package dev.hideko.spawnpoints.commands

import dev.hideko.spawnpoints.SpawnPoints
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SpawnSet: CommandExecutor {
    override fun onCommand(sender: CommandSender?, cmd: Command?, label: String?, args: Array<out String>?): Boolean {
        if(sender !is Player) return false
        if(sender.isOp) {
            if (args == null) {
                sender.sendMessage("§cIDを指定してください")
            } else {
                val pLoc = sender.location
                SpawnPoints.configure.set("spawns.${args[0]}", "${sender.world.name} | ${pLoc.x} | ${pLoc.y} | ${pLoc.z} | ${pLoc.yaw} | ${pLoc.pitch}")
                SpawnPoints.configure.save(SpawnPoints.configureFile)
            }
            return true
        } else {
            return false
        }
    }
}