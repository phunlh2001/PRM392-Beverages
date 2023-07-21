package com.phunlh2001.prm392_beverages;

<<<<<<< HEAD
import android.os.Bundle;
=======
import static com.phunlh2001.prm392_beverages.utils.Constant.KEY_LOGIN;
import static com.phunlh2001.prm392_beverages.utils.Constant.PREF_LOGIN;
>>>>>>> develop

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
=======

        SharedPreferences pref = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        String email = pref.getString(KEY_LOGIN, "");
        if (email.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, GetStartActivity.class);
            startActivity(intent);
        } else {
            // [TODO] Navigate to your layout for testing here
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
>>>>>>> develop
    }
}