package objs.utilities;

/**
 * @author chen
 */
public class Method {
    private String method;
    public Method(String method){
        this.method = method;
    }

    public boolean isNeedExec(){
        return this.method.isEmpty()?false:true;
    }

    public String getMethod(){
        return this.method;
    }
}
