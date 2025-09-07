HCA Automation Framework

This project is a hybrid **UI + API automation framework** built with:
- **Java 17+**
- **Selenium WebDriver**
- **RestAssured**
- **TestNG + Cucumber**
- **Maven**


📂 Project Structure

src
├── main
│ ├── base # Common setup classes (BaseTest, ApiBaseTest)
│ ├── factory # DriverFactory for WebDriver init
│ ├── utils # Utilities (Retry, DataHandler, Listeners, etc.)
│ └── config # Config files (test data, properties)
│
└── test
├── java
│ ├── runners # Cucumber TestRunner classes
│ ├── stepdefs # Step Definitions for API & UI
│ └── features # Gherkin feature files
└── resources
└── testdata # JSON / CSV files for test data



---

Prerequisites
- Install **Java 17+**
- Install **Maven 3.8+**
- IDE: IntelliJ IDEA / Eclipse
- Chrome browser & matching [ChromeDriver](https://chromedriver.chromium.org/downloads)

---

▶️ How to Run Tests
  Run all suites (default `testng.xml`)
- bash
- mvn clean test


Run specific suite -mvn clean test -DsuiteXmlFile=testng.xml

Run Cucumber feature - mvn test -Dcucumber.options="src/test/java/features/CreateUser.feature"

Tags & Groups-

@Smoke → light checks
@Regression → full validations
@API → API tests only
@UI → UI Selenium tests only



Reports

TestNG Report → test-output/index.html
Cucumber Report → target/cucumber-reports.html


Key Utilities

DriverFactory → Handles WebDriver lifecycle
ApiBaseTest → RestAssured base config
RetryAnalyzer → Retry flaky tests automatically
DataHandler → Loads test data from JSON


Pending Steps

Add CI/CD integration (Jenkins / GitHub Actions)
Add Allure Reports for better visualization
Add environment configs (dev, qa, staging)
Database Connectivity(JDBC&SQL)

