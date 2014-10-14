Start ->
  class
  Program
  Fields ->
      INT ->
          A[100]
      INT ->
          length
  Methods ->
      BOOLEAN partition ->
      (
          INT p
          INT r
      )
      {
        Vars ->
            INT ->
              x
              i
              j
              t
            INT ->
              z
        Stmts ->
            location ->
              x
              =
              A
              [
                p
              ]
            location ->
              i
              =
              expr ->
                p
              op ->
                -
              expr ->
                1
            location ->
              j
              =
              expr ->
                r
              op ->
                +
              expr ->
                1
            for->
              z
            start ->
              0
            cond ->
              expr ->
                length
              op ->
                *
              expr ->
                length
            block ->
              Stmts ->
                  location ->
                    j
                    =
                    expr ->
                      j
                    op ->
                      -
                    expr ->
                      1
                  for->
                    a
                  start ->
                    0
                  cond ->
                    length
                  block ->
                    Stmts ->
                        if ->
                        (
                          expr ->
                            A
                            [
                              j
                            ]
                          op ->
                            <=
                          expr ->
                            x
                        )
                        then {
                          Stmts ->
                              break
                        }
                        location ->
                          j
                          =
                          expr ->
                            j
                          op ->
                            -
                          expr ->
                            1
                  for->
                    a
                  start ->
                    expr ->
                      i
                    op ->
                      +
                    expr ->
                      1
                  cond ->
                    length
                  block ->
                    Stmts ->
                        if ->
                        (
                          expr ->
                            A
                            [
                              a
                            ]
                          op ->
                            >=
                          expr ->
                            x
                        )
                        then {
                          Stmts ->
                              location ->
                                i
                                =
                                a
                              break
                        }
                  if ->
                  (
                    expr ->
                      i
                    op ->
                      <
                    expr ->
                      j
                  )
                  then {
                    Stmts ->
                        location ->
                          t
                          =
                          A
                          [
                            i
                          ]
                        location ->
                          A
                          [
                            i
                          ]
                          =
                          A
                          [
                            j
                          ]
                        location ->
                          A
                          [
                            j
                          ]
                          =
                          t
                  }
                  else {
                    Stmts ->
                        return
                          j
                  }
            return
              -
                1
      }
      VOID quicksort ->
      (
          INT p
          INT r
      )
      {
        Vars ->
            INT ->
              q
        Stmts ->
            if ->
            (
              expr ->
                p
              op ->
                <
              expr ->
                r
            )
            then {
              Stmts ->
                  location ->
                    q
                    =
                    Name ->
                      partition
                    Exprs ->
                        p
                        r
                  Name ->
                    quicksort
                  Exprs ->
                      p
                      q
                  Name ->
                    quicksort
                  Exprs ->
                      expr ->
                        q
                      op ->
                        +
                      expr ->
                        1
                      r
            }
      }
      VOID main ->
      {
        Vars ->
            INT ->
              temp
        Stmts ->
            location ->
              length
              =
              10
            callout 
              "printf"
            args ->
                "creating random array of %d elements\n"
                length
            callout 
              "srandom"
            args ->
                17
            for->
              i
            start ->
              0
            cond ->
              length
            block ->
              Stmts ->
                  location ->
                    temp
                    =
                    callout 
                      "random"
                    args ->
                  location ->
                    A
                    [
                      i
                    ]
                    =
                    temp
            callout 
              "printf"
            args ->
                "\nbefore sort:\n"
            for->
              i
            start ->
              0
            cond ->
              length
            block ->
              Stmts ->
                  callout 
                    "printf"
                  args ->
                      "%d\n"
                      A
                      [
                        i
                      ]
            Name ->
              quicksort
            Exprs ->
                0
                expr ->
                  length
                op ->
                  -
                expr ->
                  1
            callout 
              "printf"
            args ->
                "\nafter sort\n"
            for->
              i
            start ->
              0
            cond ->
              length
            block ->
              Stmts ->
                  callout 
                    "printf"
                  args ->
                      "%d\n"
                      A
                      [
                        i
                      ]
      }
Tabla de simbolos:
Scope ID:     1
Parent Scope: 1
ID: p	Type: int
ID: A[100]	Type: int
ID: r	Type: int
ID: length	Type: int
 Scope ID:     2
 Parent Scope: 2
  ID: t	Type: int
  ID: x	Type: int
  ID: i	Type: int
  ID: j	Type: int
  ID: z	Type: int
  Scope ID:     3
  Parent Scope: 3
   Scope ID:     4
   Parent Scope: 4
    Scope ID:     5
    Parent Scope: 5
     Scope ID:     6
     Parent Scope: 6
      Scope ID:     7
      Parent Scope: 7
       Scope ID:     8
       Parent Scope: 8
        Scope ID:     9
        Parent Scope: 9
         Scope ID:     10
         Parent Scope: 10
                  ID: p	Type: int
                  ID: r	Type: int
          Scope ID:     11
          Parent Scope: 11
                    ID: q	Type: int
           Scope ID:     12
           Parent Scope: 12
            Scope ID:     13
            Parent Scope: 13
             Scope ID:     14
             Parent Scope: 14
                          ID: temp	Type: int
              Scope ID:     15
              Parent Scope: 15
               Scope ID:     16
               Parent Scope: 16
                Scope ID:     17
                Parent Scope: 17
                 Scope ID:     18
                 Parent Scope: 18
