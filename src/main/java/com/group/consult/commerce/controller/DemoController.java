package com.group.consult.commerce.controller;

import com.group.consult.commerce.model.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo Controller
 *
 * @author Huang, Dylan Bo
 * @since 2024-08-05
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Demo Controller")
@RequestMapping("/api/standard")
public class DemoController {

    /**
     * demo for controller
     *
     * @param demoId demoId
     * @return boolean
     */
    @GetMapping("/demo")
    @Operation(summary = "DEMONSTRATION", description = "DEMONSTRATION DESCRIPTION")
    public ApiResult<String> demo(long demoId) {
        return ApiResult.success("this is back data");
    }
}
