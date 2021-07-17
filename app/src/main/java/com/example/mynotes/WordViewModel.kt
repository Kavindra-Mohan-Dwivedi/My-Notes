package com.example.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) :AndroidViewModel(application) {


    private val repository : WordRepository
    val allNotes : LiveData<List<Word>>
    init {
        val dao=WordDataBase.getDatabase(application).getwordDao()
        repository = WordRepository(dao)
        allNotes=repository.allWords
    }


    fun deleteNode(note:Word) =viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)

    }

    fun insertNode(note:Word) =viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)

    }

}