CRUD API for Animal Objects
This REST API performs CRUD operations on Animal objects as described below.

Installation
Clone the project:

git clone (https://github.com/jahsiyahvarona/Individual-Assignment4_CRUD_API.git)

Open the project in IntelliJ or any preferred IDE.

Ensure the MySQL database is configured properly in the /src/main/resources/application.properties file:

The database name should be specified in the datasource.url property.
You must have the database up and running before executing the project:
Start your Apache server.
Start MySQL.
Ensure the necessary database is available.
Build and run the main class. You should see tables created in your specified database.

API Endpoints
Use POSTMAN or a similar tool to test the following endpoints:

Get list of Animals
Request:

GET /animals/all

Example:

http://localhost:8080/animals/all

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "species": "Panthera leo" },
  { "animalId": 2, "name": "Elephant", "species": "Loxodonta" }
]
Get a specific Animal
Request:

GET /animals/{animalId}

Example:

http://localhost:8080/animals/1

Response:

json
Copy code
{
  "animalId": 1,
  "name": "Lion",
  "species": "Panthera leo"
}
Create a new Animal
Request:

POST /animals/new

Example:

http://localhost:8080/animals/new

Request Body:

json
Copy code
{
  "name": "Giraffe",
  "species": "Giraffa camelopardalis"
}
Response:

json
Copy code
{
  "animalId": 3,
  "name": "Giraffe",
  "species": "Giraffa camelopardalis"
}
Get Animals by Species
Request:

GET /animals?species={species}

Example:

http://localhost:8080/animals?species=Panthera leo

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "species": "Panthera leo" }
]
Get Animals by Habitat
Request:

GET /animals/habitat/{habitat}

Example:

http://localhost:8080/animals/habitat/savannah

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "habitat": "savannah" }
]
Get Animals by Scientific Name
Request:

GET /animals/scientificName/{scientificName}

Example:

http://localhost:8080/animals/scientificName/Panthera leo

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "scientificName": "Panthera leo" }
]
Search Animals by Name Keyword
Request:

GET /animals/search?keyword={keyword}

Example:

http://localhost:8080/animals/search?keyword=Lion

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion" }
]
Update an existing Animal
Request:

PUT /animals/update/{animalId}

Example:

http://localhost:8080/animals/update/1

Request Body:

json
Copy code
{
  "name": "Updated Name",
  "species": "Updated Species"
}
Response:

json
Copy code
{
  "animalId": 1,
  "name": "Updated Name",
  "species": "Updated Species"
}
Delete an existing Animal
Request:

DELETE /animals/delete/{animalId}

Example:

http://localhost:8080/animals/delete/1

Response:

json
Copy code
{
  "animalId": 2,
  "name": "Elephant",
  "species": "Loxodonta"
}
Get Animals by Species with Default
Request:

GET /animals?species={species}

Example:

http://localhost:8080/animals?species=defaultSpecies

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "species": "Panthera leo" }
]
Get Animals by Habitat
Request:

GET /animals/habitat/{habitat}

Example:

http://localhost:8080/animals/habitat/{habitat}

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "habitat": "savannah" }
]
Get Animals by Scientific Name
Request:

GET /animals/scientificName/{scientificName}

Example:

http://localhost:8080/animals/scientificName/{scientificName}

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion", "scientificName": "Panthera leo" }
]
Search for Animals by Name Keyword
Request:

GET /animals/search?keyword={keyword}

Example:

http://localhost:8080/animals/search?keyword=Lion

Response:

json
Copy code
[
  { "animalId": 1, "name": "Lion" }
]
