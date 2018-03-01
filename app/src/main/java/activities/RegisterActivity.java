package activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.whatsup.hawre.whatsup.R;

public class RegisterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText usernameView = findViewById(R.id.regUsernameView);
        TextView emailView = findViewById(R.id.regEmailView);
        TextView passwordView = findViewById(R.id.regPasswordView);
        TextView confirmPasswordView = findViewById(R.id.regConfirmPassView);
        TextView errorView = findViewById(R.id.errorView);
        Button regButton = findViewById(R.id.regButton);


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        View view = getCurrentFocus();
        view.clearFocus();
        return super.dispatchTouchEvent(ev);
    }
}
