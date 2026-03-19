package com.philiprehberger.timeago

import java.time.Instant
import kotlin.test.*

class CompactStyleTest {
    private val now = Instant.parse("2026-03-18T12:00:00Z")

    @Test fun `compact seconds`() = assertEquals("30s ago", timeAgo(now.minusSeconds(30), now) { style = Style.COMPACT })
    @Test fun `compact minutes`() = assertEquals("5m ago", timeAgo(now.minusSeconds(300), now) { style = Style.COMPACT })
    @Test fun `compact hours`() = assertEquals("2h ago", timeAgo(now.minusSeconds(7200), now) { style = Style.COMPACT })
}
