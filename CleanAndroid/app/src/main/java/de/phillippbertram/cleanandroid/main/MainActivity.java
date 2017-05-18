package de.phillippbertram.cleanandroid.main;

import android.os.Bundle;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import de.phillippbertram.cleanandroid.R;


public class MainActivity extends RxAppCompatActivity implements MainView {

    private final MainPresenter presenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}
