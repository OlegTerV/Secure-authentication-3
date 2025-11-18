package com.example.inventory.ui.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import java.io.File

object PreferencesService {
    val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    var sharedPreferences: SharedPreferences? = null

    fun encodingFiles(file: File, context: Context) {

    }

    @Composable
    fun InitPreferences () {
         sharedPreferences = EncryptedSharedPreferences.create(
            "PreferencesTestFile_8",
            masterKeyAlias,
             LocalContext.current,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}