package com.example.andrew.contactmanager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class searches SMS on the phone to determine a possible contact addition
 *
 * Created by Andrew on 4/24/2017.
 */
public class SMSquery {
    private Context context = new MyApplication();
    private List<SMSData> smsDataList = new ArrayList<>(); // list of SMS data
    private ArrayAdapter<String> arrayAdapter; // creates viewable list
    private List<String> infoList = new ArrayList<>(); // holds a list of Strings

    public ArrayAdapter<String> getArrayAdapter(){
        return this.arrayAdapter;
    }

    public void pullSMSData() {
        Uri uri = Uri.parse("content://sms/inbox");
        //SELECT address, date FROM sms WHERE (type=1) AND (address IS NOT NULL) GROUP BY (date DESC)
        Cursor c = context.getContentResolver().query(uri, new String[]{"address", "person", "date"},
                "address IS NOT NULL) GROUP BY (address", null, "date desc"); //Todo: Get application context

        // Read the sms data and store it in the list
        assert c != null;
        if (c.moveToFirst()) {
            for (int i = 0; i < c.getCount(); i++) {
                SMSData sms = new SMSData();

                sms.setPerson(c.getString(c.getColumnIndexOrThrow("person")));
                sms.setDate(c.getString(c.getColumnIndexOrThrow("date")));
                sms.setNumber(c.getString(c.getColumnIndexOrThrow("address")));

                infoList.add(sms.toString());
                smsDataList.add(sms);
                c.moveToNext();
            }
        }
        c.close();
    }
}
