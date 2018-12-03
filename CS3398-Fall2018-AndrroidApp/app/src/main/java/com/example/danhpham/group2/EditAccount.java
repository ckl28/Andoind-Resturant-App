package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class EditAccount extends AppCompatActivity {

    String id;
    EditText email, phone;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        email = (EditText) findViewById(R.id.editText2);
        phone = (EditText) findViewById(R.id.editText3);
        save = (Button) findViewById(R.id.edit_button);

        id = HomePageActivity.getId();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAccount();
                //sendEmail(email.getText().toString());
            }
        });
    }

    public void editAccount() {

        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/edit_customer_online.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")){
                            Toast.makeText(getApplicationContext(), "Save successful", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Unable to update account",
                                    Toast.LENGTH_SHORT).show();
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
                params.put("email",email.getText().toString());
                params.put("phone",phone.getText().toString());
                params.put("id", id);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);

    }

    public void goToUser(View view) {

        Intent startUser = new Intent(this, User.class);
        startActivity(startUser);
    }

    protected void sendEmail(final String email) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/email_edit_account.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (!response.contains("1")){
                            Toast.makeText(getApplicationContext(), "Unable to send confirmation to email",
                                    Toast.LENGTH_SHORT).show();
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
                params.put("email",email);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

}
