import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class SwitchStatementDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(SwitchStmt n, Void args) {
        Optional<Node> parent = n.getParentNode();
        String variableName = n.getSelector().toString();
        if (parent.isPresent()) {
            if (isEnum(parent.get(), variableName)) {
                System.out.println("Should not be switching on enum \"" + variableName + "\"");
            }
        }
        super.visit(n, args);
    }

    private boolean isEnum(Node parentNode, String name) {
        for (Node node : parentNode.getChildNodes()) {
            if (node instanceof FieldDeclaration) {
                for (VariableDeclarator variable : ((FieldDeclaration) node).getVariables()) {
                    if (name.equals(variable.getName().asString())) {
                        if (checkIfTypeIsEnum(parentNode, variable.getType().toString())) {
                            return true;
                        }
                    }
                }

            }
        }
        Optional<Node> parent = parentNode.getParentNode();
        return parent.filter(node -> isEnum(node, name)).isPresent();
    }

    private boolean checkIfTypeIsEnum(Node parentNode, String name) {
        for (Node node : parentNode.getChildNodes()) {
            if (node instanceof EnumDeclaration) {
                if (((EnumDeclaration) node).getName().toString().equals(name)) {
                    return true;
                }
            }
        }
        Optional<Node> parent = parentNode.getParentNode();
        return parent.filter(node -> checkIfTypeIsEnum(node, name)).isPresent();
    }

}
