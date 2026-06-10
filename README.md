# KatalonCertification

This repository contains a Katalon Studio automation project for web UI testing.

## Project Summary

- Project name: `KatalonCertification`
- Katalon Studio edition: Enterprise
- Created version: 10.3.2
- Modified version: 10.4.3
- Project type: `WEBUI`

## Prerequisites

- Katalon Studio installed (compatible with Katalon 10.x)
- Java JDK installed
- Gradle or the Gradle wrapper available
- Git checked out in this repository

## How to Run

### Using Katalon Studio

1. Open Katalon Studio.
2. Select `File > Open Project`.
3. Choose the repository root folder `d:\KatalonCertification`.
4. Run test cases or test suites from the `Test Explorer`.

### Using Gradle

This project includes a `build.gradle` file with the Katalon Gradle plugin configured.

From the repository root, run:

```bash
gradle katalonStudioExecute
```

If your system is using the Gradle wrapper, run:

```bash
./gradlew katalonStudioExecute
```

> Note: Adjust the task and arguments as needed for your environment and Katalon CLI settings.

## Repository Layout

- `Test Cases/` - Katalon test case definitions
- `Test Suites/` - Katalon test suite definitions
- `Object Repository/` - UI object definitions
- `Data Files/` - Test data and spreadsheets
- `Scripts/` - Generated test scripts for execution
- `Include/` - Additional scripts, configuration, and feature files
- `Profiles/` - Execution profiles and environment configurations
- `Plugins/` - Custom plugins used by the project
- `Libs/` - Custom libraries and helper Groovy scripts
- `Reports/` - Test execution reports
- `Drivers/` - Browser or platform driver files
- `Test Listeners/` - Listener scripts for test lifecycle events

## Notes

- The Gradle script currently includes the Katalon Gradle plugin and sample dependency comments.
- Update `build.gradle` with any required dependencies before running Gradle-based execution.
- Use the Katalon project settings in `KatalonCertification.prj` to confirm project-specific configuration.

## Contact

For project-specific updates or questions, review the repository owner or team documentation.
