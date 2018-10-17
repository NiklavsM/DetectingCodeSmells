import SupportClasses.StatementCounter;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LargeClassBasicDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {

        StatementCounter sc = new StatementCounter();
        n.accept(sc, null);
        int statementCount = sc.getCount() - 1; // -1 not to count class declaration itself
        if (statementCount > 100) {
            System.out.println("Class: " + n.getName() + " is too long. It has " + statementCount + " statements.");
        }
        super.visit(n,arg);
    }
}
