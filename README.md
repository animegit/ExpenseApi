

# Expense Tracking API

The Expense Tracking API is a Spring Boot-based application for managing and tracking expenses. It allows users to upload expense details, including receipts in PDF format, and store them in a MySQL database.

## Features

- **Expense Upload**: Easily upload and manage your expenses, including type, amount, description, and PDF receipts.

- **PDF Storage**: Securely store PDF receipts in the `/static/pdf` directory for easy access and retrieval.

- **Validation**: Comprehensive validation ensures that expense details meet required constraints.

## Getting Started

Follow these steps to run the Expense Tracking API:

### Prerequisites

- Java Development Kit (JDK) 11 or later
- Apache Maven
- MySQL database

### Configuration

1. Clone this repository to your local machine.

2. Configure the database settings in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   ```

3. Build the project using Maven:

   ```
   mvn clean install
   ```

### Running the Application

4. Run the Spring Boot application:

   ```
   mvn spring-boot:run
   ```

The application will start, and you can access it at `http://localhost:8080`.

- Thanks to the Spring Boot and MySQL communities for providing essential tools and resources.

Feel free to customize this README file further to include any specific instructions or information relevant to your project.
