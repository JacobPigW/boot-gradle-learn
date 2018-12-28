package com.jacob.learn.enums;

import lombok.Getter;

public interface Category {

    @Getter
    enum One implements Category {
        A(1), B(2), C(3);

        private final Integer value;

        One(Integer value) {
            this.value = value;
        }
    }

    @Getter
    enum Two implements Category {
        A(3), B(39);

        private final Integer value;

        Two(Integer value) {
            this.value = value;
        }
    }
}