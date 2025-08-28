# Kotlin JS Template

A minimal Kotlin/JS (Kotlin Multiplatform) browser template using Gradle Kotlin DSL. It sets up a Webpack dev server, includes an example entry point, and demonstrates how to add npm dependencies (React is included as an example).

## Features
- Kotlin 2.2.10 with Kotlin/JS target (browser)
- Webpack dev server configured to run on port 8010 with CSS support
- ES2015 JavaScript target
- Example `Main.kt` that manipulates the DOM
- Example npm dependency: `react@19.1.1`
- Gradle Wrapper included (no global Gradle install required)

## Getting Started

Clone the repository and move into the project directory, then build once to download dependencies:

```bash
./gradlew :kotlinNpmInstall
# or simply
./gradlew build
```

## Run (Development)
Start the Webpack dev server and open http://localhost:8010 in your browser:

```bash
./gradlew jsBrowserDevelopmentRun --continuous
```

- The dev server is configured in `build.gradle.kts` to use port `8010`.
- Hot reload/live reload is provided by Webpack.

## Build (Production)
Create an optimized production bundle:

```bash
./gradlew jsBrowserProductionWebpack
```

Artifacts are placed under `build/distributions/`. You can open the generated `.html` file there or serve the folder with any static server.

## Project Structure
- `src/jsMain/kotlin/Main.kt` — Kotlin entry point. Currently sets the document background to red.
- `src/jsMain/resources/index.html` — Base HTML page. It contains a `<div id="root"></div>` and includes the generated bundle script.
- `build.gradle.kts` — Kotlin/JS target configuration, Webpack dev server, dependencies.
- `settings.gradle.kts` — Root project settings and toolchain resolver plugin.
- `kotlin-js-store/` — Yarn lock and caches for Kotlin/JS npm integration (auto-managed).

## Customization
- Dev server port: change in `build.gradle.kts` under `browser { commonWebpackConfig { devServer = ... port = 8010 } }`.
- JavaScript target: `tasks.withType<KotlinJsCompile>().configureEach { compilerOptions { target = "es2015" } }`.
- NPM dependencies: add under `sourceSets { val jsMain by getting { dependencies { implementation(npm("pkg", "version")) } } }`.
- Application code: edit `src/jsMain/kotlin/Main.kt`. For React usage, you can add the Kotlin/JS React wrappers if needed.

## Troubleshooting
- If the browser does not load, ensure nothing else is running on port 8010.
- If Gradle cannot resolve Node/Yarn, try cleaning caches:
  ```bash
  ./gradlew clean
  rm -rf ~/.gradle/caches
  ```
- For Windows, use `gradlew.bat` instead of `./gradlew`.

## License
MIT (or update to your preferred license).
