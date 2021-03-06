package com.cahyaa.moviedb.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cahyaa.moviedb.R;
import com.cahyaa.moviedb.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    private ActivityMainMenuBinding binding;

    NavHostFragment navHostFragment;

    MenuItem menuItem;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarMainMenu);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.nowPlayingFragment, R.id.upComingFragment, R.id.popularFragment).build();
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.getNavController(), appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavMainMenu, navHostFragment.getNavController());

        navHostFragment.getNavController().addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.nowPlayingFragment || destination.getId() == R.id.upComingFragment || destination.getId() == R.id.popularFragment) {
                binding.toolbarMainMenu.setVisibility(View.VISIBLE);
                binding.bottomNavMainMenu.setVisibility(View.VISIBLE);
                if (menuItem != null) {
                    menuItem.setVisible(true);
                }
            } else if (destination.getId() == R.id.movieDetailsFragment) {
                binding.toolbarMainMenu.setVisibility(View.VISIBLE);
                binding.bottomNavMainMenu.setVisibility(View.GONE);
                menuItem.setVisible(false);
            } else {
                binding.toolbarMainMenu.setVisibility(View.GONE);
                binding.bottomNavMainMenu.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navHostFragment.getNavController().navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        menuItem = menu.findItem(R.id.toolbar_search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.toolbar_search) {
            navHostFragment.getNavController().navigate(R.id.searchFragment);
        }
        return super.onOptionsItemSelected(item);
    }

//        @Override
//    public void onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Click again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce = false;
//            }
//        }, 2000);
//    }
}