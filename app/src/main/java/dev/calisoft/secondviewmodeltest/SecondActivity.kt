package dev.calisoft.secondviewmodeltest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val model = ViewModelProviders
            .of(this, ViewModelFactory.getInstance())
            .get(NameViewModel::class.java)


        mbutton.setOnClickListener {
            val inputText = editText.text
            Log.d(TAG, "click inputText: $inputText")
            model.name!!.value = inputText.toString()
        }


    }


    companion object {
        const val TAG = "fdl.Second"
    }
}
