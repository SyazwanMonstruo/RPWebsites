package sg.edu.rp.c346.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCat;
    Spinner spnSub;
    Spinner spnYesNo;
    Button btnGo;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCat = findViewById(R.id.spinnerCat);
        spnSub = findViewById(R.id.spinnerSub);
        spnYesNo = findViewById(R.id.spinnerCat);
        btnGo = findViewById(R.id.buttonURL);

        // Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner Layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alNumbers);

        //Bind the ArrayAdapter to the Spinner
        spnSub.setAdapter(aaNumbers);


        spnYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                if (position == 0) {


                    //Get the string-array and store as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.SubCategory1);

                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));

                }

                else {

                    //Get the string-array and store as an Array
                    String[] strNumber = getResources().getStringArray(R.array.SubCategory2);

                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumber));


                }

            aaNumbers.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Web.class);

                int Pos1 = spnCat.getSelectedItemPosition();
                int pos = spnSub.getSelectedItemPosition();
                String[][] sites ={
                        {
                                "https://www.rp.edu.sg",
                                "https://www.rp.edu.sg/student-life",
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                        },



                };
                alNumbers.clear();
                if (Pos1 == 0) {
                    if (pos == 0) {
                        intent.putExtra("web", sites[0][0]);
                    } else {
                        intent.putExtra("web", sites[0][1]);
                    }

                } else {
                    if (pos == 0) {
                        intent.putExtra("web", sites[1][0]);
                    } else {
                        intent.putExtra("web", sites[1][1]);
                    }

                }




               /* spnCat.setVisibility(View.GONE);
                spnSub.setVisibility(View.GONE);
                btnGo.setVisibility(View.GONE);
                tvCat.setVisibility(View.GONE);
                tvSub.setVisibility(View.GONE);*/

                startActivity(intent);
                aaNumbers.notifyDataSetChanged();

            }


        });





    }
}
