package com.example.sampledestroyview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.child_fragment.*

class ChildFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.child_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.adapter = Adapter()
        (recycler.layoutManager as? LinearLayoutManager)?.recycleChildrenOnDetach = true
    }

    class Adapter : RecyclerView.Adapter<ChildViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
            return ChildViewHolder(parent.context)
        }

        override fun getItemCount(): Int = 100

        override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
            holder.bind()
        }

    }

    class ChildViewHolder(context: Context) : RecyclerView.ViewHolder(TextView(context)) {

        fun bind() {
            (itemView as TextView).text = "$adapterPosition"
        }

    }
}