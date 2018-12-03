package com.example.danhpham.group2;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static String id;
    //String id;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        mTextMessage = (TextView) findViewById(R.id.message);
    }

    public void goToLogin(View view){
        Intent startLogin = new Intent(this, Login.class);
        startActivity(startLogin);
    }
     public void goToMenu(View view){
        Intent startMenu = new Intent(this, Menu.class);
        startActivity(startMenu);
    }

    public void goToUser(View view){
        Intent startUser = new Intent(this, User.class);
        //Toast.makeText(getApplicationContext(), String.format("Passing in ID to User: %s", id), Toast.LENGTH_LONG).show();
        //startUser.putExtra("id", id);
        startActivity(startUser);
    }

    public void goToInfo(View view){
        Intent startInfo = new Intent(this, Info.class);
        startActivity(startInfo);
    }

    public static String getId() {
        return id;
    }

}
