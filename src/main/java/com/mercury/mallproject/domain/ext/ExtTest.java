package com.mercury.mallproject.domain.ext;

import com.mercury.mallproject.domain.Test;

public class ExtTest extends Test {
    public String getIdAndName(){
        return this.getUserId()+this.getUserName();
    }
}
