package app

import app.components.Hello
import lib.react.el

val App: (dynamic) -> dynamic = {
    el(
        "div",
        js("({ style: { fontFamily: 'system-ui, sans-serif', padding: '16px' } })"),
        el(Hello, js("({ name: 'from a component' })")),
        el("p", null, "This is a minimal Kotlin/JS + React template.")
    )
}