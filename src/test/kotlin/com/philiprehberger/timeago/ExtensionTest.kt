package com.philiprehberger.timeago

import java.time.Instant
import kotlin.test.*

class ExtensionTest {
    @Test fun `extension function`() {
        val now = Instant.parse("2026-03-18T12:00:00Z")
        assertEquals("5 minutes ago", now.minusSeconds(300).timeAgo(now))
    }
}
