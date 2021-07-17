package com.example.mynotes

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val allWords :LiveData<List<Word>> = wordDao.getAllNotes()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun delete(word: Word){
        wordDao.delete(word)
    }
}