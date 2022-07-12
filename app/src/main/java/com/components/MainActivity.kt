package com.components

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.components.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var card_no: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.edtUdyamAadharNo.paintFlags = View.GONE
//        card_no = binding.edtUdyamAadharNo.text.toString()
        binding.edtUdyamAadharNo.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                card_no = binding.edtUdyamAadharNo.text.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                if(!s.toString().startsWith("UDYAM-")){
                    s!!.insert(0, "UDYAM-")
                }
            }

        })

        binding.btnValidate.setOnClickListener {
//            binding.tvUdyam.text = card_no
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
