package com.londonappbrewery.climapm;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static com.loopj.android.http.AsyncHttpClient.log;

public class Scenarios {


//private String tempholder = new WeatherDataModel().getmTemperature();
//int temp = Integer.parseInt(tempholder);
//int conditions = new WeatherDataModel().getmConditions();


    public static int test2() {
        int conditions = new WeatherDataModel().getmConditions();
       // int temp = new WeatherDataModel().getmTemperature();
        //log.d("what", Integer.toString(conditions));

        if (conditions >= 0 && conditions < 300) {
            return R.string.snow_one;
        } else if (conditions >= 300 && conditions < 500) {
            return R.string.heavy_rain_one;
        } else if (conditions >= 500 && conditions < 600) {
            return R.string.heavy_rain_three;
        } else if (conditions >= 600 && conditions <= 700) {
            return R.string.heavy_rain_two;
        } else if (conditions >= 701 && conditions <= 771) {
            return R.string.fog_one;
        } else if (conditions >= 772 && conditions < 800) {
            return R.string.heavy_rain_three;
        } else if (conditions == 800) {
            return R.string.storm_one;
        } else if (conditions >= 801 && conditions <= 804) {
            return R.string.storm_one;
        } else if (conditions >= 900 && conditions <= 902) {
            return R.string.storm_three;
        } else if (conditions == 903) {
            return R.string.snow_two;
        } else if (conditions == 904) {
            return R.string.snow_one;
        } else if (conditions >= 905 && conditions <= 1000) {
            return R.string.storm_three;
        }
        return R.string.fog_one;
    }
}







