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
    private var isChatFragment = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        setInstanceState(savedInstanceState)
    }

    fun setChatFragment(){
        fm.beginTransaction()
                .add(R.id.fragment_activity, chatFragment)
                .commit()
        isChatFragment = 1
    }
    fun setProfileFragment(){
        fm.beginTransaction()
                .replace(R.id.fragment_activity, profileFragment)
                .addToBackStack("fragment_profile")
                .commit()
        isChatFragment = 0
    }


    fun getFM(): FragmentManager {
        return fm
    }

    private fun setInstanceState(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            setChatFragment()
        } else {
            isChatFragment = savedInstanceState.getInt("IS_CHAT")
            if(isChatFragment == 1){
                setChatFragment()
            }else{
                setProfileFragment()
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("IS_CHAT", isChatFragment)
    }



}