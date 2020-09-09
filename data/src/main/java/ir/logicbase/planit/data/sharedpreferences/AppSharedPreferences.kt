package ir.logicbase.planit.data.sharedpreferences

import android.content.Context
import dagger.Reusable
import ir.logicfan.core.data.sharedpreferences.BaseSharedPreferences
import javax.inject.Inject

@Reusable
class AppSharedPreferences @Inject constructor(
    context: Context
) : BaseSharedPreferences(context, charArrayOf('s', 'e', 'c', 'r', 'e', 't'))