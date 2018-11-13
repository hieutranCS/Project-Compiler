grammar CompilerFinal;
import CommonLexerRules;

prog: stat+ ;

stat:  expr NEWLINE           # printExpr
    | NEWLINE                # blank
    ;
    
expr:  MAX  #max
    |  MIN #min
    |  MEAN #mean
    |  STD #std
    |  DONE #done
    |	INT                  # int
    ;

STD : 'std';
MAX : 'max';
MIN : 'min';
MEAN : 'mean';
DONE : 'done';
