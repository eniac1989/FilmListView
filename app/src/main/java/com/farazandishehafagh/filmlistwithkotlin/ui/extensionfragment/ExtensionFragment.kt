package com.farazandishehafagh.filmlistwithkotlin.ui.extensionfragment


import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils
import kotlinx.android.synthetic.main.fragment_extension.*
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ExtensionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExtensionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extension, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val txtName = findViewById<EditText>(R.id.btnFormatAmount)
        btnFormatAmount.setOnClickListener {
            val amount = txtAmount.text.toString().toLong()
            val formatAmount = amount.formatAmount()
            txtResult.text = formatAmount
        }

        btnFormatDate.setOnClickListener {

            txtResultDate.text = txtDate.text.toString().formatDate()
        }

        btnFormatText.setOnClickListener {
            txtText.setStyleOnText()
        }

        btnValidatePhoneNumber.setOnClickListener {
            txtResultValidation.text = txtPhoneNumber.text.toString().validateString()
        }

        btnCheckConnection.setOnClickListener {
            if(context!!.isConnected())
                txtResultConnection.text="Connection is available!"
            else
                txtResultConnection.text="network is disconnected!"
        }

    }

    fun Context.isConnected():Boolean{
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected

    }

    fun String.validateString(): String = if (this.isEmpty())
        "* Text is Empty!!!"
    else {
        val pattern = Pattern.compile("^\\d{10}$")
        val matcher = pattern.matcher(this)
        if (!matcher.matches())
            "* Phone Number is not 10 digits!!"
        else
            "* Phone Number is Valid!"
    }


    fun EditText.setStyleOnText(): Unit {
        this.typeface = Typeface.DEFAULT_BOLD
        this.textSize = 30F
        this.gravity = Gravity.CENTER
        this.setTextColor(Utils.getColor(R.color.red_dark, Utils.lambdaColor))
    }

    fun Long.formatAmount(): String {
        var originalNumber = this
        var newNumber: String = ""
        do {
            newNumber = if (newNumber != "") {
                if (originalNumber % 1000 == 0L)
                    "000,$newNumber"
                else
                    (originalNumber % 1000).toString() + "," + newNumber
            } else {
                if (originalNumber % 1000 == 0L)
                    "000$newNumber"
                else
                    (originalNumber % 1000).toString() + newNumber
            }
            originalNumber /= 1000
        } while (originalNumber > 0)
        return newNumber
    }

    fun String.formatDate(): String {
        return this.substring(0, 4) + "/" + this.substring(4, 6) + "/" + this.substring(6)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *

         * @return A new instance of fragment ExtensionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ExtensionFragment().apply {

            }
    }


}
