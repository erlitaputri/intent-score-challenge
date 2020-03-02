package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    private TextView homeText;
    private TextView awayText;
    private TextView homeScore;
    private TextView awayScore;
    private ImageView homelogo;
    private ImageView awaylogo;
    int home;
    int away;
    private TextView scorehomeText;
    private TextView scoreawayText;

    public static final String RESULT_KEY="result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homeScore = findViewById(R.id.score_home);
        awayScore = findViewById(R.id.score_away);
        homelogo = findViewById(R.id.home_logo);
        awaylogo = findViewById(R.id.away_logo);
        scorehomeText = findViewById(R.id.score_home);
        scoreawayText = findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            Bundle extra = getIntent().getExtras();
            Bitmap bmp = extra.getParcelable("homeImg");
            Bitmap bmp2 = extra.getParcelable("awayImg");

            homelogo.setImageBitmap(bmp);
            awaylogo.setImageBitmap(bmp2);
            homeText.setText(extras.getString(MainActivity.HOMETEAM_KEY));
            awayText.setText(extras.getString(MainActivity.AWAYTEAM_KEY));
            //receive img

            String scorername = extras.getString(ScorerActivity.SCORER_KEY);
            scorehomeText.setText(scorername);
            String username = extras.getString(ScorerActivity.SCORER_KEY);
            scoreawayText.setText(scorername);
        }
    }

    //2.Tombol add score menambahkan memindah activity ke scorerActivity dimana pada scorer activity di isikan nama pencetak gol
    public void handleAddAway(View view) {
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivity(intent);
    }

    public void handleAddHome(View view) {
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivity(intent);
    }

    //3.Dari activity scorer akan mengirim kembali ke activity matchactivity otomatis nama pencetak gol dan skor bertambah +1


    //4.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang beserta nama pencetak gol ke ResultActivity, jika seri di kirim text "Draw",
    public void handleResult(View view) {
    }
}
