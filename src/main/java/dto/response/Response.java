package dto.response;

public class Response<T> {
    private long timestamp = System.currentTimeMillis();
    private int status;
    private String message;
    private T data;

    public static <T> Response<T> ok() {
        return new Response<>();
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> notFound() {
        return notFound(null);
    }

    public static <T> Response<T> notFound(String message) {
        return new Response<>(STATUS.NOT_FOUND, message);
    }

    public static <T> Response<T> badRequest(String message) {
        return new Response<>(STATUS.BAD_REQUEST, message);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(STATUS.ERROR, message);
    }

    public static <T> Response<T> forbidden(String message) {
        return new Response<>(STATUS.FORBIDDEN, message);
    }

    public static <T> Response<T> forbidden() {
        return forbidden(null);
    }

    public static <T> Response<T> noContent(String message) {
        return new Response<>(STATUS.NO_CONTENT, message);
    }

    public static <T> Response<T> noContent() {
        return noContent(null);
    }

    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> created() {
        return created(null);
    }


    public Response() {
    }

    public static <T> Response<T> created(T data) {
        return new Response<>(STATUS.CREATED.statusCode, null, data);
    }

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(STATUS status, String message) {
        this(status.getStatusCode(), message);
    }

    public Response(T data) {
        this(STATUS.OK, null);
        this.data = data;
    }


    public Response(T data, String message) {
        this(STATUS.OK, message);
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public enum STATUS {
        OK(0), BAD_REQUEST(400), FORBIDDEN(403), NOT_FOUND(404), ERROR(500), NO_CONTENT(204), CREATED(201);

        private final int statusCode;

        public int getStatusCode() {
            return statusCode;
        }

        STATUS(int statusCode) {
            this.statusCode = statusCode;
        }
    }
}
