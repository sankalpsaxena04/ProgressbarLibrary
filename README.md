<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Animated circular progress bar library for Android using Jetpack Compose with XML support. Customizable, lightweight, gradient-supported, and easy to integrate.">
    <meta name="keywords" content="Android, Circular Progress Bar, Jetpack Compose, XML integration, Android UI, Compose Progress, Android UI component, Gradient ProgressBar, Kotlin Android Library">
    <meta name="author" content="Your Name or GitHub Handle">
    <meta property="og:title" content="Android Circular Progress Bar Library – Jetpack Compose + XML">
    <meta property="og:description" content="Beautiful and animated circular progress bar for Android built with Jetpack Compose and easy XML integration.">
    <meta property="og:image" content="demo.gif">
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://github.com/yourname/yourlibrary">
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:title" content="Android Circular Progress Bar Library">
    <meta name="twitter:description" content="A customizable animated progress bar with Jetpack Compose + XML support. Perfect for Android apps.">
    <meta name="twitter:image" content="demo.gif">
    
</head>
<body>
    <header>
        <h1>🔵 Android Circular Progress Bar Library</h1>
        <p>
            A modern and customizable <strong>circular progress bar</strong> component for Android apps, built using <strong>Jetpack Compose</strong> and designed for <strong>easy XML integration</strong>. Add beautiful and animated progress indicators to your Android UI in just a few lines of code.
        </p>
    </header>
    <section class="highlight">
        <strong>Key Features:</strong>
        <ul>
            <li>🎯 Jetpack Compose powered circular animation</li>
            <li>🎨 Gradient color support (start-to-end)</li>
            <li>🧩 Easy XML and Compose integration</li>
            <li>⚡ Smooth percentage-based animation</li>
            <li>💎 Lightweight, reusable, and customizable</li>
        </ul>
    </section>
    <section>
        <h2>📦 Installation</h2>
        <p>Add this to your <code>build.gradle.kts</code>:</p>
        <pre><code>
dependencies {
    implementation("com.github.sankalpsaxena04:ProgressbarLibrary:cpb-2.0")
}
        </code></pre>
    </section>
    <section>
        <h2>🧑‍💻 Usage</h2>
        <h3>Jetpack Compose</h3>
        <pre><code>
@Composable
fun ExampleCircularBar() {
    CircularProgressbar(
    modifier= Modifier.size(200.dp),
    cpbarThickness=8.dp,
    completedPercentage= 30.0,
    backgroundColor= Color.Transparent,
    progressbarGradientColors = listOf(Color(0, 0, 255), Color(0, 255, 0), Color(0, 0, 255)),
    percentageVisibility= true,
    title="Test",
    titleVisibility = true
)
}
        </code></pre>
        <h3>XML Layout</h3>
        <p>Embed it in your existing XML layout:</p>
        <pre><code>
&lt;com.yourpackage.CircularProgressView
    android:id="@+id/progressBar"
    android:layout_width="200dp"
    android:layout_height="200dp"
    app:percentage="0.75"
    app:startColor="#FF5722"
    app:endColor="#FFC107"
    app:strokeWidth="12dp"
    app:animationDuration="1000" /&gt;
        </code></pre>
    </section>
    <section>
        <h2>⚙️ Customization</h2>
        <ul>
            <li><strong>percentage</strong>: sets the progress (0 to 100)</li>
            <li><strong>startColor</strong>, <strong>endColor</strong>: for gradient effect</li>
            <li><strong>strokeWidth</strong>: defines the thickness of the progress arc</li>
        </ul>
    </section>
   <section>
        <h2>📗 Documentation</h2>
        <p>
            Full documentation is available in the <a href="https://github.com/sankalpsaxena04/ProgressbarLibrary/releases" target="_blank">Release section</a> of this repository.
        </p>
    </section>
    <section>
        <h2>💬 Support & Contribution</h2>
        <p>
            Found a bug or want a feature? Create an issue or submit a pull request. Contributions are welcome!
        </p>
    </section>
    <footer>
        <h2>📄 License</h2>
        <p>
            Licensed under the MIT License. Free for personal and commercial use.
        </p>
    </footer>

</body>
</html>
