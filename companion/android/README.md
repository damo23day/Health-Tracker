# Health Tracker Helper — TASK 001

Minimal personal Android helper for testing the notification-to-ChatGPT workflow.

## Scope
This APK does not process health data. ChatGPT remains the Health Tracker intelligence and GitHub workflow. TASK 001 only proves:

`Health Tracker notification -> Update Health Tracker -> ChatGPT`

## Build
The easiest build path is the repository GitHub Actions workflow `.github/workflows/health-tracker-android.yml`. It installs JDK 17, Android SDK 35 and Gradle 8.13, builds the debug APK and uploads `health-tracker-helper-debug-apk` as an artifact.

For a local Android Studio build, use JDK 17, Android SDK Platform 35 and Build Tools 35.0.0, then build the `app` debug variant. If Gradle 8.13 is installed locally, from this directory run:

```sh
gradle :app:assembleDebug
```

Expected APK: `app/build/outputs/apk/debug/app-debug.apk`.

## Install and test
Install the official ChatGPT app in the same Android profile and sign in. Install the debug APK, open **Health Tracker Helper**, tap **Send Test Notification**, and allow notifications if prompted.

Expand **Health Tracker Update** and press **Update Health Tracker**. Record where ChatGPT opens and how many taps remain before you can dictate into the Health Tracker Project/chat.

## Routing
The helper uses Android's public `PackageManager.getLaunchIntentForPackage("com.openai.chatgpt")` and an immutable notification `PendingIntent`. No supported exact private Project/chat Android routing contract has been established, so the helper deliberately does not invent a deep-link format or use private APIs/UI automation.

TASK 001 must be tested on the real Samsung phone before expanding scope.
