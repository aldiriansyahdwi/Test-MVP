package com.example.testmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.testmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnClear.setOnClickListener{
            clearField()
        }
        binding.btnSubmit.setOnClickListener {
            val mResult = MainPresenterImp(this)
            mResult.addData(binding.etFirst.text.toString(), binding.etSecond.text.toString())
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showData(result: String) {
        val resultDialog = AlertDialog.Builder(this)
        resultDialog.setTitle("Result")
        resultDialog.setMessage(result)
        resultDialog.setCancelable(true)
        resultDialog.show()
    }

    override fun clearField() {
        binding.etFirst.text.clear()
        binding.etSecond.text.clear()
    }
}