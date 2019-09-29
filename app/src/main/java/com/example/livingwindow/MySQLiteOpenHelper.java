package com.example.livingwindow;
//the point of this class is to fill in a database
//with the appropriate values that we get from
//the sensors

//the video has this line of "import android.content.Context;
 import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.ContentValues;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final /*String DATABASE_NAME = "measurements.db"; */ String databaseName = "measurements.db";
    private static final int /*DATABASE_VERSION= 1; */ databaseVersion = 1;
    public static final String /*TABLE_NAME = "Lettuce"; */ tableName = "lettuce";
    public static final String /*COLUMN_ID = "_id"; */ columnId = "_id"
    public static final String /*COLUMN_SENSORNAME = "_sensorname"; */ columnSensorName = "_sensorName";
    public static final String /*COLUMN_SENSORVALUE = "_sensor_value"; */ columnSensorValue = "_sensorValue";


    public MySQLiteOpenHelper(Context aContext, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        //super(aContext, DATABASE_NAME, null, DATABASE_VERSION);
        super(aContext, databaseName, null,databaseVersion);
    }


//onCreate occurs when you create the database,

    @Override
    public void onCreate(SQLiteDatabase db) {

    //String database_create_statement =
    String databaseCreateStatement=
            "CREATE TABLE " +
    /*
            TABLE_NAME + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_SENSORNAME + "sensorname" + COLUMN_SENSORVALUE + "_sensorvalue " +
    */
        tableName + "(" + columnId + "INTEGER PRIMARY KEY AUTOINCREMENT," + columnSensorName+ "sensorName"
                    + columnSensorValue + " sensorValue " + ")";
    //need to find the number of sensors, from their fire-base account
        //call addSensorRow that number of times

      //  db.execSQL(database_create_statement);
        db.execSQL(databaseCreateStatement);
}
//onUpgrade, every time you get new data. Which could be every second,
//such as for the air pump. So over-write the data with every
//"upgrade"

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion /* as a number*/, int newVersion) {
        //changes in the database
        db.execSQL("DROP TABLE IF EXISTS " + /*TABLE_NAME*/tableName);
        onCreate(db);
    }
    //add a new row to the database
    public void addSensorRow (SensorEntries aSensorEntry){
        ContentValues fillInWith = new ContentValues();
        fillInWith.put (/*COLUMN_SENSORNAME*/ columnSensorName, aSensorEntry.get_SensorName() );
        ContentValues fillInWith2= new ContentValues();
        fillInWith2.put(/*COLUMN_SENSORVALUE*/columnSensorValue, aSensorEntry.get_Value());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(/*TABLE_NAME*/ tableName, null, fillInWith);
 //different addRow function for each type of sensors: ph, humidity, temperature,
        //humidity and temperature come from same sensor but each should have its own row
        //at least one row, maybe more: co2 sensor, othergases-sensor (eg toxins)
        //to summarize the health benefits with respect to air quality by owning LW device
        //each plant or similar plants in the same row. row are differentiated by necessary micro-climates

        db.close();
}

    //delete a sensor from the table
    public void deleteSensorRow (String sensorName){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_SENSORNAME + "=\"" + sensorName + "\";" );
        db.execSQL("DELETE FROM " + tableName + " WHERE " + columnSensorName + "=\"" + sensorName + "\";" );
    }

    //print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        //String jungkook = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        String tableFill = "SELECT * FROM" + tableName + " WHERE 1";
        //1 means all conditions are met
        //select every column, select every row
                dbString += "This sensor's ID number is: ";
                //Cursor point to location in your results
                Cursor cr = db.rawQuery (tableFill, null);
                //move to the first row in your results
                cr.moveToFirst();

                while (!cr.isAfterLast()){
                    if(cr.getString(cr.getColumnIndex("sensorName"))!=null){
                dbString += cr.getString(cr.getColumnIndex("columnId"));
                dbString+= "\n";
                dbString += "The sensor is ";
            dbString += cr.getString(cr.getColumnIndex("sensorName"));
            dbString += ".\n";
            dbString += "The sensor's current measurement is: ";
            dbString += cr.getString(cr.getColumnIndex ("sensorValue"));
            dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }
}
