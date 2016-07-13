## Techdegree project 5
### Countries of the World with Spring
<hr>
### Table of Contents
### Installation instructions
* [Eclipse installation instructions.] (#eclipse)
<hr>

### Tasks
* [1.] (#task-1) Gather current, accurate information on the five countries 
    you’ll be including in your application. The information must include the 
    following:
    - Country name
    - Population
    - Capital city
    - Official language(s)
    - Image of flag
    
    <hr>
* [2.] (#task-2) In IntelliJ IDEA, create a Gradle project. Add all required 
    Spring dependencies, and create the directory and package structure of the 
    application. Save all static assets into the proper directory.
    <hr>
* [3.] (#task-3)  Write the application code, including a data repository 
    and controller. 
    <hr>
* [4.] (#task-4) Create the index view, which will serve as the homepage of the 
    application. This view must contain the following:
    - A list of the countries you’ve chosen
    - A small thumbnail image of each country’s flag next to its name
    - A clickable link to each country’s detail page 
       (could be the country name and/or flag image)
    
    <hr>
* [5.] (#task-5) Create the detail view. This view must contain all required 
    pieces of information for each country, presented in an easily-readable 
    fashion.
    <hr>
### Extra Credit    
* [6.] (#task-6) Add two ways of sorting the countries on the index page, 
    for example by country name and by population.
    <hr>
* [7.] (#task-7) Pick a country with at least two official languages. On its 
    detail page, render the languages as either an ordered or unordered list.
    <hr>
* [8.] (#task-8) In the repository class’s method for fetching a single 
    country object, use the streams API to filter the list of all countries 
    down to the one being requested.
<!--Links-->
### Eclipse Installation instructions
<hr> <a id="eclipse"></a>
    I generated necessary `.classpath`, `.project` and 
    `pt5-world-countries-spring.userlibraries`. NOTE: there is always a
    problem with sourcepath
    