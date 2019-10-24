package bonch.dev.school.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.school.ui.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        if (supportActionBar != null)
            supportActionBar?.hide()
        init()
        setListeners()
    }

    private fun init(){
        signUp = findViewById(R.id.complete_sign_up_button)
    }

    private fun setListeners(){
        signUp.setOnClickListener{
            val intent = Intent(this, MainAppActivity::class.java)
            startActivity(intent)
        }
    }
}
