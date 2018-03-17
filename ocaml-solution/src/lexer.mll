{
open Parser
}

let variable = ['A' - 'Z']+ ['A' - 'Z' '0' - '9']*

rule main = parse
        | variable as v { VAR(v) }
        | "->"          { IMPL }
        | "&"           { AND }
        | "|"           { OR }
        | "!"           { NOT }
        | "("           { OPEN }
        | ")"           { CLOSE }
        | eof           { EOF }  


