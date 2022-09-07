package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {
    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonpercent: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttonequal: android.widget.Button
    lateinit var buttonadd: android.widget.Button
    lateinit var buttonminus: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonmultiply: android.widget.Button
    lateinit var buttonbackspace: android.widget.Button

    lateinit var inputText: EditText
    lateinit var result: EditText
    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button00 = findViewById(R.id.button00)
        buttonpercent = findViewById(R.id.buttonpercent)
        buttonclear = findViewById(R.id.clear)
        buttondot = findViewById(R.id.buttonDot)
        buttonequal = findViewById(R.id.equal)
        buttonadd = findViewById(R.id.plus)
        buttonminus = findViewById(R.id.minus)
        buttondivide = findViewById(R.id.divide)
        buttonmultiply = findViewById(R.id.multiply)
        buttonbackspace = findViewById(R.id.back)

        inputText = findViewById(R.id.input)
        result = findViewById(R.id.result)

        inputText.movementMethod = ScrollingMovementMethod()

        inputText.isActivated = true

        inputText.isPressed = true

        var text : String

        //on click listeners for all buttons

        button1.setOnClickListener{
            text = inputText.text.toString() + "1"
            inputText.setText(text)
            result(text)
        }
        button0.setOnClickListener{
            text = inputText.text.toString() + "0"
            inputText.setText(text)
            result(text)
        }
        button00.setOnClickListener{
            text = inputText.text.toString() + "00"
            inputText.setText(text)
            result(text)
        }
        button2.setOnClickListener{
            text = inputText.text.toString() + "2"
            inputText.setText(text)
            result(text)
        }
        button3.setOnClickListener{
            text = inputText.text.toString() + "3"
            inputText.setText(text)
            result(text)
        }
        button4.setOnClickListener{
            text = inputText.text.toString() + "4"
            inputText.setText(text)
            result(text)
        }
        button5.setOnClickListener{
            text = inputText.text.toString() + "5"
            inputText.setText(text)
            result(text)
        }
        button6.setOnClickListener{
            text = inputText.text.toString() + "6"
            inputText.setText(text)
            result(text)
        }
        button7.setOnClickListener{
            text = inputText.text.toString() + "7"
            inputText.setText(text)
            result(text)
        }
        button8.setOnClickListener{
            text = inputText.text.toString() + "8"
            inputText.setText(text)
            result(text)
        }
        button9.setOnClickListener{
            text = inputText.text.toString() + "9"
            inputText.setText(text)
            result(text)
        }
        buttonadd.setOnClickListener{
            text = inputText.text.toString() + "+"
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttonminus.setOnClickListener{
            text = inputText.text.toString() + "-"
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttondivide.setOnClickListener{
            text = inputText.text.toString() + "÷"
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttonmultiply.setOnClickListener{
            text = inputText.text.toString() + "*"
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttondot.setOnClickListener{
            text = inputText.text.toString() + "."
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttonpercent.setOnClickListener{
            text = inputText.text.toString() + "%"
            inputText.setText(text)
            check += 1
            result(text)
        }
        buttonclear.setOnClickListener{
            text = ""
            inputText.text = null
            result.text = null
        }

        //backspace

        buttonbackspace.setOnClickListener{
            val backSpace: String?
            if(inputText.text.isNotEmpty()){
                val stringBuilder : StringBuilder = StringBuilder(inputText.text)
                val find = inputText.text.toString()
                val find2 = find.last()
                if(find2 == '+' || find2 == '-' || find2 == '*' || find2 == '%'){
                    check--
                }

                if(inputText.text.isNotEmpty()){
                    stringBuilder.deleteCharAt(inputText.text.length-1)
                    backSpace = stringBuilder.toString()
                    inputText.setText(backSpace)
                    result(backSpace)
                }
                else{
                    text = ""
                    inputText.text = null
                    result.text = null
                }
            }
            else{
                text = ""
                result.text = null
                inputText.text = null
            }
        }

        //equal

        buttonequal.setOnClickListener {
            text=result.text.toString()
            inputText.setText(text)
            result.setText("")
        }





    }

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            val resultText : Any=engine.eval(text)
            val mainResult = resultText.toString()

            if(check == 0){
                result.setText("")
            }
            else{
                result.setText(mainResult)
            }

        }catch (e: ScriptException){
            Log.d("TAG","ERROR")
        }

    }
}