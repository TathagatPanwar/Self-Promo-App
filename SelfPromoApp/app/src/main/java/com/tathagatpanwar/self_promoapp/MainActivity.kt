package com.tathagatpanwar.self_promoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.check_box_immediate_start
import kotlinx.android.synthetic.main.activity_main.check_box_junior
import kotlinx.android.synthetic.main.activity_main.edit_text_available_date
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_name
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_number
import kotlinx.android.synthetic.main.activity_main.edit_text_display_name
import kotlinx.android.synthetic.main.activity_main.spinner_drop_down

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Software Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_drop_down.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val displayName = edit_text_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobTitle = spinner_drop_down.selectedItem?.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_available_date.text.toString()

        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_drop_down.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_available_date.text?.toString()
        )

        // Button action
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)
    }
}