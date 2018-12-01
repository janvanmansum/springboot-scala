Spring Boot POC
===============

This project is a proof of concept for using Spring Boot as the basis for our
services. The results can later be used to create a new Maven archetype that
standardizes how we use this framework.


Application entry point
-----------------------
Had to find out how to implement this in Scala. After some hurdles this turns
out to be straightforward. See `nl.knaw.dans.test.Application`.


Configuration
-------------
Spring is very flexible in how to implement your configuration, almost too flexible.
This is really something to standardize within the team. Main points learned so far:

* With the `@Value` annotation you can have Spring inject values from the
  "environment".
* You can set this value in many ways, and there is a specific order in which these
  override each other. A good strategy seems:
  - Putting a defaults config in `src/main/resources/application.yml`.
  - Overriding this with `/etc/opt/dans.knaw.nl/module/application.yml` in the RPM.
    The service unit would then specify this as `--spring.config.location` on
    the command line (or as system property). This could be mostly comments
    similar to the default Tomcat or Apache HTTP config files.

Logging
-------
By default Spring Boot configures logging mostly as you would want it. Also, you can
customize it by setting values in the Spring environment. They determine to what file
to output the logging and the levels of the various loggers.

If you want to customize beyond that you need to provide your own logging config file,
which can be a logback.xml. Fortunately, you can include the defaults, so that you don't
have to redefine most of the stuff you do want. Somehow logger definitions defined are
ignored or overwritten, so you must use the spring environment to set your logging levels.

So far the only reason I can see to want to use a custom logback.xml is to add a journal
appender.
