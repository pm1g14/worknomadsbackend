package com.worknomads.worknomads.adapters;

import java.util.Optional;

public interface InputAdapter<T, U> {

    default Optional<U> mapDTOtoDO(T dto) {
        return Optional.empty();
    }

    default Optional<T> mapDOtoDTO(U Do) {
        return Optional.empty();
    }
}
