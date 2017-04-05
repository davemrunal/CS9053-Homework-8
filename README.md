# CS9053-Homework-8

Task 1: Select the largest subset from the given jobs such that no jobs overlap in time. 
Greedy approach 
    - First sort the collection of given jobs by their finish time - O(nlogn)
    - Select the first job, then iteratively search through the sorted collection and select the job which doesn't overlap with    previously selected job. - O(n)

Runtime: O(nlogn)

Task 2: Each input job has a cost associated with it. Select the maximum total-cost subset of non-overlapping jobs.
Greedy approach doesn't work. Dynamically memoize cost associated with each job such that it doesn't include the cost of overlapping jobs preceding it. Backtrack to get the subset.
                - First sort the collection of given jobs by their finish time - O(nlogn)
                - Find the latest compatible job for each input job - O(n^2)
                - Build memoized array of costs - O(n)
                - Backtrack recursively to get the subset - O(n)
Runtime: O(n^2)

Reference: https://courses.cs.washington.edu/courses/cse521/13wi/slides/06dp-sched.pdf
