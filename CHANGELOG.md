# Changelog

## [0.1.2] - 2026-03-18

- Fix JVM signature clash between timeAgo() and Instant.timeAgo() extension

## [0.1.1] - 2026-03-18

- Upgrade to Kotlin 2.0.21 and Gradle 8.12
- Enable explicitApi() for stricter public API surface
- Add issueManagement to POM metadata

## [0.1.0] - 2026-03-18

### Added

- `timeAgo()` function for human-readable relative time formatting

- `Instant.timeAgo()` extension function

- FULL and COMPACT output styles

- Configurable nowThreshold, maxUnit, futurePrefix, pastSuffix

- Special labels: yesterday, tomorrow, last week, a minute, an hour
