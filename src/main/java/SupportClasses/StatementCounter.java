package SupportClasses;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class StatementCounter extends VoidVisitorAdapter<Void> {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(FieldDeclaration n, Void args) {
//        System.out.println("FieldDeclaration " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ExpressionStmt n, Void args) {
//        System.out.println("ExpressionStmt " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ContinueStmt n, Void args) {
//        System.out.println("ExpressionStmt " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(DoStmt n, Void args) {
//        System.out.println("ExpressionStmt " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForStmt n, Void args) {
//        System.out.println("ExpressionStmt " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForeachStmt n, Void args) {
//        System.out.println("ForeachStmt " + n.toString());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(IfStmt n, Void args) {
//        System.out.println("IfStmt " + n.toString() + count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(LabeledStmt n, Void args) {
//        System.out.println("LabeledStmt " + n.toString()+ count);
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ReturnStmt n, Void args) {
//        System.out.println("ReturnStmt " + n.toString());
        count++;
    }

    @Override
    public void visit(SwitchStmt n, Void args) {
//        System.out.println("SwitchStmt " + n.toString());

        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(SwitchEntryStmt n, Void args) {
//        System.out.println("SwitchStmt " + n.toString());

        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ThrowStmt n, Void args) {
//        System.out.println("ThrowStmt " + n.toString());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(TryStmt n, Void args) {
//        System.out.println("TryStmt " + n.toString());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(BreakStmt n, Void args) {
//        System.out.println("BreakStmt " + n.toString());
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(WhileStmt n, Void args) {
//        System.out.println("WhileStmt " + n.toString());
        count++;
        super.visit(n, args);
    }
}
