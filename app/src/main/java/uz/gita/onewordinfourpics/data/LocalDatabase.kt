package uz.gita.onewordinfourpics.data

import android.content.Context.MODE_PRIVATE
import uz.gita.onewordinfourpics.app.App

class LocalDatabase {
    private val sharedPreferences = App.instance.getSharedPreferences("game_database", MODE_PRIVATE)
    private val edit = sharedPreferences.edit()
    fun getLevel(): Int {
        return sharedPreferences.getInt("level_game", 0)
    }
    fun setLevel(level: Int) {

        edit.putInt("level_game", level)
        edit.commit()
    }

    fun getMoney() : Int{
        return sharedPreferences.getInt("game_coin", -1)
    }
    fun setMoney(count : Int) {
        edit.putInt("game_coin", count)
        edit.commit()
    }
}