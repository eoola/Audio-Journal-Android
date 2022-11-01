package com.wpi.audiojournal.ui.component

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.wpi.audiojournal.ui.theme.LocalColorScheme


inline fun <T> LazyListScope.rainbow(
    items: List<T>,
    noinline key: ((item: T) -> Any)? = null,
    crossinline itemContent: @Composable LazyItemScope.(item: T, color: Color) -> Unit
) = items(items.size, if (key != null) { index: Int -> key(items[index]) } else null) {
    itemContent(items[it], LocalColorScheme.current.getRainbowColor(it))
}
