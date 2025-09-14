# Brands API (Spring Boot Example)

This is a simple Spring Boot REST API for managing brands.

````
GET http://localhost:8080/api/v1/brands
[
    {
        "id": "b8b91a55-0d00-4e49-bf69-62333a6f4f97",
        "name": "LG"
    },
    {
        "id": "675b278e-32b7-4c7a-af00-69b9f73b1772",
        "name": "Apple"
    },
    {
        "id": "2d870aed-bbac-48c0-98cb-d25c1b10b45e",
        "name": "Nike"
    }
]
````

````
POST http://localhost:8080/api/v1/brands
{
  "name": "LG"
}
````