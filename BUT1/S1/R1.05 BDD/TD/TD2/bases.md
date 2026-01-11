# TP2

``` tutoriald
VAR pays BASE RELATION {
    nomp CHARACTER,
    superficie INT
    pop INT
} KEY {nomp}

VAR ville BASE RELATION {
    nomv CHARACTER,
    nomp CHARACTER
} KEY {nomv}

VAR fleuve BASE RELATION {
    nomf CHARACTER,
    longueur INT,
    nomm CHARACTER
} KEY {nomf}
CONSTRAINT fleuve_fk1
    fleuve{nomf} < mer{nomm}

VAR mer BASE RELATION {
    nomm CHARACTER,
    surface INT
}
```
