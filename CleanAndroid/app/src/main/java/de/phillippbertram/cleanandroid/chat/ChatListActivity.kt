package de.phillippbertram.cleanandroid.chat

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import de.phillippbertram.cleanandroid.R
import de.phillippbertram.cleanandroid.internal.base.RxActivity

class ChatListActivity : RxActivity<ChatListView, ChatListPresenter>() {

    override fun createPresenter(): ChatListPresenter {
        return ChatListPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton

        fab.setOnClickListener { view ->
            presenter.startSomething()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
    
}
