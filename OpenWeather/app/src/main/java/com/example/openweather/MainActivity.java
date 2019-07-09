package com.example.openweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView place;
    static TextView temp;
    static TextView descr;
    static TextView wind;
    static TextView pressure;
    static TextView humid;
    static TextView sunrise;
    static TextView sunset;

    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place = (TextView) findViewById(R.id.place);
        temp = (TextView) findViewById(R.id.temp);
        descr = (TextView) findViewById(R.id.descr);
        wind = (TextView) findViewById(R.id.wind);
        pressure = (TextView) findViewById(R.id.pressure);
        humid = (TextView) findViewById(R.id.humid);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);


        Weather getData = new  Weather();
        getData.execute("http://api.openweathermap.org/data/2.5/" + "weather?q=Dhaka,bd&appid=4405af8824d94dcf3c82c0530ae45962&units=metric");
    }
}
