/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FormActivity extends Activity
{
    FragmentManager manager;
    String cid;
    String first;
    String last;
    Double age;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        manager = getFragmentManager();

        FormFragment formFragment = new FormFragment();
        showFormFragment(formFragment);
    }

    private void showFormFragment(Fragment formFrag)
    {
        manager.beginTransaction().replace(R.id.container, formFrag).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save_finished)
        {
            FormFragment fragment = (FormFragment) getFragmentManager().findFragmentById(R.id.container);
            fragment.writeNewUser(cid, first, last, age);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
