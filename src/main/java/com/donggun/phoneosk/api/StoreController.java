package com.donggun.phoneosk.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    @GetMapping("/test")
    public TestClass test() {
        TestClass tc = new TestClass();
        tc.setTest("This is test.");
        return tc;
    }

    @Data
    static class TestClass {
        private String test;
    }

}
