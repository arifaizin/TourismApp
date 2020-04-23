package com.dicoding.tourismapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.model.DataItem
import kotlinx.android.synthetic.main.item_list_data.view.*

class UserAdapter(private val listData: MutableList<DataItem>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_data, parent, false)
        return ListViewHolder(
            view
        )
    }

    fun addUser(newUsers: DataItem) {
        listData.add(newUsers)
        notifyItemInserted(listData.lastIndex)
    }

    fun clear() {
        listData.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataItem){
            with(itemView){
                Glide.with(itemView.context)
                    .load(data.image2)
//                    .apply(RequestOptions().override(80, 80).placeholder(R.drawable.icon_avatar))
//                    .transform(CircleCrop())
                    .into(media_image)

                primary_text.text = data.caption
                sub_text.text = data.address
            }
        }

    }
}