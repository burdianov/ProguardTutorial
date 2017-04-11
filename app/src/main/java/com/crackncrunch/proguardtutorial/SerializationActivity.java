package com.crackncrunch.proguardtutorial;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SerializationActivity extends AppCompatActivity {
    @BindView(R.id.text_view)
    TextView mTextView;

    PersonStorage mPersonStorage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialization);
        ButterKnife.bind(this);

        mPersonStorage = new PersonStorage(getCacheDir().getAbsolutePath());
    }

    @OnClick(R.id.button_save)
    public void savePerson() {
        Person person = new Person("John", "Doe",
                new Random().nextInt(90), new Random().nextInt(160));
        mPersonStorage.write(person);
    }

    @OnClick(R.id.button_read)
    public void readPerson() {
        Person person = mPersonStorage.read();
        mTextView.setText(person.toString());
    }
}
