# Project Work OwlNet - AI-Powered Coworking Space

## Background

OwlNet represents an innovative approach in Zurich's agglomeration, merging AI technology with a unique coworking space experience. This project focuses on utilizing AI for efficient member management and optimal space utilization.

## Getting Started

This section guides new developers through the process of setting up the OwlNet project on their local machine.

### Prerequisites

- Git
- Docker
- Visual Studio Code
- Dev-Container Extension (Install from [VS Code Marketplace](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers))

### Setup Instructions

1. Clone the Git repository: `git clone https://github.com/lunadelinte/OwlNet.git`
2. Ensure Docker is up and running on your machine.
3. Open the project directory in Visual Studio Code.
4. Start the development container: Navigate to `Remote-Containers: Open Folder in Container` and select the project folder.
5. Launch the project with `Quarkus: Debug current Quarkus Project` command in VS Code.

### Running the Application

After setting up, you can access:

- **Web Application**: http://localhost:8080
- **Swagger API Interface**: http://localhost:8080/q/swagger-ui/

### Database Setup

OwlNet uses PostgreSQL. Configuration for the development environment is specified in [docker-compose.yml](./.devcontainer/docker-compose.yml).

#### Database Administration with PgAdmin4

Access PgAdmin4 at http://localhost:5050. Use `zli@example.com` and `zli*123` for login. Configure the database connection with:

- Host name/address: `db`
- Port: `5432`
- Maintenance database: `postgres`
- Username: `postgres`
- Password: `postgres`

### Test Data

Test data is located in `src/main/resources/import.sql` and is automatically loaded when Quarkus starts. This data is crucial for testing and validating application functionalities.

## Project Overview

This section provides a high-level overview of OwlNet's objectives, key actors, and functional as well as non-functional use cases.

### Key Actors

- Administrator
- Member
- Visitor (non-authenticated user)

### Functional Use Cases

Implementation includes registration, authentication, booking systems, and administrative tools.

### Non-Functional Use Cases

Key requirements include data normalization, JWT authentication, and system performance standards.

## Use Case Diagram

Refer to the [Use Case Diagram section](#1.3---Use-Case-Diagram) for a detailed depiction of interactions between different actors and the OwlNet system.

## Testing Methodology

Comprehensive testing ensures the OwlNet application meets all functional and non-functional requirements.

### Running Tests

To execute tests:

1. Navigate to the test directory: `cd <test-directory-path>`
2. Run the test suite with the command: `mvn test`

#### Generating and Loading Test Data

Test data reflects various user scenarios for thorough application testing. It includes:

- User Test Data
- Booking Test Data
- Workspace Test Data

**Automated Data Loading**: In development mode, test data is automatically loaded into the database on application start.

## Project Documentation

### Version History

For a comprehensive overview of the development process and changes made throughout the project, refer to the [OwlNet Git Log](./OwlNet_Git_Log.txt). This document contains a detailed log of all commits, providing insights into the evolution of the OwlNet project. It serves as an essential resource for understanding the chronological development and decision-making process behind the application.

### README Note

This README is crafted to offer a complete guide for developers contributing to the OwlNet project, focusing on AI integration and creating a user-friendly coworking space.

---

*This README was prepared with the assistance of Athena, an AI language model, ensuring precision and comprehensive coverage of OwlNet's development aspects.*
