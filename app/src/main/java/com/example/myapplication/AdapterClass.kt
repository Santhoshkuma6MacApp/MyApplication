package com.example.myapplication

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.AdapterClassBinding

class AdapterClass(
    private val mList: ArrayList<DataModel>,
    private val clickInterface: ClickInterface
) :
    RecyclerView.Adapter<AdapterClass.SampleViewHolder>() {

    private val list1 = ArrayList<DataModel>()

    class SampleViewHolder(private val binding: AdapterClassBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val check = binding.check
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(
            AdapterClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {

        holder.check.text = mList[position].checkList

        holder.check.setOnClickListener {
            if (holder.check.isChecked) {
                list1.add(DataModel(mList[position].checkList!!))

                Log.i("TAG", "onBindViewHolder:$list1")
                clickInterface.click(list1)

            } else {
                list1.remove(DataModel(mList[position].checkList!!))
                clickInterface.click(list1)
                Log.i("TAG", "onBindViewHolderRemoved:$list1")
            }

        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}
