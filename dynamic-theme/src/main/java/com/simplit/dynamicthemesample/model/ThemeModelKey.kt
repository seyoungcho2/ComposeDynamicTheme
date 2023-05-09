package com.simplit.dynamicthemesample.model

data class ThemeModelKey internal constructor(internal val key: String) {
    companion object {
        private const val KEY_DEFAULT = "Default"
        val Default = ThemeModelKey(KEY_DEFAULT)

        fun of(keyString: String?) : ThemeModelKey{
            return if(keyString == null) {
                ThemeModelKey.Default
            } else {
                ThemeModelKey(keyString)
            }
        }
    }
}
