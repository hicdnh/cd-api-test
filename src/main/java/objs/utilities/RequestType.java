package objs.utilities;

/**
 * @author chen
 */

public enum RequestType {
    /*
    header中有application/json，发送数据的格式为json
     */
    JSON,

    /*
    header中有multipart-form，发送数据使用multipart格式
     */
    MULTI
}
