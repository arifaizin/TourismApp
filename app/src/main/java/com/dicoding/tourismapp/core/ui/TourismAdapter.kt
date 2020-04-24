package com.dicoding.tourismapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import kotlinx.android.synthetic.main.item_list_data.view.*
import java.util.ArrayList

class TourismAdapter : RecyclerView.Adapter<TourismAdapter.ListViewHolder>() {

    private var listData = ArrayList<TourismEntity>()
    var onItemClick: ((TourismEntity) -> Unit)? = null

    fun setData(newListData: List<TourismEntity>?) {
        if (newListData == null) return
        this.listData.clear()
        this.listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_data, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: TourismEntity) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.image1)
                    .into(media_image)

                title_text.text = data.caption
                subtitle_text.text = data.address
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}