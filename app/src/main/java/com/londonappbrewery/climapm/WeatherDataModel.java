package com.londonappbrewery.climapm;

import android.content.SharedPreferences;
import android.graphics.drawable.Icon;
import android.renderscript.Sampler;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import static com.loopj.android.http.AsyncHttpClient.log;

public class WeatherDataModel {


    // TODO: Declare the member variables here
    private int mTemperature;

    private String mTempratureStr;
    private String mCity;
    private String mIconeName;
    private int mConditions;

    private int mDescript;








    // TODO: Create a WeatherDataModel from a JSON:
    public static WeatherDataModel fromJson(JSONObject jsonObject) {


        try {

            WeatherDataModel weatherData = new WeatherDataModel();

            weatherData.mCity = jsonObject.getString("name");
            weatherData.mConditions = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mIconeName = updateWeatherIcon(weatherData.mConditions);
            weatherData.mDescript = testing(weatherData.mConditions);
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") * 1.8 - 459.67;
            int roundValue = (int) Math.rint(tempResult);
            weatherData.mTemperature = roundValue;
            weatherData.mTempratureStr = Integer.toString(roundValue);
           // weatherData.mDescriptionText = Integer.toString(R.string.cold_two);

            return weatherData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }




    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {
        log.d("what", Integer.toString(condition));

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }
        return "dunno";
    }

    public static int testing(int condition) {
        log.d("what", Integer.toString(condition));

        if (condition >= 0 && condition < 300) {
            return R.string.snow_one;
        } else if (condition >= 300 && condition < 500) {
            return R.string.heavy_rain_one;
        } else if (condition >= 500 && condition < 600) {
            return R.string.heavy_rain_three;
        } else if (condition >= 600 && condition <= 700) {
            return R.string.heavy_rain_two;
        } else if (condition >= 701 && condition <= 771) {
            return R.string.fog_one;
        } else if (condition >= 772 && condition < 800) {
            return R.string.heavy_rain_three;
        } else if (condition == 800) {
            return R.string.storm_one;
        } else if (condition >= 801 && condition <= 804) {
            return R.string.storm_one;
        } else if (condition >= 900 && condition <= 902) {
            return R.string.storm_three;
        } else if (condition == 903) {
            return R.string.snow_two;
        } else if (condition == 904) {
            return R.string.snow_one;
        } else if (condition >= 905 && condition <= 1000) {
            return R.string.storm_three;
        }
        return R.string.fog_one;
    }













    public int getmTemperature() {
        return mTemperature ;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmIconeName() {
        return mIconeName;
    }
    public int getmConditions() {
        return mConditions;
    }
    public String getmTempratureStr() {
        return mTempratureStr + "°";
    }
    public int getmDescript() {
        return mDescript;
    }



}



