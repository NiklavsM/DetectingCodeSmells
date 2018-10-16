import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;

public class DataClassDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void arg) {
        if(isDataClass(n)){
            System.out.println("Class \"" + n.getName() + "\" looks like a data class");
        }
        super.visit(n, arg);
    }

    private boolean isDataClass(ClassOrInterfaceDeclaration n) {
        for(MethodDeclaration method : n.getMethods()){
            if(!justAGetterOrSetter(method)){
                return false;
            }
        }
        return true;
    }

    private boolean justAGetterOrSetter(MethodDeclaration method){
        Optional<BlockStmt> methodBody = method.getBody();
        if(method.getParameters().size()>1){
            return false;
        }
        if(methodBody.isPresent()) {
            if (methodBody.get().getStatements().size() > 1) {
                return false;
            }
        }
        return true;
    }

}

