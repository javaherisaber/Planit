package ir.logicbase.planit.data.db.entity

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = BaseColumns._ID)
    var id: Long? = null, // todo: change to immutable variable after refactor
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "time")
    val time: String
)