package objs.utilities;


import okhttp3.Headers;

/**
 * @author chen
 */
public class Header {
    private String header;
    private String[] headerLines;

    public Header(String header){
        this.header = header;
        headerLines = this.header.split("\n");
    }

    /**
     *
     * @return boolean header.isEmpty() ? false: true;
     */

    public boolean isNeedExec(){
        return this.header.isEmpty() ? false: true;
    }

    /**
     *
     * @return default RequestType.JSON
     */
    public RequestType getType(){
        if(isNeedExec()){
            for(String h: headerLines){
                if(h.contains("application/json")){
                    return RequestType.JSON;
                }else if(h.contains("multipart/form-data")){
                    return RequestType.MULTI;
                }else {
                    return RequestType.JSON;
                }
            }
        }
        return null;
    }


    public Headers.Builder getHeaderBuilder(){
        Headers.Builder httpHeaders = new Headers.Builder();
        String[] headerLines = this.header.split("\n");
        for(String h: headerLines){
            httpHeaders.add(h.trim());
        }
        return httpHeaders;
    }
}
