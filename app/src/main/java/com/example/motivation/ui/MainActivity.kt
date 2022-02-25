package com.example.motivation.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.utils.MotivationConstants
import com.example.motivation.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSharedPreferences: SharedPreferencesUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSharedPreferences = SharedPreferencesUtils(this)



        btnSave.setOnClickListener(this)

        val sharedPreferences = this.getSharedPreferences("motivation", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("key", "value").apply()


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnSave)
            navegarOutraTela()
    }

    private fun navegarOutraTela() {
        var name = etName.text.toString()
        if (name != "") {
            mSharedPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, ActivityHello::class.java))
        } else {
            Toast.makeText(this, "Preencha o nome", Toast.LENGTH_LONG).show()
        }

    }
}