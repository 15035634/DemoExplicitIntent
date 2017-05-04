package sg.edu.rp.c347.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTech;
    Button bLike, bDislike;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        Intent i = getIntent();
        Hero hero = (Hero) i.getSerializableExtra("hero");

        bLike = (Button)findViewById(R.id.bLike);
        bDislike = (Button)findViewById(R.id.bDislike);

        tvName = (TextView)findViewById(R.id.tvName);
        tvStrength = (TextView)findViewById(R.id.tvStrength);
        tvTech = (TextView)findViewById(R.id.tvTechnical);


        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTech.setText("Techical: " + hero.getTechnicalProwess());

        bLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("like", "like");

                setResult(RESULT_OK, i);
                finish();
            }
        });

        bDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("like", "dislike");

                setResult(RESULT_OK, i);
                finish();
            }
        });


    }
}
