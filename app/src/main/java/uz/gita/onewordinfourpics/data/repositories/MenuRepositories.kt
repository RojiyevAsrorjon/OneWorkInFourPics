package uz.gita.onewordinfourpics.data.repositories

import uz.gita.onewordinfourpics.contracts.MenuContract
import uz.gita.onewordinfourpics.data.LocalDatabase
import uz.gita.onewordinfourpics.data.entities.GameQuestionData
import uz.gita.onewordinfourpics.data.entities.Questions

class MenuRepositories : MenuContract.Model {
    private val dao = LocalDatabase()
    private val rep = Questions().getQuestions()
    override fun getLastLevelOfGame(): GameQuestionData {
        val level = dao.getLevel()
        return if (level < 2) {
            rep[level]
        } else rep[0]
    }

    override fun getCoin(): Int {
        return dao.getMoney()
    }
}