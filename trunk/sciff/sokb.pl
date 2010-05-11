:- dynamic(fdet/1).
:- dynamic(society_goal/0).

:- dynamic(begin/4).

:- dynamic(end/4).

:- dynamic(maxmove/1).

:- dynamic(ban/3).

:- dynamic(force/3).

:- dynamic(move_rules/3).

:- dynamic(left/4).

:- dynamic(prereq/2).

society_goal.

begin(1,1,_,_).

end(_,_,_,home).

maxmove(5).

ban([_,_,_,paper],[_,_,_,treasure],2).

force([_,_,COL,money],[_,_,COL,treasure],3).

move_rules([_,_,_,paper],left,1).

left(X1,Y1,X2,Y2) :- 
    X2#<X1.

prereq([_,_,_,troll],[_,_,_,arrow]).

