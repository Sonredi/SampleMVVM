package com.example.jcp.samplemvvm;

import android.app.Application;
import android.content.Context;

import com.example.jcp.samplemvvm.model.GithubService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class App extends Application {

    private GithubService githubService;
    private Scheduler scheduler;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public GithubService getGithubService() {
        if (githubService == null) {
            githubService = GithubService.Factory.create();
        }
        return githubService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }
}
