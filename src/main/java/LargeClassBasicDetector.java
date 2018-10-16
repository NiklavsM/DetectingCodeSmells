import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class LargeClassBasicDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {

        int classStatements = Helper.countStatements(n.getChildNodes());

//        System.out.println("classStatementsss " + classStatements);
        if (classStatements > 100) {
            System.out.println("\""+ n.getName() + "\" class is too large");
        }
        super.visit(n, arg);
    }
}
