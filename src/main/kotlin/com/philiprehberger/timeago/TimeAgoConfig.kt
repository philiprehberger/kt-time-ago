package com.philiprehberger.timeago

import java.time.Duration
import java.time.temporal.ChronoUnit

/** Configuration for [timeAgo] formatting. */
public class TimeAgoConfig {
    /** Duration threshold for "just now" (default: 10 seconds). */
    public var nowThreshold: Duration = Duration.ofSeconds(10)
    /** Maximum time unit to display. `null` means no limit. */
    public var maxUnit: ChronoUnit? = null
    /** Prefix for future times (default: "in "). */
    public var futurePrefix: String = "in "
    /** Suffix for past times (default: " ago"). */
    public var pastSuffix: String = " ago"
    /** Output style (default: FULL). */
    public var style: Style = Style.FULL
}
