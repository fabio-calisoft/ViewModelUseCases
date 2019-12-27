package dev.calisoft.secondviewmodeltest

import FirstFragment
import SecondFragment
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_fragment_holder.*


class FragmentHolderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_fragment_holder)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmentHolder, FirstFragment())
        ft.commit()

        val model = ViewModelProviders
            .of(this, ViewModelFactory.getInstance())
            .get(NameViewModel::class.java)
        model.name!!.observe(this, Observer {
            Log.d(MainActivity.TAG, "observer called with updates: $it")
            textViewObserved.text = it
        })

        buttonGoToFirst.setOnClickListener {
            Log.d(TAG, "click buttonGoToFirst")
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragmentHolder, FirstFragment())
            ft.commit()
        }

        buttonGoToSecond.setOnClickListener {
            Log.d(TAG, "click buttonGoToSecond")
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragmentHolder, SecondFragment())
            ft.commit()
        }


    }


    companion object {
        const val TAG = "fdl.FHA"
    }
}
