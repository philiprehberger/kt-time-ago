package com.philiprehberger.timeago

import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.math.abs

/**
 * Formats the time between [instant] and [relativeTo] as a human-readable relative string.
 */
public fun timeAgo(
    instant: Instant,
    relativeTo: Instant = Instant.now(),
    config: TimeAgoConfig.() -> Unit = {},
): String {
    val cfg = TimeAgoConfig().apply(config)
    val seconds = Duration.between(instant, relativeTo).seconds
    val absSeconds = abs(seconds)
    val isFuture = seconds < 0

    val (value, unit) = pickUnit(absSeconds, cfg.maxUnit)
    val text = formatUnit(value, unit, cfg.style, isFuture)

    return when {
        absSeconds < cfg.nowThreshold.seconds -> "just now"
        isFuture -> "${cfg.futurePrefix}${text}"
        else -> "${text}${cfg.pastSuffix}"
    }
}

/** Extension: `instant.timeAgo()`. */
public fun Instant.timeAgo(
    relativeTo: Instant = Instant.now(),
    config: TimeAgoConfig.() -> Unit = {},
): String = timeAgo(this, relativeTo, config)

private fun pickUnit(absSeconds: Long, maxUnit: ChronoUnit?): Pair<Long, String> {
    val units = listOf(
        Triple(31536000L, "year", ChronoUnit.YEARS),
        Triple(2592000L, "month", ChronoUnit.MONTHS),
        Triple(604800L, "week", ChronoUnit.WEEKS),
        Triple(86400L, "day", ChronoUnit.DAYS),
        Triple(3600L, "hour", ChronoUnit.HOURS),
        Triple(60L, "minute", ChronoUnit.MINUTES),
        Triple(1L, "second", ChronoUnit.SECONDS),
    )
    for ((threshold, name, chrono) in units) {
        if (maxUnit != null && chrono > maxUnit) continue
        if (absSeconds >= threshold) return Pair(absSeconds / threshold, name)
    }
    return Pair(absSeconds, "second")
}

private fun formatUnit(value: Long, unit: String, style: Style, isFuture: Boolean): String {
    if (style == Style.COMPACT) {
        val abbr = when (unit) {
            "year" -> "y"; "month" -> "mo"; "week" -> "w"; "day" -> "d"
            "hour" -> "h"; "minute" -> "m"; "second" -> "s"; else -> unit
        }
        return "$value$abbr"
    }
    // Special cases
    if (value == 1L && unit == "day" && !isFuture) return "yesterday"
    if (value == 1L && unit == "day" && isFuture) return "tomorrow"
    if (value == 1L && unit == "week" && !isFuture) return "last week"
    if (value == 1L && unit == "hour") return "an hour"
    if (value == 1L && unit == "minute") return "a minute"
    val plural = if (value == 1L) unit else "${unit}s"
    return "$value $plural"
}
