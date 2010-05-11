:-module(ics,[ics/2]).

ics([h(start,0),begin(X,Y,C,F)],
        [[e(sono(X,Y,C,F),0)]]).

ics([h(start,0),notclause(begin(_,_,_,_),true)],
        [[e(sono(0,0,_,_),0)]]).

ics([h(start,0),end(X,Y,C,F)],
        [[T>0,T2>T,e(sono(X,Y,C,F),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),notclause(end(_,_,_,_),true)],
        [[T>0,T2>T,e(sono(7,7,_,_),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),maxmove(MAXT)],
        [[T2>MAXT,en(sono(_,_,_,_),T2)]]).

ics([h(start,0),minmove(MINT)],
        [[T2>MINT,e(sono(_,_,_,_),T2)]]).

ics([h(start,0),force([X,Y,C,F],[X2,Y2,C2,F2],DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,e(sono(X2,Y2,C2,F2),T2)]]).

ics([h(start,0),ban([X,Y,C,F],[X2,Y2,C2,F2],DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,en(sono(X2,Y2,C2,F2),T2)]]).

ics([h(start,0),move_rules([X,Y,C,F],COND,DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,e(sono(X2,Y2,C2,F2),T2),call(COND,X,Y,X2,Y2)]]).

ics([h(start,0),not_move_rules([X,Y,C,F],COND,DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,en(sono(X2,Y2,C2,F2),T2),call(COND,X,Y,X2,Y2)]]).

