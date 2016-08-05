package com.example.ravenmargret.androidcrud;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brenna Pavlinchak on 8/5/16.
 */
public class Post
{
    String uid;
    String first;
    String last;
    String age;
    public Map<String, Boolean> post = new HashMap<>();

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
    public Map<String, Object> toMap()
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("first", first);
        result.put("last", last);
        result.put("age", age);

        return result;
    }
}
