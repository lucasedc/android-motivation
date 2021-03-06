package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.R
import com.example.motivation.mock.Mock
import com.example.motivation.utils.MotivationConstants
import com.example.motivation.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_hello.*
import kotlinx.android.synthetic.main.activity_main.*

class ActivityHello : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSharedPreferences: SharedPreferencesUtils
    private var mPhraseFilter: Int = MotivationConstants.INDEX_PHRASE.ALL_MESSAGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        mSharedPreferences = SharedPreferencesUtils(this)

        var name = mSharedPreferences.restoreString(MotivationConstants.KEY.PERSON_NAME).toString()

        if (name != "") {
            tvName.text = name
        }
        showAllMessage(MotivationConstants.PHRASE.ALL_MESSAGE)
        ivAll.setOnClickListener(this)
        ivHappy.setOnClickListener(this)
        ivSunny.setOnClickListener(this)

        btnNewPhrase.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        when (id) {
            R.id.ivAll -> showAllMessage(MotivationConstants.PHRASE.ALL_MESSAGE)
            R.id.ivHappy -> showAllMessage(MotivationConstants.PHRASE.HAPPY_MESSAGE)
            R.id.ivSunny -> showAllMessage(MotivationConstants.PHRASE.SUNNY_MESSAGE)
            R.id.btnNewPhrase -> showAllMessage(MotivationConstants.PHRASE.ALL_MESSAGE)
        }


    }

    private fun showAllMessage(typeMessage: String) {
        ivAll.setColorFilter(resources.getColor(R.color.white))
        ivHappy.setColorFilter(resources.getColor(R.color.white))
        ivSunny.setColorFilter(resources.getColor(R.color.white))
        when (typeMessage) {
            MotivationConstants.PHRASE.ALL_MESSAGE -> {
                tvPhrase.text = Mock().getPhrase(MotivationConstants.INDEX_PHRASE.ALL_MESSAGE)
                ivAll.setColorFilter(resources.getColor(R.color.colorSelected))
            }
            MotivationConstants.PHRASE.HAPPY_MESSAGE -> {
                tvPhrase.text = Mock().getPhrase(MotivationConstants.INDEX_PHRASE.HAPPY_MESSAGE)
                ivHappy.setColorFilter(resources.getColor(R.color.colorSelected))
            }
            MotivationConstants.PHRASE.SUNNY_MESSAGE -> {
                tvPhrase.text = Mock().getPhrase(MotivationConstants.INDEX_PHRASE.SUNNY_MESSAGE)
                ivSunny.setColorFilter(resources.getColor(R.color.colorSelected))
            }

        }
    }
}