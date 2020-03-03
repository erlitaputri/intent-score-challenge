package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ScorerActivity extends AppCompatActivity {

    public static final String SCORER_KEY = "scorername";

    private EditText scorernameInput;

    public static final int SCORER_REQUEST_CODE=1&2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        scorernameInput = findViewById(R.id.editText);
    }

    public void handleSubmit(View view) {
        String scorername = scorernameInput.getText().toString();

        if((scorername).equals("")){
            Toast.makeText(getApplicationContext(), "Isi nama Pencetak gol!", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, MatchActivity.class);
            intent.putExtra(SCORER_KEY, scorername);
            setResult(MatchActivity.RESULT_OK, intent);
            finish();
        }
    }
}
