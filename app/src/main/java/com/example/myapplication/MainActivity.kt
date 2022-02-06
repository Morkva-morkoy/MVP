package com.example.myapplication
import android.graphics.Color
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.Button
import android.widget.*
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.CalendarFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.PersonFragment
import kotlinx.android.synthetic.main.fragment_calendar.*

class MainActivity : AppCompatActivity() {
    private lateinit var a: com.google.android.material.bottomnavigation.BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
//        val today = Calendar.getInstance()
//        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
//            today.get(Calendar.DAY_OF_MONTH)
//
//        ) { view, year, month, day ->
//            val month = month + 1
//            val msg = "You Selected: $day/$month/$year"
//            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
//        }
        setContentView(R.layout.activity_main)



        a = findViewById(R.id.bottom_navigation)
        val homeFragment = HomeFragment()
        val calendarFragment = CalendarFragment()
        val personFragment = PersonFragment()
//        btSelect.setOnClickListener {
//            var a = "ds"
//            var b = "dasdsa"
//        }
        makeCurrentFragment(homeFragment)
        a.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_calendar -> makeCurrentFragment(calendarFragment)
                R.id.ic_person -> makeCurrentFragment(personFragment)

            }
            true
        }

    }
//    private fun showDatePickerDialog() {
//        val cal = Calendar.getInstance()
//        val d = cal.get(Calendar.DAY_OF_MONTH)
//        val m = cal.get(Calendar.MONTH)
//        val y = cal.get(Calendar.YEAR)
//        datePicker.showDialog(d, m, y, object : DatePickerHelper.Callback {
//            override fun onDateSelected(dayofMonth: Int, month: Int, year: Int) {
//                val dayStr = if (dayofMonth < 10) "0${dayofMonth}" else "${dayofMonth}"
//                val mon = month + 1
//                val monthStr = if (mon < 10) "0${mon}" else "${mon}"
//                Date.text = "${dayStr}-${monthStr}-${year}"
//            }
//        })
//    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}