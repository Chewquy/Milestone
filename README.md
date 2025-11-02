## Project Description
This Spring Boot application manages a database of movies and screenings.  
It supports full CRUD operations through RESTful HTTP endpoints, allowing users to create, read, update, and delete movie and screening records.

## How to Run Locally
1. Clone or download the project.  
2. Open it in IntelliJ IDEA or any other IDE that supports Spring Boot.  
3. Run the main application class (usually `Application.java`).  
4. Once running, the API will be available at `http://localhost:8080`.  
5. Use Postman or any API client to test the endpoints and perform CRUD operations on movies and screenings.


### Movies
| Method | Endpoint                  | Description                         | Request Body             | Response                          |
|--------|---------------------------|-------------------------------------|--------------------------|-----------------------------------|
| GET    | `/movies`                 | Get all movies                      | None                     | List of all movies                |
| GET    | `/movies/{id}`            | Get a movie by its ID               | None                     | Movie object                      |
| POST   | `/movies`                 | Create a new movie                  | JSON with movie details  | Created movie                     |
| PUT    | `/movies/{id}`            | Update an existing movie            | JSON with updated fields | Updated movie                     |
| DELETE | `/movies/{id}`            | Delete a movie                      | None                     | Success message                   |
| GET    | `/movies/{id}/screenings` | Get screenings for a specific movie | None                     | List of screenings for that movie |

### Screenings
| Method | Endpoint           | Description                  | Request Body                | Response           |
|--------|--------------------|------------------------------|-----------------------------|--------------------|
| GET    | `/screenings`      | Get all screenings           | None                        | List of screenings |
| GET    | `/screenings/{id}` | Get a screening by its ID    | None                        | Screening object   |
| POST   | `/screenings`      | Create a new screening       | JSON with screening details | Created screening  |
| PUT    | `/screenings/{id}` | Update an existing screening | JSON with updated fields    | Updated screening  |
| DELETE | `/screenings/{id}` | Delete a screening           | None                        | Success message    |


Sample :
# Get all movies
curl -X GET http://localhost:8080/movies

# Create a new movie
curl -X POST http://localhost:8080/movies \
  -H "Content-Type: application/json" \
  -d '{"title": "Inception", "director": "Christopher Nolan", "year": 2010}'

Deployement:
Locally : Local: http://localhost:8080

No authentication required.
