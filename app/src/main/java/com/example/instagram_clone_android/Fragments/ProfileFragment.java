package com.example.instagram_clone_android.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.instagram_clone_android.LoginActivity;
import com.example.instagram_clone_android.MainActivity;
import com.example.instagram_clone_android.Post;
import com.example.instagram_clone_android.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostFragment{


    @Override
        protected void queryPosts() {
            ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
            query.include(Post.KEY_USER);
            query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
            query.setLimit(20);
            query.addDescendingOrder(Post.KEY_CREATED_KEY);
            query.findInBackground(new FindCallback<Post>() {
                @Override
                public void done(List<Post> posts, ParseException e) {
                    if (e != null) {
                        Log.e(TAG, "Issue with getting posts", e);
                        return;
                    }
                    for (Post post : posts) {
                        Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
                    }
                    allPosts.addAll(posts);
                    adapter.notifyDataSetChanged();
                }
            });
        }


    private Button btnLogout;



    }
