# End-to-End-Testing-with-Java-Selenium-Cucumber
End to End Hybrid Testing framework based on JUnit, Selenium, Cucumber

## Setup

+ Chekout the latest code from branch `aditi`
+ Open `pom.xml` in IntelliJ IDEA as a **project**
  - This will download all the required dependencies and setupt the project

## Configuration

+ For browser configuration and base url see `testConfiguration.properties` in `src/main/resources/config/`
+ For waiting times during test see `TestConfigurations.java` in `src/test/java/works/metadata/qa/tests/`

## Running tests

Note: In order for the test to pass MetadataExchange(MDX3) application should be up and running

+ Open `TestRunner.java` in `src/test/java/works/metadata/qa/tests/`
+ Right click and select `Run TestRunner.java`