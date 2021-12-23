{-
ECS 140: Programming Languages
Homework Assignment 3 
By: Suryakiran Santhosh
Summer Session 1
-}


-- can only use ':', 'head',  'tail', 'null', 'elem' 


-- Question 1) Non pattern matching version
myremoveduplicates :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
myremoveduplicates list 
    | null list = []  -- check if list is empty 
    -- if element is in tail of array then don't include head in the array
    | (elem (head list) (tail list)) = myremoveduplicates (tail list) 
    -- if head is not in the tail of the array then include head in the return array
    | otherwise = (head list) : myremoveduplicates (tail list)  -- (elem (head list) (tail list)) == False


-- Question 1) pattern matching version
-- similar to myinsert on slide 19 of episode 19
myremoveduplicates_pm :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
myremoveduplicates_pm [] = []
myremoveduplicates_pm (x:xs)
    | elem x xs = myremoveduplicates_pm xs
myremoveduplicates_pm (x:xs) = x : myremoveduplicates_pm xs


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Intersection: return the elements taht are common in both lists
-- Question 2) Non pattern matching version
myintersection :: (Eq anyDataType) => [anyDataType] -> [anyDataType] -> [anyDataType]
myintersection list1 list2 
    | elem (head list1) (tail list1) = []  -- checking for duplicates in a set
    | elem (head list2) (tail list2) = []  -- checking for duplicates in a set
    | null list1 || null list2 = []
    | elem (head list1) (list2) = (head list1) : myintersection(tail list1)(list2) 
    | otherwise = myintersection(tail list1)(list2)


-- Question 2) pattern matching version
myintersection_pm :: (Eq anyDataType) => [anyDataType] -> [anyDataType] -> [anyDataType]
myintersection_pm [] list2 = []
myintersection_pm list1 [] = []
myintersection_pm (x:xs) (y:ys)  -- checking for duplicates in a set
    | (elem(x)(xs)) || (elem(y)(ys)) = [] 

myintersection_pm (x:xs) list2 
    | elem(x)(list2) = x : myintersection_pm(xs)(list2)

myintersection_pm (x:xs) list2 = myintersection_pm(xs)(list2)


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Question 3) Non pattern matching version
mynthtail :: (Eq anyDataType) => Int -> [anyDataType] -> [anyDataType]
mynthtail n list
    | n == 0 = list
    | otherwise = mynthtail(n-1)(tail list)


-- Question 3) pattern matching version
mynthtail_pm :: (Eq anyDataType) => Int -> [anyDataType] -> [anyDataType]
mynthtail_pm 0 list = list
mynthtail_pm n list = mynthtail_pm(n-1)(tail list)


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Question 4) Non pattern matching version
mylast :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
mylast list
    | null list = []
    | tail list == [] = list
    | otherwise = mylast(tail list)


-- Question 4) Pattern matching version
mylast_pm :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
mylast_pm [] = []
mylast_pm (x:xs) 
    | null xs = [x] 
mylast_pm (x:xs) = mylast_pm(xs)


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Question 5) Non pattern matching version
myreverse :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
myreverse list 
    | null list = []
    | otherwise = myreverse_helper(list)([])


myreverse_helper :: (Eq anyDataType) => [anyDataType] -> [anyDataType] -> [anyDataType]
myreverse_helper list1 list2 
    | null list1 = list2
    | otherwise = myreverse_helper(tail list1)((head list1) : list2)


-- Question 5) Pattern matching version
myreverse_pm :: (Eq anyDataType) => [anyDataType] -> [anyDataType]
myreverse_pm [] = []
myreverse_pm list = myreverse_pm_helper(list)([])


myreverse_pm_helper :: (Eq anyDataType) => [anyDataType] -> [anyDataType] -> [anyDataType]
myreverse_pm_helper [] list = list
myreverse_pm_helper (x:xs) list = myreverse_pm_helper(xs)(x:list)


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Question 6) Non pattern matching version
myreplaceall :: (Eq anyDataType) => anyDataType -> anyDataType -> [anyDataType] -> [anyDataType]
myreplaceall val replaceVal list 
    | null list = []
    | (head list) == replaceVal = val : myreplaceall(val)(replaceVal)(tail list)
    | otherwise = head list : myreplaceall(val)(replaceVal)(tail list)


-- Question 6) Pattern matching version
myreplaceall_pm :: (Eq anyDataType) => anyDataType -> anyDataType -> [anyDataType] -> [anyDataType]
myreplaceall_pm val replaceVal [] = []
myreplaceall_pm val replaceVal (x:xs)
    | (x == replaceVal) = val : myreplaceall_pm (val) (replaceVal) (xs)
myreplaceall_pm val replaceVal (x:xs) = x : myreplaceall_pm (val) (replaceVal) (xs)


----------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------


-- Question 7) Non pattern matching version
myordered :: (Ord anyDataType, Eq anyDataType) => [anyDataType] -> Bool
myordered list
    | null list = True
    | null (tail list) = True
    | ((head list) > (head(tail list))) = False
    | otherwise = myordered(tail list)


-- Question 7) Pattern matching version
myordered_pm :: (Ord anyDataType, Eq anyDataType) => [anyDataType] -> Bool
myordered_pm [] = True
myordered_pm (_:[]) = True
myordered_pm (x:xs)
    | (x > (head xs)) = False
myordered_pm (x:xs) = myordered_pm(xs)

