//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Step 1: Create a set to track visited rooms
        Set<Integer> visited = new HashSet<>();
        visited.add(0); // Start with room 0

        // Step 2: Use a queue (BFS approach)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.add(key);
                }
            }
        }

        // Step 4: Check if all rooms have been visited
        return visited.size() == rooms.size();
    }

    // Test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));
        rooms1.add(Arrays.asList(2));
        rooms1.add(Arrays.asList(3));
        rooms1.add(Arrays.asList());
        System.out.println(solution.canVisitAllRooms(rooms1)); // Output: true

        // Test case 2
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));
        System.out.println(solution.canVisitAllRooms(rooms2)); // Output: false

        // Test case 3
        List<List<Integer>> rooms3 = new ArrayList<>();
        rooms3.add(Arrays.asList(1));
        rooms3.add(Arrays.asList(0, 3));
        rooms3.add(Arrays.asList(3));
        rooms3.add(Arrays.asList(2));
        System.out.println(solution.canVisitAllRooms(rooms3)); // Output: false
    }
}
