package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
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

import com.android.volley.toolbox.StringRequest;

public class User extends AppCompatActivity {

    String id;
    TextView email, phone, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //Intent intent = getIntent();
        //id = intent.getStringExtra("id");
        //Toast.makeText(getApplicationContext(), String.format("ID IN USER CLASS: %", id), Toast.LENGTH_SHORT).show();
        id = HomePageActivity.getId();

        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/customer_info_danh_test.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            //Toast.makeText(getApplicationContext(), String.format("Response: %s", response), Toast.LENGTH_LONG).show();
                            String arr[] = response.split(",");


                            //JSONArray jsonArray=new JSONArray(response);

                            //JSONObject jsonObject = jsonArray.getJSONObject(0);
                            //String email_str = jsonObject.getString("email");
                            //Toast.makeText(getApplicationContext(), String.format("Email grabbed: %s", email_str), Toast.LENGTH_LONG).show();
                            //String phone_str = jsonObject.getString("phone");
                            //String card_str = jsonObject.getString("price");
                            //String card_str = "12341233412341234"; // hard-coded since no card field exists in db

                            /*
                            String email_str = arr[6];
                            email_str = email_str.replace("email", "");
                            email_str = email_str.replace(":", "");
                            email_str = email_str.replace("\"", "");
                            email_str = email_str.replace("}", "");
                            Toast.makeText(getApplicationContext(), email_str, Toast.LENGTH_LONG).show();

                            String phoneNum = arr[5];
                            phoneNum = phoneNum.replace("phone", "");
                            phoneNum = phoneNum.replace(":", "");
                            phoneNum = phoneNum.replace("\"", "");
                            phoneNum = phoneNum.replace("}", "");

                            */
                            // Try version 2
                            name = (TextView) findViewById(R.id.textView10);
                            name.setText(arr[1]);

                            email = (TextView) findViewById(R.id.textView14);
                            email.setText(arr[0]);
                            phone = (TextView) findViewById(R.id.textView12);
                            phone.setText(arr[2]);

                            //creditCard = (TextView) findViewById(R.id.editText4);
                            //creditCard.setText(card_str);


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

    }

    public void goToOrders(View view){
        Intent startOrders = new Intent(this, userOrders.class);
        //Toast.makeText(getApplicationContext(), String.format("ID in goToOrders(): %s", id), Toast.LENGTH_LONG).show();
        startOrders.putExtra("id", id);
        //Toast.makeText(getApplicationContext(), String.format("Passing ID to Order Display: %s", id), Toast.LENGTH_LONG).show();
        startActivity(startOrders);
    }

    public void goToEdit(View view) {
        Intent startEdit = new Intent(this, EditAccount.class);
        startEdit.putExtra("id", id);
        startActivity(startEdit);
    }

}
