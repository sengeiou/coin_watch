package com.terry.watch.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;
import com.uber.autodispose.lifecycle.LifecycleScopes;

import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;


public class BaseAndroidViewModel extends AndroidViewModel implements LifecycleScopeProvider<BaseAndroidViewModel.ViewModelEvent> {

    public CompositeDisposable compositeDisposable;

    enum ViewModelEvent {
        CREATED, CLEARED
    }

    private BehaviorSubject<ViewModelEvent> lifecycleEvents = BehaviorSubject.createDefault(ViewModelEvent.CREATED);

    public BaseAndroidViewModel(@NonNull Application application) {
        super(application);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public Observable<ViewModelEvent> lifecycle() {
        return lifecycleEvents.hide();
    }

    @Override
    public CorrespondingEventsFunction<ViewModelEvent> correspondingEvents() {
        return CORRESPONDING_EVENTS;
    }

    @Override
    public ViewModelEvent peekLifecycle() {
        return lifecycleEvents.getValue();
    }

    @Override
    public CompletableSource requestScope() {
        return LifecycleScopes.resolveScopeFromLifecycle(this);
    }

    private CorrespondingEventsFunction<ViewModelEvent> CORRESPONDING_EVENTS = event -> {

        if (event == ViewModelEvent.CREATED) {
            return ViewModelEvent.CLEARED;
        } else {
            throw new LifecycleEndedException("Cannot bind to ViewModel lifecycle after onCleared.");
        }
    };

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

}