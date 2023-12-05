# Project Work OwlNet - AI-Powered Coworking Space

## Background

The "OwlNet" project is aimed at developing a futuristic, AI-powered coworking space web application. Located in the Zurich agglomeration, this project focuses on digitally capturing member information and usage data of the coworking space.

## Objective

The prototype to be developed consists of a server and a client application. The client application interacts with the server application over an HTTP API. The prototype is designed with the following human actors in mind:

- Administrator
- Member
- Visitor (non-authenticated user)

## Functional Use Cases

The following functional use cases are to be implemented at a minimum in the prototype:

- As a visitor, I want to register with my first and last name, email address, and password, so I can become a member.
- As a visitor, I want to log in with my email address and password, so I can authenticate as a member or administrator.
- As a member, I want to request half and full day bookings on specific dates in the coworking space, so I can use the services of the coworking space.
- As a member, I want to check the status of my bookings, so I know if my booking has been confirmed or rejected.
- As a member, I can cancel my future bookings, so I can respond to changes in my schedule.
- As an administrator, I can manage members (create, edit, delete), so I can organize the members.
- As an administrator, I can accept or reject booking requests, so members can use the offerings of the coworking space.
- As an administrator, I can manage bookings (create, edit, delete), so I can organize the bookings.

## Non-Functional Use Cases

The following non-functional requirements should be implemented at a minimum in the prototype:

- The data model adheres to the first, second, and third normal forms of relational design theory.
- The first visitor receives the role of Administrator instead of Member after registration.
- Authentication is done using JSON Web Token (JWT according to RFC 7519) via the 'Authorization' HTTP header.
- The JWT expires and loses validity 24 hours after issuance.
- The JWT is persistently stored client-side for its lifetime.

## 1 - Analyzing Requirements

### 1.1 Extended Requirements

#### A. Three additional unique functional requirements described as user stories (As [Actor], I can [Function], so that [Context]).

- As a member, I can add other members to a booking, so a coworking appointment can be created in the coworking space.
- As a member, I can book specific meeting rooms, so meetings can be held.
- As a member, I can add Noccos (energy drinks) to my booking, so I am caffeinated and ready for my work.

#### B. Three additional unique non-functional requirements are measurably described.

- Passwords are stored hashed.
- Users should never wait longer than one second for page loading.
- The web application has a 99% availability.

#### C. The additional requirements are relevant to the project and tailored to the needs of a coworking space.

### 1.2 - Personas

Personas have been described for the actors involved in the project according to the following criteria.

#### Requirements

- A. A persona is described for each actor.
- B. Each persona is described with a first and last name, age, and gender.
- C. Each persona is described with a suitable image.
- D. The professional activity of each persona is described.
- E. It is described for each persona why they use the offerings of a coworking space.

#### Personas

*Include personas as per your project's specifics, following the structure and criteria outlined above.*

### 1.3 - Use Case Diagram

A use case diagram has been created according to UML 2 and the following criteria.

#### Requirements

- A. The system context and a project-relevant system title are depicted.
- B. All actors and their names are visualized.
- C. All functional requirements (including additional requirements from criterion 1) are depicted as use cases.
- D. The relations between actors and requirements are visualized.

#### Diagram - PlantUML code

*Include PlantUML code for your project's use case diagram.*

#### Diagram - Image

*Include an image of the use case diagram.*

### Note:

*This README should be further customized to fit the specifics of the OwlNet project, including detailed descriptions of use cases, personas, and system requirements.*