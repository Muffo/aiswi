
% I re-implement the old findall_constraints that was implemented in
% SICStus 3. I have looked at the source code of the new CHR library
findall_constraints(C,L):-
    findall(C,'$enumerate_constraints'(C),L).

max_constraints(C,Max):-
    assert('$n_constraints'(0)),
    ('$enumerate_constraints'(C), retract('$n_constraints'(N)),
        (N<Max -> N1 is N+1, assert('$n_constraints'(N1)), fail
            ;   !,retract('$n_constraints'(_)), fail
        )
    ; retractall('$n_constraints'(_))
    ).

print_chr_list([],_).
print_chr_list([X|R],Sep):-
    portray(X), write(Sep),
    print_chr_list(R,Sep).
