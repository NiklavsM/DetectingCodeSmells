import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LongParameterListDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n , Void arg){
        if(n.getParameters().size() > 5){
            System.out.println("Method: \"" + n.getName() + "\" has too many parameters");
        }
    }
}
