package bonch.dev.school.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.models.Message
import java.util.*

class MessageRecyclerItems(val messageList: MutableList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mymsg=1
    val othermsg=2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            mymsg-> UserViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.user_message_item, parent,false)))
            othermsg-> OtherViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.other_message_item,parent,false)))
            else -> UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_message_item,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            mymsg-> (holder as UserViewHolder).bind(position)
            othermsg->(holder as OtherViewHolder).bind(position)
        }
    }
    
    override fun getItemCount(): Int {
        return messageList.size
    }

    inner class UserViewHolder(view:View):RecyclerView.ViewHolder(view){
        val showText:TextView=view.findViewById(R.id.user_message_text)
        val showDate:TextView=view.findViewById(R.id.user_message_date)
        fun bind(position: Int){
            showText.text="${messageList[position].messageText}"
            showDate.text="${Date()}"
        }
    }

    inner class OtherViewHolder(view: View):RecyclerView.ViewHolder(view){
        val showText:TextView=view.findViewById(R.id.other_message_text)
        val showDate:TextView=view.findViewById(R.id.other_message_date)
        val senderName:TextView=view.findViewById(R.id.other_message_name)
        fun bind(position: Int){
            showText.text="${messageList[position].messageText}"
            showDate.text="${Date()}"
            senderName.text="Имя другого пользователя"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList.get(position).isUser){
            mymsg
        }
        else othermsg
    }

}