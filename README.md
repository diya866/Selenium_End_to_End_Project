# Selenium PetStore Automation Framework

## Overview

This project is an end-to-end test automation framework developed for the JPetStore application using Selenium WebDriver, Java, TestNG, Maven, and the Page Object Model (POM) design pattern.

The framework automates the complete customer purchase workflow, including user registration, login, product selection, cart management, checkout, order confirmation, invoice verification, and logout. It also incorporates Extent Reports, Log4j2 logging, and screenshot capture for comprehensive test execution reporting.

---

## Objectives

The primary objectives of this framework are:

- Automate critical business workflows of the JPetStore application.
- Implement a scalable and maintainable automation framework.
- Generate detailed execution reports with screenshots.
- Provide structured logging for debugging and analysis.
- Demonstrate industry-standard automation testing practices.

---

## Technology Stack

| Technology | Purpose |
|------------|----------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| TestNG | Test Execution Framework |
| Maven | Build and Dependency Management |
| Page Object Model (POM) | Framework Design Pattern |
| Extent Reports | Test Reporting |
| Log4j2 | Logging Framework |
| Apache Commons IO | Screenshot File Handling |

---

## Framework Structure

```text
src
│
├── main
│   └── java
│       ├── pages
│       │   ├── RegistrationPage.java
│       │   ├── LoginPage.java
│       │   ├── SearchPage.java
│       │   ├── CartPage.java
│       │   └── CheckoutPage.java
│       │
│       └── utils
│           ├── Utilities.java
│           ├── ScreenshotUtil.java
│           └── ExtentManager.java
│
├── test
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       │
│       └── tests
│           └── PetStoreTest.java
│
├── Reports
├── Screenshots
├── logs
├── pom.xml
└── README.md
```

---

## Features Implemented

### User Registration

- Navigates to registration page.
- Creates a new user account.
- Generates a unique username dynamically.
- Configures account preferences.
- Saves account information successfully.

### Dynamic Login

- Captures the username generated during registration.
- Uses the generated username for login.
- Eliminates dependency on hardcoded credentials.

### Product Selection

Automates navigation through:

```text
Dogs
   → Dog Product
      → Female Golden Retriever
```

### Shopping Cart Operations

- Adds selected product to cart.
- Updates product quantity.
- Validates shopping cart information.

### Checkout Process

#### Billing Information

Updates:

- Credit Card Number
- Expiry Date
- First Name
- Last Name
- Address
- City
- State
- Zip Code
- Country

#### Shipping Information

- Selects "Ship to Different Address".
- Updates shipping address details.
- Continues order placement workflow.

### Order Confirmation

- Confirms order successfully.
- Verifies successful order placement.

### Invoice Verification

After order confirmation:

```text
My Account
   → My Orders
      → Latest Order
```

The framework automatically opens the latest order and captures an invoice screenshot for evidence.

### Screenshot Capture

Screenshots are captured during:

- Registration
- Login
- Product Selection
- Cart Operations
- Checkout Process
- Billing Details
- Shipping Details
- Order Confirmation
- Invoice Verification
- Failure Scenarios

### Extent Reporting

The framework generates detailed HTML reports containing:

- Execution Status
- Pass/Fail Results
- Step-Level Reporting
- Embedded Screenshots
- Failure Evidence
- Execution Summary

### Logging

Log4j2 logging is integrated throughout the framework to provide:

- Execution Tracking
- Debug Information
- Error Reporting
- Workflow Monitoring

---

## Design Pattern

### Page Object Model (POM)

The framework follows the Page Object Model design pattern where each application page is represented by a dedicated Java class.

Implemented Page Classes:

- RegistrationPage
- LoginPage
- SearchPage
- CartPage
- CheckoutPage

Benefits:

- Improved Maintainability
- Enhanced Reusability
- Better Readability
- Reduced Code Duplication

---

## Utility Components

### Utilities.java

Provides reusable methods for:

- Explicit Waits
- Element Visibility Checks
- Element Clickability Checks
- Scrolling Operations
- JavaScript Execution

### ScreenshotUtil.java

Responsible for:

- Capturing Screenshots
- Storing Screenshots
- Supporting Extent Report Attachments

### ExtentManager.java

Responsible for:

- Report Initialization
- Report Configuration
- Report Generation

---

## Test Scenario Covered

```text
1. Register New User
2. Login Using Generated Credentials
3. Navigate to Store
4. Open Dogs Category
5. Select Female Golden Retriever
6. Add Product to Cart
7. Update Quantity
8. Proceed to Checkout
9. Update Billing Details
10. Update Shipping Details
11. Confirm Order
12. Verify Successful Order Placement
13. Navigate to My Orders
14. Open Latest Order
15. Capture Invoice Screenshot
16. Return to Main Menu
17. Logout
```

---

## Execution Instructions

### Clone Repository

```bash
git clone https://github.com/diya866/mph_selenium.git
```

### Navigate to Project Directory

```bash
cd mph_selenium
```

### Install Dependencies

```bash
mvn clean install
```

### Execute Test Suite

```bash
mvn test
```

---

## Report Locations

### Extent Report

```text
Reports/ExtentReport.html
```

### Screenshots

```text
Screenshots/
```

### Log Files

```text
logs/application.log
```

---

## Expected Outcome

Upon successful execution, the framework will:

- Register a new user.
- Login using generated credentials.
- Purchase a product.
- Complete checkout.
- Confirm the order.
- Capture invoice evidence.
- Generate execution reports.
- Record logs for all major actions.

---

## Author

Diya B

Computer Science Engineering (Artificial Intelligence and Machine Learning)

Skills:
- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model
- Extent Reports
- Log4j2
- Automation Framework Development
