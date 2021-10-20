package uz.gita.onewordinfourpics.ui.presenters

import android.graphics.Color
import android.view.View
import uz.gita.onewordinfourpics.contracts.GameContract
import uz.gita.onewordinfourpics.data.entities.GameQuestionData

class GamePresenter(private val view: GameContract.View, private val model: GameContract.Model) :
    GameContract.Presenter {
    private var level = 0
    private var coin = 0
    private fun setQuestion(questionData: GameQuestionData) {
        view.setQuestion(questionData)
    }

    init {
        val level = model.getLastLevel()
        if (model.getMoney() == -1) {
            model.setMoney(400)
        }
        if (level < model.getQuestions().size) {
            val questionData = model.getQuestions()[level]
            view.addCoins(model.getMoney())
            setQuestion(questionData)
        } else {
            setQuestion(model.getQuestions()[0])
            view.addCoins(model.getMoney())
            model.setLevel()
        }
    }

    override fun clickLetters() {
        val letters = view.getLetters()
        val answers = view.getAnswers()
        for (i in 0 until letters.size) {
            letters[i].setOnClickListener {
                val level = model.getLastLevel()
                val question = model.getQuestions()[level]
                for (answerLetter in answers) {
                    if (answerLetter.text == "" && answerLetter.visibility == View.VISIBLE) {
                        answerLetter.text = letters[i].text.toString()
                        answerLetter.tag = i.toString()
                        letters[i].text = ""
                        break
                    }
                }
                if (answers[question.answer.length - 1].text != "") {
                    if (checkResult(level)) {
                        showDialog(level)
                        val coin = model.getMoney()
                        view.addCoins(coin + 4)
                        model.setMoney(coin + 4)
                    }
                }
            }
        }
        for (i in 0 until answers.size) {
            answers[i].setOnClickListener {
                if (answers[i].text.toString() != "") {
                    val index = answers[i].tag.toString().toInt()
                    letters[index].text = answers[i].text.toString()
                    answers[i].text = ""
                }
            }
        }
    }

    override fun clickLump() {
        val level = model.getLastLevel()
        val question = model.getQuestions()[level]
        var pos = (question.answer.indices).random()
        val answers = view.getAnswers()
        while (answers[pos].text != "") {
            pos = (question.answer.indices).random()
        }
        if (answers[pos].text == "" && model.getMoney()>=60) {
            answers[pos].text = question.answer[pos].toString()
            answers[pos].setTextColor(Color.parseColor("#B0D815"))
            answers[pos].isClickable = false
            view.addCoins(model.getMoney() - 60)
            model.setMoney(model.getMoney()-60)
            if (checkResult(level)) {
                showDialog(level)
                val coin = model.getMoney()
                view.addCoins(coin + 4)
                model.setMoney(coin + 4)
            }
        }
        else view.showSnackBar("You don`t have enough money!")
    }

    override fun clickBack() {
        view.finishActivity()
    }

    override fun clickContinue() {
        var level = model.getLastLevel()
        val questionData = model.getQuestions()
        setQuestion(questionData[level])
        view.closeDialog()
    }


    private fun checkResult(level: Int): Boolean {
        val answerLetters = view.getAnswers()
        val question = model.getQuestions()[level]
        var _string = ""
        for (element in answerLetters) {
            if (element.visibility == View.VISIBLE) {
                _string += element.text.toString()
            }
        }
        if (_string.equals(question.answer, true)) {
            return true
        }
        return false
    }

    private fun showDialog(level: Int) {
        val letters = view.getLetters()
        val answers = view.getAnswers()
        val showAnswers = view.getShowAnswers()
        val question = model.getQuestions()[level]

        if (level < model.getQuestions().size-1) {
            view.showDialog()
            for (letter in letters) {
                letter.isClickable = false
            }
            for (answerLetter in answers) {
                answerLetter.isClickable = false
            }
            view.makeSomeButtons()
            val answer = question.answer
            for (i in 0 until answers.size) {
                if (i < answer.length) {
                    showAnswers[i].visibility = View.VISIBLE
                    showAnswers[i].text = answer[i].toString()
                } else {
                    showAnswers[i].visibility = View.GONE
                }
            }
            for (i in 0 until showAnswers.size) {
                if (i < answer.length) {
                    showAnswers[i].visibility = View.VISIBLE
                    showAnswers[i].text = answer[i].toString()
                } else {
                    showAnswers[i].visibility = View.GONE
                }
            }
            view.setCoinShow(model.getMoney())
            model.setLevel()
            view.showDialog()
        } else {
            view.showDialog()
            for (letter in letters) {
                letter.isClickable = false
            }
            for (answerLetter in answers) {
                answerLetter.isClickable = false
            }
            view.makeSomeButtons()
            val answer = question.answer
            for (i in 0 until answers.size) {
                if (i < answer.length) {
                    showAnswers[i].visibility = View.VISIBLE
                    showAnswers[i].text = answer[i].toString()
                } else {
                    showAnswers[i].visibility = View.GONE
                }
            }
            for (i in 0 until showAnswers.size) {
                if (i < answer.length) {
                    showAnswers[i].visibility = View.VISIBLE
                    showAnswers[i].text = answer[i].toString()
                } else {
                    showAnswers[i].visibility = View.GONE
                }
            }
            view.setCoinShow(model.getMoney())
            view.finishDialog()
            model.setLevel()
        }

    }

    override fun clickBackButtonShow() {
        view.finishActivity()
    }
}