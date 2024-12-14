
# Feature Toggle

This is a Spring Boot project demonstrating a feature toggle mechanism. Based on the `propriedade` value in the database table `VEICULO`, the application routes the requests to different controllers.

## How It Works

The application checks the value of the `propriedade` column in the `VEICULO` table. Based on the value, it routes the request to the appropriate controller:

- **Table: `VEICULO`**
    - Column: `propriedade`
    - Possible Values:
        - `carro` → Routes to `CarController`
        - `moto` → Routes to `BikeController`
        - `jetski` → Routes to `JetSkiController`

## How to Run the Application

1. **Build and Run**
    - Ensure you have Java 11 installed.
    - Use Maven to build and run the project:
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```

2. **Database Access**
    - The application uses an H2 in-memory database.
    - H2 Console is available at: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - Use the following credentials to log in:
        - **JDBC URL:** `jdbc:h2:mem:veiculosdb`
        - **Username:** `sa`
        - **Password:** _(leave blank)_

## API Endpoints

The routing depends on the value in the `VEICULO` table:

1. **Update the Table**
    - Access the H2 Console and modify the table:
      ```sql
      UPDATE VEICULO SET propriedade = 'carro'; -- To route to CarController
      UPDATE VEICULO SET propriedade = 'moto'; -- To route to BikeController
      UPDATE VEICULO SET propriedade = 'jetski'; -- To route to JetSkiController
      ```

2. **Test the API**
    - Use tools like `curl` or Postman to test the root endpoint:
      ```bash
      curl http://localhost:8080
      ```
    - The response will vary based on the `propriedade` value:
        - `carro` → `"Car Controller"`
        - `moto` → `"Bike Controller"`
        - `jetski` → `"Jet Ski Controller"`

## Project Structure

- **Controller Layer**: Contains endpoints for `CarController`, `BikeController`, and `JetSkiController`.
- **Service Layer**: Retrieves the `propriedade` value from the database.
- **Interceptor**: Routes the request to the appropriate controller based on the `propriedade` value.

