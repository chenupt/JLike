//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package me.risky.jlike.fragment;

import java.util.List;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import me.risky.jlike.R.layout;
import me.risky.jlike.bean.Page_;
import me.risky.jlike.db.News;
import me.risky.jlike.service.WelfareService_;
import me.risky.jlike.ui.LoadListView;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class NewsListFragment_
    extends NewsListFragment
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;
    private Handler handler_ = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.fragment_news_list, container, false);
        }
        return contentView_;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        welfareDao = WelfareService_.getInstance_(getActivity());
        page = Page_.getInstance_(getActivity());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static NewsListFragment_.FragmentBuilder_ builder() {
        return new NewsListFragment_.FragmentBuilder_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        loadListview = ((LoadListView) hasViews.findViewById(me.risky.jlike.R.id.listview));
        afterInject();
    }

    @Override
    public void loadError() {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                NewsListFragment_.super.loadError();
            }

        }
        );
    }

    @Override
    public void loadFromDBFinish(final List<News> list) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                NewsListFragment_.super.loadFromDBFinish(list);
            }

        }
        );
    }

    @Override
    public void loadSuccess(final List<News> list, final boolean isClean) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                NewsListFragment_.super.loadSuccess(list, isClean);
            }

        }
        );
    }

    @Override
    public void loadFromDB() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    NewsListFragment_.super.loadFromDB();
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    @Override
    public void parseResponse(final String response, final boolean isClean) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    NewsListFragment_.super.parseResponse(response, isClean);
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public NewsListFragment build() {
            NewsListFragment_ fragment_ = new NewsListFragment_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
