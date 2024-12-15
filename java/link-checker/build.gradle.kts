plugins {
    id("java")
    id("org.springframework.boot") version "3.3.3"
}

apply(plugin = "io.spring.dependency-management")

group = "au.com.treeshake"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.yaml:snakeyaml:2.3")
    implementation("org.springframework.boot:spring-boot:3.3.3")
    implementation("org.springframework:spring-web:6.1.12")
    implementation("org.springframework.boot:spring-boot-starter-logging:3.3.3")
    implementation("org.jsoup:jsoup:1.18.1")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")
}
