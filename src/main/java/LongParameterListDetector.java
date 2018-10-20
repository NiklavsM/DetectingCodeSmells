import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LongParameterListDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void args) {
        int parameterCount = n.getParameters().size();
        if (parameterCount > 5) {
            System.out.println("Method: \"" + n.getName() + "\" has too many parameters: " + parameterCount);
        }
        super.visit(n, args);
    }

    @Override
    public void visit(ConstructorDeclaration n, Void args) {
        int parameterCount = n.getParameters().size();
        if (parameterCount > 5) {
            System.out.println("Constructor: \"" + n.getName() + "\" has too many parameters: " + parameterCount);
        }
        super.visit(n, args);
    }
}
