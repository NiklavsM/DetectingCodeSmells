import SupportClasses.StatementCounter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class DataClassDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        if (n.getFields().size() > 0) {
            if (!n.isInterface() && !n.isAbstract()) {
                if (isDataClass(n)) {
                    System.out.println("Class \"" + n.getName() + "\" looks like a data class");
                }
            }
        }
        super.visit(n, arg);
    }

    private boolean isDataClass(ClassOrInterfaceDeclaration n) {
        for (MethodDeclaration method : n.getMethods()) {
            if (!justAGetterOrSetter(method)) {
                return false;
            }
        }
        return true;
    }

    private boolean justAGetterOrSetter(MethodDeclaration method) {

        if (method.getParameters().size() > 1) {
            return false;
        }

        StatementCounter sc = new StatementCounter();
        MethodCallCounter mcc = new MethodCallCounter();
        method.accept(sc, null);
        method.accept(mcc, null);

        int statementCount = sc.getCount();
        int methodCallCount = mcc.getCount();
        return methodCallCount + statementCount <= 1;
    }

    class MethodCallCounter extends VoidVisitorAdapter<Void> {
        private int count = 0;

        int getCount() {
            return count;
        }

        @Override
        public void visit(MethodCallExpr n, Void args) {
            count++;
            super.visit(n, args);
        }
    }

}

