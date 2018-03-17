open Tree;;
open Buffer;;
open Printf;;

let (>>) x f = f x;;

let string_of_tree tree = 
  let s_op op = match op with Conj -> "&" | Disj -> "|" | Impl -> "->" in

  let buf = create 1000 in
  let rec s_t t = match t with
    | Var v -> add_string buf v
    | Neg t -> add_string buf "(!"; s_t t; add_char buf ')'
    | Binop (op,l,r) -> bprintf buf "(%s," (s_op op); s_t l; add_char buf ','; s_t r; add_char buf ')'
  in s_t tree; 
  contents buf;;

let (ic,oc) = (open_in "input.txt", open_out "output.txt");;

ic >> input_line >> Lexing.from_string >> Parser.main Lexer.main >> string_of_tree >> fprintf oc "%s\n";;

close_out oc;;
close_in ic;;
