package uz.gita.onewordinfourpics.contracts

import android.widget.Button
import uz.gita.onewordinfourpics.data.entities.GameQuestionData

interface GameContract {
    interface Model {
        fun getQuestions() : List<GameQuestionData>
        fun getLastLevel() : Int
        fun setLevel()
        fun getMoney() : Int
        fun setMoney(coin : Int)
    }

    interface View {
        fun setQuestion(questionData: GameQuestionData)
        fun getLetters() : ArrayList<Button>
        fun getAnswers() : ArrayList<Button>
        fun getShowAnswers(): ArrayList<Button>
        fun showDialog()
        fun closeDialog()
        fun makeSomeButtons()
        fun finishActivity()
        fun finishDialog()
        fun addCoins(coin : Int)
        fun setLevel(level : Int)
        fun showSnackBar(message : String)
        fun setCoinShow(coin : Int)
    }

    interface Presenter {
        fun clickLetters()
        fun clickLump()
        fun clickBack()
        fun clickContinue()
        fun clickBackButtonShow()
    }
}