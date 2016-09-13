package ru.marten.testproject.netutils;

import android.os.AsyncTask;

import java.lang.reflect.Method;

/**
 * Created by marten on 19.08.16.
 * Пример передачи метода в качестве параметра
 */
public class CustomAsyncTask extends AsyncTask<Object, Object, Object> {

    private Method method;
    private Object object;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object... objects) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        try {
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPostExecute(o);
    }

    public void setPostExecuteLogic(Method method, Object object) {
       this.method = method;
       this.object = object;
    }


}
