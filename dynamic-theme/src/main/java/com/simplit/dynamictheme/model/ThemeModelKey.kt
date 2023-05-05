package com.simplit.dynamictheme.model

data class ThemeModelKey internal constructor(val key: String) {
    companion object {
        private val Default = ThemeModelKey("Default")

        fun of(keyString: String?) : ThemeModelKey{
            return if(keyString == null) {
                ThemeModelKey.Default
            } else {
                ThemeModelKey(keyString)
            }
        }
    }
}
