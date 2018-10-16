import SupportClasses.StatementCounter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class LongMethodDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        StatementCounter sc = new StatementCounter();
        Optional<BlockStmt> body = n.getBody();
        if (body.isPresent()) {
            body.get().accept(sc, null);

            int statementCount = sc.getCount();
            if (statementCount > 10) {
                System.out.println("Method: " + n.getName() + " is too long. I has " + statementCount + " statements.");
            }
        }
    }

}

