package com.group.consult.commerce.controller.sys;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.google.code.kaptcha.Producer;
import com.group.consult.commerce.configuration.Constants;
import com.group.consult.commerce.model.ApiCodeEnum;
import com.group.consult.commerce.model.ApiResult;
import com.group.consult.commerce.model.dto.CaptchDTO;
import com.group.consult.commerce.model.vo.CaptchaVO;
import com.group.consult.commerce.service.ISysLoginDomainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @title: 验证码控制器
 * @description: 验证码控制器
 * @author: zl
 * @date: 2024-08-08
 */
@Slf4j
@RestController
@RequestMapping("/api/sys/captcha")
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Value("${commerce.captchaType: math}")
    private String captchaType;

    @Autowired
    private ISysLoginDomainService loginDomainService;

    @GetMapping("/img")
    @Operation(summary = "生成验证码", description = "生成验证码")
    public ApiResult<CaptchaVO> getImage() {

        String uuid = IdUtil.fastSimpleUUID();
        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        if ("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
            log.info("验证码，math方式：capText:{},code={}", capText, code);
        } else if ("char".equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        log.info("验证码，code={}, 超时{}, 单位={}", code, Constants.CAPTCHA_EXPIRATION,
                TimeUnit.MINUTES.name());
        CaptchDTO captchDTO = new CaptchDTO();
        captchDTO.setCode(code);
        captchDTO.setUuid(uuid);
        captchDTO.setExpireTime(DateUtil.offsetMinute(new Date(), Constants.CAPTCHA_EXPIRATION));
        loginDomainService.saveAndClearCaptchaCode(captchDTO);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return ApiResult.fail();
        }
        String img64 = Base64.encode(os.toByteArray());

        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setUuid(uuid);
        captchaVO.setImg(img64);
        return ApiResult.success(captchaVO);
    }
}
