Coding Take-home Test Questions

- Questions 1-4 & Question 7, Typescript/Javascript. Answers located under `javascript` folder.
- Questions 5-6, PostgreSQL. Answers located under `sql` folder
- Question 8 - Java. Answer located under `java` folder

Node version: *22.11.0*

Build/test

```
cd javascript
npm i
npm run build
npm run tests
```

Example output:

```
➜  javascript git:(main) ✗ npm run tests

> campaign-monitor-js@1.0.0 tests
> jest

 PASS  src/question-7-arrange-by.test.ts
 PASS  src/question-3-area-triangle.test.ts
 PASS  src/question-1-null-or-empty.test.ts
 PASS  src/question-4-most-common.test.ts
 PASS  src/question-2-positive-divisors.test.ts

Test Suites: 5 passed, 5 total
Tests:       18 passed, 18 total
Snapshots:   0 total
Time:        0.336 s, estimated 1 s
Ran all test suites.

```

Java: JRE: *openjdk-22, Language-level: 21*
Build/run

Example outputs

```
2:22:50 am: Executing ':Application.main()'...

> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE

> Task :Application.main()

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.3)

2024-12-02 02:22:51,147 INFO  [main] au.com.treeshake.linkchecker.Application : Starting Application using Java 22 with PID 23318 (/Users/dng/development/campaign-monitor/java/link-checker/build/classes/java/main started by dng in /Users/dng/development/campaign-monitor/java/link-checker)
2024-12-02 02:22:51,148 INFO  [main] au.com.treeshake.linkchecker.Application : No active profile set, falling back to 1 default profile: "default"
2024-12-02 02:22:51,252 INFO  [main] au.com.treeshake.linkchecker.Application : Started Application in 0.277 seconds (process running for 0.438)
2024-12-02 02:22:51,254 INFO  [main] au.com.treeshake.linkchecker.LinkCheckerService : Extracting links from file: page.html
2024-12-02 02:22:51,280 INFO  [main] org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor : No task executor bean found for async processing: no bean of type TaskExecutor and no bean named 'taskExecutor' either
2024-12-02 02:22:51,282 INFO  [SimpleAsyncTaskExecutor-1] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://example.com', status=null}
2024-12-02 02:22:51,282 INFO  [SimpleAsyncTaskExecutor-2] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://randomuser.me', status=null}
2024-12-02 02:22:51,282 INFO  [SimpleAsyncTaskExecutor-3] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://unsplash.com', status=null}
2024-12-02 02:22:51,282 INFO  [SimpleAsyncTaskExecutor-4] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.wikipedia.org', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-5] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.reddit.com', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-6] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.github.com', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-7] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.stackoverflow.com', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-8] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.medium.com', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-9] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.quora.com', status=null}
2024-12-02 02:22:51,283 INFO  [SimpleAsyncTaskExecutor-10] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.bbc.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-11] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.nytimes.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-12] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.cnn.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-13] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.weather.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-14] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.nationalgeographic.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-15] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.amazon.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-16] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.apple.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-17] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.spotify.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-18] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.ted.com', status=null}
2024-12-02 02:22:51,284 INFO  [SimpleAsyncTaskExecutor-19] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.blogger.com', status=null}
2024-12-02 02:22:51,285 INFO  [SimpleAsyncTaskExecutor-20] au.com.treeshake.linkchecker.LinkCheckerService : Started task: Link{url='https://www.yelp.com', status=null}
2024-12-02 02:22:51,875 INFO  [SimpleAsyncTaskExecutor-13] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.weather.com', status=301 MOVED_PERMANENTLY}
2024-12-02 02:22:51,875 INFO  [SimpleAsyncTaskExecutor-8] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.medium.com', status=301 MOVED_PERMANENTLY}
2024-12-02 02:22:51,875 INFO  [SimpleAsyncTaskExecutor-12] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.cnn.com', status=302 FOUND}
2024-12-02 02:22:51,875 INFO  [SimpleAsyncTaskExecutor-5] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.reddit.com', status=302 FOUND}
2024-12-02 02:22:51,882 INFO  [SimpleAsyncTaskExecutor-17] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.spotify.com', status=301 MOVED_PERMANENTLY}
2024-12-02 02:22:51,889 INFO  [SimpleAsyncTaskExecutor-6] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.github.com', status=301 MOVED_PERMANENTLY}
2024-12-02 02:22:52,081 INFO  [SimpleAsyncTaskExecutor-1] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://example.com', status=200 OK}
2024-12-02 02:22:52,223 INFO  [SimpleAsyncTaskExecutor-9] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.quora.com', status=200 OK}
2024-12-02 02:22:52,411 INFO  [SimpleAsyncTaskExecutor-7] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.stackoverflow.com', status=301 MOVED_PERMANENTLY}
2024-12-02 02:22:52,416 INFO  [SimpleAsyncTaskExecutor-2] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://randomuser.me', status=200 OK}
2024-12-02 02:22:52,614 INFO  [SimpleAsyncTaskExecutor-16] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.apple.com', status=200 OK}
2024-12-02 02:22:52,758 INFO  [SimpleAsyncTaskExecutor-15] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.amazon.com', status=503 SERVICE_UNAVAILABLE}
2024-12-02 02:22:52,782 INFO  [SimpleAsyncTaskExecutor-3] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://unsplash.com', status=200 OK}
2024-12-02 02:22:52,792 INFO  [SimpleAsyncTaskExecutor-19] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.blogger.com', status=302 FOUND}
2024-12-02 02:22:52,938 INFO  [SimpleAsyncTaskExecutor-18] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.ted.com', status=200 OK}
2024-12-02 02:22:53,124 INFO  [SimpleAsyncTaskExecutor-4] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.wikipedia.org', status=200 OK}
2024-12-02 02:22:53,137 INFO  [SimpleAsyncTaskExecutor-10] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.bbc.com', status=200 OK}
2024-12-02 02:22:53,300 INFO  [SimpleAsyncTaskExecutor-20] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.yelp.com', status=200 OK}
2024-12-02 02:22:53,646 INFO  [SimpleAsyncTaskExecutor-11] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.nytimes.com', status=200 OK}
2024-12-02 02:22:53,649 INFO  [SimpleAsyncTaskExecutor-14] au.com.treeshake.linkchecker.LinkCheckerService : Finished task: Link{url='https://www.nationalgeographic.com', status=200 OK}

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.10.2/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD SUCCESSFUL in 3s
3 actionable tasks: 1 executed, 2 up-to-date
2:22:54 am: Execution finished ':Application.main()'.

```

