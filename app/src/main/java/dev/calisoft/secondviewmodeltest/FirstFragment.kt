import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.calisoft.secondviewmodeltest.*
import kotlinx.android.synthetic.main.activity_fragment_holder.*
import kotlinx.android.synthetic.main.activity_main.*


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_first, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProviders
            .of(this, ViewModelFactory.getInstance())
            .get(NameViewModel::class.java)
        model.name!!.observe(this, Observer {
            Log.d(MainActivity.TAG, "observer called with updates: $it")
            textViewObserved.text = it
        })


        mbutton.setOnClickListener {
            val inputText = editText.text
            Log.d(SecondActivity.TAG, "click inputText: $inputText")
            model.name!!.value = inputText.toString()
        }


    }


    companion object {
        const val TAG = "fdl.FF"
    }


}