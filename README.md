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

<!--External URLs-->
[spark-blog-readme]: 
    https://github.com/nikiforov-alexander/pt4-spark-blog#eclipse "Spark Blog README"
<!--Directories-->
[resources]: 
    src/main/resources "/src/main/resources"
[static]: 
    src/main/resources/static "/src/main/resources/static"
[templates]: 
    src/main/resources/templates "/src/main/resources/templates"
<!-- Files in static -->
[app.css]: 
    src/main/resources/static/app.css "src/main/resources/static/app.css"
[favicon.ico]: 
    src/main/resources/static/favicon.ico "src/main/resources/static/favicon.ico"
[flags]: 
    src/main/resources/static/flags "/src/main/resources/static/flags"
[layout.html]: 
    src/main/resources/templates/layout.html "/src/main/resources/templates/layout.html"
[index.html]: 
    src/main/resources/templates/index.html "/src/main/resources/templates/index.html"
[error.html]: 
    src/main/resources/templates/error.html "/src/main/resources/templates/error.html"
[country-details.html]: 
    src/main/resources/templates/country-details.html "/src/main/resources/templates/country-details.html"
<!--Dirs and files in source folders-->
[data]: 
    src/main/java/com/teamtreehouse/countries/data "src/main/java/com/teamtreehouse/countries/data"
[controller]: 
    src/main/java/com/teamtreehouse/countries/controller "src/main/java/com/teamtreehouse/countries/controller"
[CountryController]: 
    src/main/java/com/teamtreehouse/countries/controller/CountryController.java "src/main/java/com/teamtreehouse/countries/controller/CountryController.java"
[CountryRepository]: 
    src/main/java/com/teamtreehouse/countries/data/CountryRepository.java "src/main/java/com/teamtreehouse/countries/data/CountryRepository.java"
### Eclipse Installation instructions
<hr> <a id="eclipse"></a>
    I generated necessary `.classpath`, `.project` and 
    `pt5-world-countries-spring.userlibraries`. I tested it once again
    It worked. As always there is a problem with `BuildPath` in 
    `Eclipse`.
    So it is better to set `src/main/java` as a source in `BuildPath`
    options, if `Eclipse` does not understand it. Here is a link to old
    [Spark Blog README.md][spark-blog-readme] just in case. To run a 
    program `bootRun` task of `Gradle` is used.
<hr>
### Tasks
1. <a id="task-1"></a>
    Gather current, accurate information on the five countries you’ll 
    be including in your application. The information must include the 
    following:
    - Country name
    - Population
    - Capital city
    - Official language(s)
    - Image of flag
    
    <hr>
    All is done using Wikipedia pages
<hr>
2. <a id="task-2"></a>
    In IntelliJ IDEA, create a Gradle project. Add all required Spring 
    dependencies, and create the directory and package structure of 
    the application. Save all static assets into the proper directory.
    <hr>
    Dependencies added, static assets saved in [static] directory:
    - [app.css]. NOTE: changed css a bit to include sorting links, see
      [Task 6.] (#task-6)
    - [favicon.ico]
    - all flag images in [flags] sub-directory
    
    <hr>
3. <a id="task-3"></a>
   Write the application code, including a data repository and 
   controller. 
   <hr>
   Data repository is situated in [data] directory and 
   called [CountryRepository]. Controller is in [controller] directory
   and called [CountryController].
<hr>
4. <a id="task-4"></a> 
    Create the index view, which will serve as the homepage of the 
    application. This view must contain the following:
    - A list of the countries you’ve chosen
    - A small thumbnail image of each country’s flag next to its name
    - A clickable link to each country’s detail page 
       (could be the country name and/or flag image) 
       
    <hr>
    Home page is created as in template file. HTML thymeleaf template 
    file used to 
    build page is called [index.html]. It is situated in [templates] 
    directory, and uses [layout.html] file as a layout file. 
    In [CountryController] is mapped to `listCountries` method with
    URI "/".
    Two headers are added "Sort by
    Name" and "Sort by Population", that are clickable and are
    implemented to solve [Task 6.] (#task-6)
<hr>
5. <a id="task-5"></a> 
    Create the detail view. This view must contain all required 
    pieces of information for each country, presented in an easily-readable 
    fashion.
    <hr>
    Detail view is modeled exactly as in provided html files, except
    maybe small change in header. HTML 
    Thymeleaf template file used to build a page is called
    [country-details.html]. It uses [layout.html] and in 
    [CountryController] is mapped to `countryDetails` method with
    URI "/country/{id}/{slugFromName}". The URI is self-explanatory.
    `id` is used as unique identifier to facilitate possible future
    database implementation. `slugFromName` is used to easier 
    navigation for user. 
<hr>
### Extra Credit
6. <a id="task-6"></a> 
    Add two ways of sorting the countries on the index page, 
    for example by country name and by population.
    <hr>
    Two headers are added "Sort by
    Name" and "Sort by Population", that are clickable and generate
    upon clicking list of countries sorted by name and population
    accordingly. This GET request with query parameter is realized in
    `sortByParameter` in [CountryController]. URI responsible will
    look like "/?sort=name" or "/?sort=population".
<hr>
7. <a id="task-7"></a> 
    Pick a country with at least two official languages. On its 
    detail page, render the languages as either an ordered or unordered list.
    <hr>
    On a detail page, languages are rendered in unordered list. Click 
    page with India from home page: it is the only country with two
    languages.
<hr>
8. <a id="task-8"></a> 
    In the repository class’s method for fetching a single 
    country object, use the streams API to filter the list of all countries 
    down to the one being requested.
    <hr>
    `findById` method in [CountryRepository] is using stream API to fetch 
    country with given id.
<hr>
