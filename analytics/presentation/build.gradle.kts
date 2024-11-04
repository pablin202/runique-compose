plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.pdm.runique.analytics.presentation"
}

dependencies {
    implementation(projects.analytics.domain)
}