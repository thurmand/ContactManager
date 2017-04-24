package com.example.andrew.contactmanager;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * CONTACTDATA
 * This class holds info from the user's contact list.
 * Name, Number, and ID of contact.
 *
 * Created by Andrew on 11/4/2016.
 */

public class ContactData {

    private String number;
    private String name;
    private String _ID;
    private Date dLastTimeCont;
    private String sLastTimeCont;

    public void setlTimeCont(String time) {
        dLastTimeCont = new Date(Long.parseLong(time));
        sLastTimeCont = new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(dLastTimeCont);
    }

    public Date getDateLastTimeCont(){
        return dLastTimeCont;
    }

    public String getlTimeCont() {
        return sLastTimeCont;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ", id:" + _ID
                + "\n" + number
                + "\n" + sLastTimeCont;
    }
}
