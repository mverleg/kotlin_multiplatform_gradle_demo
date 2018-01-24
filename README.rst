
Example of using Gradle sub-projects together with Kotlin multi-platform support
=======================================================================================

This project is an example of one way to set up a multi-platform Kotlin project separated into Gradle submodules.

The code itself is super simple, with just a platform-dependent method (expect/actual).

To run the code::

    gradle wrapper
    ./gradlew run

Or to run only one platform (``jvm`` in this example)::

    ./gradlew -p alpha/alpha-jvm run

This should show (between a bunch of Gradle stuff)::

    Hello from JVM
    Hello from JS

To collect the Javascript files in ``build/js``, use the ``collectWeb`` task.

What I learned
-------------------------------

* Every 'normal' (common) module has one platform module for each platform.
* For common module ``alpha``, the javascript platform module must be called ``alpha-js`` (similar for ``-jvm``).
* If there is no platform specific code, this module can be just a gradle file in a directory.
* The platform modules can be conveniently placed inside of the common module directory (so ``alpha:alpha-js``).
* The common module should not refer to the platform modules; the platform modules have a dependency ``expectedBy project(":the_common_module")``.
* If module ``alpha`` depends on ``beta``, then

    * ``alpha`` must have ``dependencies { compile project(":beta") }``
    * ``alpha-js`` must have ``dependencies { compile project(":beta:beta-js") }`` (in addition to ``expectedBy``)
    * ``alpha-jvm`` must have ``dependencies { compile project(":beta:beta-jvm") }`` (in addition to ``expectedBy``) etc

* Only the top module has ``settings.gradle``, which includes ALL submodules (including platform ones).
* Make sure to get the names right, as incorrect ones don't cause an error, they just fail silently. (It seems ridiculous but I guess there is a reason.)
* Just because the build completes and creates jars does not mean it worked; the jar might only contain .kjsm and .kotlin_metadata files.
* This demo uses the top level ``build.gradle`` for coordinating submodules; the top level doesn't contain code or platforms.
* It's not hard to put shared functionality per level together at the top level (except ``buildscript`` which is inherited), possibly with one gradle file per platform.
* If you don't mind using string manipulation and adhering to a naming scheme (you have to anyway), you can specify the dependencies in ``dependencies.gradle`` and not repeat them for every platform.

Some errors and solutions
-------------------------------

* If you get ``Could not find method expectedBy() for arguments ...``, move the ``dependencies`` block lower in the file.
* If you get unresolved reference errors, make sure that the target module has a ``package`` statement, and check all the above.
* If you get npm errors, make sure the ``.npm`` directory for your system is writable.
* If you get ``e: No class roots are found in the JDK path: /usr/lib/jvm/java-9-openjdk-amd64`` or similar, set ``JAVA_HOME`` environment variable to where java 8 jdk is (for example ``/usr/lib/jvm/java-8-openjdk-amd64/``).
* If you get ``TypeError: Cannot read property 'config' of undefined``, probably qunit did not see your test file. Maybe there are no tests (should be caught by Gradle) or there is something wrong with the pattern (absolute paths don't work, for example).
* If you get ``Error: Cannot find module`` on JS tests, set ``NODE_PATH`` to the js dir, because imports aren't relative to the file of the current dir but only to path & node modules.
* If your jar file does not work because it does not contain .class files, make sure you're looking at the jvm platform project, not the common or javascript one.
* If the test code cannot find the main code on JVM, it could mean that you're trying to use a shared build directory for multiple projects, which leads to errors and non-determinism.
* If you get ``java.lang.NoClassDefFoundError``, this happens because of shared build dir (doing a clean build works too, but not a long-term solution). Adding hamcrest to dependencies does not work.
* If stuck on a problem for a long time, remove ``build``, ``gradle``, ``.gradle``, ``gradlew``, ``gradlew.bat`` and try again... (Yes, sage advice).

For the future
-------------------------------

* Make NPM faster (~1.5s even if already the correct version).
* Get errors when including non-existing submodules (Gradle strict mode?).
* Put platform projects in ``alpha:js`` instead of ``alpha:alpha-js`` (I tried but they couldn't see each other).
* Avoid having to make platform modules when there is no platform specific code.
* Stop IntelliJ IDEA from creating a lot of extra modules (or understand why it's useful) => fixed amount of 9 per module; I guess it's necessary.
* Try to get rid of ``w: Module "[...]-js" is defined in more than one file`` which is shown for all js modules.
* Try to get rid of ``w: Classpath entry points to a non-existent location: /home/mark/gradle_demo/alpha/build/classes/java/main``.
* Make the distribution into jvm, js and common modules not depend on the name.
* Remove any non-determinism, since it feels like the same build sometimes works and sometimes doesn't... (caching?) => some of this was due to using a single build file for all projects.
* Clearer error message when failing because a module has no tests

Tests
-------------------------------

Currently the tests just use ``kotlin.test``, and are ran by ``JUnit`` on JVM and ``QUnit`` in Javascript. They are included in ``./gradlew run``.

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


