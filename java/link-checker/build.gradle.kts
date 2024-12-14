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
    implementation("org.aspectj:aspectjrt:1.9.22.1")
    implementation("org.aspectj:aspectjweaver:1.9.22.1")
}
