package leetcode.digitalProblem;

public class ReachingPoints {
    public static void main(String[] args){
        ReachingPoints reachingPoints = new ReachingPoints();
        System.out.println(reachingPoints.reachingPoints(1, 1, 3, 5));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty){
        //快速取模到
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        if (tx == sx && ty == sy) return true;
        else if (tx == sx) return ty > sy && (ty - sy) % sx == 0;
        else if (ty == sy) return tx > sx && (tx - sx) % sy == 0;
        else return false;
    }

    private boolean process1(int sx, int sy, int tx, int ty){
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;
        return process1(sx, sy, (tx - sx) % ty, ty) || process1(sx, sy, tx, (ty - tx) % tx);

    }


    //正向思考，爆栈
    private boolean process(int sx, int sy, int tx, int ty){
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;
        return process(sx + sy, sy, tx, ty) || process(sx, sx + sy, tx, ty);
    }

}
