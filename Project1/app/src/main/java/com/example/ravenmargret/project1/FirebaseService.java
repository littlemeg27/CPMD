/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseService
{
    FirebaseDatabase androidFormDatabase = FirebaseDatabase.getInstance();
    DatabaseReference androidFormRef = androidFormDatabase.getReference("Form");


    public void getFinishedData()
    {
        androidFormRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
