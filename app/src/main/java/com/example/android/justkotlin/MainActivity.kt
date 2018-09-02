package com.example.android.justkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
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
        val price = calculatePrice()
        val whippedCreamCheckbox = findViewById<CheckBox>(R.id.whipped_cream_checkbox)
        val hasWhippedCream = whippedCreamCheckbox.isChecked

        displayMessage(createOrderSummary(price,hasWhippedCream))
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private fun calculatePrice(): Int {
        return quantity * 35
    }

    /**
     * Creates the order summary
     *
     * @param price of the order
     * @param hasWhippedCream whether or not the user wants whipped cream
     * @return text summary
     */
    private fun createOrderSummary(price: Int, hasWhippedCream: Boolean): String {
        return "Name: Dude \nAdded Whipped Cream? $hasWhippedCream \nQuantity: $quantity \nTotal: $$price \nThank You!"
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(number: Int){
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = "" + number
    }

    /**
     * This method displays the given text on the screen.
     */
    private fun displayMessage(message: String) {
        val orderSummaryTextView = findViewById<TextView>(R.id.order_summary_text_view)
        orderSummaryTextView.text = message
    }

    /**
     * This method is called when the + button is clicked.
     */
    fun increment(view: View){
        quantity += 1
        displayQuantity(quantity)
    }

    /**
     * This method is called when the + button is clicked.
     */
    fun decrement(view: View){
        quantity -= 1
        displayQuantity(quantity)
    }
}
