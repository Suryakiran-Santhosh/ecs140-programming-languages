% University of California, Davis
% ECS  140: Programming Languages 
% Summer Session 1 2021
% Homework Assignment 5
% By: Suryakiran Santhosh


-module(hw5).
-export([myremoveduplicates/1, myintersection/2, mylast/1, myreverse/1, myreplaceall/3]).


% Problem 1:
myremoveduplicates([]) -> [];
myremoveduplicates([H|T]) -> 
    case myMember(H, T) of
        true -> myremoveduplicates(T);
        false -> [H|myremoveduplicates(T)]
    end.


% ========================================================================================


% Problem 2:
myintersection([], _) -> [];
myintersection(_, []) -> [];
myintersection([H|T], List2) ->
    case myMember(H, List2) of
        false -> myintersection(T, List2);
        true -> [H | myintersection(T, List2)]
    end.
    

% ========================================================================================


% Problem 3: 
mylast([]) -> [];
mylast([H|[]]) -> [H];
mylast([_|T]) -> mylast(T).


% ========================================================================================


% Problem 4:
myreverse([]) -> [];
myreverse(List) -> myReverseHelper(List, []).

myReverseHelper([], Out) -> Out;
myReverseHelper([H|T], Out) -> myReverseHelper(T, [H|Out]).


% ========================================================================================


% Problem 5:
myreplaceall(_, _, []) -> [];
myreplaceall(X, Y, [H|T]) -> 
    if
        H == Y -> [X | myreplaceall(X, Y, T)];
        true -> [H|myreplaceall(X, Y, T)]
    end. 


% ========================================================================================


% Utility Functions:


% returns true if arg1 is in the arg2 list
myMember(_, []) -> false;
myMember(Value, [H|T]) -> 
    if 
        H == Value -> true;
        true -> myMember(Value, T)
    end.
