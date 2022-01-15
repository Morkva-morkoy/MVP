package com.example.myapplication
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.CalendarFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.PersonFragment

class MainActivity : AppCompatActivity() {
    private lateinit var a: com.google.android.material.bottomnavigation.BottomNavigationView
    private lateinit var Date: TextView
    private lateinit var btSelect: Button
    lateinit var datePicker: DatePickerHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_calendar)
        btSelect = findViewById(R.id.btSelectDate)
        Date = findViewById(R.id.tvDate)
        datePicker = DatePickerHelper(this, true)

        setContentView(R.layout.activity_main)



        a = findViewById(R.id.bottom_navigation)
        val homeFragment = HomeFragment()
        val calendarFragment = CalendarFragment()
        val personFragment = PersonFragment()
        btSelect.setOnClickListener {
            var a = "ds"
            var b = "dasdsa"
        }
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
    private fun showDatePickerDialog() {
        val cal = Calendar.getInstance()
        val d = cal.get(Calendar.DAY_OF_MONTH)
        val m = cal.get(Calendar.MONTH)
        val y = cal.get(Calendar.YEAR)
        datePicker.showDialog(d, m, y, object : DatePickerHelper.Callback {
            override fun onDateSelected(dayofMonth: Int, month: Int, year: Int) {
                val dayStr = if (dayofMonth < 10) "0${dayofMonth}" else "${dayofMonth}"
                val mon = month + 1
                val monthStr = if (mon < 10) "0${mon}" else "${mon}"
                Date.text = "${dayStr}-${monthStr}-${year}"
            }
        })
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}