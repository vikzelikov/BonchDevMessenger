package bonch.dev.school.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import bonch.dev.school.ui.R
import bonch.dev.school.ui.fragments.ChatFragment
import bonch.dev.school.ui.fragments.ProfileFragment

class MainAppActivity : AppCompatActivity() {
    val fm = supportFragmentManager
    private var chatFragment = ChatFragment()
    private var profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        fm.beginTransaction()
                .add(R.id.fragment_activity, chatFragment)
                .commit()
    }

    fun replaceFragment(){
        fm.beginTransaction()
                .replace(R.id.fragment_activity, profileFragment)
                .addToBackStack("fragment_profile")
                .commit()
    }

    fun getFM(): FragmentManager {
        return fm
    }

}