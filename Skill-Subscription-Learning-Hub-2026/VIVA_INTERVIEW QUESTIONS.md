# Viva / Interview Questions

##  Basic

- What is Spring Boot?
- Spring Boot is a framework built on top of the Spring ecosystem.

It makes it easy to create standalone, production-ready applications with minimal configuration.

Key features:

 Auto-configuration: Automatically sets up beans and configurations based on dependencies.

 Embedded servers: Comes with Tomcat/Jetty/Undertow so you don’t need to deploy separately.

 Convention over configuration: Provides sensible defaults so you can focus on business logic.

 Starter dependencies: Bundled sets of dependencies (e.g., spring-boot-starter-web) for common use cases.

 Production-ready tools: Includes monitoring, metrics, and health checks.

In short: Spring Boot reduces boilerplate and speeds up development of Java applications.

- What is MVC architecture?
- MVC stands for Model–View–Controller.

It’s a design pattern that separates concerns in an application:

Model → Represents data and business logic (e.g., entities like User or SkillPack).

View → The user interface (e.g., JSP pages, HTML templates).

Controller → Handles requests, processes input, interacts with the model, and returns the view.
Flow:

User sends a request (e.g., clicks “Subscribe”).

Controller receives the request and calls the Model (via service/repository).

The Model processes data and returns results.

The Controller passes results to the View.

The View renders the response for the user.

 In short: MVC keeps applications organized by separating data (Model), logic (Controller), and presentation (View).

---

##  Intermediate

- What is Service layer?
- The Service layer is the middle tier in a Spring application, sitting between the Controller and the Repository.

Its role is to hold business logic — the rules and operations that define how your application works.

Responsibilities:

Keeps controllers lightweight by moving logic out of them.

Ensures business rules are applied consistently.

Coordinates between controllers (handling requests) and repositories (data access).

Makes testing and maintenance easier.

Example: In a subscription flow, the controller receives the request, the service checks if the user is already subscribed, and then calls the repository to save the subscription.

- What is Repository in Spring Data JPA?
- A Repository is a Spring Data interface that abstracts database operations.

It provides ready‑made methods for CRUD (Create, Read, Update, Delete) without writing SQL.

Common repository interfaces:

CrudRepository

JpaRepository

PagingAndSortingRepository
Spring Data JPA automatically generates the implementation at runtime.

 In short: The repository is the data access layer that talks directly to the database.
 
- Difference between GET and POST?
- GET                                                                  -POST
- Retrieve data                                                        -Submit data
- Parameters are appended to the URL (query string)                    -Data is sent in the request body
- Visible in browser history, bookmarks, logs                          -Hidden from URL, not easily bookmarked
- Less secure (data exposed in URL)                                    -More secure (data in body, not shown in URL)
- Search queries, fetching resources                                   -Form submissions, login, registration

---

##  Advanced (Project Based)

- How does subscription flow work?
- User logs in → The system authenticates the user.

User views available packs → Controller fetches all SkillPack entries from the database and passes them to the JSP view.

User selects a plan → Clicking “Subscribe” sends a request with userId and packId.

Backend processes subscription → A Subscription entity is created linking the user and the chosen pack.

Data saved in DB → The subscription record is stored, confirming the user’s enrollment.

 This ensures only registered users can subscribe to a skill pack.
 
- How do you link User and SkillPack?
- You create a Subscription entity that connects both:
- A User can subscribe to multiple packs.

A Pack can be subscribed to by multiple users.

The Subscription table acts as the bridge.

- Why do we use Service layer?
- The Service layer contains the business logic of the application.

Benefits:

Keeps controllers clean (controllers only handle requests/responses).

Centralizes rules (e.g., “a user cannot subscribe twice to the same pack”).

Easier to test independently.

Improves maintainability by separating concerns.

 Without it, controllers would become bloated and harder to manage.
- How does JSP get data from Controller?
- In Spring MVC:

Controller adds data to the Model:
DispatcherServlet forwards the request to the JSP view.

JSP uses JSTL (<c:forEach>) or EL (${packs}) to display the data.
