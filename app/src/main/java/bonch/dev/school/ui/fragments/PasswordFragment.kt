package bonch.dev.school.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import bonch.dev.school.ui.R

class PasswordFragment: DialogFragment() {
    private lateinit var changeBtn: Button
    private lateinit var oldPassword: EditText
    private lateinit var newPassword: EditText
    private lateinit var confirmPassword: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_password, container, false)
        init(view)
        setListeners()
        return view
    }

    private fun init(view: View){
        changeBtn = view.findViewById(R.id.change_password_button)
        oldPassword = view.findViewById(R.id.old_password_edit_text)
        newPassword = view.findViewById(R.id.new_password_edit_text)
        confirmPassword = view.findViewById(R.id.confirm_password_edit_text)
    }

    private fun setListeners(){
        changeBtn.setOnClickListener {
            Toast.makeText(this.context, "Password changed!", Toast.LENGTH_LONG).show()
            dismiss()
        }

    }
}