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
        val view = inflater.inflate(R.layout.fragment_chat, container,false)
        init(view)
        setListeners()

        val dataMessages: MutableList<Message> = receiveMessagesFromServer()
        setDataInRecyclerView(dataMessages)
        scrollBottom()
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

    private fun setDataInRecyclerView(dataMessages: MutableList<Message>){
        messageList.addAll(dataMessages)
        messageRecycler.layoutManager = layoutManager
        messageRecycler.adapter = MessageRecyclerItems(messageList)
    }

    private fun addMessage(message: String, date: Date, isUser: Boolean){
        messageList.add(Message(1, message, date, isUser))
        if(isUser){
            //TODO
            //send to server for save
            //сообщения собеседника не надо сохранять в базу, тк они уже сохранены
        }
    }

    private fun receiveMessagesFromServer(): MutableList<Message>{
        /* TODO
        * Запросить у сервера первые 20 сообщений для вывода
        * ??? Если доскроллил до верха экрана, то запросить следующие 20 сообщений ???
        * */

        //FOR EXAMPLE
        val dataMessages: MutableList<Message> = mutableListOf()
        for (i in 1..20) {
            //разделим для наглядности
            if(i%2 == 0){
                dataMessages.add(Message(1,"This is my text!", Date(), true))
            }else{
                dataMessages.add(Message(1,"The text of other user", Date(), false))
            }
        }
        return dataMessages
    }

    private fun receiveOtherMessage(){
        //TODO
        //method call if other user send message
        //add to messageList for output
    }

    private fun scrollBottom(){
        messageRecycler.scrollToPosition(messageList.count()-1)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("RECYCLER", messageRecycler.layoutManager?.onSaveInstanceState())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null){
            listState = savedInstanceState?.getParcelable("RECYCLER")
            messageRecycler.layoutManager?.onRestoreInstanceState(listState)
        }
    }



}
