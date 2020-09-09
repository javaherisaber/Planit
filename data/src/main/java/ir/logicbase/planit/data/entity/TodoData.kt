package ir.logicbase.planit.data.entity

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.logicfan.core.ui.recyclerview.diffutil.Equatable

@Entity(tableName = "todo")
data class TodoData constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = BaseColumns._ID)
    var id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "time")
    val time: String
): Equatable