# Algorithms and Computational Methods Laboratory Work Project

This repository contains the code for my laboratory work project in Algorithms and Computational Methods course. 
The project is a web application built with Java Spring Boot, Thymeleaf, and Bootstrap that implements various 
algorithms and computational methods and allows users to visualize and analyzing their performance.

## Requirements

To run the code in this repository, you will need:

- Java 11 or later

## Installation

1. Clone the repository: `git clone https://github.com/your_username/your_project.git`
2. Navigate to the project directory: `cd your_project`
3. Install the required dependencies: `mvn install`

## Usage

To run the project, use the following command: `mvn spring-boot:run`. Once the server is up and running, you can access the application in your web browser at `http://localhost:8080/`.
Also you can access the application in your web browser at [`https://acm-lab.herokuapp.com/`](https://acm-lab.herokuapp.com/)

The application allows users to select an algorithm or computational method from a list and input any necessary parameters. The user can then run the algorithm and visualize the results on the webpage.

The `src/main/java` directory contains the Java source code for the application, including the controller, service, and repository classes. The `src/main/resources/templates` directory contains the Thymeleaf templates for rendering the HTML pages, while the `src/main/resources/static` directory contains the static assets (such as CSS and JavaScript files) for the application.

The `pom.xml` file contains the project dependencies and configuration.

## Contributing

If you find a bug or want to suggest an improvement, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE), which allows for free use, modification, and distribution of the code, with no warranty or liability.
