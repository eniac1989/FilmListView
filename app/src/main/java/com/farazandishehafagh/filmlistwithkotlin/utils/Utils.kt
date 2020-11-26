package com.farazandishehafagh.filmlistwithkotlin.utils


import android.content.Context
import android.net.ConnectivityManager
import com.farazandishehafagh.filmlistwithkotlin.KotlinBaseApplication
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity

/**
 * @author Paniz 99.07.16
 */
class Utils {

    companion object {


        val lambdaTranslation: (Int) -> String = { x ->
            KotlinBaseApplication.getKotlinResource().getString(x)
        }

        fun getTranslationOfString(x: Int, op: (Int) -> String): String {
            return op(x)
        }

        val lambdaColor: (Int) -> Int = { x ->
            KotlinBaseApplication.getKotlinResource().getColor(x)

        }

        fun getColor(x: Int, op: (Int) -> Int): Int {
            return op(x)
        }

        val lambdaFormatDate: (String) -> String = { x ->
            x.substring(0, 2) + "/" + x.substring(2, 4) + "/" + x.substring(4)

        }

        fun formatDate(x: String, op: (String) -> String): String {
            return op(x)
        }

        fun Int.formatAmount(): String {
            var originalNumber = this
            var newNumber: String = ""
            do {
                newNumber = (originalNumber % 1000).toString() + newNumber
                originalNumber = originalNumber / 1000
            } while (originalNumber > 0)
            return newNumber
        }

    }

}

fun Context.isConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected

}

fun mapList(movieEntityList: List<MovieEntity>): List<Datum> {
    val movieList = mutableListOf<Datum>()
    for (movie in movieEntityList) {
        movieList.add(mapEntitytoModel(movie))

    }
    return movieList
}

fun mapEntitytoModel(movie: MovieEntity): Datum {
    return Datum(
        movie.id,
        movie.title,
        movie.poster,
        listOf(movie.genre),
        listOf(movie.image)
    )
}

