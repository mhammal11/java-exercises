class BadCommandException extends RuntimeException {
    // Exception to catch invalid inputs
    BadCommandException(String message) {
        super(message);
    }
}
