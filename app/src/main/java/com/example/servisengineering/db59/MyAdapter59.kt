package com.example.servisengineering.db59

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.servisengineering.EditActivity
import com.example.servisengineering.EditActivity59
import com.example.servisengineering.R
import com.example.servisengineering.checkBox93.CheckBoxAdapter93

class MyAdapter59(listMain: ArrayList<ListItem59>, contextM: Context): RecyclerView.Adapter<MyAdapter59.MyHolder>() {
    var listArray = listMain
    var context = contextM

    class MyHolder(itemView: View, contextV: Context): RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.et)
        val date = itemView.findViewById<TextView>(R.id.date)
        val context = contextV


        //WHERE WE ENTER DATA
        fun setData(item: ListItem59){
            tvTitle.text = item.title
            date.text = item.date

            itemView.setOnClickListener {

                val intent = Intent(context, EditActivity59::class.java).apply {

                    putExtra(MyIntentConstants59.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstants59.I_DESC_KEY, item.desc)
                    putExtra(MyIntentConstants59.I_URI_KEY, item.uri)
                    putExtra(MyIntentConstants59.I_ID_KEY, item.id)
                }
                context.startActivity(intent)
            }
        }
    }

    //CREATE LAYOUT
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyHolder(inflater.inflate(R.layout.add_job, parent, false), context)
    }

    //FILLING IN THE LAYOUT
    override fun onBindViewHolder(holder: MyHolder, position: Int){
        holder.setData(listArray.get(position))
    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    fun updateAdapter(listItems: List<ListItem59>){
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()
    }

    //ФУНКЦИЯ УДАЛЕНИЕ ИЗ RecyclerView
    fun removeItem(pos: Int, dbManager: MyDbManager59){

        dbManager.removeItemFromDb(listArray[pos].id.toString())
        listArray.removeAt(pos)
        notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(pos)
    }
}