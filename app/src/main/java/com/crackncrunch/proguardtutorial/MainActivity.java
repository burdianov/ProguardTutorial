package com.crackncrunch.proguardtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, new SomeClass("Hello").getSomeString(), Toast
                .LENGTH_SHORT).show();
        try {
            Field someString = SomeClass.class.getDeclaredField("someString");
            Toast.makeText(this, someString.getName(), Toast.LENGTH_SHORT).show();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
