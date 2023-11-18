package com.example.springbootlabs;

public class CustomErrorResponse {
        private int code;
        private String message;

        public CustomErrorResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public int getCode() {
            return code;
        }


}
