package com.example.danhpham.group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class userOrders extends AppCompatActivity {

    String id;
    String orderList;

    //RequestQueue requestQueue;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_orders);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        orderList = "";
        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/display_orders_danh.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String orderNum = jsonObject.getString("orderID");
                                String status = jsonObject.getString("status");
                                String price = jsonObject.getString("price");
                                String date = jsonObject.getString("date");

                                orderList += "Order Number: " + orderNum + "\nStatus: " + status + "\nPrice: $"
                                        + price + "\nDate: " + date + "\n\n\n\n";

                            }

                            results = (TextView) findViewById(R.id.orders);
                            results.setText(orderList);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("id",id);
                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);
        //this.requestQueue.add(request);

    }
}
