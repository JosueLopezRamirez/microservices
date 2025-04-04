# Spring Boot Microservices Project

This project demonstrates a microservices architecture built using Spring Boot. It includes a set of independent services that communicate with each other using REST and service discovery, and are routed through an API Gateway.

## 🧱 Microservices Overview

- **API Gateway (`api-gateway`)**: Acts as the single entry point for all client requests. It handles routing, filtering, and load balancing using Spring Cloud Gateway.

- **Discovery Server (`discovery-server`)**: Service registry built with Netflix Eureka. All other services register with the discovery server to enable service-to-service communication.

- **Product Service (`product-service`)**: Manages product-related operations such as adding, updating, and retrieving product details.

- **Order Service (`orders-service`)**: Handles order processing, including creating and managing customer orders.

- **Inventory Service (`inventory-service`)**: Manages inventory and stock level checks, ensuring product availability before an order is placed.

---

## 🧩 Architecture


Each service is registered with the Eureka Discovery Server. The API Gateway routes incoming requests to the appropriate service using service discovery.

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker (for databases or containerized deployment)
- Spring Boot CLI (optional)

### Running the Services

Each service is a Spring Boot application and can be started independently. You can run them using your IDE or the command line.

   ```bash
   cd discovery-server
   mvn spring-boot:run

   cd api-gateway
   mvn spring-boot:run

  cd product-service
  mvn spring-boot:run

  cd inventory-service
  mvn spring-boot:run

  cd orders-service
  mvn spring-boot:run
   ```

## 📁 Folder Structure

      spring-boot-microservices/
      │
      ├── api-gateway/
      ├── discovery-server/
      ├── product-service/
      ├── orders-service/
      └── inventory-service/

