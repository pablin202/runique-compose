plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.pdm.runique.auth.presentation"
    compileSdk = 34
}

dependencies {
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}