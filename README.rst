
Example of using Gradle sub-projects together with Kotlin multi-platform support
=======================================================================================

This project is an example of one way to set up a multi-platform Kotlin project separated into Gradle submodules.

The code itself is super simple, with just a platform-dependent method (expect/actual).

To run the code::

    gradle run

This should show (between a bunch of Gradle stuff)::

    Hello from JVM
    Hello from Javascript

More info
-------------------------------

Inspiration from:

* Trying a lot (way more than I'd have liked).
* This page of documentation https://kotlinlang.org/docs/reference/multiplatform.html
* Some ideas from Kluent https://github.com/MarkusAmshove/Kluent
* Some ideas from this example https://github.com/MarcinMoskala/KotlinAcademyApp
* See also StackOverflow https://stackoverflow.com/questions/48194556/use-gradle-sub-projects-with-kotlin-multiplatform

These paragraphs from the documentation may be useful:

    A multiplatform project consists of three types of modules:

    * A common module contains code that is not specific to any platform, as well as declarations without implementation of platform-dependent APIs. Those declarations allow common code to depend on platform-specific implementations.
    * A platform module contains implementations of platform-dependent declarations in the common module for a specific platform, as well as other platform-dependent code. A platform module is always an implementation of a single common module.
    * A regular module. Such modules target a specific platform and can either be dependencies of platform modules or depend on platform modules.

    A common module can depend only on other common modules and libraries, including the common version of the Kotlin standard library (kotlin-stdlib-common). Common modules contain only Kotlin code, and not code in any other languages.

    A platform module can depend on any modules and libraries available on the given platform (including Java libraries in case of Kotlin/JVM and JS libraries for Kotlin/JS). Platform modules targeting Kotlin/JVM can also contain code in Java and other JVM languages.


