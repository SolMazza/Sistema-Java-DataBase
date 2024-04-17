plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.h2database:h2:2.1.214")
    implementation ("org.eclipse.persistence:javax.persistence:2.0.0")
    implementation ("org.hibernate:hibernate-entitymanager:4.2.8.Final")
}

tasks.test {
    useJUnitPlatform()
}