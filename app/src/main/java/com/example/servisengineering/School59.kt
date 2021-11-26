package com.example.servisengineering

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import android.view.View
import android.widget.*
import com.example.servisengineering.checkBox59.CheckBoxAdapter59
import com.example.servisengineering.checkBox59.CheckBoxDbManager59
import com.example.servisengineering.checkBox93.CheckBoxAdapter93
import com.example.servisengineering.checkBox93.CheckBoxDbManager93
import com.example.servisengineering.db59.MyAdapter59
import com.example.servisengineering.db59.MyDbManager59
import com.example.servisengineering.db93.MyAdapter93
import com.example.servisengineering.db93.MyDbManager93
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class School59 : AppCompatActivity() {

    val myDbManager = MyDbManager59(this)   //CREATE DATABASE
    val myAdapter = MyAdapter59(ArrayList(), this)  //CREATE RecyclerView ADAPTER
    val checkBoxDbManager = CheckBoxDbManager59(this)
    val checkBoxAdapter = CheckBoxAdapter59(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school59)
        init()
        checkBoxDbManager.openDb()

        val n1: TextView = findViewById(R.id.num1)
        val n2: TextView = findViewById(R.id.num2)
        val n3: TextView = findViewById(R.id.num3)
        val n4: TextView = findViewById(R.id.num4)
        val AllNum = ArrayList<TextView>()

        AllNum.add(n1)
        AllNum.add(n2)
        AllNum.add(n3)
        AllNum.add(n4)

        val date: TextView = findViewById(R.id.date)
        val currentDate = Date()
        val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val dateText: String = dateFormat.format(currentDate)
        val weekNumber: DateFormat = SimpleDateFormat("W", Locale.getDefault())
        val wN: String = weekNumber.format(currentDate)
        val w = wN.toInt()

        date.setText(dateText)

        AllNum[w - 1].setTextColor(Color.RED)

        val spinner: Spinner = findViewById(R.id.spinner)
        val numbers = arrayOf("Контакты:","Сильванера Константиновна (директор)", "Нелля Альбертовна (завуч по АХЧ)", "Охрана", "Алексей (слесарь)", "Андрей (пожарка)", "Владимир (электрика)")


        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numbers)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (numbers[position] == "Сильванера Константиновна (директор)") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+89127831878"))
                    startActivity(intent)
                } else if (numbers[position] == "Нелля Альбертовна (завуч по АХЧ)") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+89526501385"))
                    startActivity(intent)
                } else if (numbers[position] == "Охрана") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+73422085574"))
                    startActivity(intent)
                } else if (numbers[position] == "Алексей (слесарь)") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+79048499344"))
                    startActivity(intent)
                } else if (numbers[position] == "Андрей (пожарка)") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+89028338971"))
                    startActivity(intent)
                } else if (numbers[position] == "Владимир (электрика)") {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+89223544678"))
                    startActivity(intent)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val chB1: CheckBox = findViewById(R.id.chB1)
        val chB2: CheckBox = findViewById(R.id.chB2)
        val chB3: CheckBox = findViewById(R.id.chB3)
        val chB4: CheckBox = findViewById(R.id.chB4)
        val chB5: CheckBox = findViewById(R.id.chB5)
        val chB6: CheckBox = findViewById(R.id.chB6)
        val chB7: CheckBox = findViewById(R.id.chB7)
        val chB8: CheckBox = findViewById(R.id.chB8)


        chB1.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }

        chB2.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }
        chB3.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }

        chB4.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }
        chB5.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }

        chB6.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }

        chB7.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }

        chB8.setOnCheckedChangeListener { buttonView, isChecked ->
            checkBoxListner()
        }


    }

    fun onClickNew(view: android.view.View) {
        val i = Intent(this, EditActivity59::class.java)
        startActivity(i)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        fillAdapter()
        val checkBoxList = ArrayList<CheckBox>()

        val B1: CheckBox = findViewById(R.id.chB1)
        val B2: CheckBox = findViewById(R.id.chB2)
        val B3: CheckBox = findViewById(R.id.chB3)
        val B4: CheckBox = findViewById(R.id.chB4)
        val B5: CheckBox = findViewById(R.id.chB5)
        val B6: CheckBox = findViewById(R.id.chB6)
        val B7: CheckBox = findViewById(R.id.chB7)
        val B8: CheckBox = findViewById(R.id.chB8)

        myDbManager.openDb()
        try {
            checkBoxAdapter.fillAllCheckBox(
                checkBoxDbManager.readDbData(),
                checkBoxAdapter.checkBoxList(checkBoxList, B1, B2, B3, B4, B5, B6, B7, B8)
            )
        }catch (e: Exception) {}
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
        checkBoxDbManager.closeDb()
    }

    //CONNECTING ADAPTER with RecyclerView
    fun init(){
        val rcView: RecyclerView = findViewById(R.id.rvContainer)
        rcView.layoutManager =
            LinearLayoutManager(this)
        val swapHelper = getSwapMg()
        swapHelper.attachToRecyclerView(rcView)
        rcView.adapter = myAdapter
    }

    //UPDATING ADAPTER FROM DATABASE
    fun fillAdapter(){
        myAdapter.updateAdapter(myDbManager.readDbData())
    }

    //УДАЛЕНИЕ СВАЙПОМ
    private fun getSwapMg(): ItemTouchHelper {
        return ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                p0: RecyclerView,
                p1: RecyclerView.ViewHolder,
                p2: RecyclerView.ViewHolder
            ): Boolean {
                return false //ИСКЛЮЧАЕМ ТАК КАК НЕНУЖНАЯ ФУНКЦИЯ
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, p1: Int) {
                myAdapter.removeItem(viewHolder.adapterPosition, myDbManager)

            }
        })
    }

    fun checkBoxListner() {
        val B1: CheckBox = findViewById(R.id.chB1)
        val B2: CheckBox = findViewById(R.id.chB2)
        val B3: CheckBox = findViewById(R.id.chB3)
        val B4: CheckBox = findViewById(R.id.chB4)
        val B5: CheckBox = findViewById(R.id.chB5)
        val B6: CheckBox = findViewById(R.id.chB6)
        val B7: CheckBox = findViewById(R.id.chB7)
        val B8: CheckBox = findViewById(R.id.chB8)

        if (checkBoxDbManager.readDbData().isEmpty()) {

            checkBoxDbManager.insertToDb(
                checkBoxAdapter.CheckBoxStatus(B1),
                checkBoxAdapter.CheckBoxStatus(B2),
                checkBoxAdapter.CheckBoxStatus(B3),
                checkBoxAdapter.CheckBoxStatus(B4),
                checkBoxAdapter.CheckBoxStatus(B5),
                checkBoxAdapter.CheckBoxStatus(B6),
                checkBoxAdapter.CheckBoxStatus(B7),
                checkBoxAdapter.CheckBoxStatus(B8),
            )
        } else {
            checkBoxDbManager.updateItem(
                checkBoxAdapter.CheckBoxStatus(B1),
                checkBoxAdapter.CheckBoxStatus(B2),
                checkBoxAdapter.CheckBoxStatus(B3),
                checkBoxAdapter.CheckBoxStatus(B4),
                checkBoxAdapter.CheckBoxStatus(B5),
                checkBoxAdapter.CheckBoxStatus(B6),
                checkBoxAdapter.CheckBoxStatus(B7),
                checkBoxAdapter.CheckBoxStatus(B8), 1
            )
        }
    }

}