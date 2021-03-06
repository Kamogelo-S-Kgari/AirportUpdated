package com.example.airport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser {

    private HashMap<String,String>parseJsonObject(JSONObject object)

    {
        HashMap<String,String>dataList = new HashMap<>();
        try {
            String name = object.getString("name");

            String lat = object.getJSONObject("geometry")
                    .getJSONObject("location").getString("lat");
            String lng = object.getJSONObject("geometry")
                    .getJSONObject("location").getString("lng");


            dataList.put("name",name);
            dataList.put("lat",lat);
            dataList.put("lng",lng);



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataList;

    }
    private List<HashMap<String,String>>parseJsonArray(JSONArray jsonArray)
    {
        List<HashMap<String,String>> dataList = new ArrayList<>();
        for (int i = 0; i<jsonArray.length();i++)
        {
            try {


                HashMap<String,String> data = parseJsonObject((JSONObject) jsonArray.get(i));
           dataList.add(data);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return dataList;
    }


}
