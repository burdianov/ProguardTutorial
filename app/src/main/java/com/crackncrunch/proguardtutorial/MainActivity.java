package com.crackncrunch.proguardtutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.crackncrunch.proguardtutorial.response.PersonResponse;
import com.crackncrunch.proguardtutorial.response.PersonResponse2;
import com.crackncrunch.proguardtutorial.response.PersonResponse3;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "http://private-36151-proguardlesson.apiary-mock.com/proguardlesson/";

    @BindView(R.id.text_view)
    TextView mTextView;

    Api mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        createApi();
        showToast("Hello");

        try {
            Field someString = SomeClass.class.getDeclaredField("someString");
            Toast.makeText(this, someString.getName(), Toast.LENGTH_SHORT).show();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        mTextView.setText("Alice");
    }

    @Override
    protected void onResume() {
        super.onResume();
        new AsyncTask<Void, Void, PersonResponse>() {
            @Override
            protected PersonResponse doInBackground(Void... params) {
                try {
                    Response<PersonResponse> personResponse = mApi.getPerson().execute();
                    final PersonResponse body = personResponse.body();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addText(body.getName() + " " + body
                                    .getSecondName() + " " + body.getAge());
                        }
                    });
                    final PersonResponse2 body2 = mApi.getPerson2().execute().body();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addText(body2.getName() + " " + body2
                                    .getSecondName());
                        }
                    });
                    final PersonResponse3 body3 = mApi.getPerson3().execute().body();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addText(body3.getName() + " " + body3.getAge());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    private void createApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("TAG", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .build();

        GsonConverterFactory converter = GsonConverterFactory.create(
                new GsonBuilder()
                        .setLenient()
                        .create()
        );

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(converter)
                .build();

        mApi = retrofit.create(Api.class);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void addText(String text) {
        String prev = mTextView.getText().toString();
        mTextView.setText(prev + "\n" + text);
        //throw new RuntimeException("hey hey");
    }
}
