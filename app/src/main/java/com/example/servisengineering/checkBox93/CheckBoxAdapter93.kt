package com.example.servisengineering.checkBox93

import android.content.Context
import android.widget.CheckBox

class CheckBoxAdapter93(context: Context) {

    fun CheckBoxStatus(chB: CheckBox): String{
        var status = ""
        if (chB.isChecked){
            status = "1"
        }else {
            status = "0"
        }
        return status
    }

    fun checkBoxList(chBList: ArrayList<CheckBox>, chB1: CheckBox, chB2: CheckBox, chB3: CheckBox, chB4: CheckBox, chB5: CheckBox, chB6: CheckBox, chB7: CheckBox, chB8: CheckBox, chB9: CheckBox, chB10: CheckBox) : ArrayList<CheckBox>{
        chBList.add(chB1)
        chBList.add(chB2)
        chBList.add(chB3)
        chBList.add(chB4)
        chBList.add(chB5)
        chBList.add(chB6)
        chBList.add(chB7)
        chBList.add(chB8)
        chBList.add(chB9)
        chBList.add(chB10)
        return chBList
    }

    fun fillCheckBox(status: String, chB: CheckBox){
        if(status == "1"){
            chB.isChecked = true
        }else {
            chB.isChecked = false
        }
    }

    fun fillAllCheckBox(statusList: ArrayList<String>, chBList: ArrayList<CheckBox>){
        fillCheckBox(statusList[0], chBList[0])
        fillCheckBox(statusList[1], chBList[1])
        fillCheckBox(statusList[2], chBList[2])
        fillCheckBox(statusList[3], chBList[3])
        fillCheckBox(statusList[4], chBList[4])
        fillCheckBox(statusList[5], chBList[5])
        fillCheckBox(statusList[6], chBList[6])
        fillCheckBox(statusList[7], chBList[7])
        fillCheckBox(statusList[8], chBList[8])
        fillCheckBox(statusList[9], chBList[9])
    }
}