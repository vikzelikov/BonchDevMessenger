package bonch.dev.school.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.models.Message
import bonch.dev.school.ui.MessageRecyclerItems
import java.util.*

class ChatFragment:Fragment() {
    private lateinit var messageField: EditText
    private lateinit var sendMessage: ImageButton
    private lateinit var messageRecycler: RecyclerView
    private lateinit var messageList: MutableList<Message>
    private lateinit var layoutManager: LinearLayoutManager
    private var listState: Parcelable ?= null


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat,container,false)
        init(view)
        setListeners()
        //set TEST data 20 message for example
        for (i in 1..20) {
            addMessage("Some text", Date(), false)
        }

        //scroll to bottom
        scrollBottom()
        messageRecycler.layoutManager = layoutManager
        //set data in recycler
        messageRecycler.adapter = MessageRecyclerItems(messageList)
        return view
    }

    private fun init(view: View){
        messageList = mutableListOf()
        layoutManager = LinearLayoutManager(context)

        sendMessage = view.findViewById(R.id.send_message_button)
        messageField = view.findViewById(R.id.message_et)
        messageRecycler = view.findViewById(R.id.message_recycler_view)
    }

    private fun setListeners(){
        sendMessage.setOnClickListener{
            if (messageField.text.toString().trim() != ""){
                addMessage(messageField.text.toString().trim(), Date(),true)
                messageField.setText("")
                scrollBottom()
            }
        }
    }

    private fun addMessage(message: String, date: Date, isUser: Boolean){
        messageList.add(Message(1, message, date, isUser))
    }

    private fun scrollBottom(){
        messageRecycler.scrollToPosition(MessageRecyclerItems(messageList).itemCount-1)
    }

    override fun onPause() {
        super.onPause()
        listState = messageRecycler.layoutManager?.onSaveInstanceState()
    }

    override fun onResume() {
        super.onResume()
        if (listState != null){
            messageRecycler.layoutManager?.onRestoreInstanceState(listState)
        }
    }

}
