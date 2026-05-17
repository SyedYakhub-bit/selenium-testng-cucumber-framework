# Selenium TestNG Cucumber Framework

A production-style Java test automation framework demonstrating end-to-end UI testing, data-driven execution, parallel runs, and HTML reporting — built against a live e-commerce application.

---

## Tech Stack

| Tool / Library           | Version   |
|--------------------------|-----------|
| Java                     | 26        |
| Selenium WebDriver       | 4.43.0    |
| TestNG                   | 7.12.0    |
| Cucumber (Java + TestNG) | 7.34.3    |
| Maven                    | 3.x       |
| Maven Surefire Plugin    | 3.5.4     |
| ExtentReports (Spark)    | 2.3.14    |
| Jackson Databind         | 2.21.2    |
| REST Assured             | 6.0.0     |
| Logback                  | 1.5.32    |
| Spotless (formatter)     | 2.43.0    |

---

## Key Features

- **Page Object Model** — every page is a self-contained class backed by `PageFactory`; locators never leak into test logic
- **AbstractComponents base** — reusable explicit waits (`visibilityOf`, `elementToBeClickable`), JavaScript scroll helpers, and navigation actions inherited by all page objects
- **Multi-browser support** — swap Chrome ↔ Edge with a single property file change; browser options suppress the automation banner and disable the password manager popup
- **Data-driven testing** — JSON test data deserialized via Jackson `ObjectMapper` into a `@DataProvider`, feeding the same test with multiple credential sets
- **Parallel execution** — TestNG XML suites configured with `parallel="tests"` and `thread-count`; `ThreadLocal<ExtentTest>` prevents report race conditions under concurrency
- **Auto-screenshot on failure** — `ITestListener.onTestFailure` captures a timestamped PNG and embeds it directly in the Extent Report
- **Retry analyser** — flaky tests automatically re-run once before being marked as failed
- **TestNG groups** — Smoke / ErrorHandling groups selectable at the suite level
- **Selenium technique coverage** — 30+ dedicated scripts covering dropdowns, iFrames, drag & drop, JS alerts, cookies, child windows, dynamic dropdowns, fluent waits, relative locators, table operations, calendar pickers, and HTTP handling
- **Cucumber BDD ready** — `cucumber-java` + `cucumber-testng` dependencies wired in for BDD layer expansion

---

## Prerequisites

- JDK 21+ (project compiles to Java 26)
- Maven 3.8+
- Google Chrome or Microsoft Edge (matching your installed browser version — Selenium 4 ships its own driver manager)

---

## Setup

```bash
# 1. Clone the repository
git clone https://github.com/SyedYakhub-bit/selenium-testng-cucumber-framework.git
cd selenium-testng-cucumber-framework

# 2. Install dependencies
mvn clean install -DskipTests

# 3. Configure the browser
#    Edit: src/main/java/Framework/Resources/global.properties
#    Options: chrome | edge
browser=chrome
```

---

## Running Tests

### Run all tests via Maven
```bash
mvn test
```

### Run a specific TestNG suite
```bash
# Full regression suite
mvn test -DsuiteXmlFile=testng-folder/testng-parallel_2.xml

# Error-handling suite
mvn test -DsuiteXmlFile=testng-folder/errorHandling-testng.xml

# Smoke group only
mvn test -DsuiteXmlFile=testng-folder/testng-group.xml

# Data-driven suite (JSON credentials)
mvn test -DsuiteXmlFile=testng-folder/testng-data-provider.xml
```

### Parallel execution
`testng-parallel_2.xml` runs `SubmitOrderTest` and `ErrorValidationTest` as two independent `<test>` blocks simultaneously:

```xml
<suite parallel="tests" name="Suite">
    <test name="Submit Order Test">
        <classes><class name="TestClasses.SubmitOrderTest"/></classes>
    </test>
    <test name="Error Validation Test">
        <classes><class name="TestClasses.ErrorValidationTest"/></classes>
    </test>
</suite>
```

---

## Project Structure

