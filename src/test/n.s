Start ->
  class
  Program
  Fields ->
      INT ->
          a
          b
      INT ->
          d[10]
          x[2]
      BOOLEAN ->
          c
  Methods ->
      VOID t ->
      (
          INT c
          BOOLEAN h
          BOOLEAN i
      )
      {
        Vars ->
            INT ->
              e
              d
            BOOLEAN ->
              f
              g
        Stmts ->
            location ->
              c
              =
              2
            for->
              e
            start ->
              1
            cond ->
              expr ->
                e
              op ->
                <
              expr ->
                10
            block ->
              Vars ->
                  INT ->
                    c
              Stmts ->
                  callout 
                    "printf"
                  args ->
                      "%d"
                      f
      }
      BOOLEAN d ->
      {
        Stmts ->
            return
              1
      }
      VOID p ->
      {
        Stmts ->
            return
      }
      BOOLEAN main ->
      {
        Stmts ->
            location ->
              a
              =
              expr ->
                1
              op ->
                +
              expr ->
                1
            Name ->
              p
            Name ->
              t
            Exprs ->
                expr ->
                  Name ->
                    d
                op ->
                  *
                expr ->
                  2
                !
                  false
                expr ->
                  1
                op ->
                  ==
                expr ->
                  2
      }
Tabla de simbolos:
 Scope ID: 1 (Parent: 1)
  ID: p()	Type: void
  ID: a	Type: int
  ID: b	Type: int
  ID: main()	Type: int
  ID: c	Type: boolean
  ID: d()	Type: int
  ID: x[2]	Type: int
  ID: t(int,boolean,boolean)	Type: void
  ID: d[10]	Type: int
 Scope ID: 2 (Parent: 1)
  ID: c	Type: int
  ID: h	Type: boolean
  ID: i	Type: boolean
  Scope ID: 3 (Parent: 2)
    ID: d	Type: int
    ID: e	Type: int
    ID: f	Type: boolean
    ID: g	Type: boolean
   Scope ID: 4 (Parent: 3)
      ID: c	Type: int
    Scope ID: 5 (Parent: 1)
     Scope ID: 6 (Parent: 5)
      Scope ID: 7 (Parent: 1)
       Scope ID: 8 (Parent: 7)
        Scope ID: 9 (Parent: 1)
         Scope ID: 10 (Parent: 9)
