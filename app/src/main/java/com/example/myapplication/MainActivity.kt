package com.example.myapplication

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterClass: AdapterClass
    var list3 = ArrayList<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = arrayListOf<DataModel>()

//        for (i in 1..50) {
        for (i in 1..9){
            list.add(DataModel(i.toString()))
        }

        adapterClass = AdapterClass(list, this)
        binding.recyclerView.apply {
            adapter = adapterClass
            layoutManager = LinearLayoutManager(this@MainActivity)

        }

        binding.btnSubmit.setOnClickListener {
            val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)

            val inflater = this.layoutInflater
            val dialogView: View =
                inflater.inflate(com.example.myapplication.R.layout.alert_dialog, null)
            dialogBuilder.setView(dialogView)

            val list2 = mutableListOf<String>()
            for (i in list3) {
                list2.add(i.checkList!!)
            }
            val arr = ArrayAdapter(
                this,
                R.layout.simple_spinner_dropdown_item,
                list2
            )

            dialogView.findViewById<ListView>(com.example.myapplication.R.id.check_alert).adapter =
                arr
            val alertDialog: AlertDialog = dialogBuilder.create()
            alertDialog.show()

            Log.i("TAG", "clickList: $list2")

        }

    }

    override fun click(arrayList: ArrayList<DataModel>) {

        list3 = arrayList

        Log.i("TAG", "click: $arrayList")
    }
}
