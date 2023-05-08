package pojos;

public class US06PojoKayitEnUst {

    private US06PojoIdliKayit object;
    private String message;
    private String httpStatus;

    public US06PojoKayitEnUst(){

    }

    public US06PojoKayitEnUst(US06PojoIdliKayit object, String message, String httpStatus) {
        this.object = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public US06PojoIdliKayit getObject() {
        return object;
    }

    public void setObject(US06PojoIdliKayit object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "US06PojoKayitEnUst{" +
                "object=" + object +
                ", message='" + message + '\'' +
                ", httpStatus='" + httpStatus + '\'' +
                '}';
    }
}
