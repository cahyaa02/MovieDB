package com.cahyaa.moviedb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cahyaa.moviedb.model.Credits;
import com.cahyaa.moviedb.model.Movies;
import com.cahyaa.moviedb.model.NowPlaying;
import com.cahyaa.moviedb.model.Popular;
import com.cahyaa.moviedb.model.Search;
import com.cahyaa.moviedb.model.UpComing;
import com.cahyaa.moviedb.model.Videos;
import com.cahyaa.moviedb.repositories.MovieRepository;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        repository = MovieRepository.getInstance();
    }

    //*Begin of ViewModel getMovieById
    private MutableLiveData<Movies> resultGetMovieById = new MutableLiveData<>();

    public void getMovieById(String movieId) {
        resultGetMovieById = repository.getMovieData(movieId);
    }

    public LiveData<Movies> getResultGetMovieById() {
        return resultGetMovieById;
    }
    //End of ViewModel getMovieById

    //*Begin of ViewModel getMovieResult
    private MutableLiveData<Search> resultGetMovieResult = new MutableLiveData<>();

    public void getMovieResult(String query) {
        resultGetMovieResult = repository.getSearchData(query);
    }

    public LiveData<Search> getResultGetMovieResult() {
        return resultGetMovieResult;
    }
    //End of ViewModel getMovieResult

    //*Begin of ViewModel getNowPlaying
    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();

    public void getNowPlaying(int page) {
        resultGetNowPlaying = repository.getNowPlayingData(page);
    }

    public LiveData<NowPlaying> getResultGetNowPlaying() {
        return resultGetNowPlaying;
    }
    //End of ViewModel getNowPlaying

    //*Begin of ViewModel getUpComing
    private MutableLiveData<UpComing> resultGetUpComing = new MutableLiveData<>();

    public void getUpComing(int page) {
        resultGetUpComing = repository.getUpComingData(page);
    }

    public LiveData<UpComing> getResultGetUpComing() {
        return resultGetUpComing;
    }
    //End of ViewModel getNowPlaying

    //*Begin of ViewModel getPopular
    private MutableLiveData<Popular> resultGetPopular = new MutableLiveData<>();

    public void getPopular(int page) {
        resultGetPopular = repository.getPopularData(page);
    }

    public LiveData<Popular> getResultGetPopular() {
        return resultGetPopular;
    }
    //End of ViewModel getPopular

    //*Begin of ViewModel getVideos
    private MutableLiveData<Videos> resultGetVideos = new MutableLiveData<>();

    public void getVideos(String movieId) {
        resultGetVideos = repository.getVideosData(movieId);
    }

    public LiveData<Videos> getResultGetVideos() {
        return resultGetVideos;
    }
    //End of ViewModel getVideos

    //*Begin of ViewModel getCredits
    private MutableLiveData<Credits> resultGetCredits = new MutableLiveData<>();

    public void getCredits(String movieId) {
        resultGetCredits = repository.getCreditsData(movieId);
    }

    public LiveData<Credits> getResultGetCredits() {
        return resultGetCredits;
    }
    //End of ViewModel getCredits
}
