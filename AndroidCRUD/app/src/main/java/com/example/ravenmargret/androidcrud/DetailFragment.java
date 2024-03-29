package com.example.ravenmargret.androidcrud;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment
{
    public static final String KEY = "PersonKey";

    public DetailFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle args = getArguments();
        if (args != null)
        {
            // Set article based on argument passed in
            updateText((Form)args.getSerializable(KEY));
        }
    }

    public void updateText(Form object)
    {
        TextView firstTextView = (TextView) getActivity().findViewById(R.id.firstNameTextView);
        firstTextView.setText(object.getmFirstName());

        TextView lastTextView = (TextView) getActivity().findViewById(R.id.lastNameTextView);
        lastTextView.setText(object.getmLastName());

        TextView ageTextView = (TextView) getActivity().findViewById(R.id.ageTextView);
        ageTextView.setText(object.getmAge().toString());
    }

    public void DeleteContact()
    {
        Toast.makeText(getActivity(), "Contact Deleted", Toast.LENGTH_LONG).show();

        getActivity().finish();
    }


}
