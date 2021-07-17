package com.example.mynotes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InotesRVAdapter {

    lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this,this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WordViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {view->
            view?.let{
                adapter.updateList(it as ArrayList<Word>)
            }
        })
        addButton.setOnClickListener {
            val noteText = input.text.toString()
            if(noteText.isEmpty()){
                viewModel.insertNode(Word(noteText))
                Toast.makeText(this,"${noteText} is added",Toast.LENGTH_LONG).show()
            }
        }

    }




    override fun onItemClicked(note: Word) {
        viewModel.deleteNode(note)
        Toast.makeText(this,"${note.word} is deleted",Toast.LENGTH_LONG).show()
    }

    fun submitNote(view: View) {
        val noteText = input.text.toString()
        if(noteText.isEmpty()){
            viewModel.insertNode(Word(noteText))
            Toast.makeText(this,"${noteText} is added",Toast.LENGTH_LONG).show()
        }
    }
}