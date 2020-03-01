package com.javaniuniu.shops.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 5:04 PM
 * 查看图片
 */
@Slf4j
@Controller
@RequestMapping(value = "/img/")
public class FileController {

    @Value("${app.upload.location}")
    public String uploadingDir;

    @RequestMapping(value = "/{fileName}",method = RequestMethod.GET)
    public String showImage(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        File file = new File(uploadingDir+"/"+fileName);
        BufferedImage bi = ImageIO.read(new FileInputStream(file));
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
