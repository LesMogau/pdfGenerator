package com.example.pdfGenerator.controller;


import com.example.pdfGenerator.service.PDFGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {
    //we have to use the service we created called the pdf generator and
    // in order to do that we have to use DEPENDENCY INJECTION METHOD

    private final PDFGeneratorService pdfGeneratorService;

    //default constructor added by intellij
    //so when the app runs spring should just take service class
    // then use dependency injection to inject in the constructor below
    //so we can use the service

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate")
        public void generatePDF(HttpServletResponse response) throws IOException {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String HeaderKey = "Content-Disposition";
            String HeaderValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
            response.setHeader(HeaderKey,HeaderValue);
        //setting the content disposition key to the response so the browser  can know what its getting back


        this.pdfGeneratorService.export(response);

    }
}
