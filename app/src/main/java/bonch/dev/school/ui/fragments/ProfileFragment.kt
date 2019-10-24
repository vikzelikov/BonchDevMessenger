package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import bonch.dev.school.ui.R

class ProfileFragment: Fragment() {
    private lateinit var confirmEmail: Button
    private lateinit var changePassword: Button
    private lateinit var logout: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container,false)
        init(view)
        setListeners()
        return view
    }


    private fun init(view:View){
        confirmEmail = view.findViewById(R.id.email_confirm_button)
        changePassword = view.findViewById(R.id.change_password_button)
        logout = view.findViewById(R.id.sign_out_button)
    }

    private fun setListeners(){
        confirmEmail.setOnClickListener{

        }

        changePassword.setOnClickListener{

        }

        logout.setOnClickListener{

        }
    }
}
