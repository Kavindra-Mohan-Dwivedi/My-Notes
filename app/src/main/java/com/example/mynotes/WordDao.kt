package com.example.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word:Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("SELECT * From notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Word>>
}