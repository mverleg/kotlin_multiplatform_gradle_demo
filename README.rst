
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


