package com.example.week3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.ViewBinding
import android.viewbinding.ViewBindings
import com.example.week3.databinding.ActivityMainBinding
import java.text.NumberFormat
class MainActivity : AppCompatActivity() {

    //TODO 2: Create an instance of view binding
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

             var premium = when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                //both also work
                //4,5 -> 150
                else -> 150

            }
             if(gender == binding.radioButtonMale.id){
                 premium += when(age){
                     0 -> 0
                     1 -> 50
                     2 -> 100
                     3 -> 150
                     //both also work
                     //4,5 -> 150
                     else -> 200
                 }

             }

        // both WORK
            if(smoker){
                premium += when(age){
                    0 -> 0
                    1 -> 100
                    2 -> 150
                    3 -> 200
                    4 -> 250
                    else-> 300
                }

            }
         //   if(smoker == true){}


        val output_premium = NumberFormat.getCurrencyInstance().format(premium)
        binding.textViewPremium.text = output_premium
        }
    }}