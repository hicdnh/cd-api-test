package objs.utilities;

/**
 * @author chen
 */
public class Data{
    private String data;
    private RequestType type;

    public Data(String data, RequestType t){
        this.data = data;
        this.type = t;
    }

    public boolean isNeedExec(){
        if(this.data.isEmpty()|| this.type == null){
            return false;
        }else {
            return true;
        }
    }

    public

}
