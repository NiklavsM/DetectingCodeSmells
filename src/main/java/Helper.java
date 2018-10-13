import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;
import com.github.javaparser.ast.stmt.Statement;

import java.util.List;

public class Helper {

    public static int countStatements(List<Node> nodes) {
        int statements = 0;
        for(Node node : nodes) {
            if(node instanceof Statement){
                statements += countStatements(node.getChildNodes());
                if(!(node instanceof BlockStmt || node instanceof LocalClassDeclarationStmt)){
//                    System.out.println("STATEMENT " + node.getClass().getName());
                    statements++;
                }
            }
            if(node instanceof ClassOrInterfaceDeclaration){
                statements++;
                statements += countStatements(node.getChildNodes());
            }
            if(node instanceof MethodDeclaration){
//                System.out.println("MethodDeclaration " + node.getClass().getName());
                statements++;
                statements += countStatements(node.getChildNodes());
            }
            if(node instanceof FieldDeclaration){
//                System.out.println("FieldDeclaration " + node.getClass().getName());
                statements ++;
            }
        }

//        System.out.println("statements counted   " + statements);
        return statements;


    }
}
