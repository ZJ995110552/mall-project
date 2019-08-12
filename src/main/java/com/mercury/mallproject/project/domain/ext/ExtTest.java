package com.mercury.mallproject.project.domain.ext;

import com.mercury.mallproject.project.domain.Test;

public class ExtTest extends Test {
    public String getIdAndName() {
        return this.getUserId() + this.getUserName();
    }
}
