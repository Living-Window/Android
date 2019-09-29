package com.example.livingwindow;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.util.Random;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static com.example.livingwindow.R.id.userEnterText;

public class MainActivity extends AppCompatActivity {
    private Button addButton;
    //does Button have to be private?p
    /*private*/ MySQLiteOpenHelper sqLiteOpenHelper;
    /*private*/
                TextView userEnterText;
                //EditText clearOldText;
    /*private*/ TextView pHSensorText;
                TextView waterproofSensorText;
                TextView tempHumSensorText;
                TextView lightStatusText;
                TextView airPumpStatusText;
    /*private*/ //TextView lightOnOff;
    /*private*/ //TextView airPumpOnOff;
    String pHtooLow;
    String pHtooHigh;
    String pHok;
    String tempTooHigh;
    String tempTooLow;
    String tempOk;
    //String humidityTooHigh;
    String humidityTooLow;
    String humidityOk;
    String lightOn;
    String lightOff;
    String airPumpOn;
    String airPumpOff;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //.addSensorRow(SensorEntry);
       // userEnterText = findViewById(R.id.userEnterText);
        pHSensorText = findViewById(R.id.pHSensorText);
        waterproofSensorText = findViewById(R.id.waterproofSensorText);
        tempHumSensorText = findViewById (R.id.tempHumText);
        lightStatusText = findViewById (R.id.lightStatusText);
        airPumpStatusText = findViewById (R.id.airPumpStatusText);
        //if this ^ works, then do the same for the other sensors: waterproof temp sensor & phsensor
        sqLiteOpenHelper = new MySQLiteOpenHelper(this, null, null, 1);
        addButton = findViewById(R.id.addButton);
        //printDatabase()
            }

        public void buttonClicked(View v) {
            //SensorEntries aSensorEntry = new SensorEntries(userEnterText.getText().toString());
            //sqLiteOpenHelper.addSensorRow(aSensorEntry);
            //printDatabase();

            final int id = v.getId();

            //for all sensor-values, measure current value against cloud's main-database
            //with all advisable attributes for temp, pH, water-level, etc
            //compare current attribute level to advisable level
            //apply logic accordingly


            int currentHumidity = (int) (Math.random()*100);
            if(currentHumidity <45){
                humidityTooLow = "The current humidity is " +currentHumidity + "%." +'\n'
                                + "That is LOWER than the recommended humidity range of 45% or higher."
                                + '\n' + "Please raise the humidity.";
                tempHumSensorText.setText(humidityTooLow);
            }
            else /*(currentHumidity >= 45)*/{
                humidityOk = "The current humidity is " + currentHumidity + "%."
                        +'\n' + "It is within the recommended humidity range of 45% or higher."
                        +'\n' + "Please don't adjust the humidity.";
                tempHumSensorText.setText(humidityOk);
            }


            int currentTemp = (int) (Math.random()*150);
            if(currentTemp <55){
                tempTooLow = "The current temperature is " + currentTemp + " degrees Fahrenheit. " +'\n'
                        + "That is LOWER than the recommended temperature range of 55-75 degrees Fahrenheit." +'\n'
                        + "Please add heat.";
                waterproofSensorText.setText(tempTooLow);
            }
            else if (currentTemp > 75){
                tempTooHigh = "The current temperature is " + currentTemp + " degrees Fahrenheit. " +'\n'
                + "That is HIGHER than the recommended temperature range of 55-75 degrees Fahrenheit."
                +'\n' + "Please reduce heat.";
                waterproofSensorText.setText(tempTooHigh);
            }
            else /*temp is in range */{
                tempOk = "The current temperature is " + currentTemp + " degrees Fahrenheit." + '\n'
                + "That is within the recommended temperature range of 55-75 degrees Fahrenheit."
                + '\n'+ "Please don't adjust the temperature.";
                waterproofSensorText.setText(tempOk);
            }


        int currentPh = (int) (Math.random()*14);
        //switch (id) {
          //  case R.id.addButton:
                if(currentPh <6) {
                    pHtooLow = "The current pH is " +currentPh + "." + '\n' +
                            "That is LOWER than the recommended level of 6.0." + '\n' +
                            "Please give your plant pH-UP solution.";
                    pHSensorText.setText(pHtooLow);
                }
                else if(currentPh >6) {
                    //System.out.println("The current pH level is" + currentPh);
                    pHtooHigh = "The current pH is " +currentPh + "." +'\n'+
                            "That is HIGHER than the recommended level of 6.0." + '\n' +
                            "Please give your plant pH-DOWN solution.";
                    pHSensorText.setText(pHtooHigh);
                }
                else
                    //(currentPh == 6)
                    {
                    pHok = "The current pH is fine at " +currentPh + "!" + '\n'
                    + "Don't adjust it!";
                    pHSensorText.setText (pHok);
                }

        int isLightOn = (int) (Math.random()*2);
                if(isLightOn ==1){
                    lightOn = "If your light is on, then please turn off the light" +'\n'
                    + "at night when plants have had 10-12 hours of light.";
                    lightStatusText.setText(lightOn);
                }
                else /*lightOff*/ {
                    lightOff = "If your light is off, then please turn on the light in the morning.";
                    lightStatusText.setText(lightOff);
                }
        int isAirPumpOn= (int) (Math.random()*2);
            if(isAirPumpOn==1){
                airPumpOn = "If the air pump is on, keep it running!";
                airPumpStatusText.setText(airPumpOn);
            }
            else{
                airPumpOff= "If the air pump is off, TURN IT ON OR FIX IT IMMEDIATELY!";
                airPumpStatusText.setText(airPumpOff);
            }

        }
    }
    //public void printDatabase(){
    //String dbString = sqLiteOpenHelper.databaseToString();
    //userEnterText.setText(dbString);
    //}


    /*
        btnCreateDatabase.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     sqliteOpenHelper  = new MySQLiteOpenHelper(getApplicationContext());
                                                     myDatabase = sqliteOpenHelper.getWritableDatabase();
                                                     Cursor cursor = myDatabase.rawQuery("select * from lettuce;", null);
                                                     System.out.println("MainActivity.onClick:" + cursor.getColumnCount());



        public View onCreateView
             //View view = inflater.inflate(R.layout.add_edit_fragment, container, false);
                View view = inflater.inflate(R.layout.addEditFragment, container, false);
                sensor1text = (TextInputLayout) view.findViewById(R.id.tempHumText);
                sensor2text = (TextInputLayout) view.findViewById(R.id.waterproofSensorText);
                sensor3text = (TextInputLayout) view.findViewById (R.id.pHsensorText);
                //once received sql data detach mainFrag. Attach displayFrag
                //
            }

            ;
        });
*/