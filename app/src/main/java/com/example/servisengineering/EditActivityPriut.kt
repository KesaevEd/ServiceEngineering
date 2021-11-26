package com.example.servisengineering

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.servisengineering.db59.MyIntentConstants59
import com.example.servisengineering.dbPriut.MyDbManagerPriut
import java.text.SimpleDateFormat
import java.util.*

class EditActivityPriut : AppCompatActivity() {

    val imageRequestCode = 10
    var tempImageUri: String = ""
    var isEditState = false
    var id = 0

    val myDbManager = MyDbManagerPriut(this)   //СОЗДАЕМ БАЗУ ДАННЫХ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_priut)
        getMyIntents()
    }

    fun onClickSave(view: View){
        myDbManager.openDb()   //open database

        val edTitle: EditText = findViewById(R.id.edTitle)
        val edDesc: EditText = findViewById(R.id.edDesc)
        val myTitle = edTitle.text.toString()
        val myDesc = edDesc.text.toString()


        if(myTitle != ""){
            if(isEditState) {          //ПРОВЕРКА ЕСТЬ ЛИ ДАННЫЕ
                myDbManager.updateItem(myTitle, myDesc, tempImageUri, id, getCurrentDate())   //update database
            }else{
                myDbManager.insertToDb(myTitle, myDesc, tempImageUri, getCurrentDate())      //write to database
            }
            finish()
        }


    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun onClickAddImage(view: android.view.View) {
        val mainImLayout: ConstraintLayout = findViewById(R.id.mainImageLayout)
        mainImLayout.visibility = View.VISIBLE
        val addImage: FloatingActionButton = findViewById(R.id.addImge)
        addImage.visibility = View.GONE
    }

    //CHOOSE IMAGE
    fun onClickChooseImage(view: android.view.View) {
        val addImage: FloatingActionButton = findViewById(R.id.addImge)
        addImage.visibility = View.GONE
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startActivityForResult(intent, imageRequestCode)
    }

    //DELETE PICTURE
    fun onClickDeleteImage(view: android.view.View) {
        val mainImLayout: ConstraintLayout = findViewById(R.id.mainImageLayout)
        mainImLayout.visibility = View.GONE
        val addImage: FloatingActionButton = findViewById(R.id.addImge)
        addImage.visibility = View.VISIBLE
        tempImageUri = "empty"
    }

    //GETING URI OF IMAGE
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == imageRequestCode){
            val imageView: ImageView = findViewById(R.id.imageView)
            imageView.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
            contentResolver.takePersistableUriPermission(data?.data!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    fun getMyIntents(){
        val i = intent

        if(i != null){
            if(i.getStringExtra(MyIntentConstants59.I_TITLE_KEY) != null){

                val edTitle: EditText = findViewById(R.id.edTitle)
                val edDesc: EditText = findViewById(R.id.edDesc)
                edTitle.setText(i.getStringExtra(MyIntentConstants59.I_TITLE_KEY))
                edDesc.setText(i.getStringExtra(MyIntentConstants59.I_DESC_KEY))

                isEditState = true

                id = i.getIntExtra(MyIntentConstants59.I_ID_KEY, 0)

                val addImage: FloatingActionButton = findViewById(R.id.addImge)
                addImage.visibility = View.GONE

                if(i.getStringExtra(MyIntentConstants59.I_URI_KEY) != "empty"){

                    val mainImLayout: ConstraintLayout = findViewById(R.id.mainImageLayout)
                    mainImLayout.visibility = View.VISIBLE

                    val imageView: ImageView = findViewById(R.id.imageView)
                    imageView.setImageURI(Uri.parse(i.getStringExtra(MyIntentConstants59.I_URI_KEY)))

                }
            }
        }

    }

    //GETTING CURRENT DATE
    private fun getCurrentDate(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        return formatter.format(time)
    }

}