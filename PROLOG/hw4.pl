/*
ECS 140: Programming Languages
University of California, Davis
Summer 2021 Session 1
Homework Assignment #4 
By: Suryakiran Santhosh
*/


% Problem 1: shuffle(L1, L2, L3)
shuffle([], [], []).
shuffle([X|T1], Y, [X|T3]) :- shuffle2(T1, Y, T3).
shuffle2(Y, [X|T2], [X|T3]) :- shuffle(Y, T2, T3).


% Problem 2: double(L1, L2)
double([], []).
double([X|T1], [X|[X|T2]]) :- double(T1, T2).


% Problem 3: no_duplicates(L1, L2)
no_duplicates(L1, L2) :- no_duplicates_helper(L1, L2, []).
no_duplicates_helper([], L2, L3) :- reverse(L2, L3).
no_duplicates_helper([H|T], L2, NoDupsArray) :- member(H, T), no_duplicates_helper(T, L2, NoDupsArray).
no_duplicates_helper([H|T], L2, NoDupsArray) :- not(member(H, T)), no_duplicates_helper(T, L2, [H|NoDupsArray]).


% Problem 4: same_elements(L1, L2)
same_elements([], []).
same_elements(L1, [H|T]) :- remove(H, L1, NewL1), same_elements(NewL1, T).
remove(Element,[Element|Tail],Tail).
remove(Element,[Head|Tail],[Head|Tail1]) :- remove(Element,Tail,Tail1).


/* Utility Functions: "Reinventing the wheel for practice" as per what professor said in Discussion.
member(X,[X|T]).
member(X,[H|T]) :- member(X,T).

reverse([H|T], Rev) :- reverseHelper(T, [H], Rev).
reverseHelper([], Accumulator, Accumulator).
reverseHelper([H|T], Accumulator, Rev) :- reverseHelper(T, [H|Accumulator], Rev).
*/
