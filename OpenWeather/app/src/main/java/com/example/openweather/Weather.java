package com.example.openweather;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Weather extends AsyncTask<String, Void, String> {
    String result;

    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myConnection = null;

        try{
            link = new  URL(urls[0]);
            myConnection = (HttpURLConnection)link.openConnection();
            InputStream in = myConnection.getInputStream();
            InputStreamReader myStreamReader = new  InputStreamReader(in);
            int data = myStreamReader.read();
            while(data != - 1){
                char current = (char)data;
                result += current;
                data = myStreamReader.read();
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try{
            Log.d("temperature", "onPostExecute: temperature");                             //logcat to see if try-catch block has been executed

            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            JSONObject sys = new JSONObject(myObject.getString("sys"));
            JSONArray weather = myObject.getJSONArray("weather");
            JSONObject zeroInd = weather.getJSONObject(0);
            JSONObject wind = new JSONObject(myObject.getString("wind"));

            String temperature = main.getString("temp");
            String country = sys.getString("country");
            String description = zeroInd.getString("description");
            String placeName = myObject.getString("name");
            String speed = wind.getString("speed");
            String pressure = main.getString("pressure");
            String humid = main.getString("humidity");
            String sunrise = sys.getString("sunrise");
            String sunset = sys.getString("sunset");

            MainActivity.place.setText(placeName + ", " + country);
            MainActivity.temp.setText(temperature + " ℃");
            MainActivity.descr.setText(Character.toUpperCase(description.charAt(0)) + description.substring(1));
            MainActivity.wind.setText("Wind: " + speed + " m/s");
            MainActivity.pressure.setText("Pressure: " + pressure + " hPa");
            MainActivity.humid.setText("Humidity: " + humid + "%");
            MainActivity.iconStat.setText(changeIcons(description));

            //Time
            long unixSecondsRise = Integer.parseInt(sunrise);
            long unixSecondsSet = Integer.parseInt(sunset);

            MainActivity.sunrise.setText("Sunrise: " + setDate(unixSecondsRise));
            MainActivity.sunset.setText("Sunset: " + setDate(unixSecondsSet));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String setDate(long unixSeconds){
        Date date = new java.util.Date(unixSeconds * 1000L);

        SimpleDateFormat sdf = new java.text.SimpleDateFormat("h:mm a");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+6"));
        String formattedDate = sdf.format(date);

        return formattedDate;
    }

    public String changeIcons(String temperature){
        String status = null;
        switch (temperature){
            case "haze":
                status = "Z";
                MainActivity.backGroundColor = Color.parseColor("#828282");
                break;
            case "few clouds":
                status = "a";
//                MainActivity.backGroundColor = Color.LTGRAY;
                break;
            case "overcast clouds":
                status = "3";
                break;
            case "moderate rain":
                status = "K";
//                MainActivity.backGroundColor = Color.BLUE;
                break;
            case "light rain":
                status = "M";
                break;
            case "broken clouds":
                status = "A";
                break;
            case "scattered clouds":
                status = "2";
                MainActivity.backGroundColor = Color.parseColor("#a4a4ba");
                break;
            case "clear sky":
                status = "1";
//                MainActivity.backGroundColor = Color.BLUE;
                break;
        }
        return status;
    }
}
