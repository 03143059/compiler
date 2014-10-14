Start ->
  class
  Program
  Fields ->
      INT ->
          a
      INT ->
          b
  Methods ->
      BOOLEAN main ->
      {
        Vars ->
            INT ->
              x
              y
              z
        Stmts ->
            location ->
              a
              =
              'd'
            location ->
              b
              =
              20
            location ->
              x
              =
              a
            location ->
              y
              =
              b
            location ->
              z
              =
              Name ->
                gcd
              Exprs ->
                  x
                  y
            callout 
              "printf"
            args ->
                "%c"
                a
            callout 
              "print_int"
            args ->
                z
      }
      BOOLEAN gcd ->
      (
          INT a
          INT b
      )
      {
        Vars ->
            INT ->
              b
        Stmts ->
            if ->
            (
              expr ->
                b
              op ->
                ==
              expr ->
                0
            )
            then {
              Stmts ->
                  return
                    (
                      a
                    )
            }
            else {
              Stmts ->
                  return
                    (
                      Name ->
                        gcd
                      Exprs ->
                          b
                          expr ->
                            a
                          op ->
                            %
                          expr ->
                            b
                    )
            }
      }
Tabla de simbolos:
 Scope ID: 1 (Parent: 1)
  ID: a	Type: int
  ID: b	Type: int
 Scope ID: 2 (Parent: 1)
  Scope ID: 3 (Parent: 2)
    ID: x	Type: int
    ID: y	Type: int
    ID: z	Type: int
   Scope ID: 4 (Parent: 1)
      ID: a	Type: int
      ID: b	Type: int
    Scope ID: 5 (Parent: 4)
     Scope ID: 6 (Parent: 5)
     Scope ID: 7 (Parent: 5)
