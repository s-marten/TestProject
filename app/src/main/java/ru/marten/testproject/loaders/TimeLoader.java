package ru.marten.testproject.loaders;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import ru.marten.testproject.utils.Log;

/**
 * Created by marten on 10.09.16.
 */
public class TimeLoader extends Loader<String> {

    final int PAUSE = 10;

    public static final String ARGS_TIME_FORMAT = "time_format";
    public static final String TIME_FORMAT_SHORT = "h:mm:ss a";
    public static final String TIME_FORMAT_LONG = "yyyy.MM.dd G 'at' HH:mm:ss";

    GetTimeTask getTimeTaask;
    String format;

    public TimeLoader(Context context, Bundle args) {
        super(context);
        Log.d(hashCode() + " create TimeLoader");
        if (args != null)
            format = args.getString(ARGS_TIME_FORMAT);
        if (TextUtils.isEmpty(format))
            format = TIME_FORMAT_SHORT;
    }

    //вызывается при старте (onStart) Activity или фрагмента, к которому будет привязан Loader.
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d(hashCode() + " onStartLoading");
    }

    // вызывается при остановке (onStop) Activity или фрагмента, к которому будет привязан Loader.
    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        Log.d(hashCode() + " onStopLoading");
    }

    // в этом методе кодим работу лоадера. Запускаем здесь GetTimeTask, который будет нам время получать асинхронно.
    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        Log.d(hashCode() + " onForceLoad");
        if (getTimeTaask != null)
            getTimeTaask.cancel(true);
        getTimeTaask = new GetTimeTask();
        getTimeTaask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, format);
    }

    //метод означающий, что лоадер становится неактивным.
    @Override
    protected void onAbandon() {
        super.onAbandon();
        Log.d(hashCode() + " on Abandon");
    }

    //означает уничтожение лоадера, вызывается при закрытии (onDestroy) Activity или фрагмента,
    // к которому будет привязан Loader.
    // Не вызывается, если onDestroy был вызван, например при смене ориентации.
    @Override
    protected void onReset() {
        super.onReset();
        Log.d(hashCode() + " on Reset");
    }

    void getResultFromTask(String result) {
        deliverResult(result);
    }

    class GetTimeTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            Log.d(TimeLoader.this.hashCode() + " doinBackground");
            try {
                TimeUnit.SECONDS.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strings[0], Locale.getDefault());
            return simpleDateFormat.format(new Date());
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d(TimeLoader.this.hashCode() + " onPostExecute " + result);
            getResultFromTask(result);
        }
    }
}
