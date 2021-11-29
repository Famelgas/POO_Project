plugins {
    java
    application
}

application {
    mainClass.set("Main")
}

souceSet {
    main {
        java {
            setScrDirs(listOf("src"))
        }
    }
}