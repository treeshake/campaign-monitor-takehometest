# Changes (16/12/2024)

- Used `unknown` type for various Q2-Q4. Provide additional params checking and improvements error handling
- Q2 - Used positive divisor pairs (optimisation)
- Q3 - Check sides of triangle are valid
- Q2-Q4 - Improved error handling, added additional unit tests 
- Q5/Q6 - Fixed SQL syntax errors
- Q7 - Refactored concerns into separate classes, added caching capabilities

# Java notes

## Invoking the cache.

There is now caching within the app. To demonstrate this, there is an artificial delay introduced when making the `http` request. 

### Triggering the cache

The cache will be populated following the first time the app is run to store the results of any URLs retrieved inside the `cache` folder as a `serialized` object. 

On app startup/restart, it will read and return results from the cache for subsequent runs. 
It is also possible to change some of the links inside `page.html` to demonstrate that the cache is working.Removing the `.cache` file will effectively evict all entries from the cache. 

### Assumptions & design decisions

Time-based cache eviction is out of scope, therefore a proper cache provider is not used (Redis, Encache or others). The solution, however, still uses Spring's Caching api's `@Cacheable`, `@EnableCaching` and `SimpleCacheManager`. In theory, the current implementation can be swapped out easily to one of the above mentioned cache providers.

# Coding Take-home Test Questions

- Questions 1-4 & Question 7, Typescript/Javascript. Answers located under `javascript` folder.
- Questions 5-6, PostgreSQL. Answers located under `sql` folder
- Question 8 - Java. Answer located under `java` folder

## Environments

- Node version: *22.11.0*
- Java version: *22* (Language level 21)

Development environment: *macOS*

# Build/test

```
cd javascript
npm i
npm run build
npm run tests
```

```
cd java
./gradlew bootRun
```