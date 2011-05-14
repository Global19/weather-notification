/*
 *  Android Weather Notification.
 *  Copyright (C) 2010  Denis Nelubin aka Gelin
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *  http://gelin.ru
 *  mailto:den@gelin.ru
 */

package ru.gelin.android.weather.notification;

import java.util.List;

import ru.gelin.android.weather.notification.skin.SkinInfo;
import ru.gelin.android.weather.notification.skin.SkinManager;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

public class SkinsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        SkinManager sm = new SkinManager(this);
        List<SkinInfo> skins = sm.getInstalledSkins();
     
        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this); 
        for (SkinInfo skin : skins) {
        	//TODO
        	Preference pref = new CheckBoxPreference(this);
        	pref.setTitle(skin.getBroadcaseReceiverLabel());
        	screen.addPreference(pref);
        }
        setPreferenceScreen(screen);
    }

}