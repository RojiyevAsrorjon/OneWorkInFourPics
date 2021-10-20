package uz.gita.onewordinfourpics.ui.screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.asrorxon.onewordinfourpics.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(
                Intent(this@SplashActivity, MenuActivity::class.java)
            )
            finish ()
        }, 1500)
    }
}