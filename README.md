# Propelio
A backend springboot real estate application.


# Features
* User registration, authentication and token validation with JWT authentication.
* Password encryption using BCrypt.
* Role based authorisation with spring security.
* Add, remove, modify properties based on roles

# Technologies
* Java Springboot 3.3
* Spring security.
* Maven.
* JSON web tokens (JWT).
* BCrypt.
* MySQL

# Getting Started

 To get started with this project, you will need to have the following installed on your local machine:

   * JDK 17+
   * Maven 3+

To build and run the project, follow these steps:

   * Clone the repository: git clone https://github.com/EkeneU/Propelio.git
   * Navigate to the project directory: cd Propelio
   * Add database property_search_db to mySQL workbench
   * Build the project: mvn clean install
   * Run the project: mvn spring-boot:run

-> The application will be available at http://localhost:6060.





# Available endpoints.

## User Authentication 

   Regsiter a user
 * http://localhost:6060/propertytechsecurity/api/auth/register


   Generate a token
 * http://localhost:6060/propertytechsecurity/api/auth/token


    Validate a token
 * http://localhost:6060/propertytechsecurity/api/auth/validate


## Property Search


   Search for a group of properties
 * http://localhost:6060/propertytechsearch/api/properties/property

    Add a property
 * http://localhost:6060/propertytechsearch/api/properties/a/property

   Update a property listing
 * http://localhost:6060/propertytechsearch/api/properties/u/property

   Delete a property listing
 * http://localhost:6060/propertytechsearch/api/properties/d/property

   Custom search based on users and income
 * http://localhost:6060/propertytechsearch/api/users/search?first_name={}&income_bracket={}


## Landing Page

   Get all features
* http://localhost:6060/propelio/api/content/features
  
   Get all blogs
* http://localhost:6060/propelio/api/content/blogs
  
   Add a feature
* http://localhost:6060/propelio/api/content/feature
  
   Add a blogpost
* http://localost:6060/propelio/api/content/blogpost
  
  Update a feature
* http://localhost:6060/propelio/api/content/u/feature
  
  Update a blogpost
* http://localhost:6060/propelio/api/content/u/blogpost
  
  Delete a feature
* http://localhost:6060/propelio/api/content/i/feature
  
  Delete a blogpost
* http://localhost:6060/propelio/api/content/i/blogpost
