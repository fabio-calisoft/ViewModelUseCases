package dev.calisoft.secondviewmodeltest

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_pager.*

class ViewPagerHolderActivity: FragmentActivity() {

    lateinit var mAdapter: PagerAdapter
    var mPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pager)

        mAdapter = PagerAdapter(supportFragmentManager)
        mPager = findViewById (R.id.pager)
        mPager!!.adapter = mAdapter

        goToFirst.setOnClickListener {
            mPager!!.currentItem = 0
        }
        goToSecond.setOnClickListener {
            mPager!!.currentItem = 1
        }
    }

}