// Problem: Balanced Parenthesis

// Brute Force Approach:
// - Generate all possible substrings and check each for balance
// - Very inefficient, not practical
// - Time Complexity: O(n^3) (substring generation + validation)
// - Space Complexity: O(1)

// Better Approach:
// - Use a counter for open/close parentheses
// - Traverse string, increment for '(' and decrement for ')'
// - If counter ever goes negative → invalid
// - At end, if counter == 0 → valid
// - Time Complexity: O(n)
// - Space Complexity: O(1)
// - Limitation: Works only for '(' and ')', not for multiple bracket types

// Optimal Approach:
// - Use a stack to handle multiple types of brackets: (), {}, []
// - Traverse string:
//   - Push expected closing bracket when you see an opening
//   - On closing, check stack top matches
//   - If mismatch or stack empty → invalid
// - At end, stack must be empty → valid
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.Stack;

class Solution {

    // Brute Force (conceptual, not implemented due to inefficiency)
    public boolean brute(String s) {
        // Not practical: generate substrings and check balance
        return false;
    }

    // Better (works only for '(' and ')')
    public boolean better(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    // Optimal (handles (), {}, [])
    public boolean optimal(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
