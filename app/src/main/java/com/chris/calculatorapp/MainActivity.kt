package com.chris.calculatorapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear_button.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        left_parens_button.setOnClickListener {
            input.text = addToInputText("(")
        }

        right_parens_button.setOnClickListener {
            input.text = addToInputText(")")
        }

        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }

        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }

        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }

        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }

        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }

        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }

        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }

        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }

        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }

        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }

        period_button.setOnClickListener {
            input.text = addToInputText(".")
        }

        divide_button.setOnClickListener {
            input.text = addToInputText("÷")
        }

        multiply_button.setOnClickListener {
            input.text = addToInputText("×")
        }

        minus_button.setOnClickListener {
            input.text = addToInputText("-")
        }

        plus_button.setOnClickListener {
            input.text = addToInputText("+")
        }

        equals_button.setOnClickListener {
            outputResult()
        }




    }

    private fun outputResult() {
        try {
            val expression = getInput()
            val result = Expression(expression).calculate()

            if(result.isNaN()){
                output.text = "ERROR"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
            else {
                output.text = DecimalFormat("0.########").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }catch(e: java.lang.Exception){
            output.text = "MACHINE ERROR: unhandled exception"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }


    }

    private fun getInput(): String{
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }
}


