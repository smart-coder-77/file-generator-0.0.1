        ExtractValidationOutput extractValidationOutput= maxTransactionDateByFileName.values().stream().map(x->{
            try {
                return checkTransactionDateValidation(x.get().getExtractFileName(),x.get().getTransactionDate(),x.get().getDistributedView(),x.get().getGenerateExtractTimeStamp());
            } catch (DateParasingException e) {
                throw new RuntimeException(e);
            }
        });
