# Demo SpringBoot Application for DIO Lab Project Patterns

This project is a Spring Boot application developed as a demo for the Digital Innovation One (DIO) Lab Project on Design Patterns. It provides RESTful endpoints to retrieve geographical coordinates for cities and calculate the distance between a given city and the current location of the International Space Station (ISS).

### Project Features

-   **City Information Endpoint:** Retrieves geographical coordinates for a given city and caches results in an in-memory database (H2).
-   **ISS Location Endpoint:** Provides the current location of the ISS.
-   **Distance Calculation:** Calculates the distance between a given city and the current ISS position.
----------

## Overview

This project demonstrates API integration, caching, and distance calculation using RESTful services. The endpoints leverage the following external APIs:

-   **Nominatim (OpenStreetMap):** Provides geolocation data for cities.
-   **OpenNotify ISS API:** Supplies real-time coordinates for the ISS.

## Endpoints

### 1. **GET /city/{cityName}**

-   Retrieves coordinates and details for a specified city from the [Nominatim OpenStreetMap API](https://nominatim.openstreetmap.org/search).
-   Caches the response in an H2 in-memory database to minimize external API calls.

**Example Request:**

    GET /city/Curitiba
    
**Example Response:**

    {
        "message":"Success",
        "status_code":200,
        "city_data":{
            "latitude":-25.4295963,
            "longitude":-49.2712724,
            "name":"Curitiba",
            "city_id":1,
            "display_name":"Curitiba, Região Geográfica Imediata de Curitiba, Região Metropolitana de Curitiba, Região Geográfica Intermediária de Curitiba, Paraná, Região Sul, Brasil",
            "bb_latitude_1":-25.6435043,
            "bb_latitude_2":-25.3450768,
            "bb_longitude_1":-49.38914,
            "bb_longitude_2":-49.1843182
        }
    }

### 2. **GET /iss**

-   Returns the current geographical location of the ISS using the OpenNotify ISS API.

**Example Request:**

    GET /iss
    
**Example Response:**

    {
        "latitude": 10.34567,
        "longitude": -50.98765,
        "timestamp": 1670450820
    }

### 2. **GET /iss/{cityName}**

-   Retrieves the coordinates of the specified city from the OpenStreetMap API and the ISS's current location, then calculates the distance between the two.
-   Distance is provided in kilometers, miles, and nautical miles.

**Example Request:**

    GET /iss/Curitiba
    
**Example Response:**

    {
        "message":"Success",
        "status_code":200,
        "city_data":{
            "latitude":-25.4295963,
            "longitude":-49.2712724,
            "name":"Curitiba",
            "city_id":1,
            "display_name":"Curitiba, Região Geográfica Imediata de Curitiba, Região Metropolitana de Curitiba, Região Geográfica Intermediária de Curitiba, Paraná, Região Sul, Brasil",
            "bb_latitude_1":-25.6435043,
            "bb_latitude_2":-25.3450768,
            "bb_longitude_1":-49.38914,
            "bb_longitude_2":-49.1843182
        },
        "current_iss_distance_km":9161.907383234657,
        "current_iss_distance_mi":5692.943552627902,
        "current_iss_distance_nm":4947.036024929235
    }
    

## Setup

### Prerequisites

-   **JDK 17**: Ensure JDK 17 is installed.

### Installation

1.  **Clone the Repository:**

      `git clone https://github.com/hstr0100/dio-lab-padroes-projeto-spring.git`
      `cd dio-lab-padroes-projeto-spring`

2.  **Install Dependencies:**

      `./mvwd clean install`

3.  **Run the Application:**

      `./mvwd spring-boot:run`

4.  **Access Endpoints:**

      `Application will run by default at http://localhost:8080.`

