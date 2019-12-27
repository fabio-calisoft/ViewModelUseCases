package dev.calisoft.secondviewmodeltest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        buttonViewPager.setOnClickListener {
            startActivity(Intent(this, ViewPagerHolderActivity::class.java))
        }

        val model = ViewModelProviders
            .of(this, ViewModelFactory.getInstance())
            .get(NameViewModel::class.java)

        model.name!!.observe(this, Observer {
            Log.d(TAG, "observer called with updates: $it")
            displayedName.text = it
        })


        mbutton.setOnClickListener {
            val inputText = editText.text
            Log.d(TAG, "click inputText: $inputText")
            model.name!!.value = inputText.toString()
        }

        buttonOpenFragment.setOnClickListener {
            startActivity(Intent(this, FragmentHolderActivity::class.java))

        }



    }


    companion object {
        const val TAG = "fdl.MA"
    }
}
