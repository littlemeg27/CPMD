package com.example.ravenmargret.androidcrud;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;

/**
 * Created by Brenna Pavlinchak on 8/5/16.
 */
public class Post
{
    String uid;
    String first;
    String last;
    String age;
    ArrayList<String> post = new ArrayList<>();

    public Post()
    {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String first, String last, String age)
    {
        this.uid = uid;
        this.first = first;
        this.last = last;
        this.age = age;
    }

    // [START post_to_map]
    @Exclude
    public ArrayList<String> to()
    {
        ArrayList<String> result = new ArrayList<>();
        result.add(uid);
        result.add(first);
        result.add(last);
        result.add(age);

        return result;
    }
}
