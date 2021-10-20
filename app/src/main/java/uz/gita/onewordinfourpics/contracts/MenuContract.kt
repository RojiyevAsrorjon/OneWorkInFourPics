package uz.gita.onewordinfourpics.contracts

import uz.gita.onewordinfourpics.data.entities.GameQuestionData

interface MenuContract {
    interface Model{
        fun getLastLevelOfGame() : GameQuestionData
        fun getCoin() : Int
    }
    interface View{
        fun setGame(gameQuestionData: GameQuestionData, coin : Int)
        fun openGameActivity()
    }
    interface Presenter{
        fun setGameLevel()
        fun clickPlayButton()
    }
}