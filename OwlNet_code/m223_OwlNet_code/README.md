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