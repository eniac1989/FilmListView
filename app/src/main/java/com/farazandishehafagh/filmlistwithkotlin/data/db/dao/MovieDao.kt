package com.farazandishehafagh.filmlistwithkotlin.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("Select * from movie_table order by title Asc")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Insert
    suspend fun insert(movieEntity: MovieEntity)

    @Query("select * from movie_table where title like :search")
    fun getSelectedMovie(search: String): LiveData<List<MovieEntity>>
}