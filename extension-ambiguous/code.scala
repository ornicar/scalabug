object A:
  extension [T](x: Option[T]) def foo = 1

object B:
  extension [T](x: List[T]) def foo = 3

import A.*
import B.*

val _ = Option(1).foo // error: value foo is not a member of Option[Int].

/*
[info] compiling 1 Scala source to /home/thib/scalabug/extension-ambiguous/target/scala-3.2.1/classes ...
[error] -- [E008] Not Found Error: /home/thib/scalabug/extension-ambiguous/code.scala:10:18
[error] 10 |def f = Option(1).foo
[error]    |        ^^^^^^^^^^^^^
[error]    |      value foo is not a member of Option[Int].
[error]    |      An extension method was tried, but could not be fully constructed:
[error]    |
[error]    |          B.foo[T](Option.apply[Int](1))    failed with
[error]    |
[error]    |              Reference to foo is ambiguous,
[error]    |              it is both imported by import A._
[error]    |              and imported subsequently by import B._
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
 */
