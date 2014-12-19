package com.android.leaftionary.helper;

import android.content.Context;
import android.util.Log;

import com.android.leaftionary.configuration.Config;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Kevin on 12/18/2014.
 */
public class Utilities {

    public static boolean checkDatabase(Context context){
        File dbFile = context.getDatabasePath(Config.DB_NAME);
        return dbFile.exists();
    }


    public static String SendJSONRequest(String src) {
        BufferedReader reader = null;
        String data = "";
        try {

            URL url = new URL(src);

            StringBuilder builder = new StringBuilder();
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(src);
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e("SERVER CONNECTION", "Failed to read configuration");
            }
            return builder.toString();
        } catch (Exception ex) {
            Log.e("SendJSONRequest", ex.getMessage().toString());
        }

        return "";

    }

}
