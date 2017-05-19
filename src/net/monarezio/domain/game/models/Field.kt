package net.monarezio.domain.game.models

/**
 * Created by monarezio on 04/05/2017.
 */
enum class Field {
    ANON, CROSS, CIRCLE;

    /**
     * return a field, which toggles between Field.CROSS and Field.CIRCLE
     */
    fun toggle(): Field {
        if(this == Field.CROSS)
            return CIRCLE
        else
            return CROSS
    }
}