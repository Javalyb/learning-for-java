package priv.lyb.idempotencydemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MissingRequestHeaderException;
import priv.lyb.idempotencydemo.order.IdempotencyInProgressException;
import priv.lyb.idempotencydemo.order.InvalidIdempotencyKeyException;

/** 集中把常见参数和幂等异常转换成统一、可教学观察的 JSON 错误响应。 */
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ApiError> missingHeader(MissingRequestHeaderException exception) {
        return error(HttpStatus.BAD_REQUEST, "请求头 Idempotency-Key 不能为空");
    }
    @ExceptionHandler(InvalidIdempotencyKeyException.class)
    public ResponseEntity<ApiError> invalidKey(InvalidIdempotencyKeyException exception) {
        return error(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
    @ExceptionHandler(IdempotencyInProgressException.class)
    public ResponseEntity<ApiError> processing(IdempotencyInProgressException exception) {
        return error(HttpStatus.CONFLICT, exception.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validation(MethodArgumentNotValidException exception) {
        return error(HttpStatus.BAD_REQUEST, exception.getBindingResult().getFieldError().getDefaultMessage());
    }
    private ResponseEntity<ApiError> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new ApiError(status.value(), message));
    }
    /** 统一错误结构，避免客户端依赖 Spring 的默认错误响应。 */
    public static class ApiError {
        /** 响应字段 {@code status}：对应 HTTP 状态码的业务状态。 */
        private final int status;
        /** 响应字段 {@code message}：用于前端展示的中文错误原因。 */
        private final String message;
        public ApiError(int status, String message) { this.status = status; this.message = message; }
        public int getStatus() { return status; }
        public String getMessage() { return message; }
    }
}
