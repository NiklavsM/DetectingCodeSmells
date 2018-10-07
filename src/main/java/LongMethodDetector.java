import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class LongMethodDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        Optional<BlockStmt> methodBody = n.getBody();
        if (methodBody.isPresent()) {
            if (methodBody.get().getStatements().size() > 10) {
                System.out.println("Method: " + n.getName() + " is too long");
            }
        }
    }
}
