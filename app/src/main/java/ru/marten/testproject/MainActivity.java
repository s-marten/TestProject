package ru.marten.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.marten.testproject.netutils.CustomAsyncTask;

public class MainActivity extends AppCompatActivity {

    TextView status_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status_text = (TextView) findViewById(R.id.status_text);

        //start async task
        Button testBtn = (Button) findViewById(R.id.start_button);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncTest();
            }
        });


        Button btn_loader_test = (Button) findViewById(R.id.btn_loader_test);
        btn_loader_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoaderActivity.class));
            }
        });

    }


    ////// async pattern ///////////////////////////
    public void setText() {
        status_text.setText("Got it");
    }

    public void asyncTest() {
        CustomAsyncTask task = new CustomAsyncTask();
        try {
            task.setPostExecuteLogic(this.getClass().getMethod("setText", null), this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        task.execute();
    }
    /////////////////////////////////////////////////


}
