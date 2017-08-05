package com.example.sin5.aboutasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private TextView percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);
        percent = (TextView) findViewById(R.id.percent);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadURL("http://www.baidu.com");
            }
        });
    }

    public void ReadURL(String url){
        new AsyncTask<String, Float, String>(){

            @Override
            protected String doInBackground(String... params) {
                try {
                    URL Url = new URL(params[0]);
                    URLConnection urlConnection = Url.openConnection();
                    long total = urlConnection.getContentLength();
                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null){
                        sb.append(line);
                        publishProgress((float) sb.toString().length()/total);
                    }
                    br.close();
                    is.close();
                    return sb.toString();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                Toast.makeText(MainActivity.this, "begin", Toast.LENGTH_SHORT).show();
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                tv.setText(s);
                super.onPostExecute(s);
            }

            @Override
            protected void onProgressUpdate(Float... values) {
                percent.setText(values[0].toString());
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }
        }.execute(url);
    }
}
