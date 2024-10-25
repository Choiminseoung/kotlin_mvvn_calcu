package com.example.mvvm_kotlin_calcu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kotlin_calcu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CalcuViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(CalcuViewModel::class.java)
        viewModel.result.observe(this) { result ->
            binding.resultTextView.text = result.toString() }

        // 계산 버튼을 눌렀을 떄 livedata를 이용하여 mutable 데이터로 적용 후 class
        binding.calculateButton.setOnClickListener {
            val a = binding.firstNumberEditText.text.toString().toInt()
            val b = binding.secondNumberEditText.text.toString().toInt()
            val operation = binding.operationSpinner.selectedItem.toString()
            viewModel.performOperation(a, b, operation)
        }
    }
}