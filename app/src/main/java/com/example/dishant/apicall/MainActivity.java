package com.example.dishant.apicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ApicallsmsResponse apicallsmsResponseArrayList;
    Button button;
    String phone,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = "8879819580,8850368929";
        text = "Hello";
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apicallsms();
            }
        });

    }

    private void apicallsms()
    {
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_LONG).show();
        final String apiURL = "http://login.absl.net.in/api/mt/SendSMS?user=@shailesh&password=welcome&senderid=ABSLTN&channel=trans&DCS=0&flashsms=0&number=" + phone + "&text=" + text + "&route=34";

        VolleySingleton.getInstance(getBaseContext()).addToRequestQueue(new JsonObjectRequest(Request.Method.GET, apiURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("phone12345 : ", text);
                        Log.i("url12345 : ", apiURL);
                        Log.i("response12345 : ", response.toString());
                        Gson gson = new Gson();
                        apicallsmsResponseArrayList = gson.fromJson(response.toString(), ApicallsmsResponse.class);

                        if(apicallsmsResponseArrayList.ErrorMessage.equals("Done"))
                        {
                            Toast.makeText(getApplicationContext(), "Message Send Initiated",Toast.LENGTH_LONG).show();
                        }
                        else Toast.makeText(getApplicationContext(), "Message Send Failed",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Exception", error.toString());
            }
        }));
    }
}
