import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;
import java.util.Optional;

public class TemporaryFieldDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        for (FieldDeclaration field : n.getFields()) {
            if (!field.isStatic()) {
                for (VariableDeclarator variable : field.getVariables()) {
                    checkIfTemporaryField(n, variable);
                }
            }
        }
        super.visit(n, args);
    }

    private void checkIfTemporaryField(ClassOrInterfaceDeclaration n, VariableDeclarator field) {
        AnalyseFieldUsage afu = new AnalyseFieldUsage(field);
        n.accept(afu, null);
        if (!afu.usedInConstructor()) {
            int timesUsed = afu.getFieldUsedInMethods();
            if (timesUsed < 2) {
                if (timesUsed == 1) {
                    System.out.println("Field : " + field.getName() + " could be turned into local variable (Temporary field)");
                } else {
                    System.out.println("Field : " + field.getName() + " is not used");
                }

            }
        }
    }

    class AnalyseFieldUsage extends VoidVisitorAdapter<Void> {

        private int fieldUsedInMethods = 0;
        private boolean usedInConstructor = false;
        private VariableDeclarator field;

        AnalyseFieldUsage(VariableDeclarator f) {
            field = f;
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

        @Override
        public void visit(ConstructorDeclaration n, Void args) {
            usedInConstructor = fieldUsed(n.getChildNodes());
        }

        private boolean usedInConstructor() {
            return usedInConstructor;
        }

        private int getFieldUsedInMethods() {
            return fieldUsedInMethods;
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

    }

}
