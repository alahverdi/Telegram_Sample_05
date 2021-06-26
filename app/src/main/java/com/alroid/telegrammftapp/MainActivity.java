package com.alroid.telegrammftapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.alroid.telegrammftapp.adapter.AdapterViewPagerMain;
import com.alroid.telegrammftapp.databinding.ActivityMainBinding;
import com.alroid.telegrammftapp.fragment.BottomSheetHelpMenu;
import com.alroid.telegrammftapp.fragment.FragmentCalls;
import com.alroid.telegrammftapp.fragment.FragmentChats;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavController navController;

    boolean flagTheme = false;
    boolean flagProxy = false;
    boolean rotate = false;
    View parent_view;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // using navigation component in search button in main activity toolbar.
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        initComponents();
        setupToolbar();
        setupNavigationView();
        setup_viewpager();

        /*
        ////////////////////////////////////////////////////////////////////////////////////////////
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view_profile);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentAddAccount, R.id.nav_menu_contacts, R.id.nav_menu_help)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        ////////////////////////////////////////////////////////////////////////////////////////////
        */
    }

    private void initComponents() {
        // using navigation component:
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.searchFragment);
            }
        });

        binding.backDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFabMode(binding.fabAdd);
            }
        });

        binding.fabNewChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "New Chat", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fabNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "New Group", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fabNewChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "New Channel", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fabNewSecretChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "New Secret Chat", Toast.LENGTH_SHORT).show();
            }
        });

        parent_view = findViewById(android.R.id.content);
        ViewAnimation.initShowOut(binding.lytNewChat);
        ViewAnimation.initShowOut(binding.lytNewGroup);
        ViewAnimation.initShowOut(binding.lytNewChannel);
        ViewAnimation.initShowOut(binding.lytNewSecretChat);
        binding.backDrop.setVisibility(View.GONE);
        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFabMode(v);
            }
        });

    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbarMain);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                binding.drawerLayout, binding.toolbarMain, 0, 0);
        binding.drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.syncState();
    }

    private void setupNavigationView() {
        MenuItem menuItemNightMode = binding.navViewProfile.getMenu().findItem(R.id.nav_menu_nightMode); // This is the menu item that contains your switch
        SwitchCompat drawer_switch_nightMode = menuItemNightMode.getActionView().findViewById(R.id.drawer_switch);

        drawer_switch_nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Your logic goes here
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    flagTheme = true;
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    flagTheme = false;
                }
            }
        });

        MenuItem menuItemProxy = binding.navViewProfile.getMenu().findItem(R.id.nav_menu_proxy); // This is the menu item that contains your switch
        SwitchCompat drawer_switch_proxy = menuItemProxy.getActionView().findViewById(R.id.drawer_switch);

        drawer_switch_proxy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Snackbar.make(binding.navViewProfile, "Connecting ...", 1000).show();
                    flagProxy = true;
                } else {
                    Snackbar.make(binding.navViewProfile, "Disconnected.", 1000).show();
                    flagProxy = false;
                }
            }
        });

        binding.navViewProfile.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fragmentAddAccount:
                        Snackbar.make(binding.navViewProfile, "Add Accounts", 1000).show();
                        break;

                    case R.id.nav_menu_contacts:
                        Snackbar.make(binding.navViewProfile, "Open Contacts", 1000).show();
                        break;

                    case R.id.nav_menu_savedMessage:
                        Snackbar.make(binding.navViewProfile, "Saved Message", 1000).show();
                        break;

                    case R.id.nav_menu_setting:
                        Snackbar.make(binding.navViewProfile, "Go to Setting", 1000).show();
                        break;

                    case R.id.nav_menu_proxy:
                        if (flagProxy) {
                            Snackbar.make(binding.navViewProfile, "Disconnected.", 1000).show();
                            drawer_switch_proxy.setChecked(false);
                            flagProxy = false;
                        } else {
                            Snackbar.make(binding.navViewProfile, "Connecting ...", 1000).show();
                            drawer_switch_proxy.setChecked(true);
                            flagProxy = true;
                        }
                        break;

                    case R.id.nav_menu_help:
                        showBottomSheet(binding.navViewProfile);
                        //Snackbar.make(navigationView, "Help", 1000).show();
                        break;

                    case R.id.nav_menu_nightMode:
                        Snackbar.make(binding.navViewProfile, "Switch to Night Mode", 1000).show();
                        if (flagTheme) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            drawer_switch_nightMode.setChecked(false);
                            flagTheme = false;
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            drawer_switch_nightMode.setChecked(true);
                            flagTheme = true;
                        }
                        break;
                }
                return true;
            }
        });
    }

    private void setup_viewpager() {
        Map<String, Fragment> map = new HashMap<>();
        map.put("Chats", new FragmentChats());
        map.put("Calls", new FragmentCalls());

        AdapterViewPagerMain adapterViewPagerMain = new AdapterViewPagerMain(
                getSupportFragmentManager(),
                map);

        binding.viewPagerMain.setAdapter(adapterViewPagerMain);
        binding.tabLayoutMain.setupWithViewPager(binding.viewPagerMain);
        binding.tabLayoutMain.getTabAt(1).select();

    }

    private void toggleFabMode(View v) {
        rotate = ViewAnimation.rotateFab(v, !rotate);
        if (rotate) {
            ViewAnimation.showIn(binding.lytNewChat);
            ViewAnimation.showIn(binding.lytNewGroup);
            ViewAnimation.showIn(binding.lytNewChannel);
            ViewAnimation.showIn(binding.lytNewSecretChat);
            binding.backDrop.setVisibility(View.VISIBLE);
        } else {
            ViewAnimation.showOut(binding.lytNewChat);
            ViewAnimation.showOut(binding.lytNewGroup);
            ViewAnimation.showOut(binding.lytNewChannel);
            ViewAnimation.showOut(binding.lytNewSecretChat);
            binding.backDrop.setVisibility(View.GONE);
        }
    }

    //for "Help" item in nav menu
    public void showBottomSheet(View view) {
        BottomSheetHelpMenu addPhotoBottomDialogFragment =
                BottomSheetHelpMenu.newInstance();
        addPhotoBottomDialogFragment.show(((AppCompatActivity) this).getSupportFragmentManager(),
                BottomSheetHelpMenu.TAG);
    }

}