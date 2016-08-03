/**
 * Created by Brenna Pavlinchak on 08/02/16.
 */

package com.example.ravenmargret.project1;

import java.io.Serializable;

public class Form implements Serializable
{
    String mFirstName;
    String mLastName;
    Double mAge;

    public Form(String mFirstName, String mLastName, Double mAge)
    {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mAge = mAge;
    }

    public String getmFirstName() {return mFirstName;}
    public String getmLastName() {return mLastName;}
    public Double getmAge() {return mAge;}


    public void setmFirstName(String mFirstName) {this.mFirstName = mFirstName;}
    public void setmLastName(String mLastName) {this.mLastName = mLastName;}
    public void setmAge(Double mAge) {this.mAge = mAge;}

    @Override
    public String toString()
    {
        return mFirstName;
    }
}
