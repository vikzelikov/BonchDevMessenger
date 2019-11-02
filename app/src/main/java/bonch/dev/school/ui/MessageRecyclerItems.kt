package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.models.Message

class MessageRecyclerItems(val messageList: MutableList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val OTHER_MESSAGE = 0
    private val USER_MESSAGE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == USER_MESSAGE){
            UserViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.user_message_item, parent,false)))
        }else{
            OtherViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.other_message_item,parent,false)))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if(getItemViewType(position) == USER_MESSAGE){
            (holder as UserViewHolder).bind(position)
        }else{
            (holder as OtherViewHolder).bind(position)
        }
    }

    inner class UserViewHolder(view:View):RecyclerView.ViewHolder(view){
        val messageTextView: TextView = view.findViewById(R.id.user_message_text)
        val dateTextView: TextView=view.findViewById(R.id.user_message_date)
        fun bind(position: Int){
            messageTextView.text = messageList[position].messageText
            dateTextView.text = messageList[position].sentDate.toString()
        }
    }

    inner class OtherViewHolder(view: View):RecyclerView.ViewHolder(view){
        val messageTextView: TextView = view.findViewById(R.id.other_message_text)
        val dateTextView: TextView = view.findViewById(R.id.other_message_date)
        val nameTextView: TextView = view.findViewById(R.id.other_message_name)
        fun bind(position: Int){
            messageTextView.text = messageList[position].messageText
            dateTextView.text = messageList[position].sentDate.toString()
            nameTextView.text = "Other User"
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isUser){
            USER_MESSAGE
        }
        else OTHER_MESSAGE
    }

}
