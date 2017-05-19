package de.phillippbertram.cleanandroid.main

import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import de.phillippbertram.cleanandroid.R
import de.phillippbertram.cleanandroid.chat.ChatListActivity
import de.phillippbertram.cleanandroid.internal.base.RxActivity

open class MainActivity : RxActivity<MainView, MainPresenter>() {

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.detailButton)
    open fun onDetailButtonClicked() {
        val intent = Intent(this, ChatListActivity::class.java)
        startActivity(intent)
    }
}
