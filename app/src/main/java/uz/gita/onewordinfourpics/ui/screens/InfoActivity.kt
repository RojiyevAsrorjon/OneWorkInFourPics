package uz.gita.onewordinfourpics.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.asrorxon.onewordinfourpics.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()
        }
    }
}