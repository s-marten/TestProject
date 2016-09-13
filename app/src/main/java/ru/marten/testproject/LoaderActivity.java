package ru.marten.testproject;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import ru.marten.testproject.loaders.TimeLoader;
import ru.marten.testproject.utils.Log;

public class LoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    static final int LOADER_TIME_ID = 1;

    TextView tvTime;
    RadioGroup rgTimeFormat;
    static int lastCheckedId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        tvTime = (TextView) findViewById(R.id.tvTime);
        rgTimeFormat = (RadioGroup) findViewById(R.id.rgTimeFormat);

        Bundle bndl = new Bundle();
        bndl.putString(TimeLoader.ARGS_TIME_FORMAT, getTimeFormat());
        getSupportLoaderManager().initLoader(LOADER_TIME_ID, bndl, this);
        lastCheckedId = rgTimeFormat.getCheckedRadioButtonId();

        Button btn_start = (Button) findViewById(R.id.btnGetTime);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTimeClick();

            }
        });
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Loader<String> loader = null;
        if (id == LOADER_TIME_ID) {
            loader = new TimeLoader(this, args);
            Log.d("onCreateLoader: " + loader.hashCode());
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Log.d("onLoadFinished for loader " + loader.hashCode()
                + ", result = " + data);
        tvTime.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        Log.d("onLoaderReset for loader " + loader.hashCode());
    }

    public void getTimeClick() {
        Loader<String> loader;

        int id = rgTimeFormat.getCheckedRadioButtonId();
        if (id == lastCheckedId) {
            loader = getSupportLoaderManager().getLoader(LOADER_TIME_ID);
        } else {
            Bundle bndl = new Bundle();
            bndl.putString(TimeLoader.ARGS_TIME_FORMAT, getTimeFormat());
            loader = getSupportLoaderManager().restartLoader(LOADER_TIME_ID, bndl, this);
            lastCheckedId = id;
        }
        loader.forceLoad();
    }

    String getTimeFormat() {
        String result = TimeLoader.TIME_FORMAT_SHORT;
        switch (rgTimeFormat.getCheckedRadioButtonId()) {
            case R.id.rdShort:
                result = TimeLoader.TIME_FORMAT_SHORT;
                break;
            case R.id.rdLong:
                result = TimeLoader.TIME_FORMAT_LONG;
                break;
            default:
                break;
        }
        return result;
    }
}
