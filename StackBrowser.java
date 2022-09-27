import java.util.*;


public class StackBrowser {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = StackBrowser.browserStack(actions, start);

        System.out.println(output);
    }

    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // TODO:
        if(!Character.isUpperCase(start.charAt(0))) return null;
        current.push(start);
        //start가 대문자가 아니면
        for(String s : actions) {
            //뒤로가기인 경우
            if(s.equals("-1")) {
                if(prevStack.empty()){}
                else {
                    nextStack.push(current.pop());
                    current.push(prevStack.pop());
                }
            }
            //앞으로가기인 경우
            else if(s.equals("1")) {
                if(nextStack.empty()) {}
                else {
                    prevStack.push(current.pop());
                    current.push(nextStack.pop());
                }
            }
            //대문자알파벳인 경우
            else {
                if(current.empty()) current.push(s);
                else{
                    prevStack.push(current.pop());
                    current.push(s);
                    while(!nextStack.empty()) {
                        nextStack.pop();
                    }
                }
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
    }
}

