package dom

import org.w3c.dom.Element

fun Element.setAttribute(name: String, value: Any) = setAttribute(name, value.toString())
fun Element.setAttributes(vararg pairs: Pair<String, Any>) = pairs.forEach { setAttribute(it.first, it.second) }