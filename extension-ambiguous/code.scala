object A:
  extension [T](x: Option[T])
    def foo = 1
    def bar = 1
  extension [T](x: List[T])
    def bar = 2

object B: 
  extension [T](x: List[T])
    def foo = 3

import A.*
import B.*

def f = Option(1).bar
