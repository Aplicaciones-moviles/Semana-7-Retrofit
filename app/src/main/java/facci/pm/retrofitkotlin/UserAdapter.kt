package facci.pm.retrofitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList:ArrayList<User>)
    :RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName: TextView = itemView.findViewById(R.id.TextViewName)
        val textViewUsername: TextView = itemView.findViewById(R.id.TextViewUsername)
        val textViewEmail: TextView = itemView.findViewById(R.id.TextViewEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.textViewName.text = user.name
        holder.textViewUsername.text = user.username
        holder.textViewEmail.setText(user.email)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}