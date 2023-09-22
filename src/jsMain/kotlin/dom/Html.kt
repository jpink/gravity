package dom

import kotlinx.browser.document
import org.w3c.dom.HTMLBodyElement

fun <R> body(builder: HTMLBodyElement.() -> R) = builder.invoke(document.body!! as HTMLBodyElement)
