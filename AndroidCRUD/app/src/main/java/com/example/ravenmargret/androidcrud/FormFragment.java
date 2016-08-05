package com.example.ravenmargret.androidcrud;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormFragment extends Fragment
{
    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";

    EditText firstNameText;
    EditText lastNameText;
    EditText ageText;

    String firstName;
    String lastName;
    Double age;

    private DatabaseReference androidFormDatabase;

    public FormFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        androidFormDatabase = FirebaseDatabase.getInstance().getReference();

        firstNameText = (EditText)getView().findViewById(R.id.firstNameText);
        lastNameText = (EditText)getView().findViewById(R.id.lastNameText);
        ageText = (EditText)getView().findViewById(R.id.ageText);
    }

    public void submitPost()
    {
        firstName = firstNameText.getText().toString();
        lastName = lastNameText.getText().toString();
        age = Double.parseDouble(ageText.getText().toString());

//        // Title is required
//        if (TextUtils.isEmpty(title)) {
//            mTitleField.setError(REQUIRED);
//            return;
//        }
//
//        // Body is required
//        if (TextUtils.isEmpty(body)) {
//            mBodyField.setError(REQUIRED);
//            return;
//        }

        FirebaseDatabase androidFormDatabase = FirebaseDatabase.getInstance();
        DatabaseReference androidFormRef = androidFormDatabase.getReference("message");

        androidFormRef.setValue("Hello, World!");

        final String userId = Integer.toString(getId());

    androidFormDatabase.child("Form").child(firstName).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // Get user value
            Form form = dataSnapshot.getValue(Form.class);

            if (form == null) {
                // User is null, error out
                Log.e(TAG, "User " + userId + " is unexpectedly null");
//               Toast.makeText(FormFragment.getActivity(),
//                       "Error: could not fetch user.",
//                     Toast.LENGTH_SHORT).show();
            } else {
                // Write new post
                writeNewUser(userId, form.mFirstName, form.mLastName, form.mAge);
                getActivity().finish();
            }

            // Finish this Activity, back to the stream
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.w(TAG, "getUser:onCancelled", databaseError.toException());
        }
    });

    }

    public void writeNewUser(String userId, String firstName, String lastName, Double age)
    {
        String newage = Double.toString(age);
        String key = androidFormDatabase.child("post").push().getKey();
        Post post = new Post(userId, firstName, lastName, newage);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        androidFormDatabase.updateChildren(childUpdates);
    }
}
