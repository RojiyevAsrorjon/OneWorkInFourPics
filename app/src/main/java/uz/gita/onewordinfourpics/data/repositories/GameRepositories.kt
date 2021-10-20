package uz.gita.onewordinfourpics.data.repositories

import uz.gita.onewordinfourpics.contracts.GameContract
import uz.gita.onewordinfourpics.data.LocalDatabase
import uz.gita.onewordinfourpics.data.entities.GameQuestionData
import uz.gita.onewordinfourpics.data.entities.Questions

class GameRepositories : GameContract.Model {
    private val gameList = Questions().getQuestions()
    private val data = LocalDatabase()
     override fun getQuestions(): List<GameQuestionData> {
        return gameList
    }

    override fun getLastLevel() : Int{
        return getLevelFromDatabase()
    }

    override fun setLevel() {
        var level = getLevelFromDatabase()
        if (level < gameList.size) {
            data.setLevel(++level)
        }
        else{
            data.setLevel(0)
        }

    }

    override fun getMoney() : Int {
        return data.getMoney()
    }

    override fun setMoney(coin: Int) {
        data.setMoney(coin)
    }

    private fun getLevelFromDatabase(): Int = data.getLevel()


}