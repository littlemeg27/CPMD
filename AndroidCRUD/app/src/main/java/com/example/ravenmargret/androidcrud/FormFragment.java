package com.example.ravenmargret.androidcrud;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormFragment extends Fragment
{

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

        firstName = firstNameText.getText().toString();
        lastName = lastNameText.getText().toString();
        age = Double.parseDouble(ageText.getText().toString());

        Toast.makeText(getActivity(), "Contact Added", Toast.LENGTH_LONG).show();
    }

    public void writeNewUser(String classID, String firstName, String lastName, Double age)
    {
        Form form = new Form(firstName, lastName, age);

        androidFormDatabase.child("Form").child(classID).setValue(form);

        Toast.makeText(getActivity(), "Contact Added 1", Toast.LENGTH_LONG).show();

        getActivity().finish();
    }
}
