package com.example.testmvp

interface MainView {
    fun showMessage(message: String)

    fun showData(result: String)

    fun clearField()
}