package dev.hideko.spawnpoints.utils

import dev.hideko.spawnpoints.SpawnPoints
import org.bukkit.Bukkit
import org.bukkit.Location

class LocationReader {
    fun readLocation(id: String): Location {
        val locData = SpawnPoints.configure.getString("spawns.${id}")
        val splitedData = locData.split(" | ")
        return Location(Bukkit.getWorld(splitedData[0]), splitedData[1].toDouble(), splitedData[2].toDouble(), splitedData[3].toDouble(), splitedData[4].toFloat(), splitedData[5].toFloat())
    }
}