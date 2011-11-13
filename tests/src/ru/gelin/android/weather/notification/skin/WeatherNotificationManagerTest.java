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

package ru.gelin.android.weather.notification.skin;

import ru.gelin.android.weather.Weather;
import ru.gelin.android.weather.notification.WeatherUtils;
import android.content.Intent;
import android.test.AndroidTestCase;

@SuppressWarnings("deprecation")
public class WeatherNotificationManagerTest extends AndroidTestCase {
    
    public void testCreateIntentDisableNotification() {
        Intent intent = WeatherNotificationManager.createIntent(false, null);
        assertTrue(intent.hasExtra(IntentParameters.EXTRA_ENABLE_NOTIFICATION));
        assertFalse(intent.getBooleanExtra(IntentParameters.EXTRA_ENABLE_NOTIFICATION, true));
        assertFalse(intent.hasExtra(IntentParameters.EXTRA_WEATHER_1));
        assertFalse(intent.hasExtra(IntentParameters.EXTRA_WEATHER));
    }
    
    public void testCreateIntentBothExtras() throws Exception {
        Weather weather = WeatherUtils.createWeather();
        Intent intent = WeatherNotificationManager.createIntent(true, weather);
        assertTrue(intent.hasExtra(IntentParameters.EXTRA_ENABLE_NOTIFICATION));
        assertTrue(intent.getBooleanExtra(IntentParameters.EXTRA_ENABLE_NOTIFICATION, false));
        assertTrue(intent.hasExtra(IntentParameters.EXTRA_WEATHER_1));
        assertTrue(intent.hasExtra(IntentParameters.EXTRA_WEATHER));
        WeatherUtils.checkWeather((Weather)intent.getParcelableExtra(IntentParameters.EXTRA_WEATHER_1), 
                WeatherUtils.Version.V_0_2);
        WeatherUtils.checkWeather((Weather)intent.getParcelableExtra(IntentParameters.EXTRA_WEATHER), 
                WeatherUtils.Version.V_0_3);
    }

}