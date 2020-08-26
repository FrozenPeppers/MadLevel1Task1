package com.example.madlevel1task1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var current_throw: Int = 1
    private var last_throw: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        binding.btnLower.setOnClickListener { rollLower() }
        binding.btnEquals.setOnClickListener { rollEqual() }
        binding.btnHigher.setOnClickListener { rollHigher() }

        updateUI()
    }

    private fun updateUI() {
        binding.txtLastthrow.text = getString(R.string.last_throw, last_throw)

        when (current_throw) {
            1 -> binding.ivDice.setImageResource(R.drawable.dice1)
            2 -> binding.ivDice.setImageResource(R.drawable.dice2)
            3 -> binding.ivDice.setImageResource(R.drawable.dice3)
            4 -> binding.ivDice.setImageResource(R.drawable.dice4)
            5 -> binding.ivDice.setImageResource(R.drawable.dice5)
            6 -> binding.ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        last_throw = current_throw
        current_throw = (1..6).random()
        updateUI()
    }

    private fun rollLower() {
        rollDice()

        if (current_throw < last_throw) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun rollHigher() {
        rollDice()

        if (current_throw > last_throw) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun rollEqual() {
        rollDice()

        if (last_throw == current_throw) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect(){
        showToast(getString(R.string.answer_correct))
    }
    private fun onAnswerIncorrect(){
        showToast(getString(R.string.answer_incorrect))
    }

    private fun showToast(message: String) {
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, message, duration)
        toast.show()
    }

}