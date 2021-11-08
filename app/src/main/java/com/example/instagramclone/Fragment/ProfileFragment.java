package com.example.instagramclone.Fragment;

import static com.parse.ParseUser.getCurrentUser;

import android.util.Log;

import com.example.instagramclone.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment{
    @Override
    protected void queryPost() {
        super.queryPost();
        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post>() {
            @Override //just seeing if i can push
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (Post post : posts) {
                    Log.e(TAG, "Post: " + post.getDescription()+ ", username: "+ post.getUser().getUsername()) ;
                }
                allPost.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
