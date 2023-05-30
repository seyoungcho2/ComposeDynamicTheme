package io.github.seyoungcho2.dynamictheme.material3.model

data class ThemeModelKey internal constructor(internal val key: String) {
    companion object {
        private const val KEY_DEFAULT = "Default"
        val Default = ThemeModelKey(KEY_DEFAULT)

        fun of(keyString: String?) : ThemeModelKey {
            return if(keyString == null) {
                Default
            } else {
                ThemeModelKey(keyString)
            }
        }
    }
}
