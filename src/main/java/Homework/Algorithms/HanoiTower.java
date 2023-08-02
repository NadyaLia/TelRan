package Homework.Algorithms;

import java.util.Stack;

public class HanoiTower {
    public static void main(String[] args) {
        int disksNumber = 3;
        char left = 'A';
        char tmp = 'B';
        char right = 'C';

        iterativeHanoi(disksNumber, left, tmp, right);

        recursiveHanoi(disksNumber, left, tmp, right);
    }
// class HanoiMove {
//    int n;
//    char source;
//    char target;
//    char auxiliary;
//
//    HanoiMove(int n, char source, char target, char auxiliary){
//        this.n=n;
//        this.source = source;
//        this.target = target;
//        this.auxiliary = auxiliary;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws Exception{
//      int n = 3;
//      char source = 'A';
//      char target = 'C';
//      char auxiliary = 'B';
//
//        Stack<HanoiMove> moves = new Stack<>();
//        moves.push(new HanoiMove(n,source,target,auxiliary));
//
//        while (!moves.empty()){
//            HanoiMove move = moves.pop();
//
//            if (move.n==1){
//                System.out.println(move.source+""+move.target);
//            }
//            else {
//                moves.push(new HanoiMove(move.n-1,move.auxiliary,move.target,move.source));
//                moves.push(new HanoiMove(1,move.source,move.target,move.auxiliary));
//                moves.push(new HanoiMove(move.n-1,move.source,move.auxiliary,move.target));
//            }
//        }
//
//    }
//
//}


    public static void iterativeHanoi(int disksNumber, char left, char tmp, char right) {
        int totalMoves = (int) Math.pow(2, disksNumber) - 1;

        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackTmp = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();

        for (int i = disksNumber; i > 0; i--) {
            stackLeft.push(i);
        }

        char from, to;
        if (disksNumber % 2 == 0) {
            from = tmp;
            to = right;
        } else {
            from = left;
            to = right;
        }

        for (int i = 1; i <= totalMoves; i++) {

            if (i % 3 == 1) {
                from = left;
                to = right;
            } else if (i % 3 == 2) {
                from = left;
                to = tmp;
            } else if (i % 3 == 0) {
                from = tmp;
                to = right;
            }

            if (i % 3 == 1) {
                moveDisk(from, to, stackLeft, stackRight);
            } else if (i % 3 == 2) {
                moveDisk(from, to, stackLeft, stackTmp);
            } else if (i % 3 == 0) {
                moveDisk(from, to, stackTmp, stackRight);
            }
        }
    }

    public static void moveDisk(char from, char to, Stack<Integer> left, Stack<Integer> right) {
        int diskMoved = 0;
        char movedFrom = from;
        char movedTo = to;
        if (left.size() == 0) {
            int disk2 = right.pop();
            diskMoved = disk2;
            left.push(disk2);
            movedFrom = to;
            movedTo = from;
        } else if (right.size() == 0) {
            int disk1 = left.pop();
            diskMoved = disk1;
            right.push(disk1);
            movedFrom = from;
            movedTo = to;
        } else {
            int disk1 = left.pop();
            int disk2 = right.pop();

            if (disk1 > disk2) {
                left.push(disk1);
                left.push(disk2);
                movedFrom = to;
                movedTo = from;
                diskMoved = disk2;
            }

            if (disk1 < disk2) {
                right.push(disk2);
                right.push(disk1);

                movedFrom = from;
                movedTo = to;

                diskMoved = disk1;
            }
        }
        System.out.println("Move disk " + diskMoved + " from " + movedFrom + " to " + movedTo);
    }

    public static void recursiveHanoi(int disksNumber, char left, char tmp, char right) {
        if (disksNumber == 0) {
            return;
        }
        if (disksNumber == 1) {
            System.out.println("Move disk from " + left + " to " + right);
        }
        recursiveHanoi(disksNumber - 1, left, tmp, right);
        System.out.println("Move disk " + disksNumber + " from " + left + " to " + right);
        recursiveHanoi(disksNumber - 1, tmp, right, left);
    }
}
