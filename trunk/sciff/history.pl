:-module(history,[hap/2,history_is_empty/1]).


%%%% /Users/muffo/Dropbox/Develop/NetBeansProjects/TestJPL/gioco/trace.txt %%%%
hap(start,0).
hap(sono(1,1,blu,fiore),0).
hap(sono(5,5,rosa,null),1).
hap(sono(10,10,blu,teschio),2).
history_is_empty(no).
