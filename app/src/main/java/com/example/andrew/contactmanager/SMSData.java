package com.example.andrew.contactmanager;

import android.widget.ArrayAdapter;

import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 * SMSDATA
 * This class will hold all the text data: name, date received, number
 *
 * Created by Andrew on 11/1/2016.
 */

class SMSData {

    // Number from which the sms was sent
    private String number;
    // Date the sms was received
    private String formattedDate;
    //Identity of the sender
    private String person;

    void setPerson(String name){
        this.person = name;
    }

    public String getPerson(){
        return this.person;
    }

    public String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    void setDate(String time) {
        Date date = new Date(Long.parseLong(time));
        formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

    @Override
    public String toString() {
        //return super.toString();
        return "From: " + person +
                "\n" + number + ", " + formattedDate;
    }
}
