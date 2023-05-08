package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US06PojoHata {

    private String message;
    private Integer statusCode;
    private String path;
    private Long timeStamp;

    public US06PojoHata(){

    }

    public US06PojoHata(String message, Integer statusCode, String path, Long timeStamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "US06PojoHata{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", path='" + path + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
