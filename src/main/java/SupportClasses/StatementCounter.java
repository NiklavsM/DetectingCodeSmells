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
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ContinueStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(DoStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ForeachStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(IfStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(LabeledStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ReturnStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(SwitchStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(SwitchEntryStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(ThrowStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(TryStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(BreakStmt n, Void args) {
        count++;
        super.visit(n, args);
    }

    @Override
    public void visit(WhileStmt n, Void args) {
        count++;
        super.visit(n, args);
    }
}
