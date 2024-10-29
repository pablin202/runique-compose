package com.pdm.runique.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm.runique.core.database.dao.RunDao
import com.pdm.runique.core.database.dao.RunPendingSyncDao
import com.pdm.runique.core.database.entity.RunEntity
import com.pdm.runique.core.database.entity.RunPendingSyncEntity
import com.pdm.runique.core.database.entity.DeletedRunSyncEntity

@Database(
    entities = [RunEntity::class, RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val runDao: RunDao
}