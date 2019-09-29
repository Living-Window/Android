package com.example.livingwindow;

// each sensor is an object of this class
// we have three sensors: temp-humidity, waterproofTemp, and pH
//for first creation of this database, i'll have to enter the names of
//the sensors

//would like to:
//if id == 0, sensor = tempHUmidity
//if id == 1, sensor == waterproof
//if id == 2, sensor == pH
//but at least practice entering the data in with dummy values

//These variables have to have an underscore before them.
//I know it looks really annoying with the underscore but there's some
// reason the underscore is required.
// I don't necessarily know or understand that reason
// but I think there is some reason for the
//annoying initial underscores

//class sensorEntries: variables and function
public class SensorEntries {
    // variable name "idX" to emphasize camel case!
    // underscores before variable names for a reason?
    private int _idX;
    private String _sensorName;
    private double _value;
}
    //public SensorEntries(){
//
//    }

    //this class is intended to get the data from the sensor, store into database
    public SensorEntries(String sensorName) {
        this._sensorName = sensorName;
        //since name is being passed in, we don't need the underscore
        //value comes from ardueno, passed in?
        //this._value = value;
        double value = 5.25;

    }



    //setter functions.
    //public void set_ID(int _idX) {
    public void set_idX (int _idX){
        this._idX = _idX;
    }

    //public void set_Sensorname(String _sensorname) {
    public void set_SensorName (String _sensorName){
        this._sensorName = _sensorName;
    }

    //public void set_Value(float _value) {
    public void set_Value (float _value){
        this._value = _value;
    }
    // end setter functions

    // getter functions
    public int get_Id() {
        return _idX;
    }

    public String get_SensorName() {
        return _sensorName;
    }

    public double get_Value() {
        return _value;
    }
}

    //end getter functions