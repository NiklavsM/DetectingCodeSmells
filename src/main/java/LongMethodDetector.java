import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LongMethodDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {

        int statementCount = Helper.countStatements(n.getChildNodes());
        if (statementCount > 10) {
            System.out.println("Method: " + n.getName() + " is too long. I has " + statementCount + " statements.");
        }
    }

}

