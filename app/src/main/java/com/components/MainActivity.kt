package com.components

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.EditText
import com.components.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.edtCardNo.setOnClickListener {
            binding.edtCardNo.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {

                    if(!s.toString().startsWith("+91")) {
                        binding.edtCardNo.setText("+91")
                        Selection.setSelection(binding.edtCardNo.text, binding.edtCardNo.text!!.length)
                    }
                }

            })
        }

    }

}
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