```
selenium-testng-cucumber-framework/
├── pom.xml
├── testng-folder/
│   ├── testng.xml                  # Default suite
│   ├── testng-parallel_1.xml       # Parallel with listeners
│   ├── testng-parallel_2.xml       # Parallel e2e suite
│   ├── testng-group.xml            # Smoke group suite
│   ├── testng-data-provider.xml    # Data-driven suite
│   ├── testng-helper.xml
│   └── errorHandling-testng.xml
└── src/
    ├── main/java/
    │   ├── AbstractComponents/
    │   │   └── AbstractComponents.java   # Base POM class: waits, scroll, nav
    │   └── Framework/
    │       ├── PageObjects/              # One class per application page
    │       │   ├── LandingPage.java
    │       │   ├── ProductCatalogue.java
    │       │   ├── CartPage.java
    │       │   ├── CheckOutPage.java
    │       │   ├── ConfirmMessage.java
    │       │   └── OrderPage.java
    │       ├── Resources/
    │       │   ├── global.properties     # Browser config
    │       │   ├── submitOrder.json      # JSON test data
    │       │   └── ExtentReporterNG.java # Report factory
    │       └── Utilities/
    │           └── DataReader.java       # JSON → List<HashMap> via Jackson
    └── test/java/
        ├── TestComponents/
        │   ├── BaseTest.java             # Driver init, teardown, screenshot
        │   ├── Listeners.java            # ITestListener + ThreadLocal reporting
        │   └── RetryFailedCases.java     # IRetryAnalyzer (1 retry)
        ├── TestClasses/                  # Core e2e tests
        │   ├── SubmitOrderTest.java
        │   ├── SubmitOrderJSONTest.java
        │   ├── ErrorValidationTest.java
        │   ├── ExtentReportTest.java
        │   └── ...
        ├── TestNG/                       # TestNG feature demonstrations
        │   ├── TestNGAnnotations.java
        │   ├── TestNGDataProvider.java
        │   ├── TestNGGrouping.java
        │   ├── TestNGListeners.java
        │   └── ...
        ├── Selenium_Basics/              # Selenium API technique coverage
        │   ├── DropDown.java
        │   ├── iFramesDragDrop.java
        │   ├── FluentWaits.java
        │   ├── CookiesHandling.java
        │   └── ... (25+ more)
        └── Assignments/                  # Consolidated practice exercises
```

---

## Configuration Files

### `global.properties`
Controls which browser the `BaseTest` initialises:
```properties
browser=chrome   # or: edge
```

### `submitOrder.json`
JSON array feeding the `@DataProvider` in `SubmitOrderJSONTest`. Each object maps directly to a `HashMap<String, String>` via Jackson, so adding a new test user requires only a new JSON entry — no code change.

### `testng-*.xml` suites
| File | Purpose |
|------|---------|
| `testng.xml` | Default suite, method-filter example |
| `testng-parallel_1.xml` | Parallel tests with listener wiring |
| `testng-parallel_2.xml` | Parallel e2e regression |
| `testng-group.xml` | Smoke group selection |
| `testng-data-provider.xml` | Data-provider demo suite |
| `errorHandling-testng.xml` | Error validation flow |

---

## Reports & Artifacts

| Artifact | Location |
|----------|----------|
| HTML Extent Report | `ExtentReports/index.html` |
| Failure screenshots | `screenshots/<testName>_<timestamp>.png` |
| Surefire XML results | `target/surefire-reports/` |

Open `ExtentReports/index.html` in any browser after a run to see a colour-coded pass/fail dashboard with embedded screenshots.

---

## Skills Demonstrated

| Area | Detail |
|------|--------|
| Framework design | POM + AbstractComponents inheritance, BaseTest lifecycle management |
| Synchronisation | Explicit waits (`WebDriverWait`), fluent waits, strategic implicit waits |
| Parallel testing | TestNG XML `parallel="tests"`, ThreadLocal driver/report isolation |
| Data-driven testing | JSON → Jackson → `@DataProvider` pipeline |
| Reporting | ExtentSparkReporter, auto-screenshot attachment on failure |
| Resilience | `IRetryAnalyzer` with configurable retry count |
| Browser config | Chrome + Edge with headless-friendly `ChromeOptions`/`EdgeOptions` |
| JavaScript | `JavascriptExecutor` for scroll and DOM interaction |
| Selenium APIs | Dropdowns, iFrames, drag & drop, alerts, cookies, windows, relative locators |
| BDD | Cucumber 7 + `cucumber-testng` integration |
| Build tooling | Maven lifecycle, Surefire plugin, Spotless formatter |
