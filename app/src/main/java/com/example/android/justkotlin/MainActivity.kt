package com.example.android.justkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var quantity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View){
        val priceMessage = "Total: $${quantity * 35} \nThanks!"
        displayMessage(priceMessage)
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun display(number: Int){
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = "" + number
    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.text = message
    }

    /**
     * This method displays the given price on the screen.
     */
    private fun displayPrice(number: Int) {
        val priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }

    /**
     * This method is called when the + button is clicked.
     */
    fun increment(view: View){
        quantity += 1
        display(quantity)
    }

    /**
     * This method is called when the + button is clicked.
     */
    fun decrement(view: View){
        quantity -= 1
        display(quantity)
    }
}
