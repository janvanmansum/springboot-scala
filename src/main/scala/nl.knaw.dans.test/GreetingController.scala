package nl.knaw.dans.test

import java.util.concurrent.atomic.AtomicLong

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.{ RequestMapping, RequestParam, RestController }

@RestController
class GreetingController(@Value("${template}") val defaultTemplate: String) {
  val counter = new AtomicLong()

  // Attention! Do not forget the equals sign before the function body! Otherwise the method will
  // return Unit and nothing will be printed (but now exception either). Better yet to always include
  // the return type for these methods!
  @RequestMapping(Array("/greeting"))
  def greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting = {
    new Greeting(counter.incrementAndGet(), String.format(defaultTemplate, name))
  }
}
