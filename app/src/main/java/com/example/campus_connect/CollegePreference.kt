package com.example.campus_connect

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(name = "college_prefs")

object CollegePreference {

    private val COLLEGE_KEY = stringPreferencesKey("selected_college")

    suspend fun saveCollege(context: Context, college: String) {
        context.dataStore.edit { prefs ->
            prefs[COLLEGE_KEY] = college
        }
    }

    suspend fun getCollege(context: Context): String? {
        val prefs = context.dataStore.data.first()
        return prefs[COLLEGE_KEY]
    }
}

