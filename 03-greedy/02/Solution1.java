// My really shitty code that I hobbled together
// It's not about the result. It's about the process. Because improving
//      your process is how you improve for the next questions.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int[] mostRecent = new int[26];
        Arrays.fill(mostRecent, -1);
        
        // tally up the task counts
        for (char task : tasks) {
            counts[taskToIndex(task)]++;
        }
        
        // complete the tasks greedily
        int numCompletedTasks = 0;
        int currTime = 0;
        while (numCompletedTasks < tasks.length) {
            // get the task with the highest count without cooldown, or -1 if idle
            int taskIndex = -1;
            for (int i = 0; i < counts.length; i++) {
                // if there's no cooldown
                if (mostRecent[i] == -1 || mostRecent[i] + n < currTime) {
                    if (counts[i] > 0 && (taskIndex == -1 || counts[i] > counts[taskIndex])) {
                        taskIndex = i;
                    }
                }
            }
            
            // update our state variables
            currTime += 1;
            if (taskIndex != -1) {
                numCompletedTasks += 1;
                counts[taskIndex]--;
                mostRecent[taskIndex] = currTime - 1;
            }
        }
        
        return currTime;
    }
    
    private int taskToIndex(char c) {
        return c - 'A';
    }
}