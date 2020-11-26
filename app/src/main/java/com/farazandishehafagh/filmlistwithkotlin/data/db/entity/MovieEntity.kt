package com.farazandishehafagh.filmlistwithkotlin.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity(

    val title: String,
    val poster: String,
    val genre: String,
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}
