package com.example.testmvp

import android.text.TextUtils

class MainPresenterImp(private val view: MainView): MainPresenter {
    private var result: Int = 0
    override fun addData(firstNumber: String, secondNumber: String) {
        if (TextUtils.isEmpty(firstNumber) || TextUtils.isEmpty(secondNumber)){
            view.showMessage("Field tidak boleh kosong")
        } else {
            result = firstNumber.toInt() + secondNumber.toInt()

            loadData()

            view.clearField()
        }
    }

    override fun loadData() {
        view.showData(result.toString())
    }
}