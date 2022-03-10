package com.example.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.example.Rows


class CustomListAdapter(private val context: Context, private val listData: List<Rows>) :
    BaseAdapter() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return listData.size
    }

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null)
            val holder = ViewHolder()
            holder.imageView = convertView!!.findViewById<View>(R.id.imageView) as ImageView
            holder.headerTitle =
                convertView.findViewById(R.id.headerTitle) as TextView
            holder.description =
                convertView.findViewById(R.id.description) as TextView

            val rows: Rows = listData[position]

            holder.apply {
                description!!.text = rows.description
                headerTitle!!.text = rows.title
                if (!rows.imageHref.isNullOrEmpty()) {
                    Glide.with(context)
                        .load(rows.imageHref)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(imageView!!)
                }
            }
        }
        return convertView
    }

    internal class ViewHolder {
        var imageView: ImageView? = null
        var headerTitle: TextView? = null
        var description: TextView? = null
    }

}