# Project Work OwlNet - AI-Powered Coworking Space

## Background

OwlNet, a pioneering project in Zurich's agglomeration, is setting the stage for a digitally enhanced coworking space experience. This initiative focuses on leveraging AI technology to streamline member management and optimize space utilization.

## Setup

1. Clone the Git project.
2. Ensure Docker is installed and running.
3. Open the directory with VS Code.
4. Install Dev-Container Extension [here](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers).
5. Open the project in the development container.
6. Start the project with the command `Quarkus: Debug current Quarkus Project`.

### Web Application

The application runs at the address and port: http://localhost:8080

Swagger API Interface is available at http://localhost:8080/q/swagger-ui/

### Database

The data is stored in a PostgreSQL database. In the development environment, it is configured in the [docker-compose.yml](./.devcontainer/docker-compose.yml).

### Database Administration

PgAdmin4 is accessible at http://localhost:5050 for convenient database management. The username is `zli@example.com` and the password is `zli*123`. The connection to the PostgreSQL database must first be configured with the following data:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

### Test Data

Test data can be found in `src/main/resources/import.sql`. They are automatically loaded when Quarkus starts.

### Test Script

Tests are written as Bash scripts with curls instead of using Postman.

The test file is located at `src/main/resources/tests.sh`.

Use `sh tests.sh` on OSX, `./tests.sh` on Linux, and on Windows, please use WSL, thus `./tests.sh`.

The script automatically logs in an Admin and a Member user and saves the Bearer tokens in bash variables. These are then used for the individual tests/requests.

Additionally, one of my runs of the script is saved in `src/main/resources/test_outputs.txt`.

## Objective

The development of OwlNet encompasses a prototype that integrates a server and client application, communicating via an HTTP API. The platform is designed with the following key actors:

- Administrator
- Member
- Visitor (non-authenticated user)

## Functional Use Cases

Key functionalities to be implemented in the prototype include:

- Registration and authentication processes for visitors to become members.
- Booking features for members to reserve space and resources.
- Administrative tools for member and booking management.

## Non-Functional Use Cases

The prototype is built with critical non-functional requirements:

- Adherence to data normalization principles.
- Secure and efficient authentication using JWT.
- High availability and performance standards.

## 1 - Analyzing Requirements

### 1.1 Extended Requirements

#### A. Additional Unique Functional Requirements

Functional requirements are expanded to enhance user interaction and system efficiency.

#### B. Additional Unique Non-Functional Requirements

Non-functional aspects focus on security, performance, and reliability.

## 1.2 - Personas

### Athena (AI Admin)

- **Name:** Athena
- **Age:** N/A (AI)
- **Profession:** AI-Powered Admin Assistant
- **Background:** Athena is an advanced AI designed to streamline operations and enhance user experience at OwlNet.
- **Goals:** Efficient space management and personalized member assistance.
- **Challenges:** Balancing technology with user-centric values.

### Alex (Innovative Creator)

- **Name:** Alex
- **Age:** 30
- **Profession:** Digital Artist and AR/VR Developer
- **Background:** Alex combines art and technology to create futuristic digital art.
- **Goals:** To leverage OwlNet's unique environment for innovative creations.
- **Challenges:** Merging historical elements with modern digital art.

### Elena (Tech Innovator)

- **Name:** Elena
- **Age:** 34
- **Profession:** AI Startup Founder
- **Background:** Elena is a pioneer in AI technology, focusing on human-centered solutions.
- **Goals:** Developing ethical AI solutions at OwlNet.
- **Challenges:** Aligning AI advancements with human values.

## 1.3 - Use Case Diagram

The use case diagram depicts interactions between different actors and the OwlNet system, highlighting key functionalities and user relationships.

## 2 - Testing Methodology

### Generating Test Data

Comprehensive test data is crucial for validating the functionalities of the OwlNet application. The test data should cover all aspects of the application and ensure that each feature works as expected.

#### Objectives for Test Data Generation:

1. Coverage of All Functional Requirements:
   - The test data comprehensively covers all functional requirements outlined in the user stories.
2. Representation of Real-World Scenarios:
   - Test cases should mimic real-world scenarios that users of the OwlNet coworking space might encounter.
3. Validation of Entity Relationships:
   - Test data should help in validating the relationships and interactions between different entities such as Users, Bookings, Workspaces, and Events.

#### Strategies for Test Data Generation:

- **Manual Creation:** Creating a set of static test data manually which covers various scenarios.
- **Automated Tools:** Utilizing tools like Swagger for dynamic and automated test data generation, especially for API testing.

#### Example Test Data:

- **User Test Data:** ID: 101, Name: "Alex", Email: "[alex@example.com](mailto:alex@example.com)"
- **Booking Test Data:** ID: 201, BookingTime: "2023-12-05T10:00:00", UserID: 101, WorkspaceID: 301
- **Workspace Test Data:** ID: 301, Name: "Agora", Location: "First Floor"

### Automated Loading of Test Data

1. **Objective:** Test data should automatically load when the application starts in development mode.
2. **Implementation:** Utilize a data seeding script or mechanism to populate the database with test data upon startup in development mode.

### Documentation in README.md

1. **Objective:** The `README.md` file should include clear instructions on how and where the test data is defined and loaded.
2. **Implementation:** In the `README.md` file, add a section detailing the test data generation process.

### Note

*This README is tailored to OwlNet, focusing on AI integration and unique user interactions to create a comprehensive overview of the project's scope and objectives.*