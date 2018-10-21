package SupportClasses;

import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class StatementCounter extends VoidVisitorAdapter<Void> {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(ExpressionStmt n, Void args) {
//        System.out.println("ExpressionStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ContinueStmt n, Void args) {
//        System.out.println("ContinueStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(DoStmt n, Void args) {
//        System.out.println("DoStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForStmt n, Void args) {
//        System.out.println("ForStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForeachStmt n, Void args) {
//        System.out.println("ForeachStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(IfStmt n, Void args) {
//        System.out.println("IfStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(LabeledStmt n, Void args) {
//        System.out.println("LabeledStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ReturnStmt n, Void args) {
//        System.out.println("ReturnStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(SwitchStmt n, Void args) {
//        System.out.println("SwitchStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(SwitchEntryStmt n, Void args) {
//        System.out.println("SwitchEntryStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ThrowStmt n, Void args) {
//        System.out.println("ThrowStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(TryStmt n, Void args) {
//        System.out.println("TryStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(BreakStmt n, Void args) {
//        System.out.println("BreakStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(WhileStmt n, Void args) {
//        System.out.println("WhileStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }
    @Override
    public void visit(AssertStmt n, Void args) {
//        System.out.println("AssertStmt : " + n.getClass().getName());
        count++;
        super.visit(n, args);
    }
}
