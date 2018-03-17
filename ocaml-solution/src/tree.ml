type op = Conj | Disj | Impl;;

type tree = 
	| Binop of op * tree * tree
        | Neg of tree
        | Var of string;;
