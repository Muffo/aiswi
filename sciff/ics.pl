:-module(ics,[ics/2]).

ics([h(start,0)],
        [[e(sono(1,1,_,_),0)]]).

ics([h(start,0)],
        [[T>0,T2>T,e(sono(10,10,_,_),T),en(sono(_,_,_,_),T2)]]).

ics([h(sono(X,Y,C,fiore),T)],
        [[T2>T,e(sono(X2,Y2,C2,teschio),T2)]]).

