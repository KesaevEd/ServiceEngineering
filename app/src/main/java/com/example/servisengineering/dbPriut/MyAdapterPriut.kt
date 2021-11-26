package com.example.servisengineering.dbPriut

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.servisengineering.EditActivity59
import com.example.servisengineering.EditActivityPriut
import com.example.servisengineering.R

class MyAdapterPriut(listMain: ArrayList<ListItemPriut>, contextM: Context): RecyclerView.Adapter<MyAdapterPriut.MyHolder>() {
    var listArray = listMain
    var context = contextM

    class MyHolder(itemView: View, contextV: Context): RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.et)
        val date = itemView.findViewById<TextView>(R.id.date)
        val context = contextV


        //WHERE WE ENTER DATA
        fun setData(item: ListItemPriut){
            tvTitle.text = item.title
            date.text = item.date

            itemView.setOnClickListener {

                val intent = Intent(context, EditActivityPriut::class.java).apply {

                    putExtra(MyIntentConstantsPriut.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstantsPriut.I_DESC_KEY, item.desc)
                    putExtra(MyIntentConstantsPriut.I_URI_KEY, item.uri)
                    putExtra(MyIntentConstantsPriut.I_ID_KEY, item.id)
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

    fun updateAdapter(listItems: List<ListItemPriut>){
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()
    }

    //ФУНКЦИЯ УДАЛЕНИЕ ИЗ RecyclerView
    fun removeItem(pos: Int, dbManager: MyDbManagerPriut){

        dbManager.removeItemFromDb(listArray[pos].id.toString())
        listArray.removeAt(pos)
        notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(pos)
    }
}