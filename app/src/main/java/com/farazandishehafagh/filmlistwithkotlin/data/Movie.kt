package com.farazandishehafagh.filmlistwithkotlin.data

import com.farazandishehafagh.filmlistwithkotlin.R

/**
 * @author Paniz Alipour 99.07.06
 */
class Movie constructor(
    var title: String="",
    var director: String="",
    var image: Int=0,
    var year: String="",
    var rating: Int=0
) {

    companion object {

        fun populateList(): ArrayList<Movie> {
            val parasite = Movie("Parasite", "Bong Joon-ho", R.drawable.parasite, "11042019", 5)
            val avengers = Movie("Avengers", "Joss Whedon", R.drawable.avebgers, "17052019", 3)
            val toyStory = Movie("ToyStory", "Josh Cooley", R.drawable.toystory4, "11122019", 5)
            val littleWoman =
                Movie("LittleWoman", " Greta Gerwig", R.drawable.littlewoman, "25062019", 5)
            val farewell = Movie("The Farewell", "Lulu Wang", R.drawable.thefarewell, "15102019", 2)
            val iceAge = Movie("Ice Age", "Lulu Wang", R.drawable.iceage, "18062015", 4)
            val titanic = Movie("Titanic", "Lulu Wang", R.drawable.titanic, "28092010", 4)
            val greenbook = Movie("Green Book", "Lulu Wang", R.drawable.greenbook, "04072019", 4)


            val filmList = ArrayList<Movie>()
            filmList.add(parasite)
            filmList.add(avengers)
            filmList.add(toyStory)
            filmList.add(littleWoman)
            filmList.add(farewell)
            filmList.add(iceAge)
            filmList.add(titanic)
            filmList.add(greenbook)


            return filmList
        }

    }

    suspend fun getMovieList(): ArrayList<Movie> {
        val parasite = Movie("Parasite", "Bong Joon-ho", R.drawable.parasite, "11042019", 5)
        val avengers = Movie("Avengers", "Joss Whedon", R.drawable.avebgers, "17052019", 3)
        val toyStory = Movie("ToyStory", "Josh Cooley", R.drawable.toystory4, "11122019", 5)
        val littleWoman =
            Movie("LittleWoman", " Greta Gerwig", R.drawable.littlewoman, "25062019", 5)
        val farewell = Movie("The Farewell", "Lulu Wang", R.drawable.thefarewell, "15102019", 2)
        val iceAge = Movie("Ice Age", "Lulu Wang", R.drawable.iceage, "18062015", 4)
        val titanic = Movie("Titanic", "Lulu Wang", R.drawable.titanic, "28092010", 4)
        val greenbook = Movie("Green Book", "Lulu Wang", R.drawable.greenbook, "04072019", 4)


        val filmList = ArrayList<Movie>()
        filmList.add(parasite)
        filmList.add(avengers)
        filmList.add(toyStory)
        filmList.add(littleWoman)
        filmList.add(farewell)
        filmList.add(iceAge)
        filmList.add(titanic)
        filmList.add(greenbook)


        return filmList
    }
}