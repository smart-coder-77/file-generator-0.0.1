ExtractValidationOutput extractValidationOutput = maxTransactionDateByFileName.values().stream()
    .map(x -> x.map(this::validateTransactionDate))
    .orElseThrow(() -> new RuntimeException("Transaction date not found."));

// ...

private ExtractValidationOutput validateTransactionDate(YourObjectType obj) {
    try {
        return checkTransactionDateValidation(obj.getExtractFileName(), obj.getTransactionDate(), obj.getDistributedView(), obj.getGenerateExtractTimeStamp());
    } catch (DateParsingException e) {
        throw new RuntimeException(e);
    }
}

