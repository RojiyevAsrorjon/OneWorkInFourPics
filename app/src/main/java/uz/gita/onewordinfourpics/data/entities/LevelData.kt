package uz.gita.onewordinfourpics.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_level_table")
data class LevelData(
    @PrimaryKey
    val id : Long = 0L,
    var level: Int = 1
)