package com.example.openweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView place;
    static TextView temp;
    static TextView descr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place = (TextView) findViewById(R.id.place);
        temp = (TextView) findViewById(R.id.temp);
        descr = (TextView) findViewById(R.id.descr);

        Weather getData = new  Weather();
        getData.execute("http://api.openweathermap.org/data/2.5/" + "weather?q=London&appid=4405af8824d94dcf3c82c0530ae45962");
    }
}
