package com.example.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context:Context,private val listner:InotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.itemViewHolder>() {
    private val allNotes = ArrayList<Word>()

    inner class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView: TextView = itemView.findViewById(R.id.text)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        itemViewHolder(view).deleteButton.setOnClickListener {
            listner.onItemClicked(allNotes[itemViewHolder(view).adapterPosition])
        }
        return itemViewHolder(view)
    }
    fun updateList(newLIst:ArrayList<Word>){
        allNotes.clear()
        allNotes.addAll(newLIst)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.toString()

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
}
interface InotesRVAdapter{

   fun onItemClicked(note:Word)
}
