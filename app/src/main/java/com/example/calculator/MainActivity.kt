package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonPer: Button
    
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var button00: Button
    private lateinit var buttonPoint: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonBackspace: Button

    private lateinit var quesEditText: EditText
    private lateinit var ansTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonPlus = findViewById(R.id.buttonPlus)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMul = findViewById(R.id.ButtonMul)
        buttonDiv = findViewById(R.id.ButtonDiv)
        buttonPer = findViewById(R.id.ButtonPer)
        button1 = findViewById(R.id.Button1)
        button2 = findViewById(R.id.Button2)
        button3 = findViewById(R.id.Button3)
        button4 = findViewById(R.id.Button4)
        button5 = findViewById(R.id.Button5)
        button6 = findViewById(R.id.Button6)
        button7 = findViewById(R.id.Button7)
        button8 = findViewById(R.id.Button8)
        button9 = findViewById(R.id.Button9)
        button0 = findViewById(R.id.Button0)
        button00 = findViewById(R.id.Button00)
        buttonPoint = findViewById(R.id.ButtonPoint)
        buttonClear = findViewById(R.id.ButtonClear)
        buttonEqual = findViewById(R.id.ButtonEqual)
        buttonBackspace = findViewById(R.id.ButtonBackspace)

        quesEditText = findViewById(R.id.quesEditText)
        quesEditText.showSoftInputOnFocus = false
        ansTextView = findViewById(R.id.ansTextView)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button0.setOnClickListener(this)
        button00.setOnClickListener(this)
        buttonPoint.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMul.setOnClickListener(this)
        buttonDiv.setOnClickListener(this)
        buttonPer.setOnClickListener(this)


        buttonEqual.setOnClickListener {
            val expressionText = quesEditText.text.toString()
            val fixedInput = expressionText
                .replace("×", "*", ignoreCase = true)
                .replace("÷","/", ignoreCase = true)
                .replace(Regex("(\\d+)%")) {
                    val number = it.groupValues[1]
                    "($number/100)"}
            try{
                val explession = ExpressionBuilder(fixedInput).build()
                val result = explession.evaluate()
                ansTextView.text = result.toString()
                ansTextView.visibility =View.VISIBLE
            }
            catch (e:Exception){
                ansTextView.text = "error"
                ansTextView.visibility =View.VISIBLE
            }
        }

        buttonBackspace.setOnClickListener {
            ansTextView.visibility= View.VISIBLE
            ansTextView.text = null
            val cursorPos = quesEditText.selectionStart
            val expressontext = quesEditText.text.toString()
            if (cursorPos > 0) {
                val newText = expressontext.removeRange(cursorPos - 1, cursorPos)
                quesEditText.setText(newText)
                quesEditText.setSelection(cursorPos - 1) // Move cursor back 1 place
            }

        }

    }

    override fun onClick(v: View?) {

        if(quesEditText.isInvisible) {
            when (v?.id) {
                R.id.Button1 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("1")
                }
                R.id.Button2 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("2")
                }
                R.id.Button3 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("3")
                }
                R.id.Button4 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("4")
                }
                R.id.Button5 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("5")
                }
                R.id.Button6 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("6")
                }
                R.id.Button7 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("7")
                }
                R.id.Button8 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("8")
                }
                R.id.Button9 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("9")
                }
                R.id.Button0 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("0")
                }
                R.id.Button00 -> {
                    quesEditText.visibility=View.VISIBLE
                    quesEditText.append("0")
                }
                R.id.ButtonPoint -> {
                    if(quesEditText.text.isEmpty()) {
                        quesEditText.visibility = View.VISIBLE
                        quesEditText.append("0.")
                    }
                    else{
                        quesEditText.visibility = View.VISIBLE
                        quesEditText.append(".")
                    }
                }
            }
        }
        else{
            when(v?.id){
                R.id.Button1 -> {
                    quesEditText.append("1")
                }
                R.id.Button2 -> {
                    quesEditText.append("2")
                }
                R.id.Button3 -> {
                    quesEditText.append("3")
                }
                R.id.Button4 -> {
                    quesEditText.append("4")
                }
                R.id.Button5 -> {
                    quesEditText.append("5")
                }
                R.id.Button6 -> {
                    quesEditText.append("6")
                }
                R.id.Button7 -> {
                    quesEditText.append("7")
                }
                R.id.Button8 -> {
                    quesEditText.append("8")
                }
                R.id.Button9 -> {
                    quesEditText.append("9")
                }
                R.id.Button0 -> {
                    quesEditText.append("0")
                }
                R.id.Button00 -> {
                    quesEditText.append("00")
                }
                R.id.ButtonPoint -> {
                    quesEditText.append(".")
                }
                R.id.ButtonClear -> {
                    quesEditText.visibility = View.INVISIBLE
                    ansTextView.visibility = View.INVISIBLE
                    quesEditText.text = null
                    ansTextView.text = null
                }
                R.id.buttonPlus -> {
                    quesEditText.append("+")
                }
                R.id.buttonMinus -> {
                    quesEditText.append("-")
                }
                R.id.ButtonMul -> {
                    quesEditText.append("×")
                }
                R.id.ButtonDiv -> {
                    quesEditText.append("÷")
                }
                R.id.ButtonPer -> {
                    quesEditText.append("%")
                }

            }
        }

    }
}