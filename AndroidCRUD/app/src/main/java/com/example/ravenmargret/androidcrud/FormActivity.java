package com.example.ravenmargret.androidcrud;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class FormActivity extends AppCompatActivity
{
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showFragment(formFragment);
    }

    private void showFragment(Fragment formFrag)
    {
        manager.beginTransaction().replace(R.id.container, formFrag, "formFrag").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save)
        {
            FormFragment formFragment = (FormFragment)getFragmentManager().findFragmentById(R.id.container);
            formFragment.submitPost();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
