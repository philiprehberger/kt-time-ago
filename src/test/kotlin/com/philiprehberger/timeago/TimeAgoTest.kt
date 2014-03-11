package com.philiprehberger.timeago

import java.time.Instant
import kotlin.test.*

class TimeAgoTest {
    private val now = Instant.parse("2026-03-18T12:00:00Z")

    @Test fun `just now`() = assertEquals("just now", timeAgo(now.minusSeconds(5), now))
    @Test fun `seconds ago`() = assertEquals("30 seconds ago", timeAgo(now.minusSeconds(30), now))
    @Test fun `minutes ago`() = assertEquals("5 minutes ago", timeAgo(now.minusSeconds(300), now))
    @Test fun `hours ago`() = assertEquals("2 hours ago", timeAgo(now.minusSeconds(7200), now))
    @Test fun `yesterday`() = assertEquals("yesterday ago", timeAgo(now.minusSeconds(86400), now))
    @Test fun `days ago`() = assertEquals("3 days ago", timeAgo(now.minusSeconds(259200), now))
    @Test fun `weeks ago`() = assertEquals("2 weeks ago", timeAgo(now.minusSeconds(1209600), now))
    @Test fun `future`() = assertEquals("in 5 minutes", timeAgo(now.plusSeconds(300), now))
}
