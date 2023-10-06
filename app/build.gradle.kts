plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.connectandpairwithlink_os"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.connectandpairwithlink_os"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("META-INF/LICENSE.txt")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/DEPENDENCIES")
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs\\jackson-core-2.2.3.jar"))
    implementation(files("libs\\snmp6_1z.jar"))
    implementation(files("libs\\opencsv-2.2.jar"))
    implementation(files("libs\\commons-lang3-3.4.jar"))
    implementation(files("libs\\core-1.53.0.0.jar"))
    implementation(files("libs\\commons-net-3.1.jar"))
    implementation(files("libs\\commons-validator-1.4.0.jar"))
    implementation(files("libs\\httpmime-4.3.2.jar"))
    implementation(files("libs\\jackson-annotations-2.2.3.jar"))
    implementation(files("libs\\commons-io-2.2.jar"))
    implementation(files("libs\\prov-1.53.0.0.jar"))
    implementation(files("libs\\ZSDK_ANDROID_API.jar"))
    implementation(files("libs\\pkix-1.53.0.0.jar"))
    implementation(files("libs\\httpcore-4.3.1.jar"))
    implementation(files("libs\\jackson-databind-2.2.3.jar"))
    implementation(files("libs\\ZSDK_ANDROID_BTLE.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}