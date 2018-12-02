package nl.knaw.dans.test

import org.springframework.boot.autoconfigure.{ EnableAutoConfiguration, SpringBootApplication }
import org.springframework.boot.SpringApplication

/*
 * Attention! A class and a companion object are needed here. The annotation has to be added to the class
 * and the object extends App, so that an explicit main method is not necessary.
 */

@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application], args:_*)
}
