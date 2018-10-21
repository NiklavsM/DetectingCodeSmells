import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class TemporaryFieldDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        for (FieldDeclaration field : n.getFields()) {
            if (!field.isStatic()) {
                field.getVariables().forEach(variable -> checkIfTemporaryField(n, variable));
            }
        }

        super.visit(n, args);
    }

    private void checkIfTemporaryField(ClassOrInterfaceDeclaration n, VariableDeclarator field) {
        AnalyseFieldUsage afu = new AnalyseFieldUsage(field);
        n.accept(afu, null);
        int timesUsed = afu.getFieldUsedInMethods() + afu.usedInConstructors();
        if (timesUsed < 2) {
            if (timesUsed == 1) {
                System.out.println("Field: \"" + field.getName() + "\" could be turned into local variable (Temporary field)");
            } else {
                System.out.println("Field: \"" + field.getName() + "\" is not used");
            }

        }
    }

    class AnalyseFieldUsage extends VoidVisitorAdapter<Void> {

        private int usedInMethods = 0;
        private int usedInConstructors = 0;
        private VariableDeclarator field;

        AnalyseFieldUsage(VariableDeclarator f) {
            field = f;
        }

        @Override
        public void visit(MethodDeclaration n, Void args) {
            if (fieldUsed(n.getChildNodes())) {
                usedInMethods++;
            }
            super.visit(n, args);
        }

        @Override
        public void visit(ConstructorDeclaration n, Void args) {
            if (fieldUsed(n.getChildNodes())) {
                usedInConstructors++;
            }
            super.visit(n, args);
        }

        private int usedInConstructors() {
            return usedInConstructors;
        }

        private int getFieldUsedInMethods() {
            return usedInMethods;
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
