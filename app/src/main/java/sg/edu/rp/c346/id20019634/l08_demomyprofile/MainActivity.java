package sg.edu.rp.c346.id20019634.l08_demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA, etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        etAge = findViewById(R.id.editTextAge);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float gpa = Float.parseFloat(strGPA);
        String strAge = etAge.getText().toString();
        int age = Integer.parseInt(strAge);

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("age", age);

        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        String strName = prefs.getString("name", "No name set");
        Float gpa = prefs.getFloat("gpa", 0.0f);
        String strGPA = String.valueOf(gpa);
        Integer age = prefs.getInt("age", 0);
        String strAge = String.valueOf(age);

        etName.setText(strName);
        etGPA.setText(strGPA);
        etAge.setText(strAge);

    }
}