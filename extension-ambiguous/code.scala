object A:
  extension [T](x: Option[T]) def foo = 1

object B:
  extension [T](x: List[T]) def foo = 3

import A.*
import B.*

def f = Option(1).foo
