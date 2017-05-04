package sg.edu.rp.c347.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int requestCodeForSupermanStats = 1;
    int getRequestCodeForBatmanStats = 2;

    TextView bman, sman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bman = (TextView)findViewById(R.id.textViewBatman);
        sman = (TextView)findViewById(R.id.textViewSuperman);

        bman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hero batman = new Hero("Batman", 100, 60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);

                i.putExtra("hero", batman);
                startActivityForResult(i,getRequestCodeForBatmanStats);


            }
        });

        sman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hero superman = new Hero("Superman", 60, 90);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                i.putExtra("hero", superman);
                startActivityForResult(i,requestCodeForSupermanStats);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(data != null) {
                String like = data.getStringExtra("like");
                String statement = "";

                if(requestCode == getRequestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }

                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }

                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();

            }
        }
    }
}
