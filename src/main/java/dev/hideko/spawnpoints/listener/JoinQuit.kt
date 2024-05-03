package dev.hideko.spawnpoints.listener

import dev.hideko.spawnpoints.SpawnPoints
import dev.hideko.spawnpoints.utils.LocationReader
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinQuit: Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        e.player.teleport(LocationReader().readLocation("hub"))
    }
}