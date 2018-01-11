
Example of using Gradle sub-projects together with Kotlin multi-platform support
=======================================================================================

This project is an example of one way to set up a multi-platform Kotlin project separated into Gradle submodules.

The code itself is super simple, with just a platform-dependent method (expect/actual).

To run the code::

    gradle run

This should show (after a bunch of Gradle stuff)::

    Hello from JVM
    Hello from Javascript

Native is not yet supported because it's not mature enough yet.

Inspiration from:

* Trying a lot (way more than I'd have liked).
* Some ideas from Kluent https://github.com/MarkusAmshove/Kluent
* See also StackOverflow https://stackoverflow.com/questions/48194556/use-gradle-sub-projects-with-kotlin-multiplatform


