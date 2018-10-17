import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;
import java.util.Optional;

public class SwitchStatementDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {

        if (findSwitchStatements(n.getChildNodes())) {
            System.out.println("Method \"" + n.getName() + "\" is using switch statement, is it really necessary?");
        }

    }

    private boolean findSwitchStatements(List<Node> nodes) {
        for (Node node : nodes) {
//            System.out.println("Node " + node.getClass().getName());
            if (node instanceof SwitchStmt) {
                System.out.println("SwitchStmt " + node.toString());
                System.out.println("SwitchStmt selector " + (((SwitchStmt) node).getSelector()).toString());
                Optional<Node> parent = node.getParentNode();
                String variableName = (((SwitchStmt) node).getSelector()).toString();
                if (parent.isPresent()) {
                    if (isEnum(parent.get(), variableName)) {
                        System.out.println("Should not be switching on enum type");
                    }

                }
                return true;
            }
            if (findSwitchStatements(node.getChildNodes())) {
                return true;
            }
        }
        return false;
    }

    private boolean isEnum(Node parentNode, String name) {
        for (Node node : parentNode.getChildNodes()) {
            if (node instanceof FieldDeclaration) {
                for (VariableDeclarator variable : ((FieldDeclaration) node).getVariables()) {
                    if (name.equals(variable.getName().asString())) {
                        System.out.println("VARIBLE TYPE  " + variable.getType().toString() +
                                " name:" + variable.getName() + " variable.getType().getEl  " + variable.getType().getClass().isEnum());
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
        for(Node node: parentNode.getChildNodes()) {
            if (node instanceof EnumDeclaration) {
                System.out.println("HEREREEE" + ((EnumDeclaration) node).getName());
                System.out.println(((EnumDeclaration) node).getName() + "     O    " + name);
                if (((EnumDeclaration) node).getName().toString().equals(name)) {
                    System.out.println("HEREREEE2");
                    return true;
                }
            }
        }
        Optional<Node> parent = parentNode.getParentNode();
//        parent.ifPresent(n ->System.out.println("LOL  " + n.toString()));
        return parent.filter(node -> checkIfTypeIsEnum(node, name)).isPresent();
    }

}
