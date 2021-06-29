package com.worknomads.worknomads.adapters;

public interface InputAdapter<T, U> {

    U mapDTOtoDO(T dto);
}
