# time-ago

[![Tests](https://github.com/philiprehberger/kt-time-ago/actions/workflows/publish.yml/badge.svg)](https://github.com/philiprehberger/kt-time-ago/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.philiprehberger/time-ago)](https://central.sonatype.com/artifact/com.philiprehberger/time-ago)
[![License](https://img.shields.io/github/license/philiprehberger/kt-time-ago)](LICENSE)

Human-readable relative time formatting: 5 minutes ago, in 3 days, yesterday.

## Installation

### Gradle (Kotlin DSL)

```kotlin
implementation("com.philiprehberger:time-ago:0.1.4")
```

### Maven

```xml
<dependency>
    <groupId>com.philiprehberger</groupId>
    <artifactId>time-ago</artifactId>
    <version>0.1.4</version>
</dependency>
```

## Usage

```kotlin
import com.philiprehberger.timeago.*
import java.time.Instant

timeAgo(Instant.now().minusSeconds(30))    // "30 seconds ago"
timeAgo(Instant.now().minusSeconds(7200))  // "2 hours ago"
timeAgo(Instant.now().minusSeconds(86400)) // "yesterday ago"
timeAgo(Instant.now().plusSeconds(300))     // "in 5 minutes"

// Compact style
timeAgo(Instant.now().minusSeconds(300)) { style = Style.COMPACT } // "5m ago"

// Extension function
Instant.now().minusSeconds(600).timeAgo() // "10 minutes ago"
```

## API

| Function / Class | Description |
|------------------|-------------|
| `timeAgo(instant, relativeTo, config)` | Format relative time string |
| `Instant.timeAgo(relativeTo, config)` | Extension function variant |
| `Style.FULL` | Full output: "2 minutes ago" |
| `Style.COMPACT` | Compact output: "2m ago" |
| `TimeAgoConfig.nowThreshold` | Duration threshold for "just now" |
| `TimeAgoConfig.maxUnit` | Cap the largest time unit displayed |

## Development

```bash
./gradlew test       # Run tests
./gradlew build      # Build JAR
```

## License

MIT
