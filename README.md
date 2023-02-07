# 🧒Rick-and-Morty-app🧒
___
## 📄Short description
___Rick and Morty app___ - it is a java web application that use Hibernate and Spring frameworks.
___
### 📑Full Description📑
Application can parse from open [API](https://rickandmortyapi.com/documentation/#getallcharacters) and save episodes, characters and locations to db. 
Application can find all and return as json objects all characters founded by name by certain endpoint.
Also, application generate random wiki for character by certain endpoint
### 🛠Available endpoints🛠
___**General endpoint**___ - /movie/rick-and-morty
+ GET: GN + /sync - **for sync all or certain type**</br>
**Example:** GN + /sync/all ___(by default)___</br>
**Example:** GN + /sync/characters</br>
**Example:** GN + /sync/locations</br>
**Example:** /GN + /sync/episodes</br>
+ GET: GN + /character/random </br> - **for generate random wiki**
+ GET: GN + /find-by-name/{name}  <br /> - **for find all characters that have this name**
+ ### Technologies used

| Technology  | Version  |
|-------------|----------|
| JDK         | 17       |
| Spring boot | 3.0.2    |
| Spring Web  | EMBEDDED |
| TomCat      | EMBEDDED |
| Hibernate   | EMBEDDED |
| Maven       | 4.0.0    |
| PostgreSQL  | 6.15     |

### 💻🛠Local set up tutorial💻🛠
1. Fork and open this project
2. Set your properties in  [application.properties](src/main/resources/application.properties) file
3. Run
