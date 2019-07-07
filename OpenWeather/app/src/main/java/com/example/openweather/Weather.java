package com.example.openweather;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
            JSONObject weather = new JSONObject(myObject.getString("weather"));
            String temperature = main.getString("temp");
            String country = sys.getString("country");
            String description = weather.getString("description");
            String placeName = myObject.getString("name");


            MainActivity.place.setText(placeName + ", " + country);
            MainActivity.temp.setText(temperature);
            MainActivity.descr.setText(description);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
