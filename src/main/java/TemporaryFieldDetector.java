import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TemporaryFieldDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        for (FieldDeclaration field : n.getFields()) {
            for (VariableDeclarator variable : field.getVariables()) {
                CountFieldUsed cfu = new CountFieldUsed(variable);
                n.accept(cfu, null);
                System.out.println("Variable : " + variable.getName() + "   " + cfu.getFieldUsedInMethods());
            }
        }
        super.visit(n, args);
    }

    class CountFieldUsed extends VoidVisitorAdapter<Void> {

        private VariableDeclarator field;
        private int fieldUsedInMethods = 0;

        public CountFieldUsed(VariableDeclarator field) {
            this.field = field;
        }

        @Override
        public void visit(MethodDeclaration n, Void args) {
            Optional<BlockStmt> body = n.getBody();
            if (body.isPresent()) {
                if (fieldUsed(body.get().getChildNodes())) {
                    fieldUsedInMethods++;
                }

            }

        }

        private boolean fieldUsed(List<Node> children) {
            for (Node node : children) {
                if (node.toString().equals(field.getName().toString())) {
                    return true;
                }
                if (fieldUsed(node.getChildNodes())) {
                    return true;
                }
            }
            return false;
        }

        private int getFieldUsedInMethods() {
            return fieldUsedInMethods;
        }

    }
}
