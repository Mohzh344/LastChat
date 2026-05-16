package me.rerere.rikkahub.utils

fun String.isRtlText(): Boolean {
    if (this.isBlank()) return false
    val sample = this.take(100)
    var rtlCount = 0
    var ltrCount = 0
    for (char in sample) {
        val type = Character.getDirectionality(char)
        when (type) {
            Character.DIRECTIONALITY_RIGHT_TO_LEFT,
            Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC,
            Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING,
            Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE -> rtlCount++
            Character.DIRECTIONALITY_LEFT_TO_RIGHT,
            Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING,
            Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE -> ltrCount++
        }
    }
    return rtlCount > ltrCount
}

fun String.detectLayoutDirection(): androidx.compose.ui.unit.LayoutDirection {
    return if (this.isRtlText()) androidx.compose.ui.unit.LayoutDirection.Rtl
    else androidx.compose.ui.unit.LayoutDirection.Ltr
}
