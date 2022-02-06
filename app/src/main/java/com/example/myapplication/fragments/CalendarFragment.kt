package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.myapplication.R
import java.util.*
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.time.Month
import java.time.Year
import android.util.Log

import android.widget.EditText

import android.widget.LinearLayout
import android.widget.ArrayAdapter

import android.widget.ListView







// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var name: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val datePicker = inflater!!.inflate(R.layout.fragment_calendar, container, false)
        val home = inflater!!.inflate(R.layout.fragment_home, container, false)
        return datePicker
        return home
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var but = view.findViewById<Button>(R.id.button)
        var name = view.findViewById<EditText>(R.id.editTextTextPersonName)
        var description = view.findViewById<EditText>(R.id.editTextTextPersonName2)
        val today = Calendar.getInstance()
        val datePicker = view.findViewById<DatePicker>(R.id.date_Picker)
        var Day = 0
        var Month = 0
        var Year = 0
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            Month = month
            Day = day
            Year = year

            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()        }

// используем адаптер данных

// используем адаптер данных

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}