package dev.calisoft.secondviewmodeltest

import FirstFragment
import SecondFragment
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class PagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        Log.d(TAG, "getItem position:$position")
        return when (position) {
            0 -> {
                FirstFragment()
            }
            else -> SecondFragment()
        }
    }


    override fun getCount(): Int {
        return 2
    }

    companion object {
        private const val TAG = "fdl.PA"
    }

}