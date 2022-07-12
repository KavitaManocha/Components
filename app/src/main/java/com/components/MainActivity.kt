package com.components

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.components.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var card_no: String? = null
    private val cardPattern = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}\$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.edtUdyamAadharNo.paintFlags = View.GONE
//        card_no = binding.edtUdyamAadharNo.text.toString()
        binding.edtUdyamAadharNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                card_no = binding.edtUdyamAadharNo.text.toString()
//                if (s?.get(7)!!.equals("-") || s?.get(10)!!.equals("-") ){
//                    Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT).show()
//                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (!s.toString().startsWith("UDYAM-")) {
                    s!!.insert(0, "UDYAM-")
//                    s!!.insert(7,"-")
//                    s!!.insert(10,"-")

                }
//                else if (binding.edtUdyamAadharNo.text.insert() === 8||binding.edtUdyamAadharNo.text.get(8)||card_no.indices === 8|| card_no.get(8)){
//                    if (!s.toString().endsWith("-")) {
//                        s?.append("-");
//                    }
//                }
            }
        })


    }

    fun validateCard(view: View) {
        binding.tvUdyam.text = card_no
        if (card_no!!.matches(cardPattern.toRegex())) {
            Toast.makeText(applicationContext, "Valid Card Number", Toast.LENGTH_SHORT).show()
        }else if(!card_no?.elementAt(8)!!.equals("-") ||!card_no?.get(11)!!.equals("-") ) {
            Toast.makeText(applicationContext, "Separators already added", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT).show()
        }
    }

}

//val  CARD_NUMBER_TOTAL_SYMBOLS = 13; // size of pattern 0000-0000-0000-0000
//    val CARD_NUMBER_TOTAL_DIGITS = 11; // max numbers of digits in pattern: 0000 x 4
//    val CARD_NUMBER_DIVIDER_MODULO = 2; // means divider position is every 5th symbol beginning with 1
//    val CARD_NUMBER_DIVIDER_POSITION = CARD_NUMBER_DIVIDER_MODULO - 1; // means divider position is every 4th symbol beginning with 0
//    val CARD_NUMBER_DIVIDER = '-'
//binding.edtCardNo.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
////                Selection.setSelection(binding.edtCardNo.text, binding.edtCardNo.text!!.length);
//
////                            if (!isInputCorrect(s as Editable, CARD_NUMBER_TOTAL_SYMBOLS, CARD_NUMBER_DIVIDER_MODULO, CARD_NUMBER_DIVIDER)) {
////                    s!!.replace(0, s!!.length, concatString(getDigitArray(s as Editable, CARD_NUMBER_TOTAL_DIGITS)!!, CARD_NUMBER_DIVIDER_POSITION, CARD_NUMBER_DIVIDER));
////                }
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                if (!isInputCorrect(s!!, CARD_NUMBER_TOTAL_SYMBOLS, CARD_NUMBER_DIVIDER_MODULO, CARD_NUMBER_DIVIDER)) {
//                    s!!.replace(0, s!!.length, concatString(getDigitArray(s, CARD_NUMBER_TOTAL_DIGITS)!!, CARD_NUMBER_DIVIDER_POSITION, CARD_NUMBER_DIVIDER));
//                }
//            }
//
//        })
//    private fun isInputCorrect(
//        s: Editable,
//        size: Int,
//        dividerPosition: Int,
//        divider: Char
//    ): Boolean {
//        var isCorrect = s.length <= size
//        for (i in 0 until s.length) {
//            isCorrect = if (i > 0 && (i + 1) % dividerPosition == 0) {
//                isCorrect and (divider == s[i])
//            } else {
//                isCorrect and Character.isDigit(s[i])
//            }
//        }
//        return isCorrect
//    }
//
//    private fun concatString(digits: CharArray, dividerPosition: Int, divider: Char): String? {
//        val formatted = StringBuilder()
//        for (i in digits.indices) {
//            if (digits[i].toInt() != 0) {
//                formatted.append(digits[i])
//                if (i > 0 && i < digits.size - 1 && (i + 1) % dividerPosition == 0) {
//                    formatted.append(divider)
//                }
//            }
//        }
//        return formatted.toString()
//    }
//
//    private fun getDigitArray(s: Editable, size: Int): CharArray? {
//        val digits = CharArray(size)
//        var index = 0
//        var i = 0
//        while (i < s.length && index < size) {
//            val current = s[i]
//            if (Character.isDigit(current)) {
//                digits[index] = current
//                index++
//            }
//            i++
//        }
//        return digits
//    }


//binding.edtCardNo.setOnClickListener {
//    binding.edtCardNo.addTextChangedListener(object : TextWatcher{
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//        }
//
//        override fun afterTextChanged(s: Editable?) {
//
//            if(!s.toString().startsWith("+91")) {
//                binding.edtCardNo.setText("+91")
//                Selection.setSelection(binding.edtCardNo.text, binding.edtCardNo.text!!.length)
//            }
//        }
//
//    })
//}



//binding.edtCardNo.setOnClickListener{
//    binding.edtCardNo.setText("+91")
//    binding.edtCardNo.addTextChangedListener(object: TextWatcher {
//        override fun beforeTextChanged(
//            s: CharSequence?,
//            start: Int,
//            count: Int,
//            after: Int
//        ) {
//
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//        }
//
//        override fun afterTextChanged(s: Editable?) {
//            if(!s.toString().startsWith("+91")){
//                binding.edtCardNo.setText("+91");
//                Selection.setSelection(binding.edtCardNo.text, binding.edtCardNo.text!!.length);
//
//            }
//        }
//
//    })
//}