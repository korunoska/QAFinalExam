# QAFinalExam

## Overview

This project is a collection of automated test cases for the final QA Exam. Cases were executed on the SportVision web store. It uses Java and Selenium WebDriver for automating the browser interactions.

## Test Cases

The project consists of three main test cases:

1. **Search Filter Test**: This test case tests the search and filter functionality. The test initiates a search from the homepage, filters the search results by brand, age group, and price, and then verifies that the resulting products match the applied filters.

2. **Shopping Cart Test**: This test case tests the shopping cart functionality. The test selects a specific brand and product type from the homepage, adds the product to the shopping cart, and verifies that the total price in the cart is correct.

3. **Wishlist Test**: This test case tests the wishlist functionality. The test initiates a brand search on the homepage, applies a gender filter, opens the last results page and chooses the last product on the page, and then adds it to the wishlist. It then verifies that the added product appears in the wishlist by checking if the product's ID is present in the wishlist (and checks if it’s the only product in the wishlist).

## Setup

1. Clone the repository.
2. Import the project into your preferred IDE as a Maven project.
3. Download and extract the appropriate version of Chromedriver next to pom.xml.
4. Create a new Java class in the `tests` package which extends `BaseTest` and write your tests there. You can use the `driver` variable (WebDriver instance) and `wdWait` (WebDriverWait instance) which are inherited from `BaseHelper`.
5. Install Maven and run the command `mvn clean install` in your terminal to run the tests.

## License

Apache License, Version 2.0

## Author

This project was created by Emilija Korunoska. For more information visit [LinkedIn profile](https://ba.linkedin.com/in/emilijakorunoska).
