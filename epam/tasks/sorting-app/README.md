# Sorting App

[![pipeline status](https://gitlab.com/sabit-shaikholla/sorting-app/badges/master/pipeline.svg)](https://gitlab.com/sabit-shaikholla/sorting-app/-/commits/master)

[![coverage report](https://gitlab.com/sabit-shaikholla/sorting-app/badges/master/coverage.svg)](https://gitlab.com/sabit-shaikholla/sorting-app/-/commits/master)

[![Latest Release](https://gitlab.com/sabit-shaikholla/sorting-app/-/badges/release.svg)](https://gitlab.com/sabit-shaikholla/sorting-app/-/releases)

This Maven-based project is a small Java application that takes up to ten command-line arguments as integer values, sorts them in ascending order, and prints the result to the standard output.

## Project Details

### GAV Settings
- GroupId: `com.sortingapp`
- ArtifactId: `sorting-app`
- Version: `1.0.0`

### Project Structure
- Maven Model Version: `4.0.0`
- Java Source and Target Version: `1.8`
- Maven Properties are used for configuration.

### Dependencies
- [JUnit v4.12](https://junit.org/junit4/index.html) library is included.
- [Log4j v2.22.0](https://logging.apache.org/log4j/2.x/) library is included.

### Unit Tests
- JUnit 4.12 is used for unit testing.
- Parametrized unit tests cover different scenarios, including corner cases.

### Runnable JAR
- The project is configured to build a runnable JAR.
- Execute the JAR by running: `java -jar target/sorting-app-1.0.0-SNAPSHOT-jar-with-dependencies.jar <args>`

### Logging
- Logging is implemented using [Log4j](https://logging.apache.org/log4j/2.x/).

### Javadoc
- Javadoc for the public API is available in the `target/site/apidocs` directory.
- Open `target/site/apidocs/index.html` in a browser to view the documentation.

## How to Use

1. Clone the repository:

   ```bash
   git clone https://gitlab.com/sabit-shaikholla/sorting-app
   ```
2. Navigate to the project directory:

   ```bash
   cd sorting-app
   ```
3. Build the project:

   ```bash
   mvn clean package
   ```
4. Run the application:

   ```bash
   java -jar target/sorting-app-1.0.0.jar <args>
   ```
   where `<args>` is a list of up to ten integer values separated by spaces.
5. The application will print the sorted list of integers to the standard output.
6. To run the unit tests:

   ```bash
   mvn test
   ```
