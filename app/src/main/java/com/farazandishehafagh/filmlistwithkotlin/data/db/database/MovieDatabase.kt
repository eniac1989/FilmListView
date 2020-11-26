package com.farazandishehafagh.filmlistwithkotlin.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.farazandishehafagh.filmlistwithkotlin.data.db.dao.MovieDao
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity
import com.farazandishehafagh.filmlistwithkotlin.utils.DB_NAME

/**
 * @author Paniz Alipour 99.09.05
 */
@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        open fun getInstance(ctx: Context): MovieDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: create(ctx).also { INSTANCE = it }
            }

        private fun create(context: Context) =
            Room.databaseBuilder(context.applicationContext, MovieDatabase::class.java, DB_NAME)
                .build()
    }
}