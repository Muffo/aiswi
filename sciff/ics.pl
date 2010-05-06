:-module(ics,[ics/2]).

ics([h(start,0),inizio(X,Y,C,F)],
        [[e(sono(X,Y,C,F),0)]]).

ics([h(start,0),notclause(inizio(_,_,_,_),true)],
        [[e(sono(1,1,_,_),0)]]).

ics([h(start,0),fine(X,Y,C,F),notclause(maxmove(_),true)],
        [[T>0,T2>T,e(sono(X,Y,C,F),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),notclause(fine(X,Y,C,F),true),maxmove(MAXT)],
        [[T>0,T2<MAXT,e(sono(X,Y,C,F),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),fine(X,Y,C,F),maxmove(MAXMOVE)],
        [[T>0,T<MAXMOVE,T2>T,e(sono(X,Y,C,F),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),notclause(fine(_,_,_,_),true)],
        [[T>0,T2>T,e(sono(10,10,_,_),T),en(sono(_,_,_,_),T2)]]).

ics([h(start,0),risposta([X,Y,C,F],[X2,Y2,C2,F2],DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,e(sono(X2,Y2,C2,F2),T2)]]).

ics([h(start,0),notrisposta([X,Y,C,F],[X2,Y2,C2,F2],DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,en(sono(X2,Y2,C2,F2),T2)]]).

ics([h(start,0),regola([X,Y,C,F],COND,DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,e(sono(X2,Y2,C2,F2),T2),call(COND,X,Y,X2,Y2)]]).

ics([h(start,0),notregola([X,Y,C,F],COND,DELAY),h(sono(X,Y,C,F),T)],
        [[T2>T,T2=<T+DELAY,en(sono(X2,Y2,C2,F2),T2),call(COND,X,Y,X2,Y2)]]).

