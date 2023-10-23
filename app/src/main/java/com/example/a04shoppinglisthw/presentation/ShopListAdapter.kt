package com.example.a04shoppinglisthw.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a04shoppinglisthw.R
import com.example.a04shoppinglisthw.domain.ShopItem

class ShopListAdapter:RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_item_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_item_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_enabled, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = shopList[position]
        holder.tvName.text = item.name
        holder.tvCount.text = item.count.toString()

        val status = if (item.enabled)
            "Active"
        else
            "Inactive"

        if (status == "Active"){
            holder.tvName.text = item.name + " is active"
            holder.tvName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
        }
    }

    override fun onViewRecycled(holder: ShopItemViewHolder) {
        super.onViewRecycled(holder)
        holder.tvName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
    }
}