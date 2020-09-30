package com.farazandishehafagh.filmlistwithkotlin.data

import com.farazandishehafagh.filmlistwithkotlin.R

/**
 * @author Paniz Alipour 99.07.06
 */
class Movie constructor(
    var title: String,
    var director: String,
    var image: Int,
    var year: Int,
    var rating: Double
) {

    companion object {

        fun populateList(): ArrayList<Movie> {
            val parasite = Movie("Parasite", "Bong Joon-ho", R.drawable.parasite, 2019, 5.0)
            val avengers = Movie("Avengers", "Joss Whedon", R.drawable.avebgers, 2019, 3.0)
            val toyStory = Movie("ToyStory", "Josh Cooley", R.drawable.toystory4, 2019, 5.0)
            val littleWoman = Movie("LittleWoman", " Greta Gerwig", R.drawable.littlewoman, 2019, 5.0)
            val farewell = Movie("The Farewell", "Lulu Wang", R.drawable.thefarewell, 2019, 2.0)
            val iceAge = Movie("Ice Age", "Lulu Wang", R.drawable.iceage, 2015, 4.0)
            val titanic = Movie("Titanic", "Lulu Wang", R.drawable.titanic, 2010, 4.0)
            val greenbook = Movie("Green Book", "Lulu Wang", R.drawable.greenbook, 2018, 4.0)


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
}