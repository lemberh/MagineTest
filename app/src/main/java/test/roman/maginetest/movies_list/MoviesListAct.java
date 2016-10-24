package test.roman.maginetest.movies_list;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import test.roman.maginetest.R;
import test.roman.maginetest.movies_list.adapters.MoviesAdapter;
import test.roman.maginetest.movies_list.loaders.MoviesListLoader;
import test.roman.maginetest.movies_list.models.Category;
import test.roman.maginetest.movies_list.models.RootObject;

/**
 * Launcher activity which displays list of videos
 */
public class MoviesListAct extends AppCompatActivity {

    private Button mTryAgain;
    private RecyclerView mList;
    private MoviesAdapter mAdapter;
    private ContentLoadingProgressBar mProgressBar;
    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

// TODO Might be usefull in future when there will be more than one category
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        initList();

        mProgressBar = (ContentLoadingProgressBar) findViewById(R.id.progress);
        mProgressBar.show();

        mTryAgain = (Button) findViewById(R.id.try_again);
        mTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportLoaderManager().restartLoader(R.integer.movies_loader_id, null, mLoaderCallback);
            }
        });

        getSupportLoaderManager().initLoader(R.integer.movies_loader_id, null, mLoaderCallback);
    }

    private void initList(){
        mAdapter = new MoviesAdapter();
        mList = (RecyclerView) findViewById(R.id.list);
        mList.setAdapter(mAdapter);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private LoaderManager.LoaderCallbacks<RootObject> mLoaderCallback = new LoaderManager.LoaderCallbacks<RootObject>() {
        @Override
        public Loader<RootObject> onCreateLoader(int id, Bundle args) {
            return new MoviesListLoader(MoviesListAct.this);
        }

        @Override
        public void onLoadFinished(Loader<RootObject> loader, RootObject data) {
            mProgressBar.hide();
            if (data == null || data.getCategories().isEmpty()){
                Snackbar.make(mList, "Error occurred while loading data please chose your internet connection and try again", Snackbar.LENGTH_LONG).show();
                mTryAgain.setVisibility(View.VISIBLE);
                return;
            }
            Category category = data.getCategories().get(0);
            mToolbarLayout.setTitle("Category: " + category.getName());
            mAdapter.setVideos(category.getVideos());
            mTryAgain.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onLoaderReset(Loader<RootObject> loader) {
        }
    };
}
