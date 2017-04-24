package com.example.andrew.contactmanager;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class deals with existing contacts
 *
 * Created by Andrew on 4/24/2017.
 */

public class ExistingContact {
    private Context context = new MyApplication();
    List<ContactData> contactDataList = new ArrayList<>(); // list of user's contacts
    private List<String> infoList = new ArrayList<>(); // holds a list of Strings
    private Date checkDate = new Date(); // last time contacted comparison
    private Calendar calendar = Calendar.getInstance();
    private int offset = 365;// subtract from date TODO: set this dynamically; This might have to go into a user settings class.

    /**
     * get contacts that are considered for deletion
     * */
    public void pullOldContacts() {
        // subtract days from current time.
        calendar.add(Calendar.DATE, -offset);
        checkDate = calendar.getTime();

        Cursor contacts = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null); // Todo: Get application context
        while (contacts.moveToNext())
        {
            ContactData contactData = new ContactData();
            // Contact's saved name
            contactData.setName(contacts.getString
                    (contacts.getColumnIndex(ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY)));            // Contact's ID
            contactData.set_ID(contacts.getString
                    (contacts.getColumnIndex(ContactsContract.RawContacts.CONTACT_ID)));
            // Contact's phone number
            contactData.setNumber(contacts.getString
                    (contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
            // Last time ht contact was contacted
            contactData.setlTimeCont(contacts.getString
                    (contacts.getColumnIndex(ContactsContract.RawContacts.LAST_TIME_CONTACTED)));

            if(contactData.getDateLastTimeCont().before(checkDate)) {
                contactDataList.add(contactData);
                infoList.add(contactData.toString()); // TODO: Send notification
            }
        }
        contacts.close();
    }
}
