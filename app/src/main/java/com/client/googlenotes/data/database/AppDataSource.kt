package com.client.googlenotes.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.orhanobut.hawk.Hawk
import io.requery.android.sqlite.DatabaseSource
import io.requery.meta.EntityModel

class AppDataSource(val context: Context, model: EntityModel, val version: Int)
    : DatabaseSource(context, model, version) {


    companion object {
        const val DATABASE_VERSION: Int = 1
    }

}