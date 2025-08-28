package lib.react

import org.w3c.dom.Element

@JsModule("react")
@JsNonModule
@JsName("default")
external val React: dynamic

@JsModule("react-dom/client")
@JsNonModule
external object ReactDOMClient {
    fun createRoot(container: Element): ReactRoot
}

external interface ReactRoot {
    fun render(element: dynamic)
}

fun el(type: dynamic, props: dynamic = null, vararg children: dynamic): dynamic {
    val args = arrayOf<dynamic>(type, props, *children)
    return (React.createElement).apply(null, args)
}
