package com.example.jcp.samplemvvm.viewmodel;

import android.content.Context;

import com.example.jcp.samplemvvm.App;
import com.example.jcp.samplemvvm.model.GithubService;
import com.example.jcp.samplemvvm.model.Repository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainViewModel implements ViewModel {

    private Context context;
    private Disposable disposable;
    public MainViewModel(Context context) {
        this.context = context;
    }

    @Override
    public void destroy() {
        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();
        disposable = null;
        context = null;
    }

    public void initData() {
        loadGithubRepos("sonredi");
    }
    private void loadGithubRepos(String username) {

        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();
        App app = App.get(context);
        GithubService githubService = app.getGithubService();
        disposable =  githubService.getAllRepos(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(app.defaultSubscribeScheduler())
                .subscribe(this::printResult);

    }

    private void printResult(List<Repository> repositories) {
        for (Repository repository : repositories) {
            System.out.println("//" + repository.name);
        }
    }

}