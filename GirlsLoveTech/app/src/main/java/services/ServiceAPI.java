package services;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ServiceAPI {


    private static String url = "https://api-girlslovetech.herokuapp.com/";

    public static String getService(String dataset, String method, String data){
        String reqUrl = url + dataset;

        if (method == "GET") {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Miwicm9sZXMiOiJhZG1pbiIsImNyZWF0ZWRBdCI6IjIwMjEtMTEtMTlUMjE6NTc6MTIuMDAwWiIsInVwZGF0ZWRBdCI6IjIwMjEtMTEtMTlUMjE6NTc6MTIuMDAwWiIsImlzQWN0aXZlIjp0cnVlLCJpYXQiOjE2Mzc3MTczMjAsImV4cCI6MTYzODMyMjEyMH0.O7Y2VUipjrza-1ZkXNygf7JHIggH6XHJ-5VczM-o5NI");
                conn.setRequestMethod(method);
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (Exception e) {
                Log.e("Service Api", "Exception: " + e.getMessage());
            }
            return response;
        }

        else if(method == "POST") {
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestMethod(method);
                OutputStream out = conn.getOutputStream();
                byte[] input = data.getBytes("utf-8");
                out.write(input, 0, input.length);
                int responseCode= conn.getResponseCode();
                if(responseCode == HttpsURLConnection.HTTP_CREATED)
                    return "OK";
                return "Erro";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }        }        return sb.toString();    }


}


