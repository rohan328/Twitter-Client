package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.extras.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public String body;
    public String createdAt;
    public User user;
    public long Id;

    public Tweet(){} //empty constructor for parceler

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.Id = jsonObject.getLong("id");

        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return list;
    }

    public String getFormattedTimestamp() {
        return TimeFormatter.getTimeDifference(createdAt);
    }

}
