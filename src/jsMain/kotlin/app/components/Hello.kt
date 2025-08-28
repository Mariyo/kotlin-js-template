package app.components

import lib.react.el

val Hello: (dynamic) -> dynamic = { props ->
    val name = (props?.name as? String) ?: "world"
    el(
        "h1",
        js("({ style: { color: 'red' } })"),
        "Hello, $name!"
    )
}