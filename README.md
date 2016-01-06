# sfx

A lightweight set of _Scala_ wrappers for _JavaFX_.

# Motivation

_sfx_ was inspired by the excellent _[ScalaFX](http://www.scalafx.org/)_ project. Indeed, the original author of _sfx_
contributed to the _ScalaFX_ project before founding _sfx_.

So, why start another _Scala/JavaFX_ project? In our opinion, _ScalaFX_ suffers from a number of drawbacks, the primary
cause of which is a design decision to wrap a _JavaFX_ class instance as a _delegate_ inside an equivalent _ScalaFX_
class. For example:

```scala
class SomeScalaFXClass (delegate: SomeJavaFXClass) {...}
```

This has the following drawbacks:

1. The _ScalaFX_ version of the class must provide _wrappers_ for every single public member of its associated _JavaFX_
class. This is a boring chore for the developers of _ScalaFX_, and many of the duplicated members provide little in
the way of added-value to users of the library.
1. While the resulting _ScalaFX_ and _JavaFX_ classes are interchangable, through _implicit_ conversion functions, there
can be a lot of thrashing about between the two. In particular, every time a _JavaFX_ instance is converted to its
_ScalaFX_ equivalent, a new instance of the _ScalaFX_ class is created. This can lead to a lot of temporary _ScalaFX_
instances being created, resulting in unncessary memory conversion/_garbage collection_ processing overhead.
1. Having both a _ScalaFX_ and a _JavaFX_ version of just about every GUI element is confusing for users, particularly
if they are interoperating with plain _JavaFX_ code.
1. Using _FXML_ files with _ScalaFX_ is not as straightforward as it could be.
1. User sub-classing of _ScalaFX_ classes is non-trivial.

In addition, we wanted to make use of _functional reactive programming_ (_FRP_) techniques for interacting with
_JavaFX_, and also wanted to be able to work with _JavaFX_ with _[Akka](http://akka.io) actors_ (which is nontrivial
using _ScalaFX_).

Our approach makes use of a relatively new _Scala_ feature: _[implicit
classes](http://docs.scala-lang.org/overviews/core/implicit-classes.html)_.

This allows us to write very simple class definitions, such as:

```scala
implicit class SomeScalaWrapper (delegate: SomeJavaFXClass)
extends AnyVal {...}
```

This fairly trivial change has some interesting implications:

1. Users work with solely with _JavaFX_ classes, and should never create instances of the _Scala_ wrapper classes.
This simplifies how _Scala_ users interact with _JavaFX_, including working with custom _JavaFX_ subclasses and _FXML_.
1. Having an implicit class extend from `AnyVal` is a hint to the _Scala_ compiler that it does not need to create
instances of the wrapper class—it simply re-uses the sole constructor argument _as is_. This eliminates the memory
overhead and conversion/garbage collection processing overhead of using _delegate_ classes.
1. Members of the _Scala_ wrapper class are then used to _decorate_ the _JavaFX_ class, and so only members that add
value need be defined. (This is the same approach that the _Scala_ library adopts when referencing certain _Java_
classes, such as _Java_'s primite wrapper classes, the `String` class, etc.)

We welcome any comments, suggestions and/or contributions to this project. Feel free to _fork_ our code and send us
your _pull requests_...