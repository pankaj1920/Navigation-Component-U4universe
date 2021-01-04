package com.example.navigationcomponentu4universe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    Toolbar mainToolbar;
    NavigationUI navigationUI;
    BottomNavigationView bottom_nav_view;
    AppBarConfiguration appBarConfiguration;
    NavigationView navDrawer;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navDrawer = findViewById(R.id.navDrawer);
        bottom_nav_view = findViewById(R.id.bottom_nav_view);
        mainToolbar = findViewById(R.id.mainToolbar);
        //Setting toolbar
        setSupportActionBar(mainToolbar);



        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment,R.id.settingFragment,R.id.notifationFragment
        ).setOpenableLayout(drawerLayout).build();

        //Setting toolbar
        navigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);

        ////Setting bottom navigation
        NavigationUI.setupWithNavController(bottom_nav_view,navController);

        //SEtting Nav Drawer
        NavigationUI.setupWithNavController(navDrawer,navController);
    }

//    setting action on back button in toolbar

    @Override
    public boolean onSupportNavigateUp() {
        // for navDrawer
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
        //for bottom navigation only
//        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    //    Setting Menus in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //    Handing Click in menus
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_about) {
            NavDirections action = MainNavGraphDirections.actionGlobalAboutFragment();
            navController.navigate(action);
            return true;
        } else {
            return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
        }

    }

    // if navigation drawer then on pressing back it should close
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

}