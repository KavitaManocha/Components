package com.components

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.components.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var card_no: String? = null
    private val cardPattern = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}\$"
    var count = 0
    val space: Char = '-'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.edtUdyamAadharNo.paintFlags = View.GONE
        binding.edtUdyamAadharNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if ((binding.edtUdyamAadharNo.text.toString().length == 8 || binding.edtUdyamAadharNo.text.toString().length == 11)) {
                    if (before - count < 0) {
                        binding.edtUdyamAadharNo.setText(binding.edtUdyamAadharNo.text.toString() + "-");
                        binding.edtUdyamAadharNo.setSelection(binding.edtUdyamAadharNo.text.toString().length);
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (!s.toString().startsWith("UDYAM-")) {
                    s!!.insert(0, "UDYAM-")

                }
                else if (binding.edtUdyamAadharNo.text!!.matches(cardPattern.toRegex())){
                    Toast.makeText(applicationContext, "Valid Card Number", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT)
                        .show()
                    binding.edtUdyamAadharNo.removeTextChangedListener(this)
                    s?.replace(0, s.length, s.toString());
                    binding.edtUdyamAadharNo.addTextChangedListener(this)
                }
                count = binding.edtUdyamAadharNo.text.toString().length
//               binding.edtUdyamAadharNo.removeTextChangedListener(this)

            }
        })

    }

    fun validateCard(view: View) {
        val inputlength = binding.edtUdyamAadharNo.text.toString().length
        if (inputlength > 0) {
            binding.edtUdyamAadharNo.text.delete(inputlength - 1, inputlength).trim()
//            binding.edtUdyamAadharNo.text.trim()
        }
//        binding.edtUdyamAadharNo.text.delete(6,8)
//        if (card_no!!.matches(cardPattern.toRegex())) {
//            Toast.makeText(applicationContext, "Valid Card Number", Toast.LENGTH_SHORT).show()
//        }
//        else {
//            Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT).show()
//        }

//        binding.edtUdyamAadharNo.removeTextChangedListener(this)
//                s?.replace(0, s.length, s.toString());
//                binding.edtUdyamAadharNo.addTextChangedListener(this)
    }

}