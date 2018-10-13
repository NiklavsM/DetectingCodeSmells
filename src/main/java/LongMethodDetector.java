import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LongMethodDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {

        int statementCount = 0;
        Optional<BlockStmt> methodBody = n.getBody();
        statementCount = Helper.countStatements(n.getChildNodes());
        System.out.println("statementCount: " + statementCount);
        if (statementCount > 10) {
            System.out.println("Method: " + n.getName() + " is too long");
        }
    }

}

