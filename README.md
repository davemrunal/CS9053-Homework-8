**Job Scheduler**

Given a list of jobs you accept a subset of the jobs, rejecting all others, so that the accepted jobs do not overlap in time.

More formally, there will be n jobs labeled 1...n with each job, j, specifying a start time Sj and a finish time Tj. Naturally we have Sj < Tj for all j. Two jobs j and j1 are compatible if the requested intervals do not overlap; that is, either job j is for an earlier time interval than job j1 (Tj <= Sj1), or job j is for a later time than job j1 (Tj1 <= Sj). More generally, that a subset A of jobs is compatible if all pairs of jobs j,j1 within A, j != j1 are compatible. The goal is to select a compatible subset of jobs of maximum possible size. To illustrate, for the following jobs the single compatible set of size 4 is the largest compatible set.

**Task 1: Select the largest subset from the given jobs such that no jobs overlap in time.**
  - Greedy approach 
  - First sort the collection of given jobs by their finish time - O(nlogn)
  - Select the first job, then iteratively search through the sorted collection and select the job which doesn't overlap with    previously selected job. - O(n)

Final Runtime: O(nlogn)

**Task 2: Now each input job has a cost associated with it. Select the maximum total-cost subset of non-overlapping jobs. Now we do not maximize for number of jobs, we want maximum cost subset**
  - Greedy approach doesn't work. 
  - Dynamically memoize cost associated with each job such that it doesn't include the cost of overlapping jobs preceding it.
  - Backtrack to get the subset.
  - First sort the collection of given jobs by their finish time - O(nlogn)
  - Find the latest compatible job for each input job - O(n^2)
  - Build memoized array of costs - O(n)
  - Backtrack recursively to get the subset - O(n)

Final Runtime: O(n^2)


