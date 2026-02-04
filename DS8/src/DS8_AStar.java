import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class DS8_AStar {
    public static int testNumber = 0;

    public static DS8_Path_Solution<Point> aStar_Simple(char[][] maze) {
        System.out.println("started case "+ ++testNumber);
        ArrayList<DS8_AStar_Node<Character>> open = new ArrayList<>();
        ArrayList<DS8_AStar_Node<Character>> closed = new ArrayList<>();
        DS8_AStar_Node<Character> start = new DS8_AStar_Node<>('*', null, 0, 0);
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    start = new DS8_AStar_Node<>((char)(i*maze[0].length+j), null, 0, 0);
                    startX = i;
                    startY = j;
                }
                if (maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        char end = (char)(endX*maze[0].length+endY);
        start.setH(Math.abs(startX-endX)+Math.abs(startY-endY));
        open.add(start);
        while (!open.isEmpty()) {
            System.out.println("looped");
            DS8_AStar_Node<Character> n = open.removeFirst();
            System.out.println(n.getG()+" length");
            if (n.getLocation()==end) {
                ArrayList<Point> sol = new ArrayList<>();
                DS8_AStar_Node<Character> nn = n;
                sol.add(new Point(nn.getLocation()%maze[0].length, nn.getLocation()/maze[0].length));
                while (nn.getParent()!=null) {
                    System.out.println("sol loop");
                    nn = nn.getParent();
                    sol.addFirst(new Point(nn.getLocation()%maze[0].length, nn.getLocation()/maze[0].length));
                }
                System.out.println("at return");
//                sol.removeLast();
                System.out.println(sol);
                System.out.println(sol.size());
                return new DS8_Path_Solution<>(sol, n.getG());
            }
            closed.add(n);
            System.out.println("at search");
            if (n.getLocation()>=maze[0].length && maze[n.getLocation()/maze[0].length-1][n.getLocation()%maze[0].length]!='W') {//
                System.out.println("up");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-maze[0].length),//
                    n, 
                    n.getG()+1,
                    Math.abs(n.getLocation()/maze[0].length-1-endX)+Math.abs(n.getLocation()%maze[0].length-endY));//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()<(maze.length-1)*maze[0].length && maze[n.getLocation()/maze[0].length+1][n.getLocation()%maze[0].length]!='W') {//
                System.out.println("down");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+maze[0].length),//
                        n,
                        n.getG()+1,
                        Math.abs(n.getLocation()/maze[0].length+1-endX)+Math.abs(n.getLocation()%maze[0].length-endY));//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()%maze[0].length!=0 && maze[n.getLocation()/maze[0].length][n.getLocation()%maze[0].length-1]!='W') {//
                System.out.println("left");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-1),//
                        n,
                        n.getG()+1,
                        Math.abs(n.getLocation()/maze[0].length-endX)+Math.abs(n.getLocation()%maze[0].length-1-endY));//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()%maze[0].length!=maze[0].length-1 && maze[n.getLocation()/maze[0].length][n.getLocation()%maze[0].length+1]!='W') {//
                System.out.println("right");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+1),//
                        n,
                        n.getG()+1,
                        Math.abs(n.getLocation()/maze[0].length-endX)+Math.abs(n.getLocation()%maze[0].length+1-endY));//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            Collections.sort(open);
        }
        return null;
    }

    public static int aStar_JetPack(char[][] maze) {
        System.out.println("started case "+ ++testNumber);
        ArrayList<DS8_AStar_Node<Character>> open = new ArrayList<>();
        ArrayList<DS8_AStar_Node<Character>> closed = new ArrayList<>();
        DS8_AStar_Node<Character> start = new DS8_AStar_Node<>('*', null, 0, 0);
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    start = new DS8_AStar_Node<>((char)(i*maze[0].length+j), null, 0, 0);
                }
                if (maze[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        char end = (char)(endX*maze[0].length+endY);
        open.add(start);
        while (!open.isEmpty()) {
            System.out.println("looped");
            DS8_AStar_Node<Character> n = open.removeFirst();
            System.out.println(n.getG()+" length");
            if (n.getLocation()==end) {
                return n.getG();
            }
            closed.add(n);
            System.out.println("at search");
            if (n.getLocation()>=maze[0].length) {//
                System.out.println("up");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-maze[0].length),//
                        n,
                        maze[n.getLocation()/maze[0].length-1][n.getLocation()%maze[0].length]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()<(maze.length-1)*maze[0].length) {//
                System.out.println("down");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+maze[0].length),//
                        n,
                        maze[n.getLocation()/maze[0].length+1][n.getLocation()%maze[0].length]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()%maze[0].length!=0) {//
                System.out.println("left");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-1),//
                        n,
                        maze[n.getLocation()/maze[0].length][n.getLocation()%maze[0].length-1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()%maze[0].length!=maze[0].length-1) {//
                System.out.println("right");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+1),//
                        n,
                        maze[n.getLocation()/maze[0].length][n.getLocation()%maze[0].length+1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()>=maze[0].length && n.getLocation()%maze[0].length!=maze[0].length-1) {//
                System.out.println("upright");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-maze[0].length+1),//
                        n,
                        maze[n.getLocation()/maze[0].length-1][n.getLocation()%maze[0].length+1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()<(maze.length-1)*maze[0].length && n.getLocation()%maze[0].length!=maze[0].length-1) {//
                System.out.println("downright");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+maze[0].length+1),//
                        n,
                        maze[n.getLocation()/maze[0].length+1][n.getLocation()%maze[0].length+1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()>=maze[0].length && n.getLocation()%maze[0].length!=0) {//
                System.out.println("upLeft");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()-maze[0].length-1),//
                        n,
                        maze[n.getLocation()/maze[0].length-1][n.getLocation()%maze[0].length-1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            if (n.getLocation()<(maze.length-1)*maze[0].length && n.getLocation()%maze[0].length!=0) {//
                System.out.println("downLeft");
                DS8_AStar_Node<Character> a = new DS8_AStar_Node<>(
                        (char)(n.getLocation()+maze[0].length-1),//
                        n,
                        maze[n.getLocation()/maze[0].length+1][n.getLocation()%maze[0].length-1]=='O' ? n.getG()+1 : n.getG(),
                        0);//
                boolean inClose = false;
                for (DS8_AStar_Node<Character> s : closed)
                    if (s.getLocation() == a.getLocation()) {
                        inClose = true;
                        break;
                    }
                if (!inClose) {
                    DS8_AStar_Node<Character> s = null;
                    for (DS8_AStar_Node<Character> o : closed)
                        if (o.getLocation() == a.getLocation()) {
                            s = o;
                            break;
                        }
                    if (s!=null) {
                        if (n.getG() + 1 < s.getG()) {
                            s.setG(n.getG() + 1);
                            s.fixF();
                        }
                    } else {
                        a.fixF();
                        open.add(a);
                    }
                }
            }
            Collections.sort(open);
        }
        return -1;
    }
}
