import app.App
import kotlinx.browser.document
import lib.react.React
import lib.react.ReactDOMClient

fun main() {
    val container = document.getElementById("root") ?: error("Missing #root element")
    val root = ReactDOMClient.createRoot(container)
    root.render(React.createElement(App, null))
}
