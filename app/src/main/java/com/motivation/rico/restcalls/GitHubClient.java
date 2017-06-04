package com.motivation.rico.restcalls;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ronald Boodram on 12/26/16.
 * interface
 */

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

    @GET("/all/")
    Call<List<MotivateMsgs>>getMsgs();

}
