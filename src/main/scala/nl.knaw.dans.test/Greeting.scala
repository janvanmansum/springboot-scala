package nl.knaw.dans.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.{ Component, Repository }

import scala.beans.BeanProperty

/*
 * Attention! The JsonProperty annotation is not necessary. `val` makes the properties read-only.
 * If you need read-write properties, declare them as var. For longer lists the var with defaults
 * may be more readable, e.g.:
 *
 * ```
 * class G {
 *   @BeanProperty var id: Long = 0L
 *   @BeanProperty var content: String = ""
 * }
 * ```
 */

class Greeting(@BeanProperty val id: Long, @BeanProperty val content: String)
