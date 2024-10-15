plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.tp_star"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tp_star"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Utilisation de Java 17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17" // Utilisation de JVM 17
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // androidx-core-ktx
    implementation(libs.androidx.appcompat) // androidx-appcompat
    implementation(libs.material) // material
    implementation(libs.androidx.activity) // androidx-activity
    implementation(libs.androidx.constraintlayout) // androidx-constraintlayout

    // Ajout des dépendances nécessaires pour CircleImageView et Glide
    implementation(libs.circleimageview) // CircleImageView
    implementation(libs.glide) // Glide
    annotationProcessor(libs.compiler) // Glide compiler
    implementation(libs.glide)
    annotationProcessor(libs.compiler)


    // Dépendances pour les tests
    testImplementation(libs.junit) // junit
    androidTestImplementation(libs.androidx.junit) // androidx-junit
    androidTestImplementation(libs.androidx.espresso.core) // androidx-espresso-core
}
