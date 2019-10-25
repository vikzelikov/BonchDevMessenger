package bonch.dev.school.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.school.ui.R

class SignInActivity : AppCompatActivity() {

    private lateinit var signIn: Button
    private lateinit var signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
        setListeners()
    }


    private fun init(){
        signIn = findViewById(R.id.sign_in_button)
        signUp = findViewById(R.id.sign_up_button)
    }

    private fun setListeners(){
        signIn.setOnClickListener{
            val intent = Intent(this, MainAppActivity::class.java)
            //users data
            //intent.putExtra("login", "")
            //intent.putExtra("password", "")
            startActivity(intent)
        }


        signUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}
