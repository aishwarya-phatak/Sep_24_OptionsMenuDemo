package com.bitcode.sep_24_optionsmenudemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final int MENU_HISTORY = 1,
            MENU_SETTINGS = 2,
            MENU_FILE_MANAGER = 3,
            DISPLAY_SETTINGS = 4,
            BLUETOOTH_SETTINGS = 5,
            SCREEN_SETTINGS = 6;

    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(this, "onMenuOpened method called", Toast.LENGTH_LONG).show();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Toast.makeText(this, "OnCreateOptionsMenu Method got called", Toast.LENGTH_SHORT).show();
        MenuItem historyMenuItem = menu.add(1, MENU_HISTORY, 1, "History");
//        MenuItem settingsMenuItem = menu.add(2, MENU_SETTINGS, 3 , "Settings");
        MenuItem fileManagerMenuItem = menu.add(3, MENU_FILE_MANAGER,2, "File_Manager");

        SubMenu settingsSubMenu = menu.addSubMenu(2,MENU_SETTINGS,1,"Settings");
        SubMenu displaySettingsSubMenu = settingsSubMenu.addSubMenu(2,DISPLAY_SETTINGS,2,"Display Settings");
        SubMenu bluetoothSettingsSubMenu = settingsSubMenu.addSubMenu(2,BLUETOOTH_SETTINGS,3,"Bluetooth Settings");
        SubMenu screenSettingsSubMenu = settingsSubMenu.addSubMenu(2,SCREEN_SETTINGS,4,"Screen Settings");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "onPrepareOptionsMenu method called", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "findItem " + menu.findItem(2), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "getItem " + menu.getItem(2), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "hasVisibleItems " +  menu.hasVisibleItems(), Toast.LENGTH_SHORT).show();

//        menu.removeGroup(2);
        menu.setGroupEnabled(2,false);
        menu.setGroupVisible(2,false);
//        menu.removeItem(2);
    
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "onOptionsItemSelected method got called", Toast.LENGTH_LONG).show();

        itemId = item.getItemId();
        switch (itemId){
            case 1 :
                Toast.makeText(this, "History Menu Selected", Toast.LENGTH_LONG).show();
                break;
            case 2 :
                Toast.makeText(this, "Settings Menu Selected", Toast.LENGTH_LONG).show();
                break;
            case 3 :
                Toast.makeText(this, "File Manager Menu Selected", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(this, "onOptionsMenuClosed method Called", Toast.LENGTH_LONG).show();
        super.onOptionsMenuClosed(menu);
    }
}