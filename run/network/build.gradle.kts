plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jvm.ktor)
}

android {
    namespace = "com.pdm.runique.run.network"
    compileSdk = 34
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}