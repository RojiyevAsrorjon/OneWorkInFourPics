package uz.gita.onewordinfourpics.ui.screens

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.asrorxon.onewordinfourpics.R
import com.google.android.material.snackbar.Snackbar
import uz.gita.onewordinfourpics.contracts.GameContract
import uz.gita.onewordinfourpics.data.entities.GameQuestionData
import uz.gita.onewordinfourpics.data.repositories.GameRepositories
import uz.gita.onewordinfourpics.ui.presenters.GamePresenter

class GameActivity : AppCompatActivity(), GameContract.View {
    private val letters = ArrayList<Button>()
    private val answers = ArrayList<Button>()
    private val showAnswers = ArrayList<Button>()
    private val images = ArrayList<ImageView>()
    private lateinit var presenter: GameContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        loadButtons()
        presenter = GamePresenter(this, GameRepositories())
        presenter.clickLetters()
        findViewById<ImageView>(R.id.findButton).setOnClickListener {
            presenter.clickLump()
        }
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            presenter.clickBack()
        }
        findViewById<Button>(R.id.continueButton).setOnClickListener {
            presenter.clickContinue()
        }
        findViewById<ImageButton>(R.id.backButtonShow).setOnClickListener {
            presenter.clickBackButtonShow()
        }
    }


    override fun setQuestion(questionData: GameQuestionData) {
        images[0].setImageResource(questionData.questionImages.image1)
        images[1].setImageResource(questionData.questionImages.image2)
        images[2].setImageResource(questionData.questionImages.image3)
        images[3].setImageResource(questionData.questionImages.image4)
        for (i in answers.indices) {
            if (i < questionData.answer.length) {
                answers[i].visibility = View.VISIBLE
                answers[i].text = ""
                answers[i].isClickable = true
                answers[i].setTextColor(Color.WHITE)
            } else answers[i].visibility = View.GONE

        }
        val list: ArrayList<String> = questionData.getLetter() as ArrayList<String>
        for (i in 0 until letters.size) {
            letters[i].isClickable = true
            letters[i].text = list[i]
        }
        findViewById<TextView>(R.id.levelText).text = (questionData.id + 1).toString()
    }

    override fun showSnackBar(message: String) {
        val snack = Snackbar.make(findViewById(R.id.layoutShow), message, Snackbar.LENGTH_SHORT)
        snack.setTextColor(Color.RED)
        snack.setAction("Close"){
            snack.dismiss()
        }
        snack.show()
    }

    override fun setCoinShow(coin: Int) {
        findViewById<TextView>(R.id.totalScoreCoin).text = coin.toString()
    }


    override fun makeSomeButtons() {
        val lamp = findViewById<ImageView>(R.id.findButton)
        val back = findViewById<ImageButton>(R.id.backButton)
        if (lamp.isClickable && back.isClickable) {
            lamp.isClickable = false
            back.isClickable = false
        } else {
            lamp.isClickable = true
            back.isClickable = true
        }
    }

    override fun finishActivity() {
        finish()
    }

    override fun finishDialog() {
        val continueButton = findViewById<Button>(R.id.continueButton)
        val greatText = findViewById<TextView>(R.id.correctText)
        val text = "Great! Finished!"
        greatText.text = text
        val finishText = "Finish"
        continueButton.text = finishText
        continueButton.setOnClickListener { finish() }
    }

    override fun addCoins(coin: Int) {
        val coinV = findViewById<TextView>(R.id.coinText)
        coinV.text = coin.toString()
    }

    override fun setLevel(level: Int) {
        val levelV = findViewById<TextView>(R.id.levelText)
        levelV.text = level.toString()
    }


    override fun getLetters(): ArrayList<Button> {
        return letters
    }

    override fun getAnswers(): ArrayList<Button> {
        return answers
    }

    override fun showDialog() {
        val dialog = findViewById<ConstraintLayout>(R.id.layoutShow)
        dialog.visibility = View.VISIBLE
    }

    override fun closeDialog() {
        val dialog = findViewById<ConstraintLayout>(R.id.layoutShow)
        dialog.visibility = View.GONE
    }

    override fun getShowAnswers(): ArrayList<Button> {
        return showAnswers
    }

    private fun loadButtons() {
        val list = listOf<Button>(
            findViewById(R.id.answer1),
            findViewById(R.id.answer2),
            findViewById(R.id.answer3),
            findViewById(R.id.answer4),
            findViewById(R.id.answer5),
            findViewById(R.id.answer6),
            findViewById(R.id.answer7),
            findViewById(R.id.answer8),
        )
        val list1 = listOf<Button>(
            findViewById(R.id.letter1Button),
            findViewById(R.id.letter2Button),
            findViewById(R.id.letter3Button),
            findViewById(R.id.letter4Button),
            findViewById(R.id.letter5Button),
            findViewById(R.id.letter6Button),
            findViewById(R.id.letter7Button),
            findViewById(R.id.letter8Button),
            findViewById(R.id.letter9Button),
            findViewById(R.id.letter10Button),
            findViewById(R.id.letter11Button),
            findViewById(R.id.letter12Button)
        )
        showAnswers.addAll(
            listOf(
                findViewById(R.id.answerShow1),
                findViewById(R.id.answerShow2),
                findViewById(R.id.answerShow3),
                findViewById(R.id.answerShow4),
                findViewById(R.id.answerShow5),
                findViewById(R.id.answerShow6),
                findViewById(R.id.answerShow7),
                findViewById(R.id.answerShow8)
            )
        )
        images.addAll(
            listOf(
                findViewById(R.id.imageGame1),
                findViewById(R.id.imageGame2),
                findViewById(R.id.imageGame3),
                findViewById(R.id.imageGame4)
            )
        )
        answers.addAll(list)
        letters.addAll(list1)
        for (answerLetter in answers) {
            answerLetter.text = ""
            answerLetter.visibility = View.GONE
        }
        for (letter in letters) {
            letter.text = ""
        }
    }

}