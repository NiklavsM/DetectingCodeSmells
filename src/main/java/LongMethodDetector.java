import SupportClasses.StatementCounter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LongMethodDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        StatementCounter sc = new StatementCounter();
        n.accept(sc, null);

        int statementCount = sc.getCount();
        if (statementCount > 10) {
            System.out.println("Method: \"" + n.getName() + "\" is too long. It has " + statementCount + " statements.");
        }
    }
}

