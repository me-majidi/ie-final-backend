package helpers;

public class SuccessResponse<T> {
    private T data;
    private String status;

    public SuccessResponse(T data, String status) {
        this.data = data;
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return this.data;
    }

    public String getStatus() {
        return this.status;
    }
}
