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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.edtUdyamAadharNo.paintFlags = View.GONE
        binding.edtUdyamAadharNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                card_no = binding.edtUdyamAadharNo.text.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                val inputlength: Int = binding.edtUdyamAadharNo.text.toString().length

                if (!s.toString().startsWith("UDYAM-")) {
                    s!!.insert(0, "UDYAM-")
                }
                else if(count <= inputlength && inputlength == 8 || inputlength == 11){
         binding.edtUdyamAadharNo.setText(binding.edtUdyamAadharNo.text.toString() + "-")
                    val pos: Int = binding.edtUdyamAadharNo.text.length
                    binding.edtUdyamAadharNo.setSelection(pos)
                }
                else if (count >= inputlength && (inputlength == 8 || inputlength == 11)){
                    binding.edtUdyamAadharNo.setText(binding.edtUdyamAadharNo.text.toString().substring(0, binding.edtUdyamAadharNo.text
                        .toString().length - 1))
                    val pos: Int = binding.edtUdyamAadharNo.text.length
                    binding.edtUdyamAadharNo.setSelection(pos)
                }
                else if (binding.edtUdyamAadharNo.text!!.matches(cardPattern.toRegex())){
                    Toast.makeText(applicationContext, "Valid Card Number", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT).show()
                }
                count = binding.edtUdyamAadharNo.text.toString().length
            }
        })


    }

    fun validateCard(view: View) {
        if (card_no!!.matches(cardPattern.toRegex())) {
            Toast.makeText(applicationContext, "Valid Card Number", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(applicationContext, "Invalid Card Number", Toast.LENGTH_SHORT).show()
        }
    }

}