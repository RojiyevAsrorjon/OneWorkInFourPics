package uz.gita.onewordinfourpics.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.asrorxon.onewordinfourpics.R
import uz.gita.onewordinfourpics.contracts.MenuContract
import uz.gita.onewordinfourpics.data.entities.GameQuestionData
import uz.gita.onewordinfourpics.data.repositories.MenuRepositories
import uz.gita.onewordinfourpics.ui.presenters.MenuPresenter

class MenuActivity : AppCompatActivity(), MenuContract.View {
    private lateinit var presenter: MenuContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        presenter = MenuPresenter(this, MenuRepositories())
        presenter.setGameLevel()
        findViewById<Button>(R.id.playButton).setOnClickListener{
            presenter.clickPlayButton()
        }
        findViewById<ImageButton>(R.id.buttonInfo).setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setGameLevel()
    }

    override fun setGame(gameQuestionData: GameQuestionData, coin : Int) {
        val levelText = findViewById<TextView>(R.id.menuLevelText)
        val image1 = findViewById<ImageView>(R.id.imageMenu1)
        val image2 = findViewById<ImageView>(R.id.imageMenu2)
        val image3 = findViewById<ImageView>(R.id.imageMenu3)
        val image4 = findViewById<ImageView>(R.id.imageMenu4)

        val level = gameQuestionData.id + 1
        levelText.text = "$level"

        val textCoin = findViewById<TextView>(R.id.coinText)
        if (coin == -1) {
            textCoin.text = 400.toString()
        }
        else textCoin.text = coin.toString()
        image1.setImageResource(gameQuestionData.questionImages.image1)
        image2.setImageResource(gameQuestionData.questionImages.image2)
        image3.setImageResource(gameQuestionData.questionImages.image3)
        image4.setImageResource(gameQuestionData.questionImages.image4)
    }

    override fun openGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
    }


}