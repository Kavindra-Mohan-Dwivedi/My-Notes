package com.example.mynotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
data class Word(@ColumnInfo(name = "text")val word: String) {
    @PrimaryKey(autoGenerate = true) var id =0
}