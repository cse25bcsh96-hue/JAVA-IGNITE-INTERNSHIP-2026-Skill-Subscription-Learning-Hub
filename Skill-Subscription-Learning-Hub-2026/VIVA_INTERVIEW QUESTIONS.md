# Viva / Interview Questions

##  Basic

- What is Spring Boot?
  Spring Boot is a framework built on top of the Spring ecosystem.

It simplifies the process of creating standalone, production-ready applications.

Key features:

 Auto-configuration: It automatically configures your application based on the dependencies you add (e.g., if you add spring-boot-starter-web, it sets up Tomcat and Spring MVC).

 Embedded servers: You don’t need to deploy to an external server; it comes with embedded Tomcat/Jetty/Undertow.

 Convention over configuration: Provides sensible defaults so you can focus on business logic instead of boilerplate setup.

Starter dependencies: Bundles common dependencies into “starters” (e.g., spring-boot-starter-data-jpa).

 Production-ready tools: Includes monitoring, metrics, and health checks out of the box.

 In short: Spring Boot makes building and deploying Java applications faster, easier, and less error-prone.

 
- What is MVC architecture?
MVC stands for Model–View–Controller.

It’s a design pattern used to separate concerns in software applications:

Model: Represents the data and business logic (e.g., entities like User or Pack, and services that handle database operations).

View: The user interface (e.g., JSP pages, HTML templates) that displays data to the user.

Controller: Handles user requests, processes input, interacts with the model, and returns the appropriate view.

 Flow:

User sends a request (e.g., clicks “Register”).

Controller receives the request, calls the Model (service/repository) to process data.

The Model returns results (e.g., user saved in DB).

The Controller passes data to the View.

The View renders the response (e.g., confirmation page).

In short: MVC keeps your application organized by separating data (Model), logic (Controller), and presentation (View).
---

##  Intermediate

- What is Service layer?
- The Service layer in Spring applications sits between the Controller and the Repository.

Its role is to contain business logic — the rules and operations that define how your application works.

Responsibilities:

Coordinates between controllers (handling requests) and repositories (data access).

Ensures business rules are applied consistently.

Keeps controllers lightweight by moving logic out of them.

Makes code easier to test and maintain.

 Example: In a registration flow, the controller receives user input, the service validates and processes it, and then calls the repository to save the user.
 
- What is Repository in Spring Data JPA?
A Repository is a Spring Data interface that abstracts database operations.

It provides CRUD (Create, Read, Update, Delete) methods without writing SQL.

Common repository interfaces:

CrudRepository

JpaRepository

PagingAndSortingRepository
Spring Data JPA automatically generates the implementation at runtime.

 In short: The repository is the data access layer that talks to the database.
 
-Difference between GET and POST answer?
GET                                                                  POST
-Retrieve data                                                      -Submit data
-Parameters are appended to the URL (query string)                  -Data is sent in the request body
-Visible in browser history, bookmarks, logs                        -Hidden from URL, not easily bookmarked
-Less secure (data exposed in URL)                                  -More secure (data in body, not shown in URL)
-Search queries, fetching resources                                 -Form submissions, login, registration
---

##  Advanced (Project Based)

- How does subscription flow work?
- Step 1: User logs in → The system authenticates the user.

Step 2: User views available packs → Controller fetches all SkillPack entries from the database and passes them to the JSP view.

Step 3: User selects a plan → Clicking “Subscribe” sends a request with userId and packId.

Step 4: Backend processes subscription → A Subscription entity is created linking the user and the chosen pack.

Step 5: Data saved in DB → The subscription record is stored, confirming the user’s enrollment.
This flow ensures that only registered and logged-in users can subscribe to a skill pack.

- How do you link User and SkillPack?\
- This way:

A User can have multiple subscriptions.

A Pack can be subscribed to by multiple users.

It’s a many-to-many relationship implemented via the Subscription table.This way:

A User can have multiple subscriptions.

A Pack can be subscribed to by multiple users.

It’s a many-to-many relationship implemented via the Subscription table.

- Why do we use Service layer?
- The Service layer holds the business logic of the application.

Reasons:

Keeps controllers clean (controllers only handle requests/responses).

Centralizes business rules (e.g., “a user cannot subscribe twice to the same pack”).

Makes testing easier (you can test services independently).

Improves maintainability by separating concerns.

 Without a service layer, controllers would become bloated with logic, making the system harder to manage.
 
- How does JSP get data from Controller?
- Controller adds data to the Model
- Spring DispatcherServlet forwards the request to the JSP view.

JSP uses JSTL (<c:forEach>) or EL (${packs}) to display the data.
In summary:

Subscription flow: login → view packs → subscribe → save subscription.

User and SkillPack are linked via a Subscription entity (many-to-many).

Service layer ensures clean separation of business logic.

JSP gets data from the controller through the Model object and displays it using JSTL/EL.
