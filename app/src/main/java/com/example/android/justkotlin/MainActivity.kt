package com.example.android.justkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var quantity = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun submitOrder(view: View){
        // Getting the value of the whipped cream checkbox
        val whippedCreamCheckbox = findViewById<CheckBox>(R.id.whipped_cream_checkbox)
        val hasWhippedCream = whippedCreamCheckbox.isChecked

        // Getting the value of the chocolate checkbox
        val chocolateCheckbox = findViewById<CheckBox>(R.id.chocolate_checkbox)
        val hasChocolate = chocolateCheckbox.isChecked

        // Getting the user's name
        val nameTextEdit = findViewById<EditText>(R.id.name_edit_text)
        val userName = nameTextEdit.text.toString()

        val price = calculatePrice(hasWhippedCream, hasChocolate)

        displayMessage(createOrderSummary(userName, price, hasWhippedCream, hasChocolate))
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream whether or not the user wants whipped cream
     * @param hasChocolate whether or not the user wants chocolate
     * @return total price
     */
    private fun calculatePrice(hasWhippedCream: Boolean, hasChocolate: Boolean): Int {
        // Base price of a cup of coffee
        var base = 35

        // Adding +1 when whipped cream topping is selected
        if (hasWhippedCream){
            base += 1
        }

        // Adding +2 when whipped cream topping is selected
        if (hasChocolate){
            base += 2
        }

        // Return the total price
        return quantity * base
    }

    /**
     * Creates the order summary
     *
     * @param userName the name that the user entered in the text field
     * @param price of the order
     * @param hasWhippedCream whether or not the user wants whipped cream
     * @param hasChocolate whether or not the user wants chocolate
     * @return text summary
     */
    private fun createOrderSummary(userName: String, price: Int, hasWhippedCream: Boolean, hasChocolate: Boolean): String {
        return "Name: $userName \nAdd Whipped Cream? $hasWhippedCream \nAdd Chocolate? $hasChocolate \nQuantity: $quantity \nTotal: $$price \nThank You!"
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
        if (quantity == 100){
            val toast = Toast.makeText(applicationContext, "You cannot order more than 100 coffees", Toast.LENGTH_SHORT)
            toast.show()
            return
        }

        quantity += 1
        displayQuantity(quantity)
    }

    /**
     * This method is called when the - button is clicked.
     */
    fun decrement(view: View){
        if (quantity == 1){
            val toast = Toast.makeText(applicationContext, "You cannot order less than 1 coffee", Toast.LENGTH_SHORT)
            toast.show()
            return
        }

        quantity -= 1
        displayQuantity(quantity)
    }
}
