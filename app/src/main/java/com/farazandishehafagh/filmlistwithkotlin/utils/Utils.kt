package com.farazandishehafagh.filmlistwithkotlin.utils

import com.farazandishehafagh.filmlistwithkotlin.BaseApplication

/**
 * @author Paniz 99.07.16
 */
class Utils {

    companion object {
        val lambdaTranslation: (Int) -> String = { x ->
            BaseApplication.getResource().getString(x)
        }

        fun getTranslationOfString(x: Int, op: (Int) -> String): String {
            return op(x)
        }

        val lambdaColor: (Int) -> Int = { x ->
            BaseApplication.getResource().getColor(x)

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
            var newNumber: String=""
            do {
                newNumber = (originalNumber % 1000).toString()+newNumber
                originalNumber = originalNumber / 1000
            } while (originalNumber > 0)
            return newNumber
        }

    }

}
