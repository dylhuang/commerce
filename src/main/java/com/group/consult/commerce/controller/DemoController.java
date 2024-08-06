package com.group.consult.commerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: Demo Controller
 * @description: Demo
 * @author: Huang, Dylan Bo
 * @date: 2024-08-05
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Demo Controller")
@RequestMapping("/api/standard")
public class DemoController {

    /**
     * @param demoId demoId
     * @return boolean
     * @title demo for controller
     * @description your description
     */
    @GetMapping("/demo")
    @Operation(summary = "DEMONSTRATION", description = "DEMONSTRATION DESCRIPTION")
    public boolean demo(long demoId) {
        return true;
    }
}
